package com.server.controller;

import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import com.server.mapper.IOTMessageMapper;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.springframework.context.ApplicationContext;

/**
 * 订阅端 接收消息
 * 1 创建 MqttClient(broker,clientId)
 * 2 MqttClient.setCallback(new MqttCallback() {}) 设置回调函数
 * 3 MqttClient.connect(用户名，密码)
 * 4 MqttClient.subscribe() 订阅主题消息
 */

@Component
public class MqttServer implements ApplicationContextAware {
    @Autowired
    IOTMessageMapper iotMessageMapper;

//    private final ApplicationContext context;
//
//    @Autowired
//    public MqttServer(ApplicationContext context) {
//        this.context = context;
//    }
//
//    private IOTMessageMapper getIOTMessageMapper() {
//        return context.getBean(IOTMessageMapper.class);
//    }
    protected static ApplicationContext applicationContext ;
    @Override
    public void setApplicationContext(ApplicationContext arg0) throws BeansException {
        if (applicationContext == null) {
            applicationContext = arg0;
        }

    }
    public static Object getBean(String name) {
        //name表示其他要注入的注解name名
        return applicationContext.getBean(name);
    }

    public static <T> T getBean(Class<T> clazz) {
        return applicationContext.getBean(clazz);
    }


    public void handleMqtt() throws MqttException {
        System.out.println("Mqtt");

        String HOST = "tcp://localhost:1883";
        String TOPIC = "#";
        int qos = 1;
        String clientid = "emqx_server";
        String userName = "admin";
        String passWord = "02200059b";
        System.out.println("Mqtt");
        try {
            // host为主机名，test为clientid即连接MQTT的客户端ID，一般以客户端唯一标识符表示，MemoryPersistence设置clientid的保存形式，默认为以内存保存
            MqttClient client = new MqttClient(HOST, clientid, new MemoryPersistence());

            // MQTT的连接设置
            MqttConnectOptions options = new MqttConnectOptions();
            // 设置是否清空session,这里如果设置为false表示服务器会保留客户端的连接记录，这里设置为true表示每次连接到服务器都以新的身份连接
            options.setCleanSession(true);
            // 设置连接的用户名
            options.setUserName(userName);
            // 设置连接的密码
            options.setPassword(passWord.toCharArray());
            // 设置超时时间 单位为秒
            options.setConnectionTimeout(10);
            // 设置会话心跳时间 单位为秒 服务器会每隔1.5*20秒的时间向客户端发送个消息判断客户端是否在线，但这个方法并没有重连的机制
            options.setKeepAliveInterval(20);
            // 自动重连
            options.setAutomaticReconnect(true);

            // 设置回调函数
            client.setCallback(new MqttCallback() {

                public void connectionLost(Throwable cause) {
                    // 连接丢失后，一般在这里面进行重连
                    System.out.println("连接断开，可以做重连");
                }

                public void messageArrived(String topic, MqttMessage message) throws Exception {
                    /**
                     * 订阅到消息后的回调
                     * 该方法由mqtt客户端同步调用，在此方法未正确返回之前，不会发送ack确认消息到broker
                     * 一旦该方法向外抛出了异常客户端将异常关闭，当再次连接时；所有QoSl,QoS2且客户端未进行ack确认的消息都将由
                     * broker服务器再次发送到客户端
                     */
                    System.out.println("messageId:" + message.getId());
                    System.out.println("接收消息主题:" + topic);
                    System.out.println("接收消息Qos:" + message.getQos());
                    System.out.println("接收消息内容:" + new String(message.getPayload()));
                    System.out.println();
                    if (message.getId() > 0)
                        storeMessage(message);
                }

                public void deliveryComplete(IMqttDeliveryToken token) {
                    /**
                     * 消息发布完成且收到ack确认后的回调
                     * QoS0：消息被网络发出后触发一次
                     * QoS1：当收到broker的PUBACK消息后触发
                     * QoS2：当收到broer的PUBCOMP消息后触发
                     */
                    System.out.println("deliveryComplete---------" + token.isComplete());
                }

            });

            // 建立连接
            client.connect(options);

            // 订阅消息
            client.subscribe(TOPIC, qos);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void storeMessage(MqttMessage message) throws ParseException {
        // 接收消息内容:{"alert":0,"clientId":"device0003","info":"Device Data 2023/11/13
        // 22:21:53","lat":30.451956772804262,"lng":119.90936369895935,"timestamp":1699885313447,"value":77}
        String payload = new String(message.getPayload());
        String[] split = payload.split(",");
        String alert = split[0].substring(9);
        int alertInt = Integer.parseInt(alert);

        String clientId = split[1].substring(18, split[1].length() - 1);
        int clientIdInt = Integer.parseInt(clientId);

        String deviceTime = split[2].substring(20, split[2].length() - 1);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        java.util.Date parsedDate = dateFormat.parse(deviceTime);
        java.sql.Timestamp sqlDate = new java.sql.Timestamp(parsedDate.getTime());

        String lat = split[3].substring(6);
        float latFloat = Float.parseFloat(lat);

        String lng = split[4].substring(6);
        float lngFloat = Float.parseFloat(lng);

        System.out.println("alert:" + alertInt);
        System.out.println("clientId:" + clientIdInt);
        System.out.println("deviceTime:" + sqlDate);
        System.out.println("lat:" + latFloat);
        System.out.println("lng:" + lngFloat);
        try {
            // ... 你原来的代码 ...
            if (iotMessageMapper == null) {
                // 如果 iotMessageMapper 为 null，则尝试手动获取一次
                iotMessageMapper = applicationContext.getBean(IOTMessageMapper.class);
            }
            iotMessageMapper.insertMessage(clientIdInt, alertInt, latFloat, lngFloat, sqlDate);
            System.out.println("Message stored successfully.");
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Failed to store message to the database.");
        }
        // iotMessageMapper.insertMessage(clientIdInt, alertInt, latFloat, lngFloat,
        // sqlDate);
    }
}

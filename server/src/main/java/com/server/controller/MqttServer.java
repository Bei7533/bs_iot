package com.server.controller;

import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

/**
 * 订阅端 接收消息
 * 1 创建 MqttClient(broker,clientId)
 * 2 MqttClient.setCallback(new MqttCallback() {}) 设置回调函数
 * 3 MqttClient.connect(用户名，密码)
 * 4 MqttClient.subscribe() 订阅主题消息
 */
public class MqttServer {

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

//    public static void Main(String[] args) throws MqttException {
//        handleMqtt();
//    }
}

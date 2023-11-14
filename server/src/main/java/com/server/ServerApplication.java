package com.server;

import com.server.mapper.IOTMessageMapper;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import com.server.controller.MqttServer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@SpringBootApplication
@Component
public class ServerApplication{

    public static void main(String[] args) throws MqttException {
        SpringApplication.run(ServerApplication.class, args);
//        ApplicationContext context = SpringApplication.run(ServerApplication.class, args);
//        MqttServer mqttServer = context.getBean(MqttServer.class);
        MqttServer mqttServer = new MqttServer();
         // 调用 handleMqtt 方法
        try {
            // 调用 handleMqtt 方法
            mqttServer.handleMqtt();
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }
}

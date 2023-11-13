package com.server;

import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import com.server.controller.MqttServer;

@SpringBootApplication
public class ServerApplication {

    public static void main(String[] args) throws MqttException {
        SpringApplication.run(ServerApplication.class, args);
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

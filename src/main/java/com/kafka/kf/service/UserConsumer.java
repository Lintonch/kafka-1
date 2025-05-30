package com.kafka.kf.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.kafka.kf.model.User;
@Service
public class UserConsumer {
	@KafkaListener(topics = "user-created", groupId = "user-group", containerFactory = "userKafkaListenerFactory")
	public void consume(User user) {
        System.out.println("✅ User received from Kafka:");
        System.out.println("Name: " + user.getName());
        System.out.println("Email: " + user.getEmail());
        System.out.println("Phone: " + user.getPhone());
    }

}

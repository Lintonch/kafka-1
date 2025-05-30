package com.kafka.kf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.kafka.kf.model.User;
@Service
public class UserProducer {

	private static final String TOPIC = "user-created";

	@Autowired
	private KafkaTemplate<String, User> kafkaTemplate;

	public void sendUser(User user) {
		kafkaTemplate.send(TOPIC, user);
	}

}

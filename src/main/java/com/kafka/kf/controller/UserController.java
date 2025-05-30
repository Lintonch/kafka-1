package com.kafka.kf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.kf.model.User;
import com.kafka.kf.service.UserProducer;
@RestController
@RequestMapping("api/users")
public class UserController {

	 @Autowired
	    private UserProducer userProducer;

	    @PostMapping("/create")
	    public ResponseEntity<String> createUser(@RequestBody User user) {
	        userProducer.sendUser(user);
	        return ResponseEntity.ok("✅ User created and sent to Kafka successfully");
	    }
}

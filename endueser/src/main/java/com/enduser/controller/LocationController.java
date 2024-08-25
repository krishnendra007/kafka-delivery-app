package com.enduser.controller;


import com.enduser.config.KafkaConfig;
import com.enduser.service.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/location")
public class LocationController {

    @Autowired
    private KafkaConfig kafkaConfig;

    @Autowired
    private KafkaService kafkaService;

    @GetMapping("/update")
    public ResponseEntity<?> getLocation(){

        String location =kafkaService.getLatestLocation();

        System.out.println("Location receieved" + location);
        return  new ResponseEntity<>(Map.of("Message","Location received" + location), HttpStatus.OK);
    }
}

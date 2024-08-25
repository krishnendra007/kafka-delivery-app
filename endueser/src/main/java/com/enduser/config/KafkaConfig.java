package com.enduser.config;

import com.enduser.service.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
public class KafkaConfig {

    @Autowired
    private KafkaService kafkaService;

    @KafkaListener(topics = AppConstants.LOCATION_UPDATE_TOPIC,groupId = AppConstants.GROUP_ID)
    public String updatedLocation(String value){
        System.out.println(value);
        kafkaService.updateLocation(value);
        return value;
    }
}

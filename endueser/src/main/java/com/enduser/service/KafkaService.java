package com.enduser.service;

import org.springframework.stereotype.Service;

@Service
public class KafkaService {

    private String latestLocation;

    public synchronized void updateLocation(String location) {
        this.latestLocation = location;
    }

    public synchronized String getLatestLocation() {
        return this.latestLocation;
    }
}

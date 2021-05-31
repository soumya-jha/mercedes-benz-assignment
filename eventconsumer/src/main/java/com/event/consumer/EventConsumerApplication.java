package com.event.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class EventConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EventConsumerApplication.class);
    }
}

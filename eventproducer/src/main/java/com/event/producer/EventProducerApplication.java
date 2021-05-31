package com.event.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
        "com.common.config",
        "com.event.producer"
})
public class EventProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EventProducerApplication.class);
    }
}

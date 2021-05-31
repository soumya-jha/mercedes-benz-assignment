package com.event.producer.service;

import com.event.producer.model.Fuel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

@EnableBinding(Source.class)
public class EventProducerService {

    private static final Logger logger = LoggerFactory.getLogger(EventProducerService.class);

    @Autowired
    private MessageChannel output;

    public String publishEvent(Boolean fuelLid, String city) {
        Fuel fuel = new Fuel(fuelLid, city);
        output.send(MessageBuilder.withPayload(fuel).build());
        logger.info("Published event " + fuel);
        return "Published event " + fuel;
    }
}

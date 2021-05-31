package com.event.producer.config;

import com.event.producer.service.EventProducerService;
import com.event.producer.util.EventProducerUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import static javax.management.timer.Timer.ONE_MINUTE;

@Configuration
@EnableScheduling
public class ProducerSchedulingConfig {

    private static final Logger logger = LoggerFactory.getLogger(ProducerSchedulingConfig.class);

    @Autowired
    private EventProducerService producerService;

    @Scheduled(fixedRate = ONE_MINUTE * 2)
    public void produceEvents() {
        String event = producerService.publishEvent(EventProducerUtil.getRandomBoolean(), EventProducerUtil.getRandomCity());
        logger.info("Scheduler " + event);
    }
}

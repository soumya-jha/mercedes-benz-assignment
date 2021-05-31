package com.event.consumer.config;

import com.event.consumer.constant.EventConsumerConstant;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import static javax.management.timer.Timer.ONE_DAY;

@Configuration
@EnableScheduling
public class ConsumerSchedulingConfig {

    @Scheduled(fixedRate = ONE_DAY)
    @CacheEvict(cacheNames = EventConsumerConstant.CACHE_NAME, allEntries = true)
    public void clearCache() {

    }

}

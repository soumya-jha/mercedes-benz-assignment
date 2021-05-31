package com.event.consumer.util;

import com.event.consumer.constant.EventConsumerConstant;
import com.event.consumer.model.FuelPrice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.function.Consumer;

@Component
public class EventConsumerUtil {

    private static final Logger logger = LoggerFactory.getLogger(EventConsumerUtil.class);

    @Value("${fuelapi.username}")
    private String username;
    @Value("${fuelapi.password}")
    private String password;
    @Value("${fuelapi.port}")
    private String port;
    @Value("${fuelapi.backendapiurl}")
    private String backendapiurl;
    @Value("${fuelapi.relativeurl}")
    private String relativeurl;

    @Cacheable(cacheNames = EventConsumerConstant.CACHE_NAME, key = EventConsumerConstant.CACHE_KEY)
    public double getFuelPrice(String city) {
        Consumer<HttpHeaders> headersConsumer = (httpHeader) -> httpHeader.setBasicAuth(username, password);

        FuelPrice fuelPrice = WebClient.create()
                .get()
                .uri(backendapiurl + port + relativeurl + city)
                .headers(headersConsumer)
                .retrieve()
                .bodyToMono(FuelPrice.class)
                .block();

        logger.info("Price from fuel API : " + fuelPrice.getFuelPrice());
        try {
            //To understand if the data is retrieved from fuelApi, not from cache
            Thread.sleep(1000 * 2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return fuelPrice.getFuelPrice();
    }
}

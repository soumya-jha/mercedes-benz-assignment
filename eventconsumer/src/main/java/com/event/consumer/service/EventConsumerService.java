package com.event.consumer.service;

import com.event.consumer.model.Fuel;
import com.event.consumer.util.EventConsumerUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

import java.math.BigDecimal;
import java.math.RoundingMode;

@EnableBinding(Sink.class)
public class EventConsumerService {

    private static final Logger logger = LoggerFactory.getLogger(EventConsumerService.class);
    private static BigDecimal totalCost = BigDecimal.ZERO;

    @Autowired
    private EventConsumerUtil util;

    @StreamListener(target = Sink.INPUT)
    public void consumeEvent(Fuel fuel) {
        logger.info("Event Consumed in: " + fuel);
        if (fuel.isFuelLid()) {
            double fuelPrice = util.getFuelPrice(fuel.getCity());
            logger.info("Returned fuelPrice is : " + fuelPrice);
            /*TO-DO
                - Below is a basic calculation, logic to be updated after clarification from technical team */
            int amountOfFuel = 4; //4 litres
            BigDecimal cityPrice = new BigDecimal(amountOfFuel * fuelPrice).setScale(2, RoundingMode.HALF_UP);
            totalCost = totalCost.add(cityPrice);
            logger.info("Price of " + amountOfFuel + " litres of fuel for city " + fuel.getCity() + " is : " + cityPrice);
            logger.info("Total Price of fuel filled in the car from the start is : " + totalCost);
        }
    }

}

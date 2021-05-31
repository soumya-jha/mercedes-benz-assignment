package com.event.producer.controller;

import com.event.producer.service.EventProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/event")
public class EventProducerController {

    @Autowired
    private EventProducerService producerService;

    @GetMapping("/{fuelLid}/{city}")
    public String publishEvent(@PathVariable Boolean fuelLid, @PathVariable String city) {
        return producerService.publishEvent(fuelLid, city);
    }

}

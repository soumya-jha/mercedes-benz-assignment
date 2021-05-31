package com.fuelprice.controller;

import com.fuelprice.model.FuelPrice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.math.RoundingMode;

@RestController
@RequestMapping("/fuel")
public class FuelPriceController {

    @GetMapping("/lookup/{city}")
    public ResponseEntity<FuelPrice> getFuelPrice(@PathVariable String city) {
        FuelPrice fuelPrice = new FuelPrice();
        fuelPrice.setCity(city);
        fuelPrice.setFuelPrice(new BigDecimal(this.getRandomNumber(50, 120)).setScale(2, RoundingMode.HALF_UP).doubleValue());
        return new ResponseEntity<>(fuelPrice, HttpStatus.OK);
    }

    private double getRandomNumber(int min, int max) {
        return (Math.random() * (max - min)) + min;
    }
}

package com.fuelprice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
        "com.common.config",
        "com.fuelprice"
})
public class FuelPriceApplication {

    public static void main(String[] args) {
        SpringApplication.run(FuelPriceApplication.class);
    }
}

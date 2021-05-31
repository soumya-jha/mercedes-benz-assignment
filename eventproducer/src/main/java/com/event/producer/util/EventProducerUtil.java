package com.event.producer.util;

import java.util.Random;

public class EventProducerUtil {

    private static Random r;

    public static String getRandomCity() {
        String[] cityArray = {"Bangalore", "Mumbai", "Delhi", "Chennai", "Pune", "Kolkata", "Ahmedabad", "Lucknow",
                "Raipur", "Chandigarh", "Jaipur", "Visakhapatnam", "Indore", "Bhopal", "Kanpur", "Vadodara",
                "Nashik", "Nagpur", "Patna", "Agra", "Vijayawada", "Meerut", "Jabalpur", "Bangalore", "Noida"};
        r = new Random();
        int randomNumber = r.nextInt(cityArray.length);
        return cityArray[randomNumber];
    }

    public static Boolean getRandomBoolean() {
        r = new Random();
        return r.nextBoolean();
    }
}

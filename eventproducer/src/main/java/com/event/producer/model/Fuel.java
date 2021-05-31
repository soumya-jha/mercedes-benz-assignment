package com.event.producer.model;

public class Fuel {
    private boolean fuelLid;
    private String city;

    public Fuel(boolean fuelLid, String city) {
        this.fuelLid = fuelLid;
        this.city = city;
    }

    public boolean isFuelLid() {
        return fuelLid;
    }

    public void setFuelLid(boolean fuelLid) {
        this.fuelLid = fuelLid;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Fuel{" +
                "fuelLid=" + fuelLid +
                ", city='" + city + '\'' +
                '}';
    }
}

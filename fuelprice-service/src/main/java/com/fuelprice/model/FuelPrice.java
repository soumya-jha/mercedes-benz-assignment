package com.fuelprice.model;

public class FuelPrice {

    private String city;
    private double fuelPrice;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getFuelPrice() {
        return fuelPrice;
    }

    public void setFuelPrice(double fuelPrice) {
        this.fuelPrice = fuelPrice;
    }

    @Override
    public String toString() {
        return "FuelPrice{" +
                "city='" + city + '\'' +
                ", fuelPrice=" + fuelPrice +
                '}';
    }
}

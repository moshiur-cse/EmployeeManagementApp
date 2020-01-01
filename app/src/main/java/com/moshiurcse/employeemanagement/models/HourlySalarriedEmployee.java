package com.moshiurcse.employeemanagement.models;

public class HourlySalarriedEmployee extends Employee {
    private double hourly_rate;
    private double total_hour;

    public double getHourly_rate() {
        return hourly_rate;
    }

    public void setHourly_rate(double hourly_rate) {
        this.hourly_rate = hourly_rate;
    }

    public double getTotal_hour() {
        return total_hour;
    }

    public void setTotal_hour(double total_hour) {
        this.total_hour = total_hour;
    }

    @Override
    public String toString() {
        return super.toString()+"HourlySalarriedEmployee{" +
                "hourly_rate=" + hourly_rate +
                ", total_hour=" + total_hour +
                '}';
    }
}

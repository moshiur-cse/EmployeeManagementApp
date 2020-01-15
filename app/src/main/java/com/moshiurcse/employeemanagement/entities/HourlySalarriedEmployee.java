package com.moshiurcse.employeemanagement.entities;

import androidx.room.Entity;

@Entity
public class HourlySalarriedEmployee extends Employee {
    private double hourly_rate;
    private double total_hour;


    public HourlySalarriedEmployee(String emp_name, String dob, String emp_email, String emp_phone, String emp_designation, String emp_gender, double hourly_rate, double total_hour) {
        super(emp_name, dob, emp_email, emp_phone, emp_designation, emp_gender);
        this.hourly_rate = hourly_rate;
        this.total_hour = total_hour;
    }
    @Override
    public double getTotalSalary(){
        return hourly_rate*total_hour;

    }


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

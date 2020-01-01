package com.moshiurcse.employeemanagement.models;

public class BasePlusCommisionEmployee extends Employee {
    private double baseSalary1;
    private double commision_rate;
    private double gross_total;

    public double getBaseSalary1() {
        return baseSalary1;
    }

    public void setBaseSalary1(double baseSalary1) {
        this.baseSalary1 = baseSalary1;
    }

    public double getCommision_rate() {
        return commision_rate;
    }

    public void setCommision_rate(double commision_rate) {
        this.commision_rate = commision_rate;
    }

    public double getGross_total() {
        return gross_total;
    }

    public void setGross_total(double gross_total) {
        this.gross_total = gross_total;
    }

    @Override
    public String toString() {
        return super.toString()+ "BasePlusCommisionEmployee{" +
                "baseSalary1=" + baseSalary1 +
                ", commision_rate=" + commision_rate +
                ", gross_total=" + gross_total +
                '}';
    }
}

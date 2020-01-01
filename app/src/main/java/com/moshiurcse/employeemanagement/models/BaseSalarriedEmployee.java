package com.moshiurcse.employeemanagement.models;

public class BaseSalarriedEmployee extends Employee {
    private double base_salary;

    public double getBase_salary() {
        return base_salary;
    }

    public void setBase_salary(double base_salary) {
        this.base_salary = base_salary;
    }

    @Override
    public String toString() {
        return super.toString()+ "BaseSalarriedEmployee{" +
                "base_salary=" + base_salary +
                '}';
    }
}

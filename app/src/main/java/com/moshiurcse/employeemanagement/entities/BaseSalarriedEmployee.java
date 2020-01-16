package com.moshiurcse.employeemanagement.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;

@Entity(tableName = "tbl_emp_base_salaried")
public class BaseSalarriedEmployee extends Employee {
    @ColumnInfo(name = "basic_salary")
    private double base_salary;

   /* @Ignore
    int image;*/

    public BaseSalarriedEmployee(String emp_name, String dob, String emp_email, String emp_phone, String emp_designation, String emp_gender, double base_salary) {
        super(emp_name, dob, emp_email, emp_phone, emp_designation, emp_gender);
        this.base_salary = base_salary;
    }


    public double getBase_salary() {
        return base_salary;
    }
    public void setBase_salary(double base_salary) {
        this.base_salary = base_salary;
    }

    @Override
    public double getTotalSalary(){
        return base_salary;

    }

    @Override
    public String toString() {
        return super.toString()+ "BaseSalarriedEmployee{" +
                "base_salary=" + base_salary +
                '}';
    }
}

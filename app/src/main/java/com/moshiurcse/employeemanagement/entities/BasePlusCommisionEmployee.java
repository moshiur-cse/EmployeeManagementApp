package com.moshiurcse.employeemanagement.entities;

public class BasePlusCommisionEmployee extends BaseSalarriedEmployee {
    //private double baseSalaryForBasePlusComEmployee;
    private double commision_rate;
    private double gross_total;

    public BasePlusCommisionEmployee(String emp_name, String dob, String emp_email, String emp_phone, String emp_designation, String emp_gender, double base_salary, double commision_rate, double gross_total) {
        super(emp_name, dob, emp_email, emp_phone, emp_designation, emp_gender, base_salary);
        this.commision_rate = commision_rate;
        this.gross_total = gross_total;
    }

/*public BasePlusCommisionEmployee(String emp_name, String dob, String emp_email, String emp_phone, String emp_designation, String emp_gender, double baseSalary1, double commision_rate, double gross_total) {
        super(emp_name, dob, emp_email, emp_phone, emp_designation, emp_gender);
        this.baseSalaryForBasePlusComEmployee = baseSalary1;
        this.commision_rate = commision_rate;
        this.gross_total = gross_total;
    }
*/
/*    public double getBaseSalary1() {
        return baseSalaryForBasePlusComEmployee;
    }

    public void setBaseSalary1(double baseSalaryForBasePlusComEmployee) {
        this.baseSalaryForBasePlusComEmployee = baseSalaryForBasePlusComEmployee;
    }*/

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
    public double getTotalSalary(){
        return super.getBase_salary()+(commision_rate*gross_total)/100;
    }


    @Override
    public String toString() {
        return super.toString()+ "BasePlusCommisionEmployee{" +
                ", commision_rate=" + commision_rate +
                ", gross_total=" + gross_total +
                '}';
    }
}

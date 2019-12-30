package com.moshiurcse.employeemanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.moshiurcse.employeemanagement.models.BaseSalarriedEmployee;
import com.moshiurcse.employeemanagement.models.Employee;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BaseSalarriedEmployee baseSalarriedEmployee= new BaseSalarriedEmployee();

        Employee employee=new Employee();

    }

    public void registerNewEmployee(View view) {
    }
}

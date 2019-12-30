package com.moshiurcse.employeemanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.moshiurcse.employeemanagement.models.BaseSalarriedEmployee;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BaseSalarriedEmployee baseSalarriedEmployee= new BaseSalarriedEmployee();
    }
}

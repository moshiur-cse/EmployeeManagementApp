package com.moshiurcse.employeemanagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.moshiurcse.employeemanagement.adapters.BaseSalarriedEmployeeAdapter;
import com.moshiurcse.employeemanagement.entities.BaseSalarriedEmployee;
import com.moshiurcse.employeemanagement.roomdb.EmployeeDB;
import com.moshiurcse.employeemanagement.utils.ConstantUtils;

import java.util.ArrayList;
import java.util.List;

public class EmployeeListActivity extends AppCompatActivity {

    private Spinner empTypeSP;

    private RecyclerView empRV;
    private BaseSalarriedEmployeeAdapter employeeAdapter;

    private String[]empList={
            ConstantUtils.EmployeeType.BASE_SALARIED,
            ConstantUtils.EmployeeType.HOURLY_SALARIED,
            ConstantUtils.EmployeeType.BASE_COMMISION_SALARIED
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_list);
        setTitle("Employee List");
        empTypeSP=findViewById(R.id.empTypeSP);
        empRV=findViewById(R.id.empRV);



        //employeeAdapter=new BaseSalarriedEmployeeAdapter(this,genereateEmployeeData());

;


        employeeAdapter=new BaseSalarriedEmployeeAdapter(this,EmployeeDB.getInstance(this).
                getBaseSalariedEmpDao().
                gerAllBaseSalariedEmployee());



        ArrayAdapter<String>adapter=new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,empList);

        empTypeSP.setAdapter(adapter);

        empTypeSP.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selecteType=empList[position];
                Toast.makeText(EmployeeListActivity.this, selecteType, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });

        LinearLayoutManager llm=new LinearLayoutManager(this);
        empRV.setLayoutManager(llm);
        empRV.setAdapter(employeeAdapter);


    }
    private List<BaseSalarriedEmployee> genereateEmployeeData(){
        List<BaseSalarriedEmployee> bslist=new ArrayList<>();
        bslist.add(new BaseSalarriedEmployee("Moshiur","12-03-1993", "moshiur@gmail.com","0171","manager","Gender", 1000));
        bslist.add(new BaseSalarriedEmployee("Moshiur","12-03-1993", "moshiur@gmail.com","0171","manager","Gender", 1000));
        bslist.add(new BaseSalarriedEmployee("Moshiur","12-03-1993", "moshiur@gmail.com","0171","manager","Gender", 1000));
        bslist.add(new BaseSalarriedEmployee("Moshiur","12-03-1993", "moshiur@gmail.com","0171","manager","Gender", 1000));
        bslist.add(new BaseSalarriedEmployee("Moshiur","12-03-1993", "moshiur@gmail.com","0171","manager","Gender", 1000));
        bslist.add(new BaseSalarriedEmployee("Moshiur","12-03-1993", "moshiur@gmail.com","0171","manager","Gender", 1000));
        bslist.add(new BaseSalarriedEmployee("Moshiur","12-03-1993", "moshiur@gmail.com","0171","manager","Gender", 1000));
        bslist.add(new BaseSalarriedEmployee("Moshiur","12-03-1993", "moshiur@gmail.com","0171","manager","Gender", 1000));
        bslist.add(new BaseSalarriedEmployee("Moshiur","12-03-1993", "moshiur@gmail.com","0171","manager","Gender", 1000));
        bslist.add(new BaseSalarriedEmployee("Moshiur","12-03-1993", "moshiur@gmail.com","0171","manager","Gender", 1000));
        bslist.add(new BaseSalarriedEmployee("Moshiur","12-03-1993", "moshiur@gmail.com","0171","manager","Gender", 1000));
        bslist.add(new BaseSalarriedEmployee("Moshiur","12-03-1993", "moshiur@gmail.com","0171","manager","Gender", 1000));
        bslist.add(new BaseSalarriedEmployee("Moshiur","12-03-1993", "moshiur@gmail.com","0171","manager","Gender", 1000));
        bslist.add(new BaseSalarriedEmployee("Moshiur","12-03-1993", "moshiur@gmail.com","0171","manager","Gender", 1000));
        bslist.add(new BaseSalarriedEmployee("Moshiur","12-03-1993", "moshiur@gmail.com","0171","manager","Gender", 1000));
        bslist.add(new BaseSalarriedEmployee("Moshiur","12-03-1993", "moshiur@gmail.com","0171","manager","Gender", 1000));

        return bslist;
    }
}

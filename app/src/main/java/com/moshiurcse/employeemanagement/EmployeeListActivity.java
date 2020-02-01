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

import com.moshiurcse.employeemanagement.adapters.BasePlusCommisionEmployeeAdapter;
import com.moshiurcse.employeemanagement.adapters.BaseSalarriedEmployeeAdapter;
import com.moshiurcse.employeemanagement.adapters.HourlySalarriedEmployeeAdapter;
import com.moshiurcse.employeemanagement.entities.BasePlusCommisionEmployee;
import com.moshiurcse.employeemanagement.entities.BaseSalarriedEmployee;
import com.moshiurcse.employeemanagement.entities.Employee;
import com.moshiurcse.employeemanagement.roomdb.EmployeeDB;
import com.moshiurcse.employeemanagement.utils.ConstantUtils;

import java.util.ArrayList;
import java.util.List;

public class EmployeeListActivity extends AppCompatActivity {

    private Spinner empTypeSP;


    private RecyclerView empRV;
    private BaseSalarriedEmployeeAdapter employeeAdapter;
    private HourlySalarriedEmployeeAdapter employeeAdapterHourly;
    private BasePlusCommisionEmployeeAdapter employeeAdapterComission;

    //private Employee empClassList;

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

        employeeAdapter=new BaseSalarriedEmployeeAdapter(this,EmployeeDB.getInstance(this).getBaseSalariedEmployeeDAO().getAllBaseSalariedEmployee());
        employeeAdapterHourly=new HourlySalarriedEmployeeAdapter(this,EmployeeDB.getInstance(this).getHourlySalarriedEmployeeDAO().getAllHourlySalarriedEmployee());


        employeeAdapterComission=new BasePlusCommisionEmployeeAdapter(this,EmployeeDB.getInstance(this).getBasePlusCommisionEmployeeDAO().getBasePlusCommisionEmployee());



        ArrayAdapter<String>adapter=new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,empList);
        empTypeSP.setAdapter(adapter);


        LinearLayoutManager llm=new LinearLayoutManager(this);
        empRV.setLayoutManager(llm);

        empTypeSP.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //String selecteType=empList[position];

                if(position==0){
                    empRV.setAdapter(employeeAdapter);
                }else if(position==1){
                    empRV.setAdapter(employeeAdapterHourly);
                }
                else{
                    empRV.setAdapter(employeeAdapterComission);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });







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

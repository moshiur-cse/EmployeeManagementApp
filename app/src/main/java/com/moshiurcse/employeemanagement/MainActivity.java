package com.moshiurcse.employeemanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.transition.Fade;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.moshiurcse.employeemanagement.models.BasePlusCommisionEmployee;
import com.moshiurcse.employeemanagement.models.BaseSalarriedEmployee;
import com.moshiurcse.employeemanagement.models.Employee;
import com.moshiurcse.employeemanagement.models.HourlySalarriedEmployee;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    private EditText nameET,dobET,phoneET,emailET,baseSalaryET,totalHourET,hourlyRateET,commitionRateET,grossSaleET;

    private RadioGroup genderRG,typeRG;

    private String gender="Male";
    private String emp_type="Base Salaried Employee";
    private String dob="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameET=findViewById(R.id.empNameInput);
        dobET=findViewById(R.id.empDobInput);
        phoneET=findViewById(R.id.empPhoneInput);
        emailET=findViewById(R.id.empEmailInput);
        baseSalaryET=findViewById(R.id.baseSalaryInput);
        totalHourET=findViewById(R.id.totalHourInput);
        hourlyRateET=findViewById(R.id.hourlyRateInput);
        commitionRateET=findViewById(R.id.commisionRateInput);
        grossSaleET=findViewById(R.id.grossSaleInput);

        genderRG=findViewById(R.id.genderTypeRadioGroup);
        typeRG=findViewById(R.id.empTypeTypeRadioGroup);

        genderRG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            //Annonimus Class
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb=findViewById(checkedId);
                gender=rb.getText().toString();
                //short coure Toast + Tab
                //Toast.makeText(MainActivity.this, rb.getText().toString(), Toast.LENGTH_SHORT).show();

            }
        });
        typeRG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                RadioButton rb=findViewById(checkedId);
                emp_type=rb.getText().toString();

                activateDeactivateView(checkedId);
                //short coure Toast + Tab
                //Toast.makeText(MainActivity.this, rb.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void activateDeactivateView(int checkedId) {
        switch (checkedId){
            case R.id.rbBaseSalarriedEmployee:


                //baseSalaryET.setVisibility(View.VISIBLE);
                slidesShow(baseSalaryET);


                //totalHourET.animate().setDuration(5000).start();
                //totalHourET.setVisibility(View.GONE);
                slideHide(totalHourET);



                //hourlyRateET.animate().setDuration(5000).start();
                //hourlyRateET.setVisibility(View.GONE);
                slideHide(hourlyRateET);

                //commitionRateET.setVisibility(View.GONE);
                slideHide(commitionRateET);
                //grossSaleET.setVisibility(View.GONE);
                slideHide(grossSaleET);

                break;

            case R.id.rbHourlySalarriedEmployee:
                //baseSalaryET.setVisibility(View.GONE);
                slideHide(baseSalaryET);


                //totalHourET.setVisibility(View.VISIBLE);
                slidesShow(totalHourET);
                //hourlyRateET.setVisibility(View.VISIBLE);
                slidesShow(hourlyRateET);

                //commitionRateET.setVisibility(View.GONE);
                slideHide(commitionRateET);

                //grossSaleET.setVisibility(View.GONE);
                slideHide(grossSaleET);

                break;
            case R.id.rbBaseAndCommisionSalarriedEmployee:

                //baseSalaryET.setVisibility(View.GONE);
                slideHide(baseSalaryET);

                //totalHourET.setVisibility(View.GONE);
                slideHide(totalHourET);

                //hourlyRateET.setVisibility(View.GONE);
                slideHide(hourlyRateET);
                //commitionRateET.setVisibility(View.VISIBLE);
                slidesShow(commitionRateET);
                //grossSaleET.setVisibility(View.VISIBLE);
                slidesShow(grossSaleET);

                break;
            default:
                break;
        }
    }

    public void registerNewEmployee(View view) {
        String name=nameET.getText().toString();
        String email=emailET.getText().toString();
        String mobile=phoneET.getText().toString();

        switch (emp_type){
            case "Base Salaried Employee":
                String baseSalary=baseSalaryET.getText().toString();
                BaseSalarriedEmployee bse =new BaseSalarriedEmployee();

                bse.setEmp_name(name);
                bse.setDob(dob);
                bse.setEmp_phone(mobile);
                bse.setEmp_email(email);
                bse.setEmp_gender(gender);
                bse.setEmp_designation(emp_type);
                bse.setBase_salary(Double.parseDouble(baseSalary));
                Log.e("Employee","RegisterNewEmployee"+bse);


                break;
            case "Hourly Salary Employee":
                String totalHour=totalHourET.getText().toString();
                String hourlyRate=hourlyRateET.getText().toString();


                HourlySalarriedEmployee hse =new HourlySalarriedEmployee();

                hse.setEmp_name(name);
                hse.setDob(dob);
                hse.setEmp_phone(mobile);
                hse.setEmp_email(email);
                hse.setEmp_gender(gender);
                hse.setEmp_designation(emp_type);
                hse.setHourly_rate(Double.parseDouble(hourlyRate));
                hse.setTotal_hour(Double.parseDouble(totalHour));

                break;
            case "Base and Commision Salary Employee":
                String baseSalary1=baseSalaryET.getText().toString();
                String commisionRate=commitionRateET.getText().toString();
                String grossSale=grossSaleET.getText().toString();

                BasePlusCommisionEmployee bpse =new BasePlusCommisionEmployee();

                bpse.setEmp_name(name);
                bpse.setEmp_phone(mobile);
                bpse.setEmp_email(email);
                bpse.setDob(dob);
                bpse.setEmp_gender(gender);
                bpse.setEmp_designation(emp_type);
                bpse.setBaseSalary1(Double.parseDouble(baseSalary1));
                bpse.setCommision_rate(Double.parseDouble(commisionRate));
                bpse.setGross_total(Double.parseDouble(grossSale));

                break;


        }

    }

    public void showDatePicker(View view) {
        Calendar calendar=Calendar.getInstance();

        int year=calendar.get(Calendar.YEAR);
        int month=calendar.get(Calendar.MONTH);
        int day=calendar.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePickerDialog= new DatePickerDialog
                (this, this , year,month,day);
        datePickerDialog.show();
    }


    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar calendar=Calendar.getInstance();
        calendar.set(year,month,dayOfMonth);
        //dobET.setText(dayOfMonth+'/'+(month+1)+'/'+year);
        SimpleDateFormat sdf =new SimpleDateFormat("dd/MM/yyyy");
        //SimpleDateFormat sdf =new SimpleDateFormat("MMM dd, yyyy");
        dob =sdf.format(calendar.getTime());
        dobET.setText(dob);
    }

    public void slidesShow(View view){

        TranslateAnimation animate = new TranslateAnimation(
                0,                 // fromXDelta
                0,                 // toXDelta
                view.getHeight(),          // fromYDelta
                0);                // toYDelta
        animate.setDuration(500);
        animate.setFillAfter(true);
        view.setVisibility(View.VISIBLE);
        view.startAnimation(animate);


    }

    // slide the view from its current position to below itself
    public void slideHide(View view){

        TranslateAnimation animate = new TranslateAnimation(
                0,                 // fromXDelta
               0,// toXDelta
                0,                 // fromYDelta
                view.getWidth()); // toYDelta
        animate.setDuration(500);
        animate.setFillAfter(true);
        view.setVisibility(View.GONE);
        view.startAnimation(animate);

    }
}

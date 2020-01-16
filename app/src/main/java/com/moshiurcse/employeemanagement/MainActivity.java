package com.moshiurcse.employeemanagement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.moshiurcse.employeemanagement.entities.BasePlusCommisionEmployee;
import com.moshiurcse.employeemanagement.entities.BaseSalarriedEmployee;
import com.moshiurcse.employeemanagement.entities.HourlySalarriedEmployee;
import com.moshiurcse.employeemanagement.prefs.AuthPreference;
import com.moshiurcse.employeemanagement.roomdb.EmployeeDB;
import com.moshiurcse.employeemanagement.utils.ConstantUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    private EditText nameET,dobET,phoneET,emailET,baseSalaryET,totalHourET,hourlyRateET,commitionRateET,grossSaleET;

    private RadioGroup genderRG,typeRG;

    private AuthPreference authPreference;

    private String gender="Male";
    private String emp_type="Base Salaried Employee";
    private String dob="";


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.main_menu,menu);
        //menuInflater.inflate(R.menu.main_menu,menu);
        //menuInflater.inflate(R.menu.);
         //menuInflater.inflate(R.menu,menu);
        //menuInflater.inflate(R.menu.);
        //menuInflater.inflate(R.menu.);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.itemSetting:
                Toast.makeText(this,"Comming Soon",Toast.LENGTH_SHORT).show();
                break;

            case R.id.itemLogOut:
                authPreference.setLoginStatus(false);
                finish();
                Intent intent=new Intent(this,LoginActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        authPreference =new AuthPreference(this);

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

                //totalHourET.setVisibility(View.GONE);
                slideHide(totalHourET);

                //hourlyRateET.setVisibility(View.GONE);
                slideHide(hourlyRateET);

                //baseSalaryET.setVisibility(View.GONE);
                slidesShow(baseSalaryET);

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
            case ConstantUtils.EmployeeType.BASE_SALARIED:

                String baseSalary=baseSalaryET.getText().toString();
                BaseSalarriedEmployee bse =new BaseSalarriedEmployee(name,dob,email,mobile,emp_type,gender,Double.parseDouble(baseSalary));

        final long empId= EmployeeDB.getInstance(this).getBaseSalariedEmployeeDAO().insertBaseSalariedEmployee(bse);

        if(empId>0){
            Intent intent=new Intent(this,EmployeeListActivity.class);
            startActivity(intent);


            }else{
            Toast.makeText(this, "Faild", Toast.LENGTH_SHORT).show();

        }


               /* Log.e("Employee","RegisterNewEmployee"+bse);
                Log.e("Employee","Total Salary="+bse.getTotalSalary());
                Toast.makeText(this,"Total Salary="+bse.getTotalSalary(),Toast.LENGTH_LONG).show();
*/
                break;

            case "Hourly Salary Employee":
                String totalHour=totalHourET.getText().toString();
                String hourlyRate=hourlyRateET.getText().toString();


                HourlySalarriedEmployee hse =new HourlySalarriedEmployee(name,dob,email,mobile,emp_type,gender,Double.parseDouble(hourlyRate),Double.parseDouble(totalHour));

                final long empIdHourly= EmployeeDB.getInstance(this).getHourlySalarriedEmployeeDAO().insertHourlySalarriedEmployee(hse);

                if(empIdHourly>0){
                    Intent intent=new Intent(this,EmployeeListActivity.class);
                    startActivity(intent);

                }else{
                    Toast.makeText(this, "Faild", Toast.LENGTH_SHORT).show();
                }

                break;
            case "Base and Commision Salary Employee":
                //String baseSalary=baseSalaryET.getText().toString();
                String baseSalary1=baseSalaryET.getText().toString();
                String commisionRate=commitionRateET.getText().toString();
                String grossSale=grossSaleET.getText().toString();

                BasePlusCommisionEmployee bpse =new BasePlusCommisionEmployee(name,dob,email,mobile,emp_type,gender,Double.parseDouble(baseSalary1),Double.parseDouble(commisionRate),Double.parseDouble(grossSale));

                final long empIdCommision= EmployeeDB.getInstance(this).getBasePlusCommisionEmployeeDAO().insertBasePlusCommisionEmployee(bpse);

                if(empIdCommision>0){
                    Intent intent=new Intent(this,EmployeeListActivity.class);
                    startActivity(intent);


                }else{
                    Toast.makeText(this, "Faild", Toast.LENGTH_SHORT).show();

                }
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

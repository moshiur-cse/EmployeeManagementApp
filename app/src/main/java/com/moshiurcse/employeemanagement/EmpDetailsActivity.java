package com.moshiurcse.employeemanagement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.moshiurcse.employeemanagement.databinding.ActivityEmpDetailsBinding;
import com.moshiurcse.employeemanagement.entities.BaseSalarriedEmployee;
import com.moshiurcse.employeemanagement.roomdb.EmployeeDB;

public class EmpDetailsActivity extends AppCompatActivity {
    private ActivityEmpDetailsBinding binding;
    private long empId = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Employee Details");
        //setContentView(R.layout.activity_emp_details);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_emp_details);

        empId = getIntent().getLongExtra("empId", -1);

        if (empId > 0) {
            final BaseSalarriedEmployee bse = EmployeeDB.getInstance(this).getBaseSalariedEmployeeDAO().getBaseSalarriedEmpById(empId);

            binding.detailsEmpName.setText(bse.getEmp_name());
            binding.detailsEmpDesignation.setText(bse.getEmp_designation());
            binding.detailsEmpDob.setText(bse.getDob());
            binding.detailsEmpEmail.setText(bse.getEmp_email());

            binding.detailsEmpPhone.setText(bse.getEmp_phone());
            binding.detailsEmpGender.setText(bse.getEmp_gender());
            binding.detailsEmpBaseSalary.setText(String.valueOf(bse.getBase_salary()));

            binding.detailsEmpPhone.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    /*Uri phoneUri= Uri.parse("tel:"+bse.getEmp_phone());
                    Intent intent=new Intent(Intent.ACTION_DIAL,phoneUri);
                    if(intent.resolveActivity(getPackageManager())!=null) {
                        startActivity(intent);
                    }else {
                        Toast.makeText(EmpDetailsActivity.this, "No component found", Toast.LENGTH_SHORT).show();

                    }*/

                    Uri phoneUri = Uri.parse("tel:" + bse.getEmp_phone());
                    Intent intent = new Intent(Intent.ACTION_CALL, phoneUri);
                    if (intent.resolveActivity(getPackageManager()) != null) {

                        if (isCallPermissionGranted()) {
                            if (checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                                // TODO: Consider calling
                                //    Activity#requestPermissions
                                // here to request the missing permissions, and then overriding
                                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                                //                                          int[] grantResults)
                                // to handle the case where the user grants the permission. See the documentation
                                // for Activity#requestPermissions for more details.
                                return;
                            }
                            startActivity(intent);
                        }
                    }else {
                        Toast.makeText(EmpDetailsActivity.this, "No component found", Toast.LENGTH_SHORT).show();

                    }

                }
            });

            binding.detailsEmpEmail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(Intent.ACTION_SEND);
                    i.setType("message/rfc822");
                    i.putExtra(Intent.EXTRA_EMAIL  , new String[]{bse.getEmp_email()});
                    i.putExtra(Intent.EXTRA_SUBJECT, "Send Mail Details");
                    i.putExtra(Intent.EXTRA_TEXT   , "Good To See You");
                    try {
                        startActivity(Intent.createChooser(i, "Send mail..."));
                    } catch (android.content.ActivityNotFoundException ex) {
                        Toast.makeText(EmpDetailsActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                    }

                }
            });
        }
    }




    private boolean isCallPermissionGranted(){
        String[]permissions={Manifest.permission.CALL_PHONE};

        if(checkSelfPermission(Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED) {
            requestPermissions(permissions,789);
            return false;
        }
        return true;

        }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
       /* super.onRequestPermissionsResult(requestCode, permissions, grantResults);*/
    }
}

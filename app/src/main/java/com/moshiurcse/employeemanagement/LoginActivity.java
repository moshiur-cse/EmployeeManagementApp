package com.moshiurcse.employeemanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.moshiurcse.employeemanagement.utils.ConstantUtils;

public class LoginActivity extends AppCompatActivity {

    TextInputEditText mailAdressET,passwordET;
    Button loginAdminBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mailAdressET=findViewById(R.id.mailAdressET);
        passwordET=findViewById(R.id.passwordET);

    }

    public void loginAdminBtn(View view) {

        String mailAdress=mailAdressET.getText().toString();
        String password=passwordET.getText().toString();

        if (mailAdress.equals(ConstantUtils.Admin.EMAIL_ADRESS) && password.equals(ConstantUtils.Admin.PASSWORD)){
            finish();
            Intent intent=new Intent(LoginActivity.this,MainActivity.class);
            startActivity(intent);

        }else{
            Toast.makeText(this,"Log in fails",Toast.LENGTH_SHORT).show();
        }


    }
}

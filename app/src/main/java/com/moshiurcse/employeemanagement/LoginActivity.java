package com.moshiurcse.employeemanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.moshiurcse.employeemanagement.prefs.AuthPreference;
import com.moshiurcse.employeemanagement.utils.ConstantUtils;

public class LoginActivity extends AppCompatActivity {
    private AuthPreference authPreference;
    private TextInputEditText mailAdressET,passwordET;
    Button loginAdminBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();

        setContentView(R.layout.activity_login);
        mailAdressET=findViewById(R.id.emailET);
        passwordET=findViewById(R.id.passwordET);

        authPreference =new AuthPreference(this);

        if(authPreference.isAdminLoggedIn()){
            goToDashboardActivity();
        }

    }

    public void loginAdminBtn(View view) {

        String mailAdress=mailAdressET.getText().toString();
        String password=passwordET.getText().toString();

        if (mailAdress.equals(ConstantUtils.Admin.EMAIL_ADRESS) && password.equals(ConstantUtils.Admin.PASSWORD)){
            authPreference.setLoginStatus(true);
            goToDashboardActivity();

        }else{
            Toast.makeText(this,"Log in fails",Toast.LENGTH_SHORT).show();
        }

    }
    private void goToDashboardActivity(){
        finish();
        Intent intent=new Intent(LoginActivity.this,AdminDashboardActivity.class);
        startActivity(intent);

    }

}

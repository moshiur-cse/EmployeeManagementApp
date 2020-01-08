package com.moshiurcse.employeemanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {

     private TextInputEditText emailET,passwordET;
     private Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        emailET=findViewById(R.id.emailET);
        passwordET=findViewById(R.id.passwordET);

    }

    public void loginAdmin(View view) {
        String email=emailET.getText().toString();
        String pass=passwordET.getText().toString();
    }

}

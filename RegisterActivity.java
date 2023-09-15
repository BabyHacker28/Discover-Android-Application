package com.abinayak.discoverandroidapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import kotlin.text.Regex;

public class RegisterActivity extends AppCompatActivity {
    EditText username, phoneno1, phoneno2, mailID, password;
    Button Signup;
    boolean isAllFieldsChecked  = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        username = findViewById(R.id.Reg_name);
        phoneno1 = findViewById(R.id.Reg_ph1);
        phoneno2 = findViewById(R.id.Reg_ph2);
        mailID = findViewById(R.id.Mail_reg);
        password = findViewById(R.id.Reg_pass);
        Signup = findViewById(R.id.btn_reg);
        String name1 = username.getText().toString();
        String password1 = password.getText().toString();
        String phone1 = phoneno1.getText().toString();
        String phone2 = phoneno2.getText().toString();
        String mail = mailID.getText().toString();

        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isAllFieldsChecked = CheckAllFields();
                if (isAllFieldsChecked) {
                    Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    private boolean CheckAllFields(){
        if (username.length() == 0) {
            username.setError("Field cannot be empty");
            return false;
        }
         if (mailID.length() == 0) {
            mailID.setError("Field can't be empty");
            return false;
        }
         if (phoneno1.length() == 0) {
            phoneno1.setError("Field can't be empty");
            return false;
        }
         if (phoneno2.length() == 0) {
            phoneno2.setError("Field can't be empty");
            return false;
        }if (password.length() <= 5) {
            password.setError("Minimum 6 characters required");
            return false;
        }
         else {
            return true;
        }
    }
}
package com.abinayak.discoverandroidapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.Manifest.permission;
import java.util.ArrayList;



public class MainActivity extends AppCompatActivity {
    SQLiteDatabase db;
    EditText username, password;
    Button signin, register;
    boolean isAllFieldsChecked  = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = openOrCreateDatabase("Database",MODE_PRIVATE,null);
        String create = "Create table if not exists login ( username Varchar(10), password varchar(8))";
        db.execSQL(create);
        String insert = "Insert into login values ('Abinaya','2345');";
        db.execSQL(insert);
        String[] args = {"Abinaya"};
        String select = "Select password from login where username = ? ;";
        Cursor m = db.rawQuery(select,args);
        ArrayList<String> a = new ArrayList<String>();
        if(m.moveToFirst()){
            do{
                a.add(m.getString(0));
            }while(m.moveToNext());
        }
        username = findViewById(R.id.login_name);
        password = findViewById(R.id.log_pass);
        signin = findViewById(R.id.login_btn);
        register = findViewById(R.id.lregister_btn);
        String name = username.getText().toString();
        String password1 = password.getText().toString();
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isAllFieldsChecked = CheckAllFields();
                if (isAllFieldsChecked) {
                    Intent intent1 = new Intent(MainActivity.this, homepage.class);
                    startActivity(intent1);
                    finish();
                }
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private boolean CheckAllFields(){
        if (username.length() == 0) {
            username.setError("Field cannot be empty");
            return false;
        } if (password.length() <= 5) {
            password.setError("Minimum 6 characters required");
            return false;
        }
        else{
            return true;
        }
    }
}
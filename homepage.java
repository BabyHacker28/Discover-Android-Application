package com.abinayak.discoverandroidapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class homepage extends AppCompatActivity {
    Button profile, findmydevice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        profile = findViewById(R.id.btn_home);
        findmydevice = findViewById(R.id.btn2_home);
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(homepage.this, profilepg.class);
                startActivity(intent2);
                finish();
            }
        });
        findmydevice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 Intent intent = new Intent(homepage.this, findmydevice.class);
                 startActivity(intent);
                 finish();
            }
        });
    }
}
package com.abinayak.discoverandroidapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class findmydevice extends AppCompatActivity {
    Button gotofindmydev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_findmydevice);

        gotofindmydev = findViewById(R.id.btnfindmydev);
        gotofindmydev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1= new Intent(findmydevice.this, MyLocation.class);
                startActivity(i1);
                finish();
            }
        });

    }
}
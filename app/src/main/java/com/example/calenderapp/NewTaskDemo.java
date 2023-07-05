package com.example.calenderapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;

import androidx.appcompat.app.AppCompatActivity;

public class NewTaskDemo  extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_task);
        Button bButton = findViewById(R.id.bButton);

        bButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle back button click event
                // Add your desired functionality here
                Intent b2 = new Intent(NewTaskDemo.this, MainCalenderView.class);
                startActivity(b2);
                finish();
            }
        });
        }
    }
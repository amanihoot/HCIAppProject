package com.example.calenderapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class NewTaskDemo extends AppCompatActivity {

    private static final int RESULT_OK = 1;
    private static final String EXTRA_TASK_NAME = "taskName";
    private static final String EXTRA_TASK_DATE = "taskDate";

    private EditText taskNameEditText;
    private EditText taskDateEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_task);

        Button backButton = findViewById(R.id.bButton);
        Button saveButton = findViewById(R.id.buttonSave);

        taskNameEditText = findViewById(R.id.editTextTaskName);
        taskDateEditText = findViewById(R.id.editTextTaskDate);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewTaskDemo.this, MainCalenderView.class);
                startActivity(intent);
                finish();
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String taskName = taskNameEditText.getText().toString();
                String taskDate = taskDateEditText.getText().toString();

                Intent resultIntent = new Intent();
                resultIntent.putExtra(EXTRA_TASK_NAME, taskName);
                resultIntent.putExtra(EXTRA_TASK_DATE, taskDate);
                setResult(RESULT_OK, resultIntent);

                Toast t = Toast.makeText(NewTaskDemo.this, "Event has been saved!", Toast.LENGTH_SHORT);
                t.show();

            }
        });
    }
}
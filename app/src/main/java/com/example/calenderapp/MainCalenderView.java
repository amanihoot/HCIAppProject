package com.example.calenderapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.ListView;
import java.util.ArrayList;
import android.widget.ArrayAdapter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainCalenderView  extends AppCompatActivity {

    // Define the variable of CalendarView type
    // and TextView type;
    CalendarView calendar;
    //TextView date_view;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calender_main_view);
        ListView listView = findViewById(R.id.List);

        ArrayList<String> todoList = new ArrayList<>();
// Add some sample data
        todoList.add("July 4 2023 - Vet Appointment");
        todoList.add("July 18 2023- Lunch with Katie");
        todoList.add("Juley 19 2023 - Meeting with Boss");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, todoList);
        listView.setAdapter(adapter);

        Button backButton = findViewById(R.id.backButton);
        Button taskButton = findViewById(R.id.TaskButton);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle back button click event
                // Add your desired functionality here
                Intent b = new Intent(MainCalenderView.this, MainActivity.class);
                startActivity(b);
                finish();
            }
        });

        taskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent t = new Intent(MainCalenderView.this, NewTaskDemo.class);
                startActivity(t);
                finish();
            }
        });

        // By ID we can use each component
        // which id is assign in xml file
        // use findViewById() to get the
        // CalendarView and TextView
        calendar = (CalendarView)
                findViewById(R.id.calendar);
      /*  date_view = (TextView)
                findViewById(R.id.date_view);*/

        // Add Listener in calendar
        calendar.setOnDateChangeListener(
                        new CalendarView
                                .OnDateChangeListener() {
                            @Override

                            // In this Listener have one method
                            // and in this method we will
                            // get the value of DAYS, MONTH, YEARS
                            public void onSelectedDayChange(
                                    CalendarView view,
                                    int year,
                                    int month,
                                    int dayOfMonth)
                            {

                                // Store the value of date with
                                // format in String type Variable
                                // Add 1 in month because month
                                // index is start with 0
                                String Date
                                        = dayOfMonth + "-"
                                        + (month + 1) + "-" + year;

                                // set this date in TextView for Display
                                /* date_view.setText(Date);*/
                            }
                        });
    }
}
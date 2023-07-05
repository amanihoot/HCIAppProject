package com.example.calenderapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.ListView;
import java.util.ArrayList;
import android.widget.ArrayAdapter;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class MainCalenderView extends AppCompatActivity {

    CalendarView calendar;
    TextView todoText;
    ListView listView;
    ArrayAdapter<String> adapter;

    ArrayList<String> todoList;

    private static final int REQUEST_CODE_ADD_TASK = 1;
    private static final String EXTRA_TASK_NAME = "task_name";
    private static final String EXTRA_TASK_DATE = "task_date";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calender_main_view);

        listView = findViewById(R.id.List);

        todoList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, todoList);
        listView.setAdapter(adapter);

        Button backButton = findViewById(R.id.backButton);
        Button taskButton = findViewById(R.id.TaskButton);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b = new Intent(MainCalenderView.this, MainActivity.class);
                startActivity(b);
                finish();
            }
        });

        taskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent t = new Intent(MainCalenderView.this, NewTaskDemo.class);



                startActivityForResult(t, REQUEST_CODE_ADD_TASK);

                finish();
            }
        });

        todoText = findViewById(R.id.TodoText);
        todoText.setText("To-Do");

        calendar = findViewById(R.id.calendar);

        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                Calendar selectedDate = Calendar.getInstance();
                selectedDate.set(year, month, dayOfMonth);

                SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM yyyy", Locale.getDefault());
                String formattedDate = dateFormat.format(selectedDate.getTime());

                todoText.setText("To-Do " + formattedDate);

                updateListContents(month);
            }
        });

        // Initialize the list contents based on the current month
        Calendar currentDate = Calendar.getInstance();
        int currentMonth = currentDate.get(Calendar.MONTH);
        updateListContents(currentMonth);
    }

    private void updateListContents(int month) {
        todoList.clear();

        // Add sample data based on the selected month
        switch (month) {
            case Calendar.JANUARY:
                todoList.add("January 1 2023: Start New Year's resolutions");
                todoList.add("January 15 2023: Plan winter vacation");
                break;
            case Calendar.FEBRUARY:
                todoList.add("February 5 2023: Attend friend's birthday party");
                todoList.add("February 12 2023: Prepare Valentine's Day surprise");
                break;
            case Calendar.MARCH:
                todoList.add("March 1 2023: Spring cleaning");
                todoList.add("March 22 2023: Plan garden renovation");
                break;
            case Calendar.APRIL:
                todoList.add("April 10 2023: Prepare taxes");
                todoList.add("April 20 2023: Attend business conference");
                break;
            case Calendar.MAY:
                todoList.add("May 11 2023: Plan summer vacation");
                todoList.add("May 12 2023: Organize family gathering");
                break;
            case Calendar.JUNE:
                todoList.add("June 18 2023: Attend graduation ceremony");
                todoList.add("June 24 2023: Start outdoor fitness routine");
                break;
            case Calendar.JULY:
                todoList.add("July 1 2023: Enjoy summer vacation");
                todoList.add("July 4 2023: Attend fireworks show");
                break;
            case Calendar.AUGUST:
                todoList.add("August 17 2023: Visit amusement park");
                todoList.add("August 20 2023: Attend friend's wedding");
                break;
            case Calendar.SEPTEMBER:
                todoList.add("September 1 2023: Plan hiking trip");
                todoList.add("September 20 2023: Start new hobby");
                break;
            case Calendar.OCTOBER:
                todoList.add("October 20 2023: Decorate home for Halloween");
                todoList.add("October 31 2023: Attend costume party");
                break;
            case Calendar.NOVEMBER:
                todoList.add("November 24 2023: Celebrate Thanksgiving");
                todoList.add("November 25 2023: Volunteer for charity event");
                break;
            case Calendar.DECEMBER:
                todoList.add("December 1 2023: Prepare for holidays");
                todoList.add("December 29 2023: Attend company holiday party");
                break;
        }

        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_ADD_TASK && resultCode == RESULT_OK) {
            String taskName = data.getStringExtra(EXTRA_TASK_NAME);
            String taskDate = data.getStringExtra(EXTRA_TASK_DATE);

            // Create a new task object using the received data
            String newTask = taskDate + " - " + taskName;

            // Add the new task to the list
            todoList.add(newTask);

            // Notify the adapter of the data change
            adapter.notifyDataSetChanged();
        }
    }
}

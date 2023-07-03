package com.example.calenderapp;


import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        EditText username = findViewById(R.id.userN);
        EditText password = findViewById(R.id.passW);
        Button login = findViewById(R.id.LoginButton);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                determineLogin(username.getText().toString(), password.getText().toString());
            }
        });

    }

    private void determineLogin(String one, String two) {
        String u = one;
        String p = two;

        String useradmin1 = "Admin1";
        String useradmin2 = "Admin2";
        String passadmin1 = "Password1";
        String passadmin2 = "Password2";

        boolean isCorrect = false;

        if (u.equals(useradmin1) && p.equals(passadmin1)){
            System.out.print("Working");
        }
        else{
            System.out.print("ERROR");
        }

       // switchToResultScreen(grade);
    }
}
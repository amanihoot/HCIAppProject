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

    EditText username;
    EditText password;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.userN);
        password = findViewById(R.id.passW);
        login = findViewById(R.id.LoginButton);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkDataEntered();

            }
        });

    }
    //public boolean isEmpty() {
    //   return;
    //}

    void checkDataEntered() {

        if (username.getText().toString().isEmpty() || password.getText().toString().isEmpty()) {
            Toast t = Toast.makeText(this, "Please enter your credentials", Toast.LENGTH_SHORT);
            t.show();
        } else {
            checkUsername();
        }

    }

    private void checkUsername() {
        boolean isValid = true;
        if (username.getText().toString().isEmpty()) {
            username.setError("You must enter username to login!");
            isValid = false;
        }
        if (password.getText().toString().isEmpty()) {
            password.setError("You must enter password to login!");
            isValid = false;
        } else {
            if (password.getText().toString().length() < 4) {
                password.setError("Password must be at least 4 chars long!");
                isValid = false;
            }
        }

        //check email and password

        if (isValid) {
            String usernameValue = username.getText().toString();
            String passwordValue = password.getText().toString();
            if (usernameValue.equals("Admin1") && passwordValue.equals("password1")) {
                //everything checked we open new activity
                Intent i = new Intent(MainActivity.this, NewEventView.class);
                startActivity(i);
                finish();

            } else {
                Toast t = Toast.makeText(this, "Wrong username or password!", Toast.LENGTH_SHORT);
                t.show();
            }
        }

    }

}
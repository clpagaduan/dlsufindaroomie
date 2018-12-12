package com.example.clpagaduan.dlsu_find_a_roomie;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;

public class SignUp_page extends AppCompatActivity {

    TextView lastName;
    TextView firstName;
    TextView gender;
    TextView email;
    TextView username;
    TextView password;
    Button backbtn;
    Button submitbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page);

        lastName = findViewById(R.id.lastName);
        firstName = findViewById(R.id.firstName);
        gender = findViewById(R.id.gender);
        email = findViewById(R.id.email);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        backbtn = findViewById(R.id.backbtn);
        submitbtn = findViewById(R.id.submitbtn);

    }

}

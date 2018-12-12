package com.example.clpagaduan.dlsu_find_a_roomie;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class postRoom extends AppCompatActivity {
    Button findRoomiebtn;
    Button postRoombtn;
    Button myProfilebtn;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.postroom);

        findRoomiebtn = findViewById(R.id.findRoomiebtn);
        postRoombtn = findViewById(R.id.postRoombtn);
        myProfilebtn = findViewById(R.id.myProfilebtn);
        submit = findViewById(R.id.submit);

        findRoomiebtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), findRoomie.class);
                postRoom.this.startActivity(intent);
            }
        });

        postRoombtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), postRoom.class);
                postRoom.this.startActivity(intent);
            }
        });

        myProfilebtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                postRoom.this.startActivity(intent);
            }
        });

        //ONCE SUBMITTED, NEW ROOM MUST BE ADDED TO THE DATABASE
        submit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(postRoom.this,
                        "Room has been posted!", Toast.LENGTH_LONG).show();
            }
        });

    }
}
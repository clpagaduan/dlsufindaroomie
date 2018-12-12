package com.example.clpagaduan.dlsu_find_a_roomie;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    Button findRoomiebtn;
    Button postRoombtn;
    Button myProfilebtn;

    //USER'S DETAILS FROM DB MUST BE PRINTED HERE
    //USER'S ROOM WISHLIST FROM DB MUST BE PRINTED HERE

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findRoomiebtn = findViewById(R.id.findRoomiebtn);
        postRoombtn = findViewById(R.id.postRoombtn);
        myProfilebtn = findViewById(R.id.myProfilebtn);

        findRoomiebtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), findRoomie.class);
                MainActivity.this.startActivity(intent);
            }
        });

       postRoombtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), postRoom.class);
                MainActivity.this.startActivity(intent);
            }
        });

        myProfilebtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });
    }
}

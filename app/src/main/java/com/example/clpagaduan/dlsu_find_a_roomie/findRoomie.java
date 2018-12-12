package com.example.clpagaduan.dlsu_find_a_roomie;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.util.Log;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;



public class findRoomie extends AppCompatActivity implements OnItemClickListener {
    Button findRoomiebtn;
    Button postRoombtn;
    Button myProfilebtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.findroomie);

        ListView listview = (ListView) findViewById(R.id.listView);
        listview.setOnItemClickListener(this);

        findRoomiebtn = findViewById(R.id.findRoomiebtn);
        postRoombtn = findViewById(R.id.postRoombtn);
        myProfilebtn = findViewById(R.id.myProfilebtn);

        findRoomiebtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), findRoomie.class);
                findRoomie.this.startActivity(intent);
            }
        });

        postRoombtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), postRoom.class);
                findRoomie.this.startActivity(intent);
            }
        });

        myProfilebtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                findRoomie.this.startActivity(intent);
            }
        });
    }

        //LIST OF HARDCODED ROOMS ARE IN RES -> VALUES -> ARRAY.XML
     public void onItemClick(AdapterView<?> l, View v, int position, long id) {
         Log.i("HelloListView", "You clicked Item: " + id + " at position:" + position);
         // Then you start a new Activity via Intent
         Intent intent = new Intent(getApplicationContext(), bookRoom.class);
         intent.setClass(this, bookRoom.class);
         intent.putExtra("position", position);
         intent.putExtra("id", id);
         findRoomie.this.startActivity(intent);
        }
}

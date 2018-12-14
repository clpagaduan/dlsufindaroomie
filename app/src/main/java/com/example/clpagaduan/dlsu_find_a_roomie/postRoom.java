package com.example.clpagaduan.dlsu_find_a_roomie;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class postRoom extends AppCompatActivity {
    Button findRoomiebtn;
    Button postRoombtn;
    Button myProfilebtn;
    Button submit;

    Spinner spn_bath;
    Spinner spn_bed;
    Spinner spn_gen;

    DatabaseReference databaseRoom;

    EditText condoName, bedNum, bathNum, amenities, rent, roomateGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.postroom);

        databaseRoom = FirebaseDatabase.getInstance().getReference("Rooms");

        findRoomiebtn = findViewById(R.id.findRoomiebtn);
        postRoombtn = findViewById(R.id.postRoombtn);
        myProfilebtn = findViewById(R.id.myProfilebtn);
        submit = findViewById(R.id.submit);

        condoName   = findViewById(R.id.condoName);
        rent        = findViewById(R.id.rent);
        spn_bath    = findViewById(R.id.spn_bath);
        spn_bed     = findViewById(R.id.spn_bed);
        spn_gen     = findViewById(R.id.spn_gen);

//        bedNum      = findViewById(R.id.bedNum);
//        bathNum     = findViewById(R.id.bathNum);
//        amenities   = findViewById(R.id.amenities);
//        roomateGender = findViewById(R.id.roommateGender);

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
        submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                addRoom();
            }
        });
    }
    private void addRoom(){
        String str_condoName    = condoName.getText().toString().trim();
        String spn_bedNum       = spn_bed.getSelectedItem().toString();
        String spn_bathNum      = spn_bath.getSelectedItem().toString();
        String str_rent         = rent.getText().toString().trim();
        String str_roomGen      = spn_gen.getSelectedItem().toString();

//        String str_bathNum      = bathNum.getText().toString().trim();
//        String str_amenities    = amenities.getText().toString().trim();


        if(!TextUtils.isEmpty(str_condoName)){
            String id = databaseRoom.push().getKey();
            Room room = new Room(id, str_condoName, spn_bedNum, spn_bathNum, str_rent, str_roomGen);
            databaseRoom.child(id).setValue(room);

            Toast.makeText(this, "Condo added!", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Please enter the condo name", Toast.LENGTH_LONG).show();
        }


    }
}
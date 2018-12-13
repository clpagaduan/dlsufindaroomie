package com.example.clpagaduan.dlsu_find_a_roomie;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button findRoomiebtn;
    Button postRoombtn;
    Button myProfilebtn;

    private FirebaseAuth firebaseAuth;

    private Button buttonLogout;
    private TextView textViewUserEmail;

    //USER'S DETAILS FROM DB MUST BE PRINTED HERE
    //USER'S ROOM WISHLIST FROM DB MUST BE PRINTED HERE

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        firebaseAuth = FirebaseAuth.getInstance(); 1

//        if (firebaseAuth.getCurrentUser()==null){
//            finish();
//            startActivity(new Intent(this, login.class));
//        }
//
//        FirebaseUser user = firebaseAuth.getCurrentUser();

//        textViewUserEmail = findViewById(R.id.textViewUserEmail);
//        textViewUserEmail.setText("Welcome " + user.getEmail());

        buttonLogout = findViewById(R.id.buttonLogout);
        buttonLogout.setOnClickListener(this);

        findRoomiebtn = findViewById(R.id.findRoomiebtn);
        postRoombtn = findViewById(R.id.postRoombtn);
        myProfilebtn = findViewById(R.id.myProfilebtn);

//        findRoomiebtn.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(), findRoomie.class);
//                MainActivity.this.startActivity(intent);
//            }
//        });
//
//        postRoombtn.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(), postRoom.class);
//                MainActivity.this.startActivity(intent);
//            }
//        });
//
//        myProfilebtn.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//                MainActivity.this.startActivity(intent);
//            }
//        });
    }

    @Override
    public void onClick(View view){
        if (view==buttonLogout){
            firebaseAuth.signOut();
            finish();
            startActivity(new Intent(this, login.class));
        }
    }
}

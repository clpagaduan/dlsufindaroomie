package com.example.clpagaduan.dlsu_find_a_roomie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {

    Button findRoomiebtn, postRoombtn, myProfilebtn, logoutBtn;
    TextView textViewUserEmail;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser user = firebaseAuth.getCurrentUser();

        findRoomiebtn   = findViewById(R.id.findRoomiebtn);
        postRoombtn     = findViewById(R.id.postRoombtn);
        myProfilebtn    = findViewById(R.id.myProfilebtn);
        logoutBtn       = findViewById(R.id.logoutBtn);
        textViewUserEmail = findViewById(R.id.textViewUserEmail);

        findRoomiebtn.setOnClickListener(this);
        postRoombtn.setOnClickListener(this);
        myProfilebtn.setOnClickListener(this);
        logoutBtn.setOnClickListener(this);

        textViewUserEmail.setText("Welcome " + user.getEmail());
    }

    @Override
    public void onClick(View view){
        if (view == findRoomiebtn){
            startActivity(new Intent(this, findRoomie.class));
        } else if (view == postRoombtn){
            startActivity(new Intent(this, postRoom.class));
        } else if (view == myProfilebtn){
            startActivity(new Intent(this, ProfileActivity.class));
        } else if (view == logoutBtn){
            firebaseAuth.signOut();
            finish();
            startActivity(new Intent(this, login.class));
        }
    }
}

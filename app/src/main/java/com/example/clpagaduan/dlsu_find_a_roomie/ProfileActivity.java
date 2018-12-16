package com.example.clpagaduan.dlsu_find_a_roomie;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {
    String uid;
    Button findRoomiebtn, postRoombtn, myProfilebtn, logoutBtn;
    TextView textViewUserEmail, view_name, view_gen, view_email;
    private FirebaseAuth firebaseAuth;
    DatabaseReference databaseUser;

    private FirebaseUser user1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        firebaseAuth = FirebaseAuth.getInstance();
        user1 = firebaseAuth.getCurrentUser();


        findRoomiebtn   = findViewById(R.id.findRoomiebtn);
        postRoombtn     = findViewById(R.id.postRoombtn);
        myProfilebtn    = findViewById(R.id.myProfilebtn);
        logoutBtn       = findViewById(R.id.logoutBtn);
        textViewUserEmail = findViewById(R.id.textViewUserEmail);
        view_email = findViewById(R.id.view_email);
        view_gen = findViewById(R.id.view_gen);
        view_name = findViewById(R.id.view_name);

        findRoomiebtn.setOnClickListener(this);
        postRoombtn.setOnClickListener(this);
        myProfilebtn.setOnClickListener(this);
        logoutBtn.setOnClickListener(this);

        textViewUserEmail.setText("Welcome " + user1.getEmail());
        uid = user1.getUid();
//        uid = user.getUid();

        databaseUser = FirebaseDatabase.getInstance().getReference("Users").child(uid);

        databaseUser.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                user1 = firebaseAuth.getCurrentUser();


                for(DataSnapshot userSnapshot: dataSnapshot.getChildren()){
                    User user = userSnapshot.getValue(User.class);
                    //NOT YET WORKING. FIX THIS
                    String lname = user.lname;
                    String fname = user.fname;
                    String gen   = user.gen;
                    String email = user.email;

                    System.out.println("Last name: " + lname);
                    System.out.println("First name: " + fname);
                    System.out.println("Gender: " + gen);
                    System.out.println("Email: " + email);

                    view_name.setText(fname + " " + lname);
                    view_gen.setText(gen);
                    view_email.setText(email);
                }

//                User user = dataSnapshot.child(uid).getValue();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

//        textViewUserEmail.setText(uid);
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

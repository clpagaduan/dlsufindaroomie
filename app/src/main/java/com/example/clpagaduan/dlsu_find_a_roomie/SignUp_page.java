package com.example.clpagaduan.dlsu_find_a_roomie;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.ProgressBar;
import android.util.Log;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
//import com.google.firebase.auth.R;

public class SignUp_page extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    TextView lastName;
    TextView firstName;
    TextView gender;
    TextView email;
    TextView username;
    TextView password;

    Button backbtn;
    Button submitbtn;
    Button test_btn;

    Button btn_sunny;
    Button btn_foggy;
    TextView txt_condition;

    private ProgressDialog progressDialog;
    private FirebaseAuth fireBaseAuth;

//    DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
//    DatabaseReference mConditionRef = mDatabase.child("condition");


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page);

        fireBaseAuth = FirebaseAuth.getInstance();

        progressDialog = new ProgressDialog(this);

        lastName = findViewById(R.id.lastName);
        firstName = findViewById(R.id.firstName);
        gender = findViewById(R.id.gender);
        email = findViewById(R.id.email);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        backbtn = findViewById(R.id.backbtn);
        submitbtn = findViewById(R.id.submitbtn);

        test_btn = findViewById(R.id.test_btn);

        btn_foggy = findViewById(R.id.btn_foggy);
        btn_sunny = findViewById(R.id.btn_sunny);
        txt_condition = findViewById(R.id.conditionTxt);



//        mDatabase = FirebaseDatabase.getInstance().getReference();

        submitbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                registerUser();
            }
        });

        test_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                basicReadWrite();
            }
        });
    }

    private void registerUser(){
        String emailStr = email.getText().toString().trim();
        String passwordStr = password.getText().toString().trim();

        if (TextUtils.isEmpty(emailStr)){
            Toast.makeText(this, "Please enter email", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(passwordStr)){
            Toast.makeText(this, "Please enter password", Toast.LENGTH_SHORT).show();
            return;
        }

        progressDialog.setMessage("Registering user...");
        progressDialog.show();

        fireBaseAuth.createUserWithEmailAndPassword(emailStr, passwordStr)
            .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(SignUp_page.this, "Registered Successfully!", Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();
                    } else {
                        Toast.makeText(SignUp_page.this, "Could not register. Please try again.", Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();

                    }
                }
            });

    }

//    @Override
//    public void onClick(View view){
//        if(view == submitbtn){
//            registerUser();
//        }
//    }

    public void basicReadWrite(){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        myRef.setValue("Hello, World!");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d(TAG, "Value is: " + value);

                String text = dataSnapshot.getValue(String.class);
                txt_condition.setText(text);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }

//    @Override
//    protected void onStart(){
//        super.onStart();
//
//        mConditionRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                String text = dataSnapshot.getValue(String.class);
//                txt_condition.setText(text);
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });
//
//        btn_sunny.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view){
//                mConditionRef.setValue("Sunny");
//            }
//        });
//
//        btn_foggy.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view){
//                mConditionRef.setValue("Foggy");
//            }
//        });
//    }

//    private void submitPost(){
//        final String f_lastName = lastName.getText().toString();
//        final String f_firstName = firstName.getText().toString();
//        final String f_gender = gender.getText().toString();
//        final String f_email = email.getText().toString();
//        final String f_username = username.getText().toString();
//        final String f_password = password.getText().toString();
//
//    }

}


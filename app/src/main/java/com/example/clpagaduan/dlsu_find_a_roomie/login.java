package com.example.clpagaduan.dlsu_find_a_roomie;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.auth.AuthResult;

import com.google.firebase.auth.FirebaseUser;

public class login extends AppCompatActivity implements View.OnClickListener{
    Button btn_signup, btn_login;
    EditText input_username, input_password;

    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        firebaseAuth = FirebaseAuth.getInstance();

//        if(firebaseAuth.getCurrentUser()!= null){
//            finish();
//            startActivity(new Intent(getApplicationContext(), MainActivity.class));
//        }

        input_username = findViewById(R.id.input_username);
        input_password = findViewById(R.id.input_password);
        btn_signup = findViewById(R.id.btn_signup);
        btn_login = findViewById(R.id.btn_login);

        btn_login.setOnClickListener(this);
        btn_signup.setOnClickListener(this);
    }
    private void userLogin(){
        String email = input_username.getText().toString().trim();
        String password = input_password.getText().toString().trim();

        if (TextUtils.isEmpty(email)){
            Toast.makeText(this, "Please enter email", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(password)){
            Toast.makeText(this, "Please enter password", Toast.LENGTH_SHORT).show();
            return;
        }

//        Toast.makeText(this, "Password: " + password, Toast.LENGTH_SHORT).show();

//        progressDialog.setMessage("Signing in...");
//        progressDialog.show();
//
        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        progressDialog.dismiss();

                        if(task.isSuccessful()){
//                            finish();
                            System.out.println("Successfully logged in!");
                            Intent intent = new Intent(login.this, ProfileActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(intent);
//                            login.this.startActivity(intent);
//                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        } else {
                            Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    @Override
    public void onClick (View view){
        if (view == btn_login){
            userLogin();
        }
        if (view == btn_signup){
            finish();
            startActivity(new Intent(this, SignUp_page.class));
        }
    }

//        btn_signup.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(), SignUp_page.class);
//                login.this.startActivity(intent);
//            }
//        });
//
//
//
////        btn_login.setOnClickListener(this);
//        btn_login.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view){
//                userLogin();
//            }
//        });


}

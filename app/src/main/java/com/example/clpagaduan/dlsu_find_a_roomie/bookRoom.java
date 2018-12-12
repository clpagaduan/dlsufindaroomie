package com.example.clpagaduan.dlsu_find_a_roomie;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class bookRoom extends AppCompatActivity {
    Button bookRoom;
    TextView roomStatus;
    Button addWishlistbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bookroom);

        addWishlistbtn = findViewById(R.id.addWishlistbtn);
        bookRoom = findViewById(R.id.bookRoombtn);
        roomStatus = findViewById(R.id.roomStatus);

        //ROOM MUST BE MARKED AS UNAVAILABLE ON THE DB
        bookRoom.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                roomStatus.getText().toString();
                roomStatus.setText("Unavailable");
                Toast.makeText(bookRoom.this,
                        "Room has been reserved!", Toast.LENGTH_LONG).show();
            }
        });

        //ROOM NAME MUST BE ADDED TO THE USER'S WISHLIST ON THE PROFILE
        addWishlistbtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(bookRoom.this,
                        "Room has been added to your wishlist!", Toast.LENGTH_LONG).show();
            }
        });
    }
}

package com.example.clpagaduan.dlsu_find_a_roomie;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.util.Log;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

//import com.firebase.ui.database.FirebaseRecyclerAdapter;
//import com.firebase.ui.database.FirebaseRecyclerOptions;

import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class findRoomie extends AppCompatActivity {
    public static final String ROOM_NAME = "Room name";
    public static final String ROOM_ID = "Room ID";
    public static final String ROOM_RENT = "Room Rent";
    public static final String ROOM_BED = "Room Bed";
    public static final String ROOM_BATH = "Room Bath";
    public static final String ROOM_GEN = "Room Gen";
    public static final String ROOM_STATUS = "Room Rent";

    Button findRoomiebtn;
    Button postRoombtn;
    Button myProfilebtn;

    DatabaseReference databaseRoom;
    ListView listViewRoom;
    List<Room> roomList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.findroomie);


        ///////////////////////
        databaseRoom = FirebaseDatabase.getInstance().getReference("Rooms");
//        ListView listview = (ListView) findViewById(R.id.listView);
//        listview.setOnItemClickListener(this);

        findRoomiebtn = findViewById(R.id.findRoomiebtn);
        postRoombtn = findViewById(R.id.postRoombtn);
        myProfilebtn = findViewById(R.id.myProfilebtn);

        listViewRoom = findViewById(R.id.listViewRoom);

        roomList = new ArrayList<>();

        listViewRoom.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l){
                Room room = roomList.get(i);
                Intent intent = new Intent(getApplicationContext(), AddTenant.class);

                intent.putExtra(ROOM_ID, room.getRoomID());
                intent.putExtra(ROOM_NAME, room.getRoomName());
                intent.putExtra(ROOM_RENT, room.getRoomRent());
                intent.putExtra(ROOM_BED, room.getRoomBed());
                intent.putExtra(ROOM_BATH, room.getRoomBath());
                intent.putExtra(ROOM_GEN, room.getRoomGen());

                startActivity(intent);
            }
        });



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

    @Override
    protected void onStart(){
        super.onStart();
        databaseRoom.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                roomList.clear();
                for(DataSnapshot roomSnapshot: dataSnapshot.getChildren()){
                    Room room = roomSnapshot.getValue(Room.class);
                    roomList.add(room);
                }
                RoomList adapter = new RoomList(findRoomie.this, roomList);
                listViewRoom.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }



        //LIST OF HARDCODED ROOMS ARE IN RES -> VALUES -> ARRAY.XML
//     public void onItemClick(AdapterView<?> l, View v, int position, long id) {
//         Log.i("HelloListView", "You clicked Item: " + id + " at position:" + position);
//         // Then you start a new Activity via Intent
//         Intent intent = new Intent(getApplicationContext(), bookRoom.class);
//         intent.setClass(this, bookRoom.class);
//         intent.putExtra("position", position);
//         intent.putExtra("id", id);
//         findRoomie.this.startActivity(intent);
//        }
}

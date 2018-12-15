package com.example.clpagaduan.dlsu_find_a_roomie;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class AddTenant extends AppCompatActivity {
    TextView textViewRoomName, textViewRent, textViewBed, textViewBath, textViewGen;
    Spinner spn_bed;

    ListView listViewTenants;

    String uid;

    private FirebaseAuth firebaseAuth;
    private FirebaseUser user;

    DatabaseReference databaseTenant;

    List<Tenant> tenants;

    Button btn_reserve;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_tenant);

        firebaseAuth = FirebaseAuth.getInstance();




        textViewRoomName    = findViewById(R.id.textViewRoomName);
        textViewRent        = findViewById(R.id.textViewRent);
        textViewBed         = findViewById(R.id.textViewBed);
        textViewBath        = findViewById(R.id.textViewBath);
        textViewGen         = findViewById(R.id.textViewGen);
        btn_reserve = findViewById(R.id.btn_reserve);
        spn_bed = findViewById(R.id.spn_slot);

        listViewTenants = findViewById(R.id.listViewTenants);

        Intent intent = getIntent();

        tenants = new ArrayList<>();

        String id   = intent.getStringExtra(findRoomie.ROOM_ID);
        String name = intent.getStringExtra(findRoomie.ROOM_NAME);
        String rent = intent.getStringExtra(findRoomie.ROOM_RENT);
        String bed  = intent.getStringExtra(findRoomie.ROOM_BED);
        String bath = intent.getStringExtra(findRoomie.ROOM_BATH);
        String gen  = intent.getStringExtra(findRoomie.ROOM_GEN);


        textViewRoomName.setText(name);
        textViewRent.setText("Rent: " + rent);
        textViewBed.setText("Beds: " + bed);
        textViewBath.setText("Baths: " + bath);
        textViewGen.setText("Room restrictions: " + gen);

        databaseTenant = FirebaseDatabase.getInstance().getReference("tenants").child(id);

        btn_reserve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveTenant();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        databaseTenant.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                tenants.clear();
                for(DataSnapshot tenantSnapshot : dataSnapshot.getChildren()){
                    Tenant tenant = tenantSnapshot.getValue(Tenant.class);
                    tenants.add(tenant);
                }

                TenantList tenantListAdapter = new TenantList(AddTenant.this, tenants);
                listViewTenants.setAdapter(tenantListAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void saveTenant(){
        String slot = spn_bed.getSelectedItem().toString();
        user = firebaseAuth.getCurrentUser();
        uid = user.getUid();
        String id = databaseTenant.push().getKey();
        Tenant tenant = new Tenant(id, uid, slot);

        databaseTenant.child(id).setValue(tenant);
        Toast.makeText(this, "Reserved!", Toast.LENGTH_LONG).show();
    }
}

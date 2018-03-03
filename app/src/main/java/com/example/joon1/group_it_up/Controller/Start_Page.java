package com.example.joon1.group_it_up.Controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.EventLog;
import android.view.View;
import android.widget.Button;

import com.example.joon1.group_it_up.Model.EventCard;
import com.example.joon1.group_it_up.Model.SaveSharedPreference;
import com.example.joon1.group_it_up.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import static com.example.joon1.group_it_up.Model.EventCard.eid;

public class Start_Page extends AppCompatActivity {

    Button regBtn, guestBtn;
    static List<EventCard> eventCards = new ArrayList<>();
    FirebaseDatabase database;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start__page);

        regBtn = (Button) findViewById(R.id.registerBtn);
        guestBtn = (Button) findViewById(R.id.guestBtn);

//        database = FirebaseDatabase.getInstance();
//        databaseReference = database.getReference();
//
//        databaseReference.child("EventCard").addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                Iterable<DataSnapshot> children = dataSnapshot.getChildren();
//
//                int count = 0;
//                for (DataSnapshot child : children) {
//                    EventCard e = child.getValue(EventCard.class);
//                    eventCards.add(e);
//                }
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });


        if (SaveSharedPreference.getUserName(Start_Page.this).length() == 0) {
            regBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(getApplicationContext(), SignUp_Page.class));
                }
            });

            guestBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(getApplicationContext(), Main_List_Page.class));
                }
            });
        } else {
            startActivity(new Intent(getApplicationContext(), Main_List_Page.class));
        }


    }

    public List<EventCard> getEventCards() {
        return eventCards;
    }
}
package com.example.joon1.group_it_up.Controller;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.joon1.group_it_up.Model.EventCard;
import com.example.joon1.group_it_up.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main_List_Page extends AppCompatActivity {

    FloatingActionButton addBtn;
    private ListView lv;
    FirebaseDatabase database;
    DatabaseReference databaseReference;
    public static List<EventCard> myList;
    static int placed = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView) findViewById(R.id.listV);
        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference();
        myList = new ArrayList<EventCard>();

        databaseReference.child("EventCard").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Iterable<DataSnapshot> children = dataSnapshot.getChildren();

                for (DataSnapshot child : children) {
                    EventCard eventCard = child.getValue(EventCard.class);
                    if (!myList.contains(eventCard)) {
                        System.out.println("---------------------------------------------------------------------");
                        System.out.println(eventCard);
                        myList.add(eventCard);
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        List<String> sportsList = new ArrayList<>();
        List<String> titleList = new ArrayList<>();

        for (EventCard e : myList) {
            sportsList.add(e.getSports().toString());
            titleList.add(e.getTitle());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                titleList);
        lv.setAdapter(adapter);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_2,
                android.R.id.text1, sportsList);
        lv.setAdapter(adapter1);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    final int position, long id) {
                placed = position;
                databaseReference.child("EventCard").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        Iterable<DataSnapshot> children = dataSnapshot.getChildren();
                        EventCard selected = myList.get(placed);

//                        for (DataSnapshot child : children) {
//                            EventCard childValue = child.getValue(EventCard.class);
//                            if (childValue.get() == selected.getId()) {
//                                purityReport = childValue;
//                            }
//                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
                startActivity(new Intent(getApplicationContext(), View_EventCard_Page.class));
            }
        });
        addBtn = (FloatingActionButton) findViewById(R.id.addBtn);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Make_EventCard_Page.class));
            }
        });



    }
}

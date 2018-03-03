package com.example.joon1.group_it_up.Controller;

import android.app.ListActivity;
import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

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

import static com.example.joon1.group_it_up.Controller.Start_Page.eventCards;
import static com.example.joon1.group_it_up.Model.EventCard.eid;

public class Main_List_Page extends AppCompatActivity {


    //    SimpleCursorAdapter sAdapter;
    FloatingActionButton addBtn;
    private ListView lv;
    static int placed;
    FirebaseDatabase database;
    DatabaseReference databaseReference;
    public static EventCard selectedEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        System.out.println("_________________________________");
//        System.out.println("This is eid " + eid);
//        System.out.println("This is size of " + eventCards.size());
        String[] tArray = new String[eid];
        String[] sArray = new String[eid];
        for (int i = 0; i < eid; i++) {
            tArray[i] = eventCards.get(i).getTitle();
            sArray[i] = eventCards.get(i).getSports().toString();
        }

        ListAdapterHelper adapter = new ListAdapterHelper(this, tArray, sArray);
        lv = (ListView) findViewById(R.id.listV);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, final int position, long id) {
                placed = position;
                databaseReference.child("EventCard").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        Iterable<DataSnapshot> children = dataSnapshot.getChildren();
                        EventCard selected = eventCards.get(placed);

                        for (DataSnapshot child : children) {
                            EventCard childValue = child.getValue(EventCard.class);
                            if (childValue.getUid() == selected.getUid()) {
                                selectedEvent = childValue;
                            }
                        }
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


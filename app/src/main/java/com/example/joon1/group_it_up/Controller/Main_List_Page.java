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
//    FirebaseDatabase database;
//    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        System.out.println("_________________________________");
        System.out.println("This is eid " + eid);
        System.out.println("This is size of " + eventCards.size());
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
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                startActivity(new Intent(getApplicationContext(), View_EventCard_Page.class));
            }
        });
        

//        String[] titles = new String[eid];
//        String[] sports = new String[eid];
//        int i = 0;
//
//        for (EventCard e : eventCards) {
//            titles[i] = e.getTitle();
//            sports[i] = e.getSports().toString();
//        }
//
//        int[] toTitleViews = {android.R.id.text1};
//        int[] toSportsViews = {android.R.id.text2};
//
//        tAdapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_1,
//                null, titles, toTitleViews, 0);
//        sAdapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_2,
//                null, sports, toSportsViews, 0);
//        setListAdapter(tAdapter);
//        setListAdapter(sAdapter);
//
//        getLoaderManager().initLoader(0, null, this);


//        lv = (ListView) findViewById(R.id.listV);
//        database = FirebaseDatabase.getInstance();
//        databaseReference = database.getReference();
//        myList = new ArrayList<EventCard>();
//
//        databaseReference.child("EventCard").addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                Iterable<DataSnapshot> children = dataSnapshot.getChildren();
//
//                for (DataSnapshot child : children) {
//                    EventCard eventCard = child.getValue(EventCard.class);
//                    if (!myList.contains(eventCard)) {
//                        System.out.println("---------------------------------------------------------------------");
//                        System.out.println(eventCard);
//                        myList.add(eventCard);
//                    }
//                }
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });
//        List<String> sportsList = new ArrayList<>();
//        List<String> titleList = new ArrayList<>();
//
//        for (EventCard e : myList) {
//            sportsList.add(e.getSports().toString());
//            titleList.add(e.getTitle());
//            count++;
//        }
//
//        String[] titleCol = new String[count];
//
//        for (int i = 0; i < count; i++) {
//            titleCol[i] = titleList.get(i);
//        }
//
//        int[] toViews = {android.R.id.text1};
//
//        mAdapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_1,
//                null, titleCol, toViews, 0);
//        setListAdapter(mAdapter);
//        getLoaderManager().initLoader(0, null, this);
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
//                titleList);
//        lv.setAdapter(adapter);
//        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_2,
//                android.R.id.text1, sportsList);
//        lv.setAdapter(adapter1);
//
//        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view,
//                                    final int position, long id) {
//                placed = position;
//                databaseReference.child("EventCard").addValueEventListener(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(DataSnapshot dataSnapshot) {
//                        Iterable<DataSnapshot> children = dataSnapshot.getChildren();
//                        EventCard selected = myList.get(placed);
//
////                        for (DataSnapshot child : children) {
////                            EventCard childValue = child.getValue(EventCard.class);
////                            if (childValue.get() == selected.getId()) {
////                                purityReport = childValue;
////                            }
////                        }
//                    }
//
//                    @Override
//                    public void onCancelled(DatabaseError databaseError) {
//
//                    }
//                });
//                startActivity(new Intent(getApplicationContext(), View_EventCard_Page.class));
//            }
//        });
        addBtn = (FloatingActionButton) findViewById(R.id.addBtn);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Make_EventCard_Page.class));
            }
        });
    }
}

//    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
//        return new CursorLoader(this);
//    }
//
//    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
//        tAdapter.swapCursor(data);
//    }
//
//    public void onLoaderReset(Loader<Cursor> loader) {
//        tAdapter.swapCursor(null);
//    }
//
//    public void onListItemClick(ListView lv, View v, int position, long id) {
//
//    }


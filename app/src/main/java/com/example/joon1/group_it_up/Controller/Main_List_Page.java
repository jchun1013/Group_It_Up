package com.example.joon1.group_it_up.Controller;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.joon1.group_it_up.R;

import java.util.ArrayList;
import java.util.List;

public class Main_List_Page extends AppCompatActivity {

    FloatingActionButton addBtn;
    private ListView lv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println("-------------------------------------------------------------------");
        System.out.println("Its here!!!!!!!!!!!");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView) findViewById(R.id.listV);
        addBtn = (FloatingActionButton) findViewById(R.id.addBtn);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Make_EventCard_Page.class));
            }
        });
        List<String> myList = new ArrayList<String>();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                myList);
        lv.setAdapter(adapter);
    }

    public static class Registration_Page extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_registration__page);
        }
    }
}

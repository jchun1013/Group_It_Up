package com.example.joon1.group_it_up.Controller;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.joon1.group_it_up.R;

public class Main_List_Page extends AppCompatActivity {

    FloatingActionButton addBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println("-------------------------------------------------------------------");
        System.out.println("Its here!!!!!!!!!!!");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addBtn = (FloatingActionButton) findViewById(R.id.addBtn);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Make_EventCard_Page.class));
            }
        });
    }

    public static class Registration_Page extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_registration__page);
        }
    }
}

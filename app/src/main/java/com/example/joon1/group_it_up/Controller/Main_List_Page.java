package com.example.joon1.group_it_up.Controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.joon1.group_it_up.R;

public class Main_List_Page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public static class Registration_Page extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_registration__page);
        }
    }
}

package com.example.joon1.group_it_up.Controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.joon1.group_it_up.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp_Page extends AppCompatActivity {
    FirebaseDatabase database = FirebaseDatabase.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration__page);
    }
}

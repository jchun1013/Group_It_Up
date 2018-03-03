package com.example.joon1.group_it_up.Controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.joon1.group_it_up.R;

public class Start_Page extends AppCompatActivity {

    Button regBtn, guestBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start__page);

        regBtn = (Button) findViewById(R.id.registerBtn);
        guestBtn = (Button) findViewById(R.id.guestBtn);

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
    }
}
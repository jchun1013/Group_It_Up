package com.example.joon1.group_it_up.Controller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.joon1.group_it_up.Model.Experience;
import com.example.joon1.group_it_up.Model.Gender;
import com.example.joon1.group_it_up.Model.RecOrComp;
import com.example.joon1.group_it_up.Model.Sports;
import com.example.joon1.group_it_up.R;

import java.util.ArrayList;
import java.util.List;

public class Filter extends AppCompatActivity {

    private Spinner sportSpinner, genderSpinner, expSpinner, recSpinner;
    Button submitBtn, backBtn;
    static boolean filtered = false;
    static String[] filterList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        genderSpinner = (Spinner) findViewById(R.id.genderSpinner);
        expSpinner = (Spinner) findViewById(R.id.expSpinner);
        sportSpinner = (Spinner) findViewById(R.id.sportSpinner);
        recSpinner = (Spinner) findViewById(R.id.recSpinner);

        sportSpinner.setAdapter(new ArrayAdapter<Sports>(this, android.R.layout.simple_spinner_item, Sports.values()));
        genderSpinner.setAdapter(new ArrayAdapter<Gender>(this, android.R.layout.simple_spinner_item, Gender.values()));
        expSpinner.setAdapter(new ArrayAdapter<Experience>(this, android.R.layout.simple_spinner_item, Experience.values()));
        recSpinner.setAdapter(new ArrayAdapter<RecOrComp>(this, android.R.layout.simple_spinner_item, RecOrComp.values()));


        submitBtn = (Button) findViewById(R.id.refineBtn);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                filtered = true;
                filterList = new String[]{sportSpinner.getSelectedItem().toString(), genderSpinner.getSelectedItem().toString(),
                        expSpinner.getSelectedItem().toString(), recSpinner.getSelectedItem().toString()};
                finish();

            }
        });
        backBtn = (Button) findViewById(R.id.backBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    protected void onResume()
    {
        super.onResume();
        overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_up);
    }

    protected void onPause()
    {
        super.onPause();
        overridePendingTransition(R.anim.slide_in_down, R.anim.slide_out_down);
    }

}

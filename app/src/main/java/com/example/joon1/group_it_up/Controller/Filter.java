package com.example.joon1.group_it_up.Controller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.joon1.group_it_up.Model.Experience;
import com.example.joon1.group_it_up.Model.Gender;
import com.example.joon1.group_it_up.Model.RecOrComp;
import com.example.joon1.group_it_up.Model.Sports;
import com.example.joon1.group_it_up.R;

public class Filter extends AppCompatActivity {

    private Spinner sportSpinner, genderSpinner, expSpinner, recSpinner;

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

package com.example.joon1.group_it_up.Controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.joon1.group_it_up.Model.Sports;
import com.example.joon1.group_it_up.R;

public class Make_EventCard_Page extends AppCompatActivity {

    private Spinner sportSpinner;
    private Button mapButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make__even_card__page);

        sportSpinner.setAdapter(new ArrayAdapter<Sports>(this,
                android.R.layout.simple_spinner_item, Sports.values()));
        mapButton = (Button)findViewById(R.id.mapButton);
        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MapActivity.class));
            }
        });
    }
}

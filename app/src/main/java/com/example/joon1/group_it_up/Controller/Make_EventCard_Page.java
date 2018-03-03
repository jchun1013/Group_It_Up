package com.example.joon1.group_it_up.Controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.joon1.group_it_up.Model.Experience;
import com.example.joon1.group_it_up.Model.Gender;
import com.example.joon1.group_it_up.Model.RecOrComp;
import com.example.joon1.group_it_up.Model.Sports;
import com.example.joon1.group_it_up.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Make_EventCard_Page extends AppCompatActivity {

    private Spinner sportSpinner, genderSpinner, expSpinner, recSpinner;
    private Button mapButton;
    private EditText contactText, commentText, titleText;
    private TextView userText;
    private Button submitBtn;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference databaseReference = database.getInstance().getReference("Card");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make__even_card__page);

        genderSpinner = (Spinner) findViewById(R.id.genderSpinner);
        expSpinner = (Spinner) findViewById(R.id.expSpinner);
        sportSpinner = (Spinner) findViewById(R.id.sportSpinner);
        recSpinner = (Spinner) findViewById(R.id.recSpinner);

        sportSpinner.setAdapter(new ArrayAdapter<Sports>(this, android.R.layout.simple_spinner_item, Sports.values()));
        genderSpinner.setAdapter(new ArrayAdapter<Gender>(this, android.R.layout.simple_spinner_item, Gender.values()));
        expSpinner.setAdapter(new ArrayAdapter<Experience>(this, android.R.layout.simple_spinner_item, Experience.values()));
        recSpinner.setAdapter(new ArrayAdapter<RecOrComp>(this, android.R.layout.simple_spinner_item, RecOrComp.values()));

        contactText = (EditText) findViewById(R.id.editText);
        commentText = (EditText) findViewById(R.id.commentText);
        titleText = (EditText) findViewById(R.id.titleText);

        userText = (TextView) findViewById(R.id.userText);


        submitBtn = (Button) findViewById(R.id.submitBtn);

        mapButton = (Button)findViewById(R.id.mapButton);
        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MapActivity.class));
            }
        });

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
            }
        });


    }
}

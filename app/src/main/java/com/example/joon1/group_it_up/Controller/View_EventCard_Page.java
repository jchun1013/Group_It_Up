package com.example.joon1.group_it_up.Controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.example.joon1.group_it_up.Controller.Main_List_Page.selectedEvent;

import com.example.joon1.group_it_up.Model.EventCard;
import com.example.joon1.group_it_up.R;

public class View_EventCard_Page extends AppCompatActivity {

    EventCard selectedEvent;
    TextView titleView,contactView, userText, locationText, dateText, experienceView,
    genderView, sportsView, indorteamView;
    Button backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view__event_card__page);

        backBtn = (Button) findViewById(R.id.backBtn);
        titleView = (TextView) findViewById(R.id.titleView);
        contactView = (TextView) findViewById(R.id.contactView);
        userText = (TextView) findViewById(R.id.userText);
        locationText = (TextView) findViewById(R.id.locationText);
        dateText = (TextView) findViewById(R.id.dateText);
        experienceView = (TextView) findViewById(R.id.experienceView);
        genderView = (TextView) findViewById(R.id.genderView);
        sportsView = (TextView) findViewById(R.id.sportsView);
        indorteamView = (TextView) findViewById(R.id.indorteamView);

        titleView.setText(selectedEvent.getTitle());
        contactView.setText(selectedEvent.getContact());
        locationText.setText(selectedEvent.getLocation());
        dateText.setText(selectedEvent.getDate());
        experienceView.setText(selectedEvent.getExperience().toString());
        genderView.setText(selectedEvent.getGender().toString());
        sportsView.setText(selectedEvent.getSports().toString());
        indorteamView.setText(selectedEvent.getRec().toString());

        // userText

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), SignUp_Page.class));
            }
        });
    }
}

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
import android.widget.Toast;

import com.example.joon1.group_it_up.Model.EventCard;
import com.example.joon1.group_it_up.Model.Experience;
import com.example.joon1.group_it_up.Model.Gender;
import com.example.joon1.group_it_up.Model.RecOrComp;
import com.example.joon1.group_it_up.Model.SaveSharedPreference;
import com.example.joon1.group_it_up.Model.Sports;
import com.example.joon1.group_it_up.Model.User;
import com.example.joon1.group_it_up.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Date;

import static com.example.joon1.group_it_up.Controller.MapActivity.address;
import static com.example.joon1.group_it_up.Model.EventCard.eid;

public class Make_EventCard_Page extends AppCompatActivity {

    private Spinner sportSpinner, genderSpinner, expSpinner, recSpinner;
    private Button mapButton;
    private EditText contactText, commentText, titleText;
    private TextView userText, dateText;
    private Button submitBtn, backButton;

    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd");
    public final String date = sdf.format(new Date());

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference databaseReference = database.getInstance().getReference("EventCard");
    DatabaseReference databaseReference2 = database.getInstance().getReference("user");

    String username, contact;
    int uid;

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
        dateText = (TextView) findViewById(R.id.dateText);

        username = SaveSharedPreference.getUserName(getApplicationContext());
        userText.setText(username);
        dateText.setText(date);

        TextView selectedLocation = (TextView) findViewById(R.id.locationText);
        System.out.println("-------------------------------------------------");
        System.out.println(address);


        submitBtn = (Button) findViewById(R.id.submitBtn);
        backButton = (Button) findViewById(R.id.backButton);

        databaseReference2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Iterable<DataSnapshot> children = dataSnapshot.getChildren();

                for (DataSnapshot child : children) {
                    User user = child.getValue(User.class);
                    if (user.getAccount().equals(username)) {
                        uid = user.getUid();
                        contact = user.getContact();
                    }

                }
            }                        @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        contactText.setText(contact);

        mapButton = (Button)findViewById(R.id.mapButton);
        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MapActivity.class));
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Main_List_Page.class));
            }
        });

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (contactText.getText() == null ||  titleText.getText() == null) {
                    Toast.makeText(Make_EventCard_Page.this, "One or more field is empty", Toast.LENGTH_SHORT).show();
                } else {
                    eid++;
                    EventCard eventCard = new EventCard(titleText.getText().toString(),
                            commentText.getText().toString(), uid, contact,
                            (Sports) sportSpinner.getSelectedItem(),
                            (Gender) genderSpinner.getSelectedItem(),
                            (Experience) expSpinner.getSelectedItem(), date,
                            (RecOrComp) recSpinner.getSelectedItem(), address, eid);
                    addEventCard(eventCard);
                }
            }
        });
    }
    private void addEventCard(final EventCard eventCard) {
        String id = databaseReference.push().getKey();
        databaseReference.child(id).setValue(eventCard);
        Start_Page.setEventCards(eventCard);
        startActivity(new Intent(getApplicationContext(), Main_List_Page.class));
    }
}

package com.example.joon1.group_it_up.Controller;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.joon1.group_it_up.Model.EventCard;
import com.example.joon1.group_it_up.Model.SaveSharedPreference;
import com.example.joon1.group_it_up.Model.User;
import com.example.joon1.group_it_up.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import static com.example.joon1.group_it_up.Model.User.uid;

public class SignUp_Page extends AppCompatActivity {
    EditText userText, passText, phoneText;
    Button submitBtn, cancelBtn;
    String username, password, contact;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference databaseReference = database.getInstance().getReference("user");
    DatabaseReference databaseReference2 = database.getInstance().getReference("username");
    FirebaseAuth firebaseAuth;

    private static final String TAG = "Registration :";

    boolean same = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration__page);

        userText = (EditText) findViewById(R.id.userText);
        passText = (EditText) findViewById(R.id.passText);
        phoneText = (EditText) findViewById(R.id.phoneText);

        submitBtn = (Button) findViewById(R.id.submitBtn);
        cancelBtn = (Button) findViewById(R.id.cancelBtn);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = userText.getText().toString();
                password = passText.getText().toString();
                contact = phoneText.getText().toString();

                if (username == null || password == null || contact == null) {
                    Toast nullToast = Toast.makeText(getApplicationContext(),
                            "One or more fields are empty.", Toast.LENGTH_LONG);
                    nullToast.show();
                } else {
                    databaseReference2.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            Iterable<DataSnapshot> children = dataSnapshot.getChildren();

                            for (DataSnapshot child : children) {
                                String usedName = child.getValue(String.class);
                                if (usedName.equals(username)) {
                                    same = true;
                                }
                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                    if (!same) {
                        uid++;
                        User newUser = new User(uid, username, password, contact);
                        addUser(newUser);
                    }
                }
            }
        });

    }

    private void addUser(final User newUser) {
        String id = databaseReference.push().getKey();
        databaseReference.child(id).setValue(newUser);
        String id2 = databaseReference2.push().getKey();
        databaseReference2.child(id2).setValue(username);
        SaveSharedPreference.setUserName(getApplicationContext(), username);
        startActivity(new Intent(getApplicationContext(), Main_List_Page.class));

//        firebaseAuth = FirebaseAuth.getInstance();
//
//        firebaseAuth.createUserWithEmailAndPassword(username, password)
//                .addOnCompleteListener(SignUp_Page.this,
//                        new OnCompleteListener<AuthResult>() {
//                            @Override
//                            public void onComplete(@NonNull Task<AuthResult> task) {
//                                Log.d(TAG, "createUserWithEmail : " + task.isSuccessful());
//                                if (task.isSuccessful()) {
//                                    String id = databaseReference.push().getKey();
//                                    databaseReference.child(id).setValue(newUser);
//                                    String id2 = databaseReference2.push().getKey();
//                                    databaseReference2.child(id2).setValue(username);
////                                    Toast toast = Toast.makeText(getApplicationContext(),
////                                            "Registration Successful!",
////                                            Toast.LENGTH_SHORT);
////                                    toast.show();
//                                    SaveSharedPreference.setUserName(getApplicationContext(), username);
//                                    startActivity(new Intent(getApplicationContext(), Main_List_Page.class));
//                                }
//                            }
//                        });
    }
}
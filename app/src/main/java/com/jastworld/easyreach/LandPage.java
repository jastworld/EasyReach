package com.jastworld.easyreach;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LandPage extends AppCompatActivity {

    TextView viewFirebase;

    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_land_page);
        mDatabase= FirebaseDatabase.getInstance().getReference();

        viewFirebase = (TextView)findViewById(R.id.textView);

        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.child("User").getValue(String.class);
                viewFirebase.setText(value);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                viewFirebase.setText("Sorry");

            }
        });

    }

    public void goBack(View view){
        startActivity(new Intent(this,MainActivity.class));
    }




}

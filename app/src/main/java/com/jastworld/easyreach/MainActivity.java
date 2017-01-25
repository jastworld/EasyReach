package com.jastworld.easyreach;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    Button fbButton;
    private DatabaseReference mDatabase;
    private EditText enteredValue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fbButton = (Button) findViewById(R.id.firebase_button);
        mDatabase = FirebaseDatabase.getInstance().getReference();

        enteredValue = (EditText)findViewById(R.id.enteredValue);

        if(enteredValue.getText().toString()!=""){
            fbButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    mDatabase.child("User").setValue(enteredValue.getText().toString());

                }
            });

        }



        /*FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        myRef.setValue("Hello, World!");*/
    }

    public void goBack(View view){
        startActivity(new Intent(this,LandPage.class));
    }
}

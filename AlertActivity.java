package com.example.babyincar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AlertActivity extends AppCompatActivity {

    DatabaseReference databaseReference;
    Button trueButton, falseButton;
    int trueClicksI, falseClicksI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert);

        trueButton=(Button)findViewById(R.id.a_true_button);
        falseButton=(Button)findViewById(R.id.a_false_button);

        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseReference = FirebaseDatabase.getInstance().getReference().child("Clicks");
                databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                       String trueClicksS = dataSnapshot.child("trueClicks").getValue().toString().trim();
                        trueClicksI = Integer.parseInt(trueClicksS);
                        databaseReference.child("trueClicks").setValue(trueClicksI+1);
                   }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                   }
               });
            }
        });

        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseReference = FirebaseDatabase.getInstance().getReference().child("Clicks");
                databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String falseClicksS = dataSnapshot.child("falseClicks").getValue().toString().trim();
                        falseClicksI = Integer.parseInt(falseClicksS);
                        databaseReference.child("falseClicks").setValue(falseClicksI+1);
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
    }
}



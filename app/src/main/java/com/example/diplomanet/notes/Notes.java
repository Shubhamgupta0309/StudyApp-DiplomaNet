package com.example.diplomanet.notes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.diplomanet.R;

public class Notes extends AppCompatActivity {
    ImageView backBtn;
    RelativeLayout IFnotesBtn, COnotesBtn, EJnotesBtn, CEnotesBtn, MEnotesBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        IFnotesBtn = findViewById(R.id.IFnotesBtn);
        COnotesBtn = findViewById(R.id.COnotesBtn);
        EJnotesBtn = findViewById(R.id.EJnotesBtn);
        CEnotesBtn = findViewById(R.id.CEnotesBtn);
        MEnotesBtn = findViewById(R.id.MEnotesBtn);

        backBtn = findViewById(R.id.back_pressed);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Notes.super.onBackPressed();
            }
        });

        IFnotesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), IFnotes.class));

            }
        });
        COnotesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), COnotes.class));
            }
        });
        EJnotesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), EJnotes.class));
            }
        });
        CEnotesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), CEnotes.class));
            }
        });
        MEnotesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MEnotes.class));
            }
        });
    }
}
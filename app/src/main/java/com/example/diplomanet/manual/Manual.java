package com.example.diplomanet.manual;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.diplomanet.R;

public class Manual extends AppCompatActivity {

    ImageView backBtn;
    RelativeLayout IFmanualBtn, COmanualBtn, EJmanualBtn, CEmanualBtn, MEmanualBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manual);

        IFmanualBtn = findViewById(R.id.IFmanualBtn);
        COmanualBtn = findViewById(R.id.COmanualBtn);
        EJmanualBtn = findViewById(R.id.EJmanualBtn);
        CEmanualBtn = findViewById(R.id.CEmanualBtn);
        MEmanualBtn = findViewById(R.id.MEmanualBtn);

        backBtn = findViewById(R.id.back_pressed);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Manual.super.onBackPressed();
            }
        });

        IFmanualBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), IFmanual.class));

            }
        });
        COmanualBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), COmanual.class));
            }
        });
        EJmanualBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), EJmanual.class));
            }
        });
        CEmanualBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), CEmanual.class));
            }
        });
        MEmanualBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MEmanual.class));
            }
        });
    }

}
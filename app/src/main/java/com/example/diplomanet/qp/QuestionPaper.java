package com.example.diplomanet.qp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.diplomanet.R;

public class QuestionPaper extends AppCompatActivity {

    ImageView backBtn;
    RelativeLayout IFqpBtn, COqpBtn, EJqpBtn, CEqpBtn, MEqpBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionpaper);

        IFqpBtn = findViewById(R.id.IFqpBtn);
        COqpBtn = findViewById(R.id.COqpBtn);
        EJqpBtn = findViewById(R.id.EJqpBtn);
        CEqpBtn = findViewById(R.id.CEqpBtn);
        MEqpBtn = findViewById(R.id.MEqpBtn);

        backBtn = findViewById(R.id.back_pressed);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QuestionPaper.super.onBackPressed();
            }
        });

        IFqpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), IFquestionpaper.class));

            }
        });
        COqpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), COquestionpaper.class));
            }
        });
        EJqpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), EJquestionpaper.class));
            }
        });
        CEqpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), CEquestionpaper.class));
            }
        });
        MEqpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MEquestionpaper.class));
            }
        });
    }

}
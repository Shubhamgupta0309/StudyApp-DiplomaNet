package com.example.diplomanet.syllabus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.diplomanet.R;

public class Syllabus extends AppCompatActivity {
    ImageView backBtn;
    RelativeLayout IFsyllabusBtn, COsyllabusBtn, EJsyllabusBtn, CEsyllabusBtn, MEsyllabusBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_syllabus);

        IFsyllabusBtn = findViewById(R.id.IFsyllabusBtn);
        COsyllabusBtn = findViewById(R.id.COsyllabusBtn);
        EJsyllabusBtn = findViewById(R.id.EJsyllabusBtn);
        CEsyllabusBtn = findViewById(R.id.CEsyllabusBtn);
        MEsyllabusBtn = findViewById(R.id.MEsyllabusBtn);

        backBtn = findViewById(R.id.back_pressed);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Syllabus.super.onBackPressed();
            }
        });

        IFsyllabusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), IFsyllabus.class));
            }
        });
        COsyllabusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), COsyllabus.class));
            }
        });
        EJsyllabusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), EJsyllabus.class));
            }
        });
        CEsyllabusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), CEsyllabus.class));
            }
        });
        MEsyllabusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MEsyllabus.class));
            }
        });
    }

}
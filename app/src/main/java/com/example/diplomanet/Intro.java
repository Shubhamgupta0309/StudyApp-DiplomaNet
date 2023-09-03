package com.example.diplomanet;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Intro extends AppCompatActivity {
    FirebaseAuth fAuth;
    Animation topAnim, bottomAnim;
    ImageView imagetop,imagebottom;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        fAuth = FirebaseAuth.getInstance();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                FirebaseUser currentUser = fAuth.getCurrentUser();
                Intent intent;
                if (currentUser != null) {
                    intent = new Intent(Intro.this, HomePage.class);
                } else {
                    intent = new Intent(Intro.this, First_page.class);
                }
                startActivity(intent);

                finish();
            }
        }, 2500);

        topAnim = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

        imagetop = findViewById(R.id.imagetop);
        imagebottom = findViewById(R.id.imagebottom);
        textView = findViewById(R.id.slogan);

        imagetop.setAnimation(topAnim);
        imagebottom.setAnimation(bottomAnim);
        textView.setAnimation(bottomAnim);

    }
}

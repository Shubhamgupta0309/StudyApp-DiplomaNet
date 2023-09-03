package com.example.diplomanet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgetPassword extends AppCompatActivity {

    Button mForgetBtn;
    EditText mForgetEmail;
    String email;
    TextView mcreateTextBtn;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);

        fAuth = FirebaseAuth.getInstance();

        mForgetEmail = findViewById(R.id.ForgetEmail);
        mForgetBtn = findViewById(R.id.ForgetBtn);
        mcreateTextBtn = findViewById(R.id.createTextBtn);

        mcreateTextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Login.class));
            }
        });

        mForgetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateData();
            }
        });
    }

    private void validateData() {
        email = mForgetEmail.getText().toString();
        if (email.isEmpty()) {
            mForgetEmail.setError("Required");
        } else {
            fotgetpass();
        }
    }

    private void fotgetpass() {
        fAuth.sendPasswordResetEmail(email)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(ForgetPassword.this, "Check your Email", Toast.LENGTH_LONG).show();
                            startActivity(new Intent(ForgetPassword.this, Login.class));
                            finish();
                        } else {
                            Toast.makeText(ForgetPassword.this, "No user found please Recheck your enter email", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }
}
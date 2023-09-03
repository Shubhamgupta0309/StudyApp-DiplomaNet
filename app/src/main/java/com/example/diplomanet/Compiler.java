package com.example.diplomanet;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;

public class Compiler extends AppCompatActivity {

    TextView output;
    String Scroll;
    EditText codeArea;
    Button run;
    ImageView backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compiler);

        backBtn = findViewById(R.id.back_pressed);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Compiler.super.onBackPressed();
            }
        });

        output = (TextView) findViewById(R.id.output);
        codeArea = (EditText) findViewById(R.id.codeArea);
        run = (Button) findViewById(R.id.run);

        output.setMovementMethod(new ScrollingMovementMethod());
        output.setText(Scroll);

        if (! Python.isStarted()) {
            Python.start(new AndroidPlatform(this));
        }

        run.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Python py = Python.getInstance();

                PyObject pyObj = py.getModule("myScript");

                PyObject obj = pyObj.callAttr("main",codeArea.getText().toString());

                output.setText(obj.toString());
            }
        });


    }
}
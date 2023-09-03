package com.example.diplomanet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.diplomanet.chatbot.ChatBot;
import com.example.diplomanet.chatroom.ChatRoom;
import com.example.diplomanet.manual.Manual;
import com.example.diplomanet.notes.Notes;
import com.example.diplomanet.qp.QuestionPaper;
import com.example.diplomanet.syllabus.Syllabus;

public class AllCategories extends AppCompatActivity {

    ImageView backBtn;
    RelativeLayout NotesBtn, ManualBtn, QuestionPaperBtn, SyllabusBtn, CompilerBtn, ChtaRoomBtn, ChatBotBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_categories);

        NotesBtn = findViewById(R.id.NotesBtn);
        ManualBtn = findViewById(R.id.ManualBtn);
        QuestionPaperBtn = findViewById(R.id.QuestionPaperBtn);
        SyllabusBtn = findViewById(R.id.SyllabusBtn);
        CompilerBtn = findViewById(R.id.CompilerBtn);
        ChtaRoomBtn = findViewById(R.id.ChtaRoomBtn);
        ChatBotBtn = findViewById(R.id.ChatBotBtn);

        backBtn = findViewById(R.id.back_pressed);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AllCategories.super.onBackPressed();
            }
        });

        NotesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Notes.class));

            }
        });
        ManualBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Manual.class));
            }
        });
        QuestionPaperBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), QuestionPaper.class));
            }
        });
        SyllabusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Syllabus.class));
            }
        });
        CompilerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Compiler.class));
            }
        });
        ChtaRoomBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ChatRoom.class));
            }
        });
        ChatBotBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ChatBot.class));
            }
        });
    }
}
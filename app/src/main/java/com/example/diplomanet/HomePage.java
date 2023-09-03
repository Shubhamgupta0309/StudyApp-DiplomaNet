package com.example.diplomanet;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.diplomanet.Home.CategoriesAdapter;
import com.example.diplomanet.Home.CategoriesModel;
import com.example.diplomanet.Home.FeaturedAdapter;
import com.example.diplomanet.Home.FeaturedModel;
import com.example.diplomanet.Home.MostViewModel;
import com.example.diplomanet.Home.MostViewedAdpater;
import com.example.diplomanet.chatbot.ChatBot;
import com.example.diplomanet.chatroom.ChatRoom;
import com.example.diplomanet.manual.Manual;
import com.example.diplomanet.notes.Notes;
import com.example.diplomanet.qp.QuestionPaper;
import com.example.diplomanet.syllabus.Syllabus;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class HomePage extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    RecyclerView featuredRecycler, mostViewedRecycler, categoriesRecycler;
    RecyclerView.Adapter adapter;
    ImageView menuIcon, notesBtn, manualBtn, qpBtn, syllabusBtn, compilerBtn, chatbotBtn, profileBtn, chat_roomBtn;
    TextView categoriesBtn;
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        featuredRecycler = findViewById(R.id.featured_recycler);
        mostViewedRecycler = findViewById(R.id.most_viewed_recycler);
        categoriesRecycler = findViewById(R.id.categories_recycler);
        menuIcon = findViewById(R.id.menu_icon);
        categoriesBtn = findViewById(R.id.categoriesBtn);
        profileBtn = findViewById(R.id.profileBtn);
        chat_roomBtn = findViewById(R.id.chat_roomBtn);
        chatbotBtn = findViewById(R.id.chatbotBtn);

        notesBtn = findViewById(R.id.notesBtn);
        manualBtn = findViewById(R.id.manualBtn);
        qpBtn = findViewById(R.id.qpBtn);
        syllabusBtn = findViewById(R.id.syllabusBtn);
        compilerBtn = findViewById(R.id.compilerBtn);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);

        navigationDrawer();
        featuredRecycler();
        mostViewedRecycler();
        categoriesRecycler();
    }

    private void navigationDrawer() {
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);

        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawerLayout.isDrawerVisible(GravityCompat.START))
                    drawerLayout.closeDrawer(GravityCompat.START);
                else drawerLayout.openDrawer(GravityCompat.START);
            }
        });
        notesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Notes.class));
            }
        });
        manualBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Manual.class));
            }
        });
        qpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), QuestionPaper.class));
            }
        });
        syllabusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Syllabus.class));
            }
        });

        compilerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Compiler.class));
            }
        });
        chat_roomBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ChatRoom.class));
            }
        });
        categoriesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), AllCategories.class));
            }
        });
        profileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), UserProfile.class));
            }
        });

        chatbotBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), ChatBot.class));
            }
        });
    }



    @Override
    public void onBackPressed() {

        if(drawerLayout.isDrawerVisible(GravityCompat.START)){
            drawerLayout.closeDrawer((GravityCompat.START));
        }else
            super.onBackPressed();
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.nav_home:
                Intent intentHomePage = new Intent(getApplicationContext(), HomePage.class);
                startActivity(intentHomePage);
                break;
            case R.id.nav_profile:
                Intent intentUserProfile = new Intent(getApplicationContext(), UserProfile.class);
                startActivity(intentUserProfile);
                break;
            case R.id.nav_all_categories:
                Intent intentAllCategories = new Intent(getApplicationContext(), AllCategories.class);
                startActivity(intentAllCategories);
                break;
            case R.id.nav_notes:
                Intent intentNotes = new Intent(getApplicationContext(), Notes.class);
                startActivity(intentNotes);
                break;
            case R.id.nav_manual:
                Intent intentManual = new Intent(getApplicationContext(), Manual.class);
                startActivity(intentManual);
                break;
            case R.id.nav_syllabus:
                Intent intentSyllabus = new Intent(getApplicationContext(), Syllabus.class);
                startActivity(intentSyllabus);
                break;
            case R.id.nav_Compiler:
                Intent intentCompiler = new Intent(getApplicationContext(), Compiler.class);
                startActivity(intentCompiler);
            case R.id.nav_chat_room:
                Intent intentChatRoom = new Intent(getApplicationContext(), ChatRoom.class);
                startActivity(intentChatRoom);
                break;
                case R.id.nav_chat_bot:
                Intent intentChatBot = new Intent(getApplicationContext(), ChatBot.class);
                startActivity(intentChatBot);
                break;
            case R.id.nav_question_paper:
                Intent intentQuestionPaper = new Intent(getApplicationContext(), QuestionPaper.class);
                startActivity(intentQuestionPaper);
                break;
            case R.id.nav_logout:
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(HomePage.this, Login.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();
                break;
            case R.id.nav_contact_us:
                Intent intentContactus = new Intent(getApplicationContext(), Contactus.class);
                startActivity(intentContactus);
                break;
        }
        return true;
    }

    private void logout() {

        Intent intent = new Intent(this, Login.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }

    private void categoriesRecycler() {

        ArrayList<CategoriesModel> categoriesModel = new ArrayList<>();
        categoriesModel.add(new CategoriesModel(R.drawable.card_notes, "Notes"));
        categoriesModel.add(new CategoriesModel(R.drawable.card_manual, "Manual"));
        categoriesModel.add(new CategoriesModel(R.drawable.card_questionpaper, "Question paper"));
        categoriesModel.add(new CategoriesModel(R.drawable.card_syllabus, "Syllabus"));
        categoriesModel.add(new CategoriesModel(R.drawable.card_compiler, "Compiler"));
        categoriesModel.add(new CategoriesModel(R.drawable.card_chat_room, "Chat Room"));
        categoriesModel.add(new CategoriesModel(R.drawable.card_chat_bot, "Chat Bot"));
        categoriesRecycler.setHasFixedSize(true);
        adapter = new CategoriesAdapter(categoriesModel,this);
        categoriesRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        categoriesRecycler.setAdapter(adapter);
    }

    private void mostViewedRecycler() {
        mostViewedRecycler.setHasFixedSize(true);
        mostViewedRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        ArrayList<MostViewModel> mostViewedLocations = new ArrayList<>();
        mostViewedLocations.add(new MostViewModel(R.drawable.card_notes, "Chat Room"));
        mostViewedLocations.add(new MostViewModel(R.drawable.card_manual, "Notes"));
        mostViewedLocations.add(new MostViewModel(R.drawable.card_questionpaper, "Compiler"));
        mostViewedLocations.add(new MostViewModel(R.drawable.card_syllabus, "Manual"));
        adapter = new MostViewedAdpater(mostViewedLocations,this);
        mostViewedRecycler.setAdapter(adapter);
    }

    private void featuredRecycler() {
        featuredRecycler.setHasFixedSize(true);
        featuredRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        ArrayList<FeaturedModel> featuredLocations = new ArrayList<>();
        featuredLocations.add(new FeaturedModel(R.drawable.card_notes, "Notes", "The complete set of notes from all the branches can be accessed."));
        featuredLocations.add(new FeaturedModel(R.drawable.card_manual, "Manual", "Branch manuals available for consistent and efficient operations."));
        featuredLocations.add(new FeaturedModel(R.drawable.card_questionpaper, "Question paper", "All branch question papers are available."));
        featuredLocations.add(new FeaturedModel(R.drawable.card_syllabus, "Syllabus", "Online syllabus guides students on course material for the academic year."));
        featuredLocations.add(new FeaturedModel(R.drawable.card_compiler, "Compiler", "Python coding is now possible with mobile compilers, making it convenient."));
        featuredLocations.add(new FeaturedModel(R.drawable.card_chat_room, "Chat Room", "Chat room community shared diverse thoughts and opinions."));
        featuredLocations.add(new FeaturedModel(R.drawable.card_chat_bot, "Chat Bot", "A chatbot is a computer program that can hold a conversation with humans."));
        adapter = new FeaturedAdapter(featuredLocations,this);
        featuredRecycler.setAdapter(adapter);
    }
}
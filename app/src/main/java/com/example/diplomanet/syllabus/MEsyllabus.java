package com.example.diplomanet.syllabus;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.diplomanet.R;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MEsyllabus extends AppCompatActivity {

    RecyclerView recview;
    syllabusadapter adapter;
    ImageView backBtn;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mesyllabus);

        backBtn = findViewById(R.id.back_pressed);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MEsyllabus.super.onBackPressed();
            }
        });

        recview = (RecyclerView) findViewById(R.id.recview);
        recview.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<syllabusmodel> options =
                new FirebaseRecyclerOptions.Builder<syllabusmodel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("MESyllabus"), syllabusmodel.class)
                        .build();

        adapter = new syllabusadapter(options);
        recview.setAdapter(adapter);

        searchView = findViewById(R.id.SearchView);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                ArrayList<syllabusmodel> filteredList = new ArrayList<>();

                if (TextUtils.isEmpty(newText)) {
                    adapter.updateOptions(options);
                    adapter.notifyDataSetChanged();
                    return true;
                }

                for (syllabusmodel item : adapter.getSnapshots()) {
                    if (item.getFilename().toLowerCase().contains(newText.toLowerCase())) {
                        filteredList.add(item);
                    }
                }

                FirebaseRecyclerOptions<syllabusmodel> newOptions =
                        new FirebaseRecyclerOptions.Builder<syllabusmodel>()
                                .setQuery(FirebaseDatabase.getInstance().getReference().child("MESyllabus").orderByChild("filename").startAt(newText).endAt(newText + "\uf8ff"), syllabusmodel.class)
                                .build();

                adapter.updateOptions(newOptions);
                adapter.notifyDataSetChanged();

                return true;
            }

        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}
package com.example.diplomanet.manual;

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

public class MEmanual extends AppCompatActivity {

    RecyclerView recview;
    manualadapter adapter;
    ImageView backBtn;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memanual);

        backBtn = findViewById(R.id.back_pressed);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MEmanual.super.onBackPressed();
            }
        });

        recview = (RecyclerView) findViewById(R.id.recview);
        recview.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<manualmodel> options =
                new FirebaseRecyclerOptions.Builder<manualmodel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("MEManual"), manualmodel.class)
                        .build();

        adapter = new manualadapter(options);
        recview.setAdapter(adapter);

        searchView = findViewById(R.id.SearchView);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                ArrayList<manualmodel> filteredList = new ArrayList<>();

                if (TextUtils.isEmpty(newText)) {
                    adapter.updateOptions(options);
                    adapter.notifyDataSetChanged();
                    return true;
                }

                for (manualmodel item : adapter.getSnapshots()) {
                    if (item.getFilename().toLowerCase().contains(newText.toLowerCase())) {
                        filteredList.add(item);
                    }
                }

                FirebaseRecyclerOptions<manualmodel> newOptions =
                        new FirebaseRecyclerOptions.Builder<manualmodel>()
                                .setQuery(FirebaseDatabase.getInstance().getReference().child("MEManual").orderByChild("filename").startAt(newText).endAt(newText + "\uf8ff"), manualmodel.class)
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
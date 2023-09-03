package com.example.diplomanet.notes;

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

public class EJnotes extends AppCompatActivity {

    RecyclerView recview;
    notesadapter adapter;
    ImageView backBtn;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejnotes);

        backBtn = findViewById(R.id.back_pressed);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EJnotes.super.onBackPressed();
            }
        });

        recview = (RecyclerView) findViewById(R.id.recview);
        recview.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<notesmodel> options =
                new FirebaseRecyclerOptions.Builder<notesmodel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("EJNotes"), notesmodel.class)
                        .build();

        adapter = new notesadapter(options);
        recview.setAdapter(adapter);

        searchView = findViewById(R.id.SearchView);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                ArrayList<notesmodel> filteredList = new ArrayList<>();

                if (TextUtils.isEmpty(newText)) {
                    adapter.updateOptions(options);
                    adapter.notifyDataSetChanged();
                    return true;
                }

                for (notesmodel item : adapter.getSnapshots()) {
                    if (item.getFilename().toLowerCase().contains(newText.toLowerCase())) {
                        filteredList.add(item);
                    }
                }

                FirebaseRecyclerOptions<notesmodel> newOptions =
                        new FirebaseRecyclerOptions.Builder<notesmodel>()
                                .setQuery(FirebaseDatabase.getInstance().getReference().child("EJNotes").orderByChild("filename").startAt(newText).endAt(newText + "\uf8ff"), notesmodel.class)
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
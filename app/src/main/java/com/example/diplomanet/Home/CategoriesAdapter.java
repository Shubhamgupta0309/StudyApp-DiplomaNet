package com.example.diplomanet.Home;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.diplomanet.manual.Manual;
import com.example.diplomanet.notes.Notes;
import com.example.diplomanet.syllabus.Syllabus;
import com.example.diplomanet.R;
import com.example.diplomanet.qp.QuestionPaper;

import java.util.ArrayList;
public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.CategoriesViewHolder> {
    ArrayList<CategoriesModel> mostViewedLocations;
    Context context;

    public CategoriesAdapter(ArrayList<CategoriesModel> mostViewedLocations, Context context) {
        this.mostViewedLocations = mostViewedLocations;
        this.context = context;
    }

    @NonNull
    @Override
    public CategoriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.categories_card_design, parent, false);
        CategoriesViewHolder categoriesViewHolder = new CategoriesViewHolder(view);
        return categoriesViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriesAdapter.CategoriesViewHolder holder, int position) {


        CategoriesModel categoriesModel = mostViewedLocations.get(position);
        holder.imageView.setImageResource(categoriesModel.getImage());
        holder.textView.setText(categoriesModel.getTitile());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (position) {
                    case 0:
                        Intent intentNotes = new Intent(context, Notes.class);
                        context.startActivity(intentNotes);
                        break;
                    case 1:
                        Intent intentManual = new Intent(context, Manual.class);
                        context.startActivity(intentManual);
                        break;
                    case 2:
                        Intent intentQuestionPaper = new Intent(context, QuestionPaper.class);
                        context.startActivity(intentQuestionPaper);
                        break;
                    case 3:
                        Intent intentSyllabus = new Intent(context, Syllabus.class);
                        context.startActivity(intentSyllabus);
                        break;
                    case 4:
                        Intent intentCompiler = new Intent(context, Compiler.class);
                        context.startActivity(intentCompiler);
                    default:
                        return;
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mostViewedLocations.size();
    }

    public static class CategoriesViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;

        public CategoriesViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.categories_image);
            textView = itemView.findViewById(R.id.categories_title);
        }

    }
}


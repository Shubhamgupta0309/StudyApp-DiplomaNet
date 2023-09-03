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

import com.example.diplomanet.Compiler;
import com.example.diplomanet.chatroom.ChatRoom;
import com.example.diplomanet.manual.Manual;
import com.example.diplomanet.notes.Notes;
import com.example.diplomanet.syllabus.Syllabus;
import com.example.diplomanet.R;
import com.example.diplomanet.qp.QuestionPaper;

import java.util.ArrayList;

public class FeaturedAdapter extends RecyclerView.Adapter<FeaturedAdapter.FeaturedViewHolder> {

    ArrayList<FeaturedModel> featuredLocation;
    Context context;

    public FeaturedAdapter(ArrayList<FeaturedModel> featuredLocation, Context context) {
        this.featuredLocation = featuredLocation;
        this.context = context;
    }

    @NonNull
    @Override
    public FeaturedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.featured_card_design,parent,false);
        FeaturedViewHolder featuredViewHolder = new FeaturedViewHolder(view);
        return featuredViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FeaturedViewHolder holder, int position) {
        FeaturedModel featuredModel = featuredLocation.get(position);

        holder.image.setImageResource(featuredModel.getImage());
        holder.title.setText(featuredModel.getTitle());
        holder.desc.setText(featuredModel.getDescription());

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
                    case 5:
                        Intent intentChatRoom = new Intent(context, ChatRoom.class);
                        context.startActivity(intentChatRoom);
                    default:
                        return;
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return featuredLocation.size();
    }

    public static class FeaturedViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView title,desc;

        public FeaturedViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.featured_image);
            title = itemView.findViewById(R.id.featured_title);
            desc = itemView.findViewById(R.id.featured_desc);
        }
    }
}

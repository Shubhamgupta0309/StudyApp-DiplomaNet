package com.example.diplomanet.syllabus;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.diplomanet.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class syllabusadapter extends FirebaseRecyclerAdapter<syllabusmodel,syllabusadapter.myviewholder>
{

    public syllabusadapter(@NonNull FirebaseRecyclerOptions<syllabusmodel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull syllabusadapter.myviewholder holder, int position, @NonNull syllabusmodel model) {
        holder.header.setText(model.getFilename());


        holder.relativeLayoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(holder.img1.getContext(), syllabusviewpdf.class);
                intent.putExtra("filename",model.getFilename());
                intent.putExtra("fileurl",model.getFileurl());

                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                holder.img1.getContext().startActivity(intent);
            }
        });

    }

    @NonNull
    @Override
    public syllabusadapter.myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.singelrowdesign,parent,false);
        syllabusadapter.myviewholder holder = new syllabusadapter.myviewholder(view);
        holder.relativeLayoutBtn.setClickable(true);
        return holder;
    }


    public class myviewholder extends RecyclerView.ViewHolder
    {
        ImageView img1;
        TextView header;
        RelativeLayout relativeLayoutBtn;
        public myviewholder(@NonNull View itemView)
        {
            super(itemView);

            img1=itemView.findViewById(R.id.img1);
            header=itemView.findViewById(R.id.header);
            relativeLayoutBtn = itemView.findViewById(R.id.relativeLayoutBtn);
        }
    }
}

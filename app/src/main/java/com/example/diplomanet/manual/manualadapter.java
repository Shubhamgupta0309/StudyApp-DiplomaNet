package com.example.diplomanet.manual;

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
import com.example.diplomanet.qp.qpviewpdf;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class manualadapter extends FirebaseRecyclerAdapter<manualmodel, manualadapter.myviewholder> {

    public manualadapter(@NonNull FirebaseRecyclerOptions<manualmodel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myviewholder holder, int position, @NonNull manualmodel model) {

        holder.header.setText(model.getFilename());

        holder.relativeLayoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.img1.getContext(), qpviewpdf.class);
                intent.putExtra("filename", model.getFilename());
                intent.putExtra("fileurl", model.getFileurl());

                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                holder.img1.getContext().startActivity(intent);
            }
        });
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singelrowdesign, parent, false);
        myviewholder holder = new myviewholder(view);
        holder.relativeLayoutBtn.setClickable(true);
        return holder;
    }

    public class myviewholder extends RecyclerView.ViewHolder {
        ImageView img1;
        TextView header;
        RelativeLayout relativeLayoutBtn;

        public myviewholder(@NonNull View itemView) {
            super(itemView);

            img1 = itemView.findViewById(R.id.img1);
            header = itemView.findViewById(R.id.header);
            relativeLayoutBtn = itemView.findViewById(R.id.relativeLayoutBtn);
        }
    }
}

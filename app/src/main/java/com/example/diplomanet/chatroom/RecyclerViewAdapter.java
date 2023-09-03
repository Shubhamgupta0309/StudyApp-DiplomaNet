package com.example.diplomanet.chatroom;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.diplomanet.R;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{
    private Context context;
    private ArrayList<RoomMessage> list;

    public RecyclerViewAdapter(Context context, ArrayList<RoomMessage> list) {
        this.context = context;
        this.list = list;
    }

    public void addMessage(RoomMessage msg){
        list.add(0,msg);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.message_design,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        RoomMessage message = list.get(position);
        holder.username.setText(message.getUserEmail());
        holder.message.setText(message.getMessage());
        holder.dateTime.setText(message.getDateTime());

        String userEmail = FirebaseAuth.getInstance().getCurrentUser().getEmail();
        if (message.isSent(userEmail)) {
            holder.message.setBackgroundResource(R.drawable.sent_message_background);
        } else {
            holder.message.setBackgroundResource(R.drawable.received_message_background);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView username, message, dateTime;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            username = itemView.findViewById(R.id.user_email);
            message = itemView.findViewById(R.id.user_message);
            dateTime = itemView.findViewById(R.id.user_message_date_time);
        }
    }
}

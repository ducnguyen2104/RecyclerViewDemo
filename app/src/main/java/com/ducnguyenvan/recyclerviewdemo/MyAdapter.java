package com.ducnguyenvan.recyclerviewdemo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    ArrayList<Item> items;
    Context context;

    public MyAdapter(ArrayList<Item> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.item_row,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.title.setText(items.get(position).getTitle());
        holder.img.setImageResource(items.get(position).getImg());
        long time = System.currentTimeMillis() - items.get(position).getTimestamp().getTime();
        int timePassHours = (int)time/(1000*60*60);
        if (timePassHours >= 24) {
            int timePassDays = (int)time/(1000*60*60*24);
            holder.src.setText(items.get(position).getSource() + "  •  " + timePassDays + " day(s) ago" );
        }
        else if (timePassHours >= 1) {
            holder.src.setText(items.get(position).getSource() + "  •  " + timePassHours + " hour(s) ago" );
        }
        else {
            int timePassMins = (int)time/(1000*60);
            holder.src.setText(items.get(position).getSource() + "  •  " + timePassMins + " minute(s) ago" );
        }
        int numOfComments = items.get(position).getComments();
        if (numOfComments == 0) {
            holder.cmts.setText("");
        }
        else {
            holder.cmts.setText(numOfComments + " comment(s)");
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        ImageView img;
        TextView src;
        TextView cmts;
        public MyViewHolder(View itemView) {
            super(itemView);
            title = (TextView)itemView.findViewById(R.id.txtTitle);
            img = (ImageView)itemView.findViewById(R.id.img_view);
            src = (TextView)itemView.findViewById(R.id.txtSource);
            cmts = (TextView)itemView.findViewById(R.id.txtComments);
        }
    }
}

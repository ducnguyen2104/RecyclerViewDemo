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

public class MyAdapter2 extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int ITEM_TYPE_1 = 1;
    private static final int ITEM_TYPE_2 = 2;
    ArrayList<Object> items;
    Context context;

    public MyAdapter2(ArrayList<Object> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Object item = items.get(position);
        if(holder instanceof Item1ViewHolder) {
            ((Item1ViewHolder) holder).bind((Item1)item);
        } else {
            ((Item2ViewHolder) holder).bind((Item2)item);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        if (viewType == ITEM_TYPE_1) {
            View view = layoutInflater.inflate(R.layout.item1_row, parent, false);
            return new Item1ViewHolder(view);
        }
        else {
            View view = layoutInflater.inflate(R.layout.item2_row,parent, false);
            return new Item2ViewHolder(view);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (items.get(position) instanceof Item1) {
            return ITEM_TYPE_1;
        }
        else {
            return ITEM_TYPE_2;
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    private static class Item1ViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        ImageView img;
        TextView src;
        TextView cmts;
        public Item1ViewHolder (View itemView) {
            super(itemView);
            title = (TextView)itemView.findViewById(R.id.txtTitle);
            img = (ImageView)itemView.findViewById(R.id.img_view);
            src = (TextView)itemView.findViewById(R.id.txtSource);
            cmts = (TextView)itemView.findViewById(R.id.txtComments);
        }

        public void bind(Item1 item) {
            title.setText(item.getTitle());
            img.setImageResource(item.getImg());
            long time = System.currentTimeMillis() - item.getTimestamp().getTime();
            int timePassHours = (int)time/(1000*60*60);
            if (timePassHours >= 24) {
                int timePassDays = (int)time/(1000*60*60*24);
                src.setText(item.getSource() + "  •  " + timePassDays + " day(s) ago"  );
            }
            else if (timePassHours >= 1) {
                src.setText(item.getSource() + "  •  " + timePassHours + " hour(s) ago" );
            }
            else {
                int timePassMins = (int)time/(1000*60);
                src.setText(item.getSource() + "  •  " + timePassMins + " minute(s) ago" );
            }
            int numOfComments = item.getComments();
            if (numOfComments == 0) {
                cmts.setText("");
            }
            else {
                cmts.setText(numOfComments + " comment(s)");
            }
        }
    }

    private static class Item2ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView img1;
        ImageView img2;
        ImageView img3;
        TextView src;
        TextView cmts;
        public Item2ViewHolder (View itemView) {
            super(itemView);
            title = (TextView)itemView.findViewById(R.id.txtTitle);
            img1 = (ImageView)itemView.findViewById(R.id.img_view1);
            img2 = (ImageView)itemView.findViewById(R.id.img_view2);
            img3 = (ImageView)itemView.findViewById(R.id.img_view3);
            src = (TextView)itemView.findViewById(R.id.txtSource);
            cmts = (TextView)itemView.findViewById(R.id.txtComments);
        }

        public void bind(Item2 item) {
            title.setText(item.getTitle());
            img1.setImageResource(item.getImg1());
            img2.setImageResource(item.getImg2());
            img3.setImageResource(item.getImg3());
            long time = System.currentTimeMillis() - item.getTimestamp().getTime();
            int timePassHours = (int)time/(1000*60*60);
            if (timePassHours >= 24) {
                int timePassDays = (int)time/(1000*60*60*24);
                src.setText(item.getSource() + "  •  " + timePassDays + " day(s) ago"  );
            }
            else if (timePassHours >= 1) {
                src.setText(item.getSource() + "  •  " + timePassHours + " hour(s) ago" );
            }
            else {
                int timePassMins = (int)time/(1000*60);
                src.setText(item.getSource() + "  •  " + timePassMins + " minute(s) ago" );
            }
            int numOfComments = item.getComments();
            if (numOfComments == 0) {
                cmts.setText("");
            }
            else {
                cmts.setText(numOfComments + " comment(s)");
            }
        }
    }
}

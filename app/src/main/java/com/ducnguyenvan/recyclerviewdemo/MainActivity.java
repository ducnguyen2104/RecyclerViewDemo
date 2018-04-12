package com.ducnguyenvan.recyclerviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    public void initView() {
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(MainActivity.this, layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
        ArrayList<Item> listItems = new ArrayList<>();
        listItems.add(new Item(R.drawable.antimage, "Antimage from Dota2"));
        listItems.add(new Item(R.drawable.axe, "Axe from Dota2"));
        listItems.add(new Item(R.drawable.es, "Earthshaker from Dota2"));
        listItems.add(new Item(R.drawable.marutaro, "Marutaro from Chà-pan"));
        listItems.add(new Item(R.drawable.projecticon, "Project Skin universe from LOL"));
        listItems.add(new Item(R.drawable.shironeko, "Shironeko from Chà-pan"));
        listItems.add(new Item(R.drawable.sven, "Sven from Dota2"));
        listItems.add(new Item(R.drawable.templar, "Lanaya - Templar Assassin from Dota2"));
        listItems.add(new Item(R.drawable.yiproject, "Yi Project from LOL"));
        MyAdapter myAdapter = new MyAdapter(listItems, MainActivity.this);
        recyclerView.setAdapter(myAdapter);
    }
}

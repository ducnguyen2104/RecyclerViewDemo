package com.ducnguyenvan.recyclerviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    public Timestamp stringToTimestamp(String string) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT+07:00"));
        Date parsedDate = null;
        try {
            parsedDate = dateFormat.parse(string);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new java.sql.Timestamp(parsedDate.getTime());
    }

    public void initView() {
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(MainActivity.this, layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
        ArrayList<Object> listItems = new ArrayList<>();
        listItems.add(new Item1(R.drawable.antimage, "Antimage from Dota2", "Dota2", 10, stringToTimestamp("2018-04-12 11:10:00.000")));
        listItems.add(new Item1(R.drawable.axe, "Axe from Dota2","Dota2", 69, stringToTimestamp("2018-04-11 11:10:00.000")));
        listItems.add(new Item1(R.drawable.es, "Earthshaker from Dota2", "Dota2", 0, stringToTimestamp("2018-04-12 05:10:00.000")));
        listItems.add(new Item1(R.drawable.marutaro, "Marutaro from Chà-pan", "Kênh 14", 5, stringToTimestamp("2018-04-12 10:00:00.000")));
        listItems.add(new Item2(R.drawable.projecticon, R.drawable.yiproject, R.drawable.zedproject, "\"Project\" skin series first starts with Yi Project and Zed Project", "Riot", 80, stringToTimestamp("2018-04-13 10:00:00.000")));
        //listItems.add(new Item1(R.drawable.projecticon, "Project Skin universe from LOL","League Of Legends", 110, stringToTimestamp("2018-04-12 08:30:00.000")));
        listItems.add(new Item1(R.drawable.shironeko, "Shironeko from Chà-pan","Chà-pan", 70, stringToTimestamp("2018-04-02 11:10:00.000")));
        listItems.add(new Item1(R.drawable.sven, "Sven from Dota2","Dota2", 0, stringToTimestamp("2018-04-12 01:10:00.000")));
        listItems.add(new Item1(R.drawable.templar, "Lanaya - Templar Assassin from Dota2","Dota2", 10, stringToTimestamp("2018-04-12 11:08:00.000")));
        //listItems.add(new Item1(R.drawable.yiproject, "Yi Project from LOL","League Of Legends", 700, stringToTimestamp("2018-03-30 11:10:00.000")));
        //MyAdapter myAdapter = new MyAdapter(listItems, MainActivity.this);
        MyAdapter2 myAdapter2 = new MyAdapter2(listItems, MainActivity.this);
        recyclerView.setAdapter(myAdapter2);
    }
}

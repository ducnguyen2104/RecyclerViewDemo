package com.ducnguyenvan.recyclerviewdemo;

import android.net.Uri;

import java.sql.Timestamp;

public class Item3 extends Object {

    private Uri video;
    private String title;
    private String source;
    private int comments;
    private Timestamp timestamp;

    public Item3(Uri video, String title, String source, int comments, Timestamp timestamp) {
        this.video = video;
        this.title = title;
        this.source = source;
        this.comments = comments;
        this.timestamp = timestamp;
    }

    public Uri getVideo() {
        return video;
    }

    public void setVideo(Uri video) {
        this.video = video;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public int getComments() {
        return comments;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}

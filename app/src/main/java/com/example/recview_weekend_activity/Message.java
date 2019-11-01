package com.example.recview_weekend_activity;

import java.io.Serializable;

public class Message implements Serializable {

    private String mTitle;
    private String mUser;

    public Message(String s, String u){
        mTitle = s;
        mUser = u;
    }
    public String getmUser() {
        return mUser;
    }

    public void setmUser(String mUser) {
        this.mUser = mUser;
    }



    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        this.mTitle = title;
    }

}


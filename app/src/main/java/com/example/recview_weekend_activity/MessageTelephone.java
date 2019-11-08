package com.example.recview_weekend_activity;

import java.io.Serializable;

public class MessageTelephone implements Serializable, MessageInterface {
    private String mUserLast;
    private String mUserFirst;
    private String mTel;

    public MessageTelephone(String mUserLast, String mUserFirst, String mTel) {
        this.mUserLast = mUserLast;
        this.mUserFirst = mUserFirst;
        this.mTel = mTel;
    }

    public String getmUserLast() {
        return mUserLast;
    }

    public void setmUserLast(String mUserLast) {
        this.mUserLast = mUserLast;
    }

    public String getmUserFirst() {
        return mUserFirst;
    }

    public void setmUserFirst(String mUserFirst) {
        this.mUserFirst = mUserFirst;
    }

    public String getmTel() {
        return mTel;
    }

    public void setmTel(String mTel) {
        this.mTel = mTel;
    }





    @Override
    public int getType() {
        return MessageInterface.MESSAGE_URL;
    }
}


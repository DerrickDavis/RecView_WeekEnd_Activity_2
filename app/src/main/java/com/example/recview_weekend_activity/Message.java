package com.example.recview_weekend_activity;

import java.io.Serializable;
import java.util.ArrayList;

public class Message implements Serializable {

    private String mtitle;

    public String getTitle() {
        return mtitle;
    }

    public void setTitle(String title) {
        this.mtitle = title;
    }

  public static ArrayList<Message> createTitleMessageList(int numTitles){
        ArrayList<Message> messages = new ArrayList<Message>();
        for (int i = 1; i<= numTitles; i++){
          messages.add(new Message());
      }
        return messages;
  }
}

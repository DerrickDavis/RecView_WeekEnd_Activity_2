package com.example.recview_weekend_activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecviewAdapter.ItemClickListener {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecviewAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Message> titleNames = new ArrayList<>();

        titleNames.add(new Message("Can one Trust Another", "Tom Petty"));
        titleNames.add(new Message("To Infintiy and Beyond", "Buzz and wood "));
        titleNames.add(new Message("Soul food on a Plane", "Sam Lee Jackson"));
        titleNames.add(new Message("Heads Up 7 Up", "The Whole 4th grade prod"));
        titleNames.add(new Message("RedRum", "stephen King"));
        titleNames.add(new Message("Gilligan's Planet", "Skipper, Gill & Ginger Inc."));
        titleNames.add(new Message("To the Beyond", "Bob Dylan"));
        titleNames.add(new Message("Over Under the Hill", "50+ Productions"));
        titleNames.add(new Message("To and From", "TP"));
        titleNames.add(new Message("Beyond and Back", "Tom & Jerry"));
        titleNames.add(new Message("Finish first or last", "Ricky Bobby"));
        titleNames.add(new Message("To Be or ...... Not", "Rome Jul"));
        titleNames.add(new Message("Can one Trust Another", "IDK Inc."));

     //This is an option to set the list information
    /*Message msg = new Message("Can one Trust Another");
        titleNames.add(msg);*/

//this manually posts stings to list, instead of using the adapter
        /*titleNames.add("To Infintiy and Beyond");
        titleNames.add("Soul food on a Plane");
        titleNames.add("Heads Up 7 Up");
        titleNames.add("RedRum");
        titleNames.add("Gilligan's Planet");
        titleNames.add("To the Beyond");
        titleNames.add("Over Under the Hill");
        titleNames.add("To and From");
        titleNames.add("Beyond and Back");
        titleNames.add("Finish first or last");
        titleNames.add("To Be or ...... Not");
        titleNames.add("Can one Trust Another");*/

        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setHasFixedSize(true);


        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new RecviewAdapter(this, titleNames);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }
    @Override
    public void onItemClick(View view, int position){
        Toast.makeText(this, "You clicked " + adapter.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();

    }

}

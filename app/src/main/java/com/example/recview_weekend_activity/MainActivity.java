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
    RecviewAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> titleNames = new ArrayList<>();
        titleNames.add("To Infintiy and Beyond");
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
        titleNames.add("Can one Trust Another");

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setHasFixedSize(true);

        /*DividerItemDecoration dividerItemDecoration = new DividerItemDecoration
                (recyclerView.getContext(),layoutManager.getOrientation());
                recyclerView.addItemDecoration(dividerItemDecoration);*/

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new RecviewAdapter(this,titleNames);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }
    @Override
    public void onItemClick(View view, int position){
        Toast.makeText(this, "You clicked " + adapter.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();

    }
}

package com.example.recview_weekend_activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecviewAdapter.ItemClickListener {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecviewAdapter adapter;
    private EditText edtTitle, edtProd;
    private Button add, remv, cancel;
    private ArrayList<Message> titleNames = new ArrayList<>();
    private int lastSelectedItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        populateList();

        edtTitle = findViewById(R.id.et_enterTitle);
        edtProd = findViewById(R.id.et_enterProducer);
        recyclerView = findViewById(R.id.recyclerView);


        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new RecviewAdapter(this, titleNames);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this, "You clicked " + adapter.getItem(position).getTitle() + " " + adapter.getItem(position).getmUser() + " on row number " + position, Toast.LENGTH_SHORT).show();
        lastSelectedItem = position;
    }

    public void populateList() {

        /*titleNames.add(new Message("Can one Trust Another", "Tom Petty"));
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
        titleNames.add(new Message("Can one Trust Another", "IDK Inc."));*/
    }

    public void clearFields() {
        edtTitle.setText("");
        edtProd.setText("");
        edtTitle.requestFocus();
    }

    public void onClickAdd(View view) {
        String movie = edtTitle.getText().toString();
        String prod = edtProd.getText().toString();
        Message message = new Message(movie, prod);
        titleNames.add(message);
        adapter.setListofMessages(titleNames);
        clearFields();
    }

    public void onClickRemove(View view) {
        if(titleNames!= null && titleNames.size() > 0 && lastSelectedItem >= 0){
        titleNames.remove(lastSelectedItem);
        adapter.setListofMessages(titleNames);
        lastSelectedItem = -1;}
    }

    public void onClickCancel(View view) {
        clearFields();
    }
}

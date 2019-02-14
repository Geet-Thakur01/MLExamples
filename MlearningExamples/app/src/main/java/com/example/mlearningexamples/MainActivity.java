package com.example.mlearningexamples;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    private final String[] list_items = {"Arun", "Akansha", "Avadhesh", "Geet"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView user_list = findViewById(R.id.user_list);
        RecyclerView.LayoutManager lm= new LinearLayoutManager(this);
        user_list.setLayoutManager(lm);



        // specify an adapter (see also next example)
        MyAdapter  mAdapter = new MyAdapter(list_items);
        user_list.setAdapter(mAdapter);


    }
}

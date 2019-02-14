package com.example.mlearningexamples;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MyAdapter.CustomItemClick {
    private final String[] list_items = {"Arun", "Akansha", "Avadhesh", "Geet"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView user_list = findViewById(R.id.user_list);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
        user_list.setLayoutManager(lm);

        // specify an adapter (see also next example)
        MyAdapter mAdapter = new MyAdapter(this, list_items);
        user_list.setAdapter(mAdapter);


    }

    @Override
    public void onMyClick(String user) {
        Toast.makeText(this, user, Toast.LENGTH_SHORT).show();
        String classname=this.getPackageName()+"."+user.toLowerCase() +"."+ "Activity"+user;
        Log.e("TAG",classname);
        try {
            Class class_item = Class.forName(classname);
            Intent intent = new Intent(this, class_item);
            startActivity(intent);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

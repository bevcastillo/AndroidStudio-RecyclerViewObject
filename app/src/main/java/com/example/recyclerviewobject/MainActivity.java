package com.example.recyclerviewobject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.recyclerviewobject.CustomAdapter.PersonAdapter;
import com.example.recyclerviewobject.Objects.Person;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Person> personArrayList = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        personArrayList.add(new Person(R.drawable.boss, "Boss Amo", "24"));
        personArrayList.add(new Person(R.drawable.boy4, "Boy One", "20"));
        personArrayList.add(new Person(R.drawable.girl12, "Girl One", "24"));
        personArrayList.add(new Person(R.drawable.girl13, "Girl Two", "30"));
        personArrayList.add(new Person(R.drawable.girl14, "Girl Three", "18"));
        personArrayList.add(new Person(R.drawable.girl15, "Girl Four", "24"));
        personArrayList.add(new Person(R.drawable.man2, "Boy Two", "24"));
        personArrayList.add(new Person(R.drawable.girl16, "Girl Five", "15"));
        personArrayList.add(new Person(R.drawable.girl17, "Girl Six", "22"));


        mRecyclerView = findViewById(R.id.recyclerview);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new PersonAdapter(personArrayList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

    }
}

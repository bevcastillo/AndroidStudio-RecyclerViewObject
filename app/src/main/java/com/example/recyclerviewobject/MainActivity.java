package com.example.recyclerviewobject;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.recyclerviewobject.CustomAdapter.PersonAdapter;
import com.example.recyclerviewobject.Objects.Person;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Uri imageUri;
    ArrayList<Person> personArrayList = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private CoordinatorLayout coordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //
        mRecyclerView = findViewById(R.id.recyclerview);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new PersonAdapter(personArrayList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinator);
        //

//        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
//        mAdapter = new PersonAdapter(personArrayList);
//        mAdapter.notifyDataSetChanged();
//        mRecyclerView.setAdapter(mAdapter);

    }

    //for menu

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.action_add:
                Intent add = new Intent(MainActivity.this, AddPersonActivity.class);
                startActivityForResult(add, 0);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK) {
            Bundle bundle = data.getExtras();
            imageUri = bundle.getParcelable("image");
            String name = bundle.getString("name");
            String age = bundle.getString("age");

            Person person = new Person(imageUri, name, age);
            //
            switch (requestCode){
                case 0: //request to add new person
                    personArrayList.add(person);
                    Snackbar snackbar = Snackbar
                            .make(coordinatorLayout, "New person added.", Snackbar.LENGTH_INDEFINITE)
                            .setAction("UNDO", new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Snackbar snackbar1 = Snackbar
                                            .make(coordinatorLayout, "Undo successful.", Snackbar.LENGTH_SHORT);
                                    snackbar1.show();
                                }
                            })
                            .setActionTextColor(Color.RED);
                    snackbar.show();
                    break;
            }

        }else{

        }
    }
}

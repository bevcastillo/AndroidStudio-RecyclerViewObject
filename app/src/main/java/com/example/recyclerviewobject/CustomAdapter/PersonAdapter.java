package com.example.recyclerviewobject.CustomAdapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.recyclerviewobject.Objects.Person;
import com.example.recyclerviewobject.R;

import java.util.ArrayList;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.PersonViewHolder> {

    private ArrayList<Person> mpersonArrayList;

    public static class PersonViewHolder extends RecyclerView.ViewHolder{

        public ImageView mImage;
        public TextView mName, mAge;

        public PersonViewHolder(@NonNull View itemView) {
            super(itemView);
            mImage = (ImageView) itemView.findViewById(R.id.imageview1);
            mName = (TextView) itemView.findViewById(R.id.textname);
            mAge = (TextView) itemView.findViewById(R.id.textage);

        }
    }

    public PersonAdapter(ArrayList<Person> personArrayList){
        mpersonArrayList = personArrayList;
    }

    @NonNull
    @Override
    public PersonViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.custom_layout, viewGroup, false);
        PersonViewHolder pvholder = new PersonViewHolder(view);
        return pvholder;
    }

    @Override
    public void onBindViewHolder(@NonNull PersonViewHolder personViewHolder, int i) {
        Person currentItem = mpersonArrayList.get(i);

        personViewHolder.mImage.setImageResource(currentItem.getmImage());
        personViewHolder.mName.setText(currentItem.getmName());
        personViewHolder.mAge.setText(currentItem.getmAge());
    }

    @Override
    public int getItemCount() {
        return mpersonArrayList.size();
    }


}

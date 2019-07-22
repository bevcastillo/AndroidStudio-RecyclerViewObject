package com.example.recyclerviewobject.Objects;

import android.net.Uri;

public class Person {

    private Uri mImage;
    private String mName, mAge;

    //constructor
    public Person(Uri mImage, String mName, String mAge) {
        this.mImage = mImage;
        this.mName = mName;
        this.mAge = mAge;
    }

    //getters and setters
    public Uri getmImage() {
        return mImage;
    }

    public void setmImage(Uri mImage) {
        this.mImage = mImage;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmAge() {
        return mAge;
    }

    public void setmAge(String mAge) {
        this.mAge = mAge;
    }
}

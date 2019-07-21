package com.example.recyclerviewobject.Objects;

public class Person {

    private int mImage;
    private String mName, mAge;

    public Person(int mImage, String mName, String mAge) {
        this.mImage = mImage;
        this.mName = mName;
        this.mAge = mAge;
    }

    public int getmImage() {
        return mImage;
    }

    public void setmImage(int mImage) {
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

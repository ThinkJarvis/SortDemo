package com.app.sortdemo;

import android.util.Log;

public abstract class ISort {

    protected int data[] = {3, 2, 4, 6, 1, 0, 5};

    public abstract void sort();


    public String getSortMethod() {
        return getClass().getSimpleName();
    }


    public void print() {
        Log.e("wjq", getSortMethod() + " data[] {" + data[0] + " , " + data[1] + " , " + data[2] + " , " + data[3] + " , " + data[4] + " , " + data[5] + " , " + data[6] + "}");
    }
}

package com.app.sortdemo;

public class ShellSort extends ISort {


    @Override
    public void sort() {
        int length = data.length;

        for (int gap = (int) Math.floor(length / 2); gap > 0; gap = (int) Math.floor(gap / 2)) {
            for (int i = gap; i < length; i++) {
                int j = i;
                int temp = data[i];
                while (j - gap >= 0 && temp < data[j - gap]) {
                    data[j] = data[j - gap];
                    j = j - gap;
                }
                data[j] = temp;
            }
        }
    }
}

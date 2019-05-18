package com.app.sortdemo;

public class QuickSort extends ISort {

    @Override
    public void sort() {
        quickSort(0, data.length - 1);


    }


    void quickSort(int left, int right) {
        if (left >= right) {
            return;
        }


        int i = left;
        int j = right;
        int temp = data[left];
        while (i != j) {
            while (i < j && data[j] >= temp) {
                j--;
            }

            while (i < j && data[i] <= temp) {
                i++;
            }

            if (i < j) {
                int t = data[i];
                data[i] = data[j];
                data[j] = t;
            }
        }

        data[left] = data[i];
        data[i] = temp;

        quickSort(left, i - 1);
        quickSort(i + 1, right);

    }

}

package com.app.sortdemo;

public class BubbleSort extends ISort {

    @Override
    public void sort() {
        for (int i = data.length - 1; i > 0; i--) {
            int flag = 0;
            for (int j = 0; j < i; j++) {
                if (data[j] > data[j + 1]) {
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                    flag = 1;
                }
            }

            if (flag == 0) {
                break;
            }
        }
    }


}

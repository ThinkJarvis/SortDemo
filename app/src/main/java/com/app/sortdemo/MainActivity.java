package com.app.sortdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.LinkedList;
import java.util.Queue;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        int[] data = {2, 5, 4, 3, 7, 8, 1, 0, 9, 6};
//        bubbleSort1(data);
//        Log.e("wjq", "-----------------------------------------------------------------");
//        int[] data1 = {2, 5, 4, 3, 7, 8, 1, 0, 9, 6};
//        bubbleSort2(data1);

//        int[] data3 = {2, 5, 4, 3, 7, 8, 1, 0, 9, 6};
//        quickSort(data3, 0, data3.length - 1);

//        int[] data4 = {2, 5, 4, 3, 7, 8, 1, 0, 9, 6};
//        insertSort(data4);


//        new SynchronizedTest();
//        BubbleSort bubbleSort = new BubbleSort();
//        bubbleSort.sort();
//        bubbleSort.print();

        ISort iSort = new ShellSort();
        iSort.sort();
        iSort.print();
    }


    private void bubbleSort() {
        int[] data = {2, 5, 4, 3, 7, 8, 1, 0, 9, 6};
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

        Log.e("wjq", "data { " + data[0] + "," + data[1] + "," + data[2] + "," + data[3] + "," + data[4] + "," + data[5] + "," + data[6] + "," + data[7] + "," + data[8] + "," + data[9] + " }");
    }

    private void quickSort() {
        int[] data = {2, 5, 4, 3, 7, 8, 1, 0, 9, 6};

        int low = 0;
        int high = data.length - 1;
        int temp = data[low];
        while (low < high) {

            while (low < high && data[high] >= temp) {
                high--;
            }

            data[low] = data[high];

            while (low < high && data[low] <= temp) {
                low++;
            }
            data[high] = data[low];
        }

        data[low] = temp;
    }


    private void bubbleSort1(int[] data) {
        for (int i = data.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {

                if (data[j] > data[j + 1]) {
                    int tmp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = tmp;
                }

                Log.e("wjq", "data { " + data[0] + "," + data[1] + "," + data[2] + "," + data[3] + "," + data[4] + "," + data[5] + "," + data[6] + "," + data[7] + "," + data[8] + "," + data[9] + " }");
            }
        }
    }

    private void bubbleSort2(int[] data) {
        looper1:
        for (int i = data.length - 1; i > 0; i--) {
            int flag = 0;
            looper2:
            for (int j = 0; j < i; j++) {

                if (data[j] > data[j + 1]) {
                    int tmp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = tmp;
                    flag = 1;
                }
                Log.e("wjq", "data { " + data[0] + "," + data[1] + "," + data[2] + "," + data[3] + "," + data[4] + "," + data[5] + "," + data[6] + "," + data[7] + "," + data[8] + "," + data[9] + " }");
            }

            if (flag == 0) {
                break looper1;
            }
        }
    }

    private void quickSort(int[] data, int low, int high) {
        if (low < high) {
            int index = getIndex(data, low, high);
            Log.e("wjq", "index = " + index);
            // 进行迭代对index之前和之后的数组进行相同的操作使整个数组变成有序
            quickSort(data, 0, index - 1);
            quickSort(data, index + 1, high);
        }
    }

    private int getIndex(int[] arr, int low, int high) {
        int tmp = arr[low];

        while (low < high) {
            // 当队尾的元素大于等于基准数据时,向前挪动high指针
            while (low < high && arr[high] >= tmp) {
                high--;
            }

            // 如果队尾元素小于tmp了,需要将其赋值给low
            arr[low] = arr[high];
            Log.e("wjq", "data { " + arr[0] + "," + arr[1] + "," + arr[2] + "," + arr[3] + " }");
            while (low < high && arr[low] <= tmp) {
                low++;
            }
            Log.e("wjq", "low = " + low + "  high = " + high);
            // 当队首元素大于tmp时,需要将其赋值给high
            arr[high] = arr[low];

            Log.e("wjq", "data { " + arr[0] + "," + arr[1] + "," + arr[2] + "," + arr[3] + " }");
        }
        // 跳出循环时low和high相等,此时的low或high就是tmp的正确索引位置
        // 由原理部分可以很清楚的知道low位置的值并不是tmp,所以需要将tmp赋值给arr[low]
        arr[low] = tmp;

        Log.e("wjq", "data { " + arr[0] + "," + arr[1] + "," + arr[2] + "," + arr[3] + " }");

        return low; // 返回tmp的正确位置
    }

    private void insertSort(int[] a) {
        int n = a.length;
        if (n <= 1) {
            return;
        }
        for (int i = 1; i < n; i++) {
            int temp = a[i];
            for (int j = i - 1; j >= 0; j--) {
                if (a[j] > temp) {
                    a[j + 1] = a[j]; // 比temp 大的已排序数据后移一位
                } else {
                    break;
                }
                a[j + 1] = temp; // 空出来的位置，把temp放进去
            }
        }
    }

}

package com.app.sortdemo;

import android.util.Log;

import java.util.LinkedList;
import java.util.Queue;

public class SynchronizedTest {

    private final int MAX_LEN = 10;

    private Queue<Integer> queue = new LinkedList<Integer>();

    public SynchronizedTest() {
        new Producer().start();
        new Consumer("消费者A").start();
        new Consumer("消费者B").start();
    }

    private class Producer extends Thread {
        @Override
        public void run() {
            super.run();

            while (true) {

                synchronized (queue) {

                    while (queue.size() == MAX_LEN) {
                        Log.e("wjq", "当前队列满");
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }

                    queue.add(1);
                    queue.notifyAll();
                    Log.e("wjq", "生产者生产一条任务，当前队列长度为" + queue.size());
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
    }


    public class Consumer extends Thread {

        private String name;

        public Consumer(String name) {
            super(name);

            this.name = name;
        }

        @Override
        public void run() {
            super.run();
            while (true) {

                synchronized (queue) {

                    while (queue.size() == 0) {
                        Log.e("wjq", "当前队列为空");
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }

                    queue.poll();
                    queue.notifyAll();
                    Log.e("wjq", name + "消费一条任务，当前队列长度为" + queue.size());
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }


    }

}

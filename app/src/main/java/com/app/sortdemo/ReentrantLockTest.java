package com.app.sortdemo;

import android.util.Log;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {

    private final int MAX_LEN = 10;

    private Queue<Integer> queue = new LinkedList<Integer>();

    private Lock mLock = new ReentrantLock();

    private Condition mCondition = mLock.newCondition();


    public ReentrantLockTest() {
        new Producer().start();
        new Consumer("消费者A").start();
        new Consumer("消费者B").start();
    }


    private class Producer extends Thread {
        @Override
        public void run() {
            super.run();

            while (true) {
                mLock.lock();
                try {
                    while (queue.size() == MAX_LEN) {

                        try {
                            mCondition.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    queue.add(1);
                    mCondition.signalAll();
                    Log.e("wjq", "生产者生产一条任务，当前队列长度为" + queue.size());
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } finally {
                    mLock.unlock();
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
                mLock.lock();
                try {
                    while (queue.size() == 0) {

                        try {
                            mCondition.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                    queue.poll();
                    mCondition.signalAll();
                    Log.e("wjq", name + "消费一条任务，当前队列长度为" + queue.size());
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } finally {
                    mLock.unlock();
                }
            }
        }


    }

}

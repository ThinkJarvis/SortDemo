package com.app.sortdemo;

public class LinkList {

    private Link head;

    private Link tail;

    public synchronized void add(Link link) {
        if (link == null) {
            throw new NullPointerException("null cannot be enqueued");
        }
        if (tail != null) {
            tail.setNext(link);
            tail = link;
        } else if (head == null) {
            head = tail = link;
        } else {
            throw new IllegalStateException("Head present, but no tail");
        }
    }


    public synchronized void poll() {

    }
}

package com.app.sortdemo;

import android.util.Log;

public class NodeList {

    private Node head;
    private Node tail;


    public NodeList(Node head) {
        this.head = head;
        tail = head;
    }


    public void append(Node node) {
        tail.setNext(node);
        tail = tail.getNext();
    }

    public void remove(int destation) {
        Node pointer = this.head;
        for (int i = 0; i < destation - 1; i++) {
            pointer = pointer.getNext();
        }
        Node temp = pointer.getNext().getNext();
        pointer.setNext(temp);
    }

    public void insert(int destation, Node newNode) {
        Node pointer = this.head;
        for (int i = 0; i < destation - 1; i++) {
            pointer = pointer.getNext();
        }
        Node temp = pointer.getNext();
        pointer.setNext(newNode);
        newNode.setNext(temp);
    }

    public int at(int index) {
        Node pointer = this.head;
        for (int i = 0; i < index; i++) {
            pointer = pointer.getNext();
        }
        return pointer.getData();
    }

    public void display() {
        Node pointer = this.head;
        while (tail != pointer) {
            Log.e("wjq", "data is:" + pointer.getData());
            pointer = pointer.getNext();
        }
        Log.e("wjq", "data is:" + pointer.getData());
        Log.e("wjq", "this is the end.");
    }

    public int size() {
        int size = 1;
        Node pointer = this.head;
        while (tail != pointer) {
            pointer = pointer.getNext();
            size++;
        }
        return size;
    }
}

package com.app.sortdemo;

public class Node {

    private int data;

    private Node next;

    public Node() {

    }

    public Node(int data) {
        this.data = data;
        this.next = new Node();
    }

    public int getData() {
        return this.data;
    }


    public void setData(int value) {
        this.data = value;
    }

    public Node getNext() {
        return this.next;
    }

    public void setNext(Node node) {
        this.next = node;
    }
}

package com.devijoe.project;

public class LinkedNode<T> {

    //Значение поля
    private T value;
    private LinkedNode<T> next;
    private LinkedNode<T> prev;

    public LinkedNode(T value, LinkedNode<T> prev, LinkedNode<T> next) {
        this.value = value;
        this.next = next;
    }

    public LinkedNode(T value) {
        this(value, null, null);
    }

    public LinkedNode() {
        this(null);
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public LinkedNode<T> getNext() {
        return next;
    }

    public void setNext(LinkedNode<T> next) {
        this.next = next;
    }

    public LinkedNode<T> getPrev() {
        return prev;
    }

    public void setPrev(LinkedNode<T> prev) {
        this.prev = prev;
    }
}

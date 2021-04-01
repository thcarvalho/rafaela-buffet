package models;

public class Node<T> {
    public T data;
    public Node<T> next;

    public Node(T model) {
        data = model;
        next = null;
    }
}

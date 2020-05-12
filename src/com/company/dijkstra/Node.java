package com.company.dijkstra;

public class Node<T> {
    private T value;
    private int cost;

    public Node(T value, int cost) {
        this.value = value;
        this.cost = cost;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", cost=" + cost +
                '}';
    }
}

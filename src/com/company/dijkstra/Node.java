package com.company.dijkstra;

import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node<?> node = (Node<?>) o;
        return cost == node.cost &&
                Objects.equals(value, node.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, cost);
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", cost=" + cost +
                '}';
    }
}

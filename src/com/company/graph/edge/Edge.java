package com.company.graph.edge;

import java.util.Objects;

public class Edge<T> {
    private T from;
    private T to;
    private int cost;
    private Edge residual;
    private long flow;
    private long capacity;

    public Edge(T from, T to, int cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
        this.capacity = cost;
    }

    public boolean isResidual() {
        return this.capacity == 0;
    }

    public long getRemainingCapacity() {
        return this.capacity - this.flow;
    }

    public void augment(long bottleNeck) {
        flow += bottleNeck;
        this.residual.flow -= bottleNeck;
    }

    public Edge getResidual() {
        return residual;
    }

    public void setResidual(Edge residual) {
        this.residual = residual;
    }

    public long getFlow() {
        return flow;
    }

    public void setFlow(long flow) {
        this.flow = flow;
    }

    public T getFrom() {
        return from;
    }

    public void setFrom(T from) {
        this.from = from;
    }

    public T getTo() {
        return to;
    }

    public void setTo(T to) {
        this.to = to;
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
        Edge<?> edge = (Edge<?>) o;
        return cost == edge.cost &&
                Objects.equals(from, edge.from) &&
                Objects.equals(to, edge.to);
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to, cost);
    }

    @Override
    public String toString() {
        return "Edge{" +
                "from=" + from +
                ", to=" + to +
                ", cost=" + cost +
                '}';
    }
}

package com.company.graph.edge;

public class EdgeFlow extends Edge {
    private EdgeFlow residual;
    private long flow;
    private long capacity;

    public EdgeFlow(Object from, Object to, int capacity) {
        super(from, to, capacity);
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

    public void setResidual(EdgeFlow residual) {
        this.residual = residual;
    }

    public long getFlow() {
        return flow;
    }

    public void setFlow(long flow) {
        this.flow = flow;
    }

    public long getCapacity() {
        return capacity;
    }

    public void setCapacity(long capacity) {
        this.capacity = capacity;
    }
}

package com.company.graph.edge;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ResidualGraph<T> extends Graph<T> {
    protected long maxCapacity;

    public ResidualGraph() {
    }

    @Override
    public void addEdge(T from, T to, int capacity) {
        maxCapacity = Math.max(maxCapacity, capacity);
        Edge direct = new Edge(from, to, capacity);
        Edge residual = new Edge(to, from,0);
        direct.setResidual(residual);
        residual.setResidual(direct);
        List<Edge<T>> edgesFrom = Optional.ofNullable(getEdges(from)).orElse(new ArrayList<>());
        List<Edge<T>> edgesTo = Optional.ofNullable(getEdges(to)).orElse(new ArrayList<>());
        edgesFrom.add(direct);
        edgesTo.add(residual);
        getGraph().put(from, edgesFrom);
        getGraph().put(to, edgesTo);
    }

    public long getMaxCapacity() {
        return maxCapacity;
    }
}

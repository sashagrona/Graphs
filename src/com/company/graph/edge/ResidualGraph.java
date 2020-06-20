package com.company.graph.edge;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ResidualGraph<T> extends Graph<T> {

    public ResidualGraph() {
    }

    @Override
    public void addEdge(T from, T to, int capacity) {
        EdgeFlow direct = new EdgeFlow(from, to, capacity);
        EdgeFlow residual = new EdgeFlow(to, from,0);
        direct.setResidual(residual);
        residual.setResidual(direct);
        List<Edge<T>> edgesFrom = Optional.ofNullable(getEdges(from)).orElse(new ArrayList<>());
        List<Edge<T>> edgesTo = Optional.ofNullable(getEdges(to)).orElse(new ArrayList<>());
        edgesFrom.add(direct);
        edgesTo.add(residual);
        getGraph().put(from, edgesFrom);
        getGraph().put(to, edgesTo);
    }
}
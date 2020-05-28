package com.company.graph.edge;

import java.util.ArrayList;
import java.util.List;

public class UndirectedGraph<T> extends Graph<T> {

    public UndirectedGraph() {
    }

    @Override
    public void addEdge(T from, T to, int cost) {
        List<Edge<T>> edgesFrom = getGraph().get(from);
        List<Edge<T>> edgesTo = getGraph().get(to);
        if (edgesFrom == null){
            edgesFrom = new ArrayList<>();
        }
        if (edgesTo == null){
            edgesTo = new ArrayList<>();
        }
        // if the node is single then from equals to
        if (!from.equals(to)){
            edgesFrom.add(new Edge<>(from, to, cost));
            edgesTo.add(new Edge<>(to, from, cost));
        }
        getGraph().put(from, edgesFrom);
        getGraph().put(to, edgesTo);
    }
}

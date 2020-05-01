package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph<T> {
    private Map<T, List<Edge<T>>> graph;

    public Graph() {
        this.graph = new HashMap<>();
    }
    public void addEdge(T from, T to, int cost){
        List<Edge<T>> edges = graph.get(from);
        if (edges == null){
            edges = new ArrayList<>();
        }
        edges.add(new Edge<>(from, to, cost));
        graph.put(from, edges);
    }

    public List<Edge<T>> getEdges(T from){
        return graph.get(from);
    }

    @Override
    public String toString() {
        StringBuilder graphs = new StringBuilder();
        graph.forEach((k,v) -> graphs.append(k + ": " + v + "\n"));
        return graphs.toString();
    }
}

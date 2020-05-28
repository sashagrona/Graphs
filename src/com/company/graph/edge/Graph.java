package com.company.graph.edge;

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
        // if the node is single then from equals to
        if (!from.equals(to)){
            edges.add(new Edge<>(from, to, cost));
        }
        graph.put(from, edges);
    }

    public Map<T, List<Edge<T>>> getGraph() {
        return graph;
    }

    public List<Edge<T>> getEdges(T from){
        return graph.get(from);
    }

    public List<T> getNodes(){
        return new ArrayList<>(graph.keySet());
    }

    public int getSize(){
        return graph.size();
    }

    @Override
    public String toString() {
        StringBuilder graphs = new StringBuilder();
        graph.forEach((k,v) -> graphs.append(k + ": " + v + "\n"));
        return graphs.toString();
    }
}

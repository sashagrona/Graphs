package com.company.dijkstra;

import com.company.graph.edge.Graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DijkstraShortestPathDHeap<T> {
    private Graph<T> graph;
    private Set<T> visited;
    private Map<T, Integer> distances;

    public DijkstraShortestPathDHeap(Graph<T> graph) {
        this.graph = graph;
        visited = new HashSet<>();
        distances = new HashMap<>();
    }

    public int dijkstra(T start){

    }


}

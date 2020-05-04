package com.company.dfs;

import com.company.graph.edge.Graph;

import java.util.HashSet;
import java.util.Set;

public class TopologicalSort<T> {
    private Graph<T> graph;
    private Set<T> visited;
    private T node;

    public TopologicalSort(Graph<T> graph, T start) {
        this.graph = graph;
        this.visited = new HashSet<>();
        this.node = start;
    }
}

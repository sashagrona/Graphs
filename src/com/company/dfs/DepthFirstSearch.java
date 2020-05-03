package com.company.dfs;

import com.company.graph.edge.Edge;
import com.company.graph.edge.Graph;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class DepthFirstSearch<T> {
    private Set<T> visited;
    private Stack<T> stack;
    private T start;
    private Graph<T> graph;
    private int count;

    public DepthFirstSearch(T start, Graph<T> graph) {
        this.start = start;
        this.graph = graph;
        this.visited = new HashSet<>();
        this.stack = new Stack<>();
        visited.add(start);
        stack.add(start);
        count = 1;
    }

    public int getCount() {
        List<Edge<T>> edges = graph.getEdges(start);
        if (edges != null ) {
            for (Edge<T> edge : edges) {
                if (!visited.contains(edge.getTo())) {
                    start = edge.getTo();
                    visited.add(start);
                    stack.add(start);
                    count++;
                    getCount();
                }
            }
        }
        if (!stack.isEmpty()) {
            start = stack.pop();
        }
        return count;
    }
}

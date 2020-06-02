package com.company.bfs;

import com.company.graph.edge.Edge;
import com.company.graph.edge.Graph;

import java.util.*;

public class BreadthFirstSearch<T> {
    private Queue<T> queue;
    private Set<T> visited;
    private Graph<T> graph;
    private int count;

    public BreadthFirstSearch(T startNode, Graph<T> graph) {
        this.graph = graph;
        this.queue = new ArrayDeque<>();
        this.visited = new HashSet<>();
        queue.add(startNode);
        visited.add(startNode);
        count = 1;
    }

    public int getCount() {
        if (!queue.isEmpty()) {
            T node = queue.poll();
            List<Edge<T>> edges = graph.getEdges(node);
            if (edges != null) {
                for (Edge<T> edge : edges) {
                    if (!visited.contains(edge.getTo())) {
                        visited.add(edge.getTo());
                        queue.add(edge.getTo());
                        count++;
                    }
                }
            }
        } else {
            return count;
        }
        return getCount();
    }
}

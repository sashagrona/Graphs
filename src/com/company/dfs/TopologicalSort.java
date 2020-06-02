package com.company.dfs;

import com.company.graph.edge.Edge;
import com.company.graph.edge.Graph;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TopologicalSort<T> {
    private final Logger logger = Logger.getLogger(this.getClass().getName());
    private Graph<T> graph;
    private Set<T> visited;
    private List<T> nodes;
    private Stack<T> stack;
    private Map<T, Integer> distances;
    private int offset;

    public TopologicalSort(Graph<T> graph) {
        this.graph = graph;
        this.visited = new HashSet<>();
        this.nodes = graph.getNodes();
        this.stack = new Stack<>();
        this.offset = nodes.size() - 1;
    }

    public void dfs(T node, T[] ordered) {
        visited.add(node);
        stack.push(node);
        List<Edge<T>> edges = graph.getEdges(node);
        if (edges != null && !edges.isEmpty()) {
            for (Edge edge : edges) {
                if (!visited.contains(edge.getTo())) {
                    dfs((T) edge.getTo(), ordered);
                }
            }
        }
        ordered[offset] = stack.pop();
        offset--;
    }

    public T[] topSort() {
        T[] ordered = (T[]) new Object[nodes.size()];
        for (T node : nodes) {
            if (!visited.contains(node)) {
                dfs(node, ordered);
            }
        }
        return ordered;
    }

    //only for DAG (directed acyclic graph)
    private int getPath(T from, T to, int shortOrLong) {
        if (distances != null) {
            return distances.get(to) - distances.get(from);
        }
        distances = new HashMap<>();
        T[] topOrder = topSort();
        distances.put(topOrder[0], 0);
        for (T t : topOrder) {
            List<Edge<T>> edges = graph.getEdges(t);
            if (edges != null) {
                for (Edge edge : edges) {
                    T edgeTo = (T) edge.getTo();
                    int newDist = distances.get(t) + edge.getCost();
                    if (distances.get(edgeTo) != null) {
                        int currentDist = distances.get(edgeTo);
                        currentDist = ((newDist - currentDist) * shortOrLong < 0) ? newDist : currentDist;
                        distances.put(edgeTo, currentDist);
                    } else {
                        distances.put(edgeTo, newDist);
                    }
                }
            }
        }
        logger.log(Level.INFO, distances.keySet().toString());
        logger.log(Level.INFO, distances.values().toString());
        return getPath(from, to, shortOrLong);
    }

    public int getShortestPath(T from, T to) {
        return getPath(from, to, 1);
    }

    public int getLongestPath(T from, T to) {
        return getPath(from, to, -1);
    }
}

package com.company;

import com.company.graph.edge.Edge;
import com.company.graph.edge.EdgeComparator;
import com.company.graph.edge.UndirectedGraph;

import java.util.*;

//Prim's Minimum Spanning Tree algorithm
public class PrimsMST {
    private UndirectedGraph<Integer> graph;
    private Set<Integer> visited;
    private List<Edge> edges;
    private PriorityQueue<Edge> queue;
    private int start;
    private int edgeSize;
    private int cost;
    private boolean isSolved;

    public PrimsMST(UndirectedGraph<Integer> graph, int start) {
        this.graph = graph;
        this.start = start;
        this.visited = new HashSet<>();
        this.edgeSize = 0;
        this.isSolved = false;
        graph.getNodes().forEach(x -> edgeSize += graph.getEdges(x).size());
        edgeSize /= 2;
        this.edges = new ArrayList<>();
        this.cost = 0;
        this.queue = new PriorityQueue(new EdgeComparator());
    }

    public List<Edge> mst() {
        int edgeCount = 0;
        solve(start);
        while (!queue.isEmpty() && edgeCount != edgeSize) {
            Edge edge = queue.poll();
            if (!visited.contains(edge.getTo())) {
                edges.add(edge);
                edgeCount++;
                cost += edge.getCost();
                solve((Integer) edge.getTo());
            }
        }
        isSolved = true;
        return edges;
    }

    private void solve(int node) {
        visited.add(node);
        for (Edge<Integer> edge : graph.getEdges(node)) {
            if (!visited.contains(edge.getTo())) {
                queue.add(edge);
            }
        }

    }

    @Override
    public String toString() {
        if (!isSolved) {
            mst();
        }
        StringBuilder sb = new StringBuilder();
        for (Edge edge : edges) {
            sb.append(edge).append(System.lineSeparator());
        }
        sb.append("Total cost of minimum spanning tree is " + cost);
        return sb.toString();
    }
}

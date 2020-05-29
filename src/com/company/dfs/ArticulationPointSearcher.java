package com.company.dfs;

import com.company.graph.edge.Edge;
import com.company.graph.edge.UndirectedGraph;

import java.util.*;

public class ArticulationPointSearcher {
    private UndirectedGraph graph;
    private Set<Integer> visited;
    private Set<Integer> points;
    private int[] ids;
    private int[] low;
    private int id;
    private int size;
    private int edgeCount;

    public ArticulationPointSearcher(UndirectedGraph graph) {
        this.graph = graph;
        this.visited = new HashSet<>();
        this.size = graph.getSize();
        this.points = new TreeSet<>();
        this.ids = new int[size];
        this.low = new int[size];
        this.id = 0;
    }

    public Set<Integer> findArtPoints() {
        for (int i = 0; i < size; i++) {
            if (!visited.contains(i)) {
                edgeCount = 0;
                dfs(i, -1, i);
                if (edgeCount < 2) {
                    points.remove(i);
                }
            }
        }
        return points;
    }

    private void dfs(int current, int parent, int root) {
        if (root == parent) {
            edgeCount++;
        }
        visited.add(current);
        ids[current] = id;
        low[current] = id;
        id++;
        List<Edge> edges = graph.getEdges(current);
        for (Edge edge : edges) {
            int to = (int) edge.getTo();
            if (to == parent) continue;
            if (!visited.contains(to)) {
                dfs(to, current, root);
                low[current] = Math.min(low[current], low[to]);
                if (ids[current] <= low[to]) {
                    points.add(current);
                }
            } else {
                low[current] = Math.min(low[current], ids[to]);
            }
        }
    }
}

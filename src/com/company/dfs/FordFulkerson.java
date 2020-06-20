package com.company.dfs;

import com.company.graph.edge.Edge;
import com.company.graph.edge.ResidualGraph;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

//this algorithm finds the maximum flow of the graph
public class FordFulkerson {
    private ResidualGraph<Integer> graph;
    private Set<Integer> visited;
    private long maxFlow;
    private final long INFINITY = Long.MAX_VALUE / 2;
    private int source;
    private int sink;
    private boolean isSolved;

    public FordFulkerson(ResidualGraph<Integer> graph, int source, int sink) {
        this.graph = graph;
        this.visited = new HashSet<>();
        this.source = source;
        this.sink = sink;
        this.maxFlow = 0;
    }

    public long getMaxFlow() {
        if (!isSolved) {
            solve();
        }
        return maxFlow;
    }

    public void solve() {
        long bottleNeck;
        do {
            bottleNeck = dfs(source, INFINITY);
            visited.clear();
            maxFlow += bottleNeck;
        } while (bottleNeck != 0);
        isSolved = true;
    }

    public long dfs(int node, long flow) {
        if (node == sink)
            return flow;
        visited.add(node);
        List<Edge<Integer>> edges = graph.getEdges(node);
        for (Edge edge : edges) {
            long remainingCapacity = edge.getRemainingCapacity();
            if (remainingCapacity > 0 && !visited.contains(edge.getTo())) {
                long bottleNeck = dfs((int) edge.getTo(), Math.min(flow, remainingCapacity));
                if (bottleNeck > 0) {
                    edge.augment(bottleNeck);
                    return bottleNeck;
                }
            }
        }
        return 0;
    }

    @Override
    public String toString() {
        if (!isSolved) {
            solve();
        }
        StringBuilder sb = new StringBuilder();
        for (Integer node : graph.getNodes()) {
            for (Edge<Integer> edge : graph.getEdges(node)) {
                sb.append(edge + ", ").append("Flow: " + edge.getFlow()).append(", IsResidual: " + edge.isResidual()).append(System.lineSeparator());
            }
        }
        return sb.toString();
    }
}

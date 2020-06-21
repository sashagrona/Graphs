package com.company.networkflow;

import com.company.graph.edge.Edge;
import com.company.graph.edge.ResidualGraph;

import java.util.List;

//this algorithm finds the maximum flow of the graph O(f*E)
public class FordFulkerson extends NetworkFlow{

    public FordFulkerson(ResidualGraph<Integer> graph, int source, int sink) {
        super(graph, source, sink);
    }

    @Override
    public void solve() {
        long bottleNeck;
        do {
            bottleNeck = dfs(source, INFINITY);
            visited.clear();
            maxFlow += bottleNeck;
        } while (bottleNeck != 0);
        isSolved = true;
    }

    private long dfs(int node, long flow) {
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
}

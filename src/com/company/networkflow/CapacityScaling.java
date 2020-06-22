package com.company.networkflow;

import com.company.graph.edge.Edge;
import com.company.graph.edge.ResidualGraph;

public class CapacityScaling extends NetworkFlow {

    private int delta;

    public CapacityScaling(ResidualGraph<Integer> graph, int source, int sink) {
        super(graph, source, sink);
        this.delta = 1 << (int) Math.floor(Math.log(graph.getMaxCapacity()) / Math.log(2));
    }

    @Override
    public void solve() {
        for (long bottleneck = 0; delta > 0; delta /= 2) {
            do {
                bottleneck = dfs(source, INFINITY);
                maxFlow += bottleneck;
                visited.clear();
            }while (bottleneck != 0);
        }
    }

    private long dfs(int node, long flow) {
        if (node == sink)
            return flow;
        visited.add(node);
        for (Edge<Integer> edge : graph.getEdges(node)){
            long remainingCapacity = edge.getRemainingCapacity();
            if (remainingCapacity >= delta && !visited.contains(edge.getTo())){
                long bottleneck = dfs(edge.getTo(), Math.min(remainingCapacity, flow));
                if (bottleneck > 0){
                    edge.augment(bottleneck);
                    return bottleneck;
                }
            }
        }
        return 0;
    }
}

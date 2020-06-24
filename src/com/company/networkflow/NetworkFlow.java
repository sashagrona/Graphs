package com.company.networkflow;

import com.company.graph.edge.Edge;
import com.company.graph.edge.ResidualGraph;

import java.util.HashSet;
import java.util.Set;

public abstract class NetworkFlow {
    protected ResidualGraph<Integer> graph;
    protected Set<Integer> visited;
    protected long maxFlow;
    protected final long INFINITY = Long.MAX_VALUE / 2;
    protected int source;
    protected int sink;
    protected boolean isSolved;

    public NetworkFlow(ResidualGraph<Integer> graph, int source, int sink) {
        this.graph = graph;
        this.visited = new HashSet<>();
        this.source = source;
        this.sink = sink;
        this.maxFlow = 0;
    }

    public long getMaxFlow(){
        if (!isSolved) {
            solve();
        }
        return maxFlow;
    }

    public abstract void solve();

    @Override
    public String toString() {
        if (!isSolved) {
//            solve();
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

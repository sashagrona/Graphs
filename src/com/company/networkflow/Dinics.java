package com.company.networkflow;

import com.company.graph.edge.Edge;
import com.company.graph.edge.ResidualGraph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Dinics extends NetworkFlow{
    private int [] level;

    public Dinics(ResidualGraph<Integer> graph, int source, int sink) {
        super(graph, source, sink);
        this.level = new int[graph.getSize()];

    }

    @Override
    public void solve() {
        while (bfs()){
            long bottleneck;
            do {
                bottleneck = dfs(source, INFINITY);
                maxFlow+=bottleneck;
            }while (bottleneck !=0);
        }
    }

    private long dfs(int node, long flow){
        if (node == sink)
            return flow;
        for (Edge<Integer> edge : graph.getEdges(node)){
            if (level[node] + 1 == level[edge.getTo()]) {
                long remainingCapacity = edge.getRemainingCapacity();
                if (remainingCapacity >0) {
                    long bottleneck = dfs(edge.getTo(), Math.min(flow, remainingCapacity));
                    if (bottleneck > 0) {
                        edge.augment(bottleneck);
                        return bottleneck;
                    }
                }
            }
        }
        return 0;
    }

    //to set level graph
    private boolean bfs(){
        Arrays.fill(level, -1);
        Queue<Integer> queue = new ArrayDeque();
        queue.add(source);
        level[source] = 0;
        while (!queue.isEmpty()){
            int node = queue.poll();
            for (Edge<Integer> edge: graph.getEdges(node)){
                long remainingCapacity = edge.getRemainingCapacity();
                if (remainingCapacity > 0 && level[edge.getTo()] == -1) {
                    queue.add(edge.getTo());
                    level[edge.getTo()] = level[node] + 1;
                }
            }
        }
        return level[sink] != -1;
    }
}

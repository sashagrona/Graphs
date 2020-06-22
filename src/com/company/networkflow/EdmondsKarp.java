package com.company.networkflow;

import com.company.Main;
import com.company.graph.edge.Edge;
import com.company.graph.edge.ResidualGraph;

import java.util.ArrayDeque;
import java.util.Queue;

//this algorithm finds the maximum flow of the graph O(V*E^2)
public class EdmondsKarp extends NetworkFlow{

    private Edge<Integer> [] previous = new Edge[graph.getSize()];

    public EdmondsKarp(ResidualGraph<Integer> graph, int source, int sink) {
        super(graph, source, sink);
    }

    @Override
    public void solve() {
        long bottleNeck;
        do {
            bottleNeck = bfs();
            visited.clear();
            maxFlow += bottleNeck;
        } while (bottleNeck != 0);
    }

    private long bfs(){
        Queue queue = new ArrayDeque();
        queue.add(source);
        visited.add(source);
        while (!queue.isEmpty()){
            int node = (int) queue.poll();
            if (node == sink)
                break;
            for (Edge<Integer> edge : graph.getEdges(node)){
                long remainingCapacity = edge.getRemainingCapacity();
                if (remainingCapacity > 0 && !visited.contains(edge.getTo())) {
                    visited.add(edge.getTo());
                    queue.add(edge.getTo());
                    previous[edge.getTo()] = edge;
                }
            }
        }
        if (previous[sink] == null)
            return 0;
        long bottleNeck = INFINITY;
        for (Edge edge = previous[sink];edge != null;edge = previous[(int)edge.getFrom()]){
            bottleNeck = Math.min(bottleNeck, edge.getRemainingCapacity());
        }
        for (Edge edge = previous[sink];edge != null;edge = previous[(int)edge.getFrom()]){
            edge.augment(bottleNeck);
        }
        return bottleNeck;
    }
}

package com.company.networkflow;

import com.company.graph.edge.ResidualGraph;

//this algorithm finds the maximum flow of the graph O(V*E^2)
public class EdmondsKarp extends NetworkFlow{

    public EdmondsKarp(ResidualGraph<Integer> graph, int source, int sink) {
        super(graph, source, sink);
    }

    @Override
    public void solve() {

    }
}

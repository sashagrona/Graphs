package com.company;

import com.company.networkflow.FordFulkerson;
import com.company.graph.edge.ResidualGraph;
import com.company.networkflow.NetworkFlow;

public class Main {

    public static void main(String[] args) {
        ResidualGraph<Integer> graph = new ResidualGraph<Integer>();
        //source
        int s = 10;
        //sink
        int t = 11;
        graph.addEdge(s, 0, 7);
        graph.addEdge(s, 1, 2);
        graph.addEdge(s, 2, 1);
        graph.addEdge(0, 4, 4);
        graph.addEdge(0, 3, 2);
        graph.addEdge(1, 4, 5);
        graph.addEdge(1, 5, 6);
        graph.addEdge(2, 3, 4);
        graph.addEdge(2, 7, 8);
        graph.addEdge(3, 6, 7);
        graph.addEdge(3, 7, 1);
        graph.addEdge(4, 5, 8);
        graph.addEdge(4, 8, 3);
        graph.addEdge(5, 8, 3);
        graph.addEdge(6, t, 1);
        graph.addEdge(7, t, 3);
        graph.addEdge(8, t, 4);

        System.out.println(graph.toString());
        NetworkFlow fordFulkerson = new FordFulkerson(graph, s, t);
        System.out.println(fordFulkerson.getMaxFlow());
    }
}

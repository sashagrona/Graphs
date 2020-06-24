package com.company;

import com.company.networkflow.*;
import com.company.graph.edge.ResidualGraph;

public class Main {

    public static void main(String[] args) {
        ResidualGraph<Integer> graph = new ResidualGraph<Integer>();
        //source
        int s = 9;
        //sink
        int t = 10;
        graph.addEdge(s, 0, 5);
        graph.addEdge(s, 1, 10);
        graph.addEdge(s, 2, 15);
        graph.addEdge(0, 3, 10);
        graph.addEdge(1, 0, 15);
        graph.addEdge(1, 4, 20);
        graph.addEdge(2, 5, 25);
        graph.addEdge(3, 4, 25);
        graph.addEdge(3, 6, 10);
        graph.addEdge(3, 7, 20);
        graph.addEdge(4, 2, 5);
        graph.addEdge(4, 7, 30);
        graph.addEdge(5, 7, 20);
        graph.addEdge(5, 8, 10);
        graph.addEdge(7, 8, 15);
        graph.addEdge(6, t, 5);
        graph.addEdge(7, t, 15);
        graph.addEdge(8, t, 10);

        System.out.println(graph.toString());
        NetworkFlow dinics = new Dinics(graph, s, t);
        System.out.println(dinics.getMaxFlow());
    }
}

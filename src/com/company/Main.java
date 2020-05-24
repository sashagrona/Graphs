package com.company;

import com.company.graph.matrix.MatrixGraph;

public class Main {

    public static void main(String[] args) {
        MatrixGraph graph = new MatrixGraph(7);
        graph.addEdge( 0, 1, 2);
        graph.addEdge(0, 2, 5);
        graph.addEdge(0, 6, 10);
        graph.addEdge(1, 2, 2);
        graph.addEdge(1, 4, 11);
        graph.addEdge(2, 6, 2);
        graph.addEdge(6, 5, 11);
        graph.addEdge(4, 5, 1);
        graph.addEdge(5, 4, -2);
        System.out.println(graph.toString());
//        BellmanFord bellmanFord = new BellmanFord(graph, 0, 8);
//        System.out.println(Arrays.toString(bellmanFord.getDistances()));
    }
}

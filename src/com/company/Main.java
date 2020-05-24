package com.company;

import com.company.graph.matrix.MatrixGraph;
import com.company.negativecycles.FloydWarshall;

public class Main {

    public static void main(String[] args) {
        MatrixGraph graph = new MatrixGraph(7);
        graph.addEdge(0, 1, 2);
        graph.addEdge(0, 2, 5);
        graph.addEdge(0, 6, 10);
        graph.addEdge(1, 2, 2);
        graph.addEdge(1, 4, 11);
        graph.addEdge(2, 6, 2);
        graph.addEdge(6, 5, 11);
        graph.addEdge(4, 5, 1);
        graph.addEdge(5, 4, -2);
        System.out.println(graph.toString());
        FloydWarshall floydWarshall = new FloydWarshall(graph);
        System.out.println(floydWarshall.toString());
    }
}

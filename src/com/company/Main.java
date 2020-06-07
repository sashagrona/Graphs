package com.company;

import com.company.dynamicprog.TSPSolver;
import com.company.graph.matrix.MatrixGraph;

public class Main {

    public static void main(String[] args) {
        MatrixGraph graph = new MatrixGraph(6);
        graph.addEdge(0, 3, 8);
        graph.addEdge(3, 2, 6);
        graph.addEdge(2, 4, 4);
        graph.addEdge(4, 1, 2);
        graph.addEdge(1, 5, 12);
        graph.addEdge(5, 1, 10);

        System.out.println(graph.toString());
        TSPSolver tspSolver = new TSPSolver(0, graph);
        System.out.println(tspSolver);
        tspSolver.getCombinations(3);
    }
}

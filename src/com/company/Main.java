package com.company;

import com.company.dfs.EulerianPath;
import com.company.dynamicprog.TSPSolver;
import com.company.graph.edge.Graph;
import com.company.graph.matrix.MatrixGraph;

public class Main {

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addEdge(0, 1, 0);
        graph.addEdge(1, 2, 0);
        graph.addEdge(1, 4, 0);
        graph.addEdge(1, 3, 0);
        graph.addEdge(2, 1, 0);
        graph.addEdge(4, 1, 0);
        graph.addEdge(3,3,0);

        System.out.println(graph.toString());
        EulerianPath eulerianPath = new EulerianPath(graph);
        System.out.println(eulerianPath.getPath());
    }
}

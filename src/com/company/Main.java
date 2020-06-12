package com.company;

import com.company.dfs.EulerianPath;
import com.company.dynamicprog.TSPSolver;
import com.company.graph.edge.Graph;
import com.company.graph.edge.UndirectedGraph;
import com.company.graph.matrix.MatrixGraph;

public class Main {

    public static void main(String[] args) {
        UndirectedGraph graph = new UndirectedGraph();
        graph.addEdge(0, 1, 5);
        graph.addEdge(1, 2, 4);
        graph.addEdge(2, 9, 2);
        graph.addEdge(0, 4, 1);
        graph.addEdge(0, 3, 4);
        graph.addEdge(1, 3, 2);
        graph.addEdge(2, 7, 4);
        graph.addEdge(2, 8, 1);
        graph.addEdge(9, 8, 0);
        graph.addEdge(4, 5, 1);
        graph.addEdge(5, 6, 7);
        graph.addEdge(6, 8, 4);
        graph.addEdge(4, 3, 2);
        graph.addEdge(5, 3, 5);
        graph.addEdge(3, 6, 11);
        graph.addEdge(6, 7, 1);
        graph.addEdge(3, 7, 2);
        graph.addEdge(7, 8, 6);
        graph.addEdge(8,8,0);
        graph.addEdge(9,9,0);

        System.out.println(graph.toString());
        PrimsMST mst = new PrimsMST(graph, 0);
        System.out.println(mst);
    }
}

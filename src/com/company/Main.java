package com.company;

import com.company.dfs.TarjanSolver;
import com.company.graph.edge.Graph;

public class Main {

    public static void main(String[] args) {
        Graph<Integer> graph = new Graph();
        graph.addEdge(0, 1, 0);
        graph.addEdge(0, 3, 0);
        graph.addEdge(1, 2, 0);
        graph.addEdge(1, 4, 0);
        graph.addEdge(2, 0, 0);
        graph.addEdge(2, 6, 0);
        graph.addEdge(4, 5, 0);
        graph.addEdge(4, 6, 0);
        graph.addEdge(5, 6, 0);
        graph.addEdge(5, 7, 0);
        graph.addEdge(5, 8, 0);
        graph.addEdge(5, 9, 0);
        graph.addEdge(6, 4, 0);
        graph.addEdge(7, 9, 0);
        graph.addEdge(8, 9, 0);
        graph.addEdge(9, 8, 0);
        graph.addEdge(3, 3, 0);
        System.out.println(graph.toString());
        TarjanSolver tarjanSolver = new TarjanSolver(graph);
        tarjanSolver.findStronglyConnComps();
        System.out.println(tarjanSolver);
    }
}

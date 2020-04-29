package com.company;

import com.company.dfs.DepthFirstSearch;
import com.company.dfs.Graph;

public class Main {

    public static void main(String[] args) {
        Graph<Integer> graph = new Graph<>();
        graph.addEdge(0, 1,5);
        graph.addEdge(0, 9, 6);
        graph.addEdge(1, 8, 6);
        graph.addEdge(9, 8, -3);
        graph.addEdge(8, 7, 11);
        graph.addEdge(7, 10, 1);
        graph.addEdge(10, 11, 6);
        graph.addEdge(11, 7, 7);
        graph.addEdge(7, 3, -5);
        graph.addEdge(3, 4, 12);
        graph.addEdge(3, 2, 24);
        graph.addEdge(3, 5, 4);
        graph.addEdge(5, 6, 9);
        graph.addEdge(6, 7, 3);
        DepthFirstSearch<Integer> dfs = new DepthFirstSearch<>(0, graph);
        System.out.println(dfs.getCount());
    }
}

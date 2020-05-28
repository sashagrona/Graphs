package com.company;

import com.company.dfs.BridgesSearcher;
import com.company.graph.edge.UndirectedGraph;
import com.company.graph.matrix.MatrixGraph;
import com.company.negativecycles.FloydWarshall;

public class Main {

    public static void main(String[] args) {
        UndirectedGraph graph = new UndirectedGraph();
        graph.addEdge(0, 1, 0);
        graph.addEdge(0, 2, 0);
        graph.addEdge(1, 2, 0);
        graph.addEdge(2, 3, 0);
        graph.addEdge(3, 4, 0);
        graph.addEdge(2, 5, 0);
        graph.addEdge(6, 7, 0);
        graph.addEdge(7, 8, 0);
        graph.addEdge(5, 6, 0);
        graph.addEdge(8, 5, 0);
        System.out.println(graph.toString());
        BridgesSearcher bridgesSearcher = new BridgesSearcher(graph);
        System.out.println(bridgesSearcher);
    }
}

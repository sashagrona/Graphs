package com.company;

import com.company.dfs.ArticulationPointSearcher;
import com.company.graph.edge.UndirectedGraph;

public class Main {

    public static void main(String[] args) {
        UndirectedGraph graph = new UndirectedGraph();
        graph.addEdge(0, 1, 0);
        graph.addEdge(1, 2, 0);
        graph.addEdge(2, 3, 0);
        graph.addEdge(3, 0, 0);
        graph.addEdge(0, 4, 0);

        System.out.println(graph.toString());
        ArticulationPointSearcher articulationPointSearcher = new ArticulationPointSearcher(graph);
        System.out.println(articulationPointSearcher.findArtPoints());
    }
}

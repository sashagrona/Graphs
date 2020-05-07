package com.company;

import com.company.dfs.TopologicalSort;
import com.company.graph.edge.Graph;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {
        Graph<String> graph = new Graph<>();
        graph.addEdge("A","B",9);
        graph.addEdge("A","C",8);
        graph.addEdge("B","E",14);
        graph.addEdge("B","D",4);
        graph.addEdge("B","C",4);
        graph.addEdge("E","H",14);
        graph.addEdge("C","D",8);
        graph.addEdge("C","G",1);
        graph.addEdge("D","E",4);
        graph.addEdge("D","F",-5);
        graph.addEdge("D","G",2);
        graph.addEdge("F","H",2);
        graph.addEdge("G","H",3);
        graph.addEdge("H", "H",0);

        System.out.println(graph.toString());
        TopologicalSort<String> topologicalSort = new TopologicalSort<>(graph);
        System.out.println(topologicalSort.getShortestPath("D", "H"));
    }
}

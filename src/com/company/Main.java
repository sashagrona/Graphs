package com.company;

import com.company.dfs.TopologicalSort;
import com.company.graph.edge.Graph;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Graph<String> graph = new Graph<>();
        graph.addEdge("0S","1",3);
        graph.addEdge("0S","2",2);
        graph.addEdge("0S","5",3);
        graph.addEdge("1","3D",1);
        graph.addEdge("1","2",6);
        graph.addEdge("2","3D",1);
        graph.addEdge("2","4",10);
        graph.addEdge("3D","4",5);
        graph.addEdge("5","4",7);
        graph.addEdge("4","4",0);
        graph.addEdge("6","6",0);
        graph.addEdge("7","5",0);
        graph.addEdge("3D","7",5);

        System.out.println(graph.toString());

        TopologicalSort<String> topologicalSort = new TopologicalSort<>(graph);
        System.out.println(Arrays.toString(topologicalSort.topSort()));
    }
}

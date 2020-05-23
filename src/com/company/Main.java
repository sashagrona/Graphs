package com.company;

import com.company.bellman.BellmanFord;
import com.company.dijkstra.DijkstraShortestPath;
import com.company.graph.edge.Graph;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Graph<Integer> graph = new Graph<>();
        graph.addEdge( 0, 1, 1);
        graph.addEdge(1, 2, 1);
        graph.addEdge(2, 4, 1);
        graph.addEdge(4, 3, -3);
        graph.addEdge(3, 2, 1);
        graph.addEdge(1, 5, 4);
        graph.addEdge(1, 6, 4);
        graph.addEdge(5, 6, 5);
        graph.addEdge(6, 7, 4);
        graph.addEdge(5, 7, 3);
        System.out.println(graph.toString());
        BellmanFord bellmanFord = new BellmanFord(graph, 0, 9);
        System.out.println(Arrays.toString(bellmanFord.getDistances()));
    }
}

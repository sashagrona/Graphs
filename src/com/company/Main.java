package com.company;

import com.company.dijkstra.DijkstraShortestPath;
import com.company.graph.edge.Graph;

public class Main {

    public static void main(String[] args) {
        Graph<Integer> graph = new Graph<>();
        graph.addEdge(0,1,5);
        graph.addEdge(0,2,1);
        graph.addEdge(1,3,3);
        graph.addEdge(1,2,2);
        graph.addEdge(1,4,20);
        graph.addEdge(2,1,3);
        graph.addEdge(2,4,12);
        graph.addEdge(3,2,3);
        graph.addEdge(3,4,2);
        graph.addEdge(3,5,6);
        graph.addEdge(4,5,1);
        graph.addEdge(5,5,0);


        System.out.println(graph.toString());
        DijkstraShortestPath<Integer> dijkstraShortestPath = new DijkstraShortestPath<>(graph);
        System.out.println(dijkstraShortestPath.getIntPath(0,1));
    }
}

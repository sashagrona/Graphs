package com.company.negativecycles;

import com.company.graph.edge.Edge;
import com.company.graph.edge.Graph;

import java.util.Arrays;
import java.util.List;

public class BellmanFord {
    private Graph<Integer> graph;
    private int start;
    private double [] distances;

    public BellmanFord(Graph<Integer> graph, int start, int vertices) {
        this.graph = graph;
        this.start = start;
        this.distances = new double[vertices];
    }

    public double[] getDistances(){
        Arrays.fill(distances, Double.POSITIVE_INFINITY);
        distances[start] = 0;
        commonOperations(false);
        //to find parts of negative cycle
        commonOperations(true);
        return distances;
    }

    private void commonOperations(boolean isInfiniteSearch){
        for (int i=0;i<distances.length-1;i++){
            for (int j = 0;j<graph.getSize();j++){
                List<Edge<Integer>> edges = graph.getEdges(j);
                for (Edge edge : edges){
                    if(distances[(int) edge.getFrom()] + edge.getCost() < distances[(int) edge.getTo()]){
                        distances[(int) edge.getTo()] = (!isInfiniteSearch) ? distances[(int)edge.getFrom()] + edge.getCost() : Double.NEGATIVE_INFINITY;
                    }
                }
            }
        }
    }
}
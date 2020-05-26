package com.company.negativecycles;

import com.company.graph.matrix.MatrixGraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//user for all-pair shortest path with negative and positive weights
public class FloydWarshall {
    private MatrixGraph graph;
    private double [][] distances;
    private int [][] next;
    private boolean isSolved;

    public FloydWarshall(MatrixGraph graph) {
        this.graph = graph;
        this.isSolved = false;
        int size = graph.getSize();
        this.distances = new double[size][size];
        this.next = new int[size][size];
        init();
    }

    private void init(){
        for (int i = 0;i<distances.length;i++){
            for (int j =0;j< distances.length;j++){
                distances[i][j] = graph.getDistance(i,j);
                next[i][j] = j;
            }
        }
    }

    public double[][] solve(){
        if (isSolved){
            return distances;
        }
        commonOperation(false);
        //used for searching negative cycles
        commonOperation(true);
        isSolved = true;
        return distances;
    }

    private void commonOperation(boolean isInfiniteSerach){
        int size = distances.length;
        for (int i = 0;i< size;i++){
            for (int j =0;j< size;j++){
                for (int k = 0;k<size;k++){
                    if (distances[j][k] > distances[j][i] + distances[i][k]){
                        if (isInfiniteSerach){
                            distances[j][k] = Double.NEGATIVE_INFINITY;
                            next[j][k] = -1;
                        }else {
                            distances[j][k] = distances[j][i] + distances[i][k];
                            next[j][k] = next[j][i];
                        }
                    }
                }
            }
        }
    }

    public List<Integer> reconstructPath(int start, int end){
        if (!isSolved){
            solve();
        }
        if (distances[start][end] == Double.POSITIVE_INFINITY){
            return null;
        }
        List<Integer> path = new ArrayList<>();
        int i = start;
        for (; i != end; i = next[i][end]){
            if (i == -1){
                return null;
            }
            path.add(i);
        }
        path.add(end);
        if (next[i][end] == -1) {
            return null;
        }
        return path;

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        double [][] distances = solve();
        for (int i = 0;i< distances.length;i++){
            for (int j = 0;j< distances.length;j++){
                sb.append("From " + i + " to " + j + " the cost is " + distances[i][j]).append(System.lineSeparator());
            }
        }
        return sb.toString();
    }
}

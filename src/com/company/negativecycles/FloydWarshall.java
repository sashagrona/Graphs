package com.company.negativecycles;

import com.company.graph.matrix.MatrixGraph;

import java.util.Arrays;

//user for all-pair shortest path with negative and positive weights
public class FloydWarshall {
    private MatrixGraph graph;
    private double [][] distances;
    private boolean isSolved;

    public FloydWarshall(MatrixGraph graph) {
        this.graph = graph;
        this.isSolved = false;
        int size = graph.getSize();
        this.distances = new double[size][size];
        init();
    }

    private void init(){
        for (int i = 0;i<distances.length;i++){
            for (int j =0;j< distances.length;j++){
                distances[i][j] = graph.getDistance(i,j);
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
                        }else {
                            distances[j][k] = distances[j][i] + distances[i][k];
                        }
                    }
                }
            }
        }
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

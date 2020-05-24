package com.company.graph.matrix;

import java.util.Arrays;

public class MatrixGraph {
    private double[][] matrix;
    private int size;

    public MatrixGraph(int size) {
        this.size = size;
        init();
    }

    private void init(){
        this.matrix = new double[size][size];
        for (int i = 0;i<size;i++){
            Arrays.fill(matrix[i], Double.POSITIVE_INFINITY);
            matrix[i][i] = 0;
        }
    }

    public void addEdge(int from, int to, double cost){
        matrix[from][to] = cost;
    }

    public int getSize(){
        return matrix.length;
    }

    public double getDistance(int from, int to){
        return matrix[from][to];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i =0;i< size;i++){
            sb.append(Arrays.toString(matrix[i])).append(System.lineSeparator());
        }
        return sb.toString();
    }
}

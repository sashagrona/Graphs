package com.company.dynamicprog;

//used to solve np-complete Travelling Salesman Problem (shortest tour path between all nodes)
public class TSPSolver {
    private int size;
    private int start;
    private double[][] distances;
    private double[][] memotable;

    public TSPSolver(int start, double[][] distances) {
        this.start = start;
        this.distances = distances;
        this.size = distances.length;
        this.memotable = new double[size][1 << size];
        if (size > 32) throw new IllegalArgumentException("The complexity of algorithm is O(n^2 * 2^n). Input is too large");
        init();
    }

    private void init() {
        for (int i = 0; i< size;i++) {
            if (i != start) {
                memotable[i][1 << i | 1 << start] = distances[start][i];
            }
        }
    }
    
}

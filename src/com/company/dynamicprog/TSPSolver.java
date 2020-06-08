package com.company.dynamicprog;

import com.company.graph.matrix.MatrixGraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//used to solve np-complete Travelling Salesman Problem (shortest tour path between all nodes)
public class TSPSolver {
    private int size;
    private int start;
    private MatrixGraph graph;
    private double[][] memotable;
    private double minCost;
    private boolean isSolved;

    public TSPSolver(int start, MatrixGraph graph) {
        this.start = start;
        this.graph = graph;
        this.minCost = Double.POSITIVE_INFINITY;
        this.size = graph.getSize();
        this.isSolved = false;
        this.memotable = new double[size][1 << size];
        if (size > 32)
            throw new IllegalArgumentException("The complexity of algorithm is O(n^2 * 2^n). Input is too large");
        init();
    }

    private void init() {
        for (int i = 0; i < size; i++) {
            if (i != start) {
                memotable[i][1 << i | 1 << start] = (graph.getDistance(start, i) != Double.POSITIVE_INFINITY) ? graph.getDistance(start, i) : 0;
            }
        }
    }

    public void tsp() {
        for (int i = 3; i <= size; i++) {
            for (int set : getCombinations(i)) {
                if (notInSubset(start, set)) continue;
                for (int nextEl = 0; nextEl < size; nextEl++) {
                    if (nextEl == start || notInSubset(nextEl, set)) continue;
                    int setExclNext = set ^ (1 << nextEl);
                    double minDistance = Double.POSITIVE_INFINITY;
                    for (int end = 0; end < size; end++) {
                        if (end == start || end == nextEl || notInSubset(end, set)) continue;
                        double newDistance = memotable[end][setExclNext] + graph.getDistance(end, nextEl);
                        if (newDistance < minDistance) {
                            minDistance = newDistance;
                        }
                    }
                    memotable[nextEl][set] = minDistance;
                }
            }
        }
        isSolved = true;
    }

    public void setMinCost(){
        if (!isSolved){
            tsp();
        }
        int end = (1<<size) -1;
        for (int i = 0;i< size;i++){
            if (i == start) continue;
            double cost = memotable[i][end] + graph.getDistance(i, start);
            if (cost < minCost){
                minCost = cost;
            }
        }
    }

    public List<Integer> getTour(){
        if (!isSolved){
            tsp();
        }
        List<Integer> tour = new ArrayList<>();
        tour.add(start);
        int lastIndex = start;
        int state = (1<<size) -1;
        for (int i =1;i< size;i++){
            int index = -1;
            for (int j = 0;j< size;j++){
                if (j == start || notInSubset(j, state)) continue;
                if (index == -1){
                    index = j;
                }
                double prevDistance = memotable[index][state] + graph.getDistance(index, lastIndex);
                double currentDistance = memotable[j][state] + graph.getDistance(j, lastIndex);
                if (currentDistance < prevDistance){
                    index = j;
                }
            }
            tour.add(index);
            state ^= (1<<index);
            lastIndex = index;
        }
        tour.add(start);
        Collections.reverse(tour);
        return tour;
    }

    private boolean notInSubset(int el, int subset) {
        return ((1 << el) & subset) == 0;
    }

    //{1110, 1011, 1101, 0111} 1 -> the node is already visited, 0 -> not yet
    public List<Integer> getCombinations(int fillSize) {
        List<Integer> combinations = new ArrayList<>();
        setCombinations(0, 0, fillSize, combinations);
        return combinations;
    }

    private void setCombinations(int pointer, int set, int fillSize, List<Integer> combinations) {
        if (fillSize == 0) {
            combinations.add(set);
        } else {
            for (int i = pointer; i < size; i++) {
                //adding new bit
                set |= (1 << i);
                setCombinations(i + 1, set, fillSize - 1, combinations);
                //combination is set. exclude current bit and backtrack
                set ^= (1 << i);
            }
        }
    }


    @Override
    public String toString() {
        tsp();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(Arrays.toString(memotable[i])).append(System.lineSeparator());
        }
        return sb.toString();
    }
}

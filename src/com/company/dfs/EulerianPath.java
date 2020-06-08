package com.company.dfs;

import com.company.graph.edge.Edge;
import com.company.graph.edge.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class EulerianPath {
    private Graph<Integer> graph;
    private int[] in;
    private int[] out;
    private LinkedList<Integer> path;
    private int size;
    private int edgeCount;

    public EulerianPath(Graph<Integer> graph) {
        this.graph = graph;
        this.size = graph.getSize();
        this.in = new int[size];
        this.out = new int[size];
        this.path = new LinkedList<>();
        init();
    }

    private void init() {
        edgeCount = 0;
        for (Integer node : graph.getNodes()) {
            for (Edge edge : graph.getEdges(node)) {
                out[node]++;
                in[(int) edge.getTo()]++;
                edgeCount++;
            }
        }
    }

    private int findStart(){
        int start = 0;
        for (int i = 0; i< size;i++){
            if (out[i] - in[i] == 1){
                return i;
            }
            if (out[i] != 0){
                start = i;
            }
        }
        return start;
    }

    public List<Integer> getPath(){
        if (hasEulerianPath()){
            dfs(findStart());
            return path;
        }
        return null;
    }

    public void dfs(int current){
        while (out[current] > 0){
            out[current]--;
            dfs(graph.getEdges(current).get(out[current]).getTo());
        }
        path.addFirst(current);

    }
    public boolean hasEulerianPath() {
        // directed graph has eulerian path
        // if there are exactly two nodes
        // (first is when number of in degree 1 more
        // than out degree and the second with opposite)
        int inNode = 0;
        int outNode = 0;
        for (int i = 0; i < size; i++) {
            if (Math.abs(in[i] - out[i]) > 1) {
                return false;
            } else if (in[i] - out[i] == 1) {
                inNode++;
            } else if (out[i] - in[i] == 1) {
                outNode++;
            }
        }
        return (inNode == outNode) && (inNode == 1 || inNode == 0);
    }
}

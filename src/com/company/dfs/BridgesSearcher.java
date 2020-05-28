package com.company.dfs;

import com.company.graph.edge.Edge;
import com.company.graph.edge.UndirectedGraph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BridgesSearcher {
    private UndirectedGraph graph;
    private Set<Integer> visited;
    private List<Integer> bridges;
    private int [] ids;
    private int [] low;
    private int id;
    private int size;
    private boolean isFound;

    public BridgesSearcher(UndirectedGraph graph) {
        this.graph = graph;
        this.visited = new HashSet<>();
        this.size = graph.getSize();
        this.bridges = new ArrayList<>();
        this.ids = new int[size];
        this.low = new int[size];
        this.id = 0;
        this.isFound = false;
    }

    public List<Integer> findBridges(){
        for (int i = 0; i< size;i++){
            if (!visited.contains(i)){
                dfs(i,-1);
            }
        }
        isFound = true;
        return bridges;
    }

    private void dfs(int current, int parent){
        visited.add(current);
        ids[current] = id;
        low[current] = id;
        id++;
        List<Edge> edges = graph.getEdges(current);
        for (Edge edge : edges){
            int to = (int) edge.getTo();
            if (to == parent) continue;
            if (!visited.contains(to)){
                dfs(to, current);
                low[current] = Math.min(low[current], low[to]);
                if (ids[current] < low[to]){
                    bridges.add(current);
                    bridges.add(to);
                }
            }else {
                low[current] = Math.min(low[current], ids[to]);
            }
        }
    }

    @Override
    public String toString() {
        if (!isFound){
            findBridges();
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i< bridges.size()/2;i++){
            sb.append("Bridge: ").append(bridges.get(2*i)).append(" -> ").append(bridges.get(2*i+1)).append(System.lineSeparator());
        }
        return sb.toString();
    }
}

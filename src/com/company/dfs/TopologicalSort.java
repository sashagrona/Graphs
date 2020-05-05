package com.company.dfs;

import com.company.graph.edge.Edge;
import com.company.graph.edge.Graph;

import java.lang.reflect.Array;
import java.util.*;

public class TopologicalSort<T> {
    private Graph<T> graph;
    private Set<T> visited;
    private List<T> nodes;
    private Stack<T> stack;
    private int offset;

    public TopologicalSort(Graph<T> graph) {
        this.graph = graph;
        this.visited = new HashSet<>();
        this.nodes = graph.getNodes();
        this.stack = new Stack<>();
        this.offset = nodes.size()-1;
    }

    public void dfs(T node, T [] ordered){
        visited.add(node);
        stack.push(node);
        List<Edge<T>> edges = graph.getEdges(node);
        if (edges !=null && !edges.isEmpty()){
            for (Edge edge: edges){
                if (!visited.contains(edge.getTo())) {
                    dfs((T) edge.getTo(), ordered);
                }
            }
        }
        ordered[offset] = stack.pop();
        offset--;
    }

    public T [] topSort(){
        T [] ordered = (T[]) new Object [nodes.size()];
        for (T node: nodes){
            if (!visited.contains(node)){
                dfs(node, ordered);
            }
        }
        return ordered;
    }
}

package com.company.dfs;

import com.company.graph.edge.Edge;
import com.company.graph.edge.Graph;

import java.util.*;

public class TarjanSolver {
    private Graph<Integer> graph;
    private int[] ids;
    private int[] low;
    private Stack<Integer> stack;
    private Set<Integer> visited;
    private int id;
    private int size;
    private boolean isSolved;

    public TarjanSolver(Graph<Integer> graph) {
        this.graph = graph;
        this.size = graph.getSize();
        this.ids = new int[size];
        this.low = new int[size];
        this.stack = new Stack<>();
        this.visited = new HashSet<>();
        this.id = 0;
        this.isSolved = false;
    }

    public int[] findStronglyConnComps() {
        if (isSolved) {
            return low;
        }
        for (int i = 0; i < size; i++) {
            if (!visited.contains(i)) {
                stack.clear();
                dfs(i);
            }
        }
        isSolved = true;
        return low;
    }

    private void dfs(int current) {
        stack.push(current);
        visited.add(current);
        ids[current] = id;
        low[current] = id;
        id++;
        List<Edge<Integer>> edges = graph.getEdges(current);
        for (Edge edge : edges) {
            int to = (int) edge.getTo();
            if (!visited.contains(to)) {
                dfs(to);
            }
            if (stack.contains(to)) {
                low[current] = Math.min(low[current], low[to]);
            }
            if (ids[current] == low[current]) {
                while (stack.peek() != current) {
                    stack.pop();
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int numberOfConnComps = (int) Arrays.stream(low).distinct().count();
        sb.append("The number of strongly connected components in graph is: " + numberOfConnComps).append("\r\n");
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < low.length; i++) {
            if (map.get(low[i]) == null) {
                map.put(low[i], new ArrayList<>());
            }
            List<Integer> list = map.get(low[i]);
            list.add(i);
            map.put(low[i], list);
        }
        for (Integer i : map.keySet()) {
            sb.append("Strongly Connected Component contains: " + map.get(i)).append("\r\n");
        }
        return sb.toString();
    }
}

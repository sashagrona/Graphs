package com.company.dijkstra;

import com.company.graph.edge.Edge;
import com.company.graph.edge.Graph;

import java.util.*;

//used for single source shortest path with non negative weights
public class DijkstraShortestPath<T> {
    private NodeComparator<Node> comparator;
    private Graph<T> graph;
    private Set<T> visited;
    private Map<T, Integer> distances;
    private Integer[] prev;

    public DijkstraShortestPath(Graph<T> graph) {
        this.graph = graph;
        comparator = new NodeComparator<>();
        visited = new HashSet<>();
        distances = new HashMap<>();
        prev = new Integer[graph.getSize()];
    }

    public List<Integer> getIntPath(T from, T to) {
        List<Integer> path = new ArrayList<>();
        if (getShortestPath(from, to) != -1) {
            for (Integer i = (Integer) to; i !=null; i = prev[i]){
                path.add(i);
            }
            Collections.reverse(path);
        }
        return path;
    }

    public int getShortestPath(T from, T to) {
        dijkstra(from);
        return (distances.get(to) != null) ? distances.get(to) : -1;
    }

    public void dijkstra(T start) {
        PriorityQueue<Node> queue = new PriorityQueue<Node>(graph.getSize(), comparator);
        queue.add(new Node(start, 0));
        distances.put(start, 0);
        while (!queue.isEmpty()) {
            Node<T> node = queue.poll();
            visited.add(node.getValue());
            List<Edge<T>> edges = graph.getEdges(node.getValue());
            for (Edge<T> edge : edges) {
                T to = edge.getTo();
                if (visited.contains(to)) {
                    continue;
                }
                int newDist = distances.get(edge.getFrom()) + edge.getCost();
                if (distances.get(to) != null) {
                    if (newDist < distances.get(to)) {
                        queue.remove(new Node(to, distances.get(to)));
                        queue.add(new Node(to, newDist));
                        distances.put(to, newDist);
                    }
                } else {
                    distances.put(to, newDist);
                    queue.add(new Node(to, newDist));
                }
                if (to instanceof Integer) {
                    prev[(int) to] = (Integer) edge.getFrom();
                }
            }
        }
    }
}

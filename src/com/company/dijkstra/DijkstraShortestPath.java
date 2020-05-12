package com.company.dijkstra;

import com.company.graph.edge.Edge;
import com.company.graph.edge.Graph;

import java.util.*;

public class DijkstraShortestPath<T> {
    private NodeComparator<Node> comparator;
    private Graph<T> graph;
    private Set<T> visited;
    private Map<T, Integer> distances;

    public DijkstraShortestPath(Graph<T> graph) {
        this.graph = graph;
        comparator = new NodeComparator<>();
        visited = new HashSet<>();
        distances = new HashMap<>();
    }

    public int dijkstra(T start) {
        visited.add(start);
        distances.put(start, 0);
        PriorityQueue<Node> queue = new PriorityQueue<Node>(graph.getSize(), comparator);
        queue.add(new Node(start, 0));
        while (!queue.isEmpty()) {
            Node<T> node = queue.poll();
            List<Edge<T>> edges = graph.getEdges(node.getValue());
            for (Edge<T> edge : edges) {
                T to = edge.getTo();
                int newDist = distances.get(edge.getFrom()) + edge.getCost();
                if (distances.get(to) != null && (newDist < distances.get(to))) {
                    
                }


            }
        }
        return -1;
    }
}

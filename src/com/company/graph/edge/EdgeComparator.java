package com.company.graph.edge;

import java.util.Comparator;

public class EdgeComparator<T> implements Comparator<Edge<T>> {

    @Override
    public int compare(Edge<T> edgeOne, Edge<T> edgeTwo) {
        return edgeOne.getCost() - edgeTwo.getCost();
    }
}

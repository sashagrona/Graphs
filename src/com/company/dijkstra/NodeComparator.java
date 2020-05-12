package com.company.dijkstra;

import java.util.Comparator;

public class NodeComparator<T> implements Comparator<Node<T>> {
    @Override
    public int compare(Node<T> tNode, Node<T> t1) {
        return (tNode.getCost() - t1.getCost());
    }
}

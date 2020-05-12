package com.company.dijkstra;

import java.util.Comparator;

public class NodeComparator<T> implements Comparator<Node> {
    @Override
    public int compare(Node tNode, Node t1) {
        return (tNode.getCost() - t1.getCost());
    }
}

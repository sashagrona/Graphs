package com.company;

import com.company.graph.grid.GridGraph;
import com.company.graph.grid.Node;

public class Main {

    public static void main(String[] args) {
        GridGraph gridGraph = new GridGraph(5);
        gridGraph.initGraph();
        gridGraph.addNode(new Node(1,1,"S"));
        gridGraph.addNode(new Node(3,4,"E"));
        gridGraph.addNode(new Node(3,0,"#"));
        gridGraph.addNode(new Node(0,3,"#"));
        gridGraph.addNode(new Node(2,2,"#"));
        gridGraph.addNode(new Node(3,2,"#"));
        gridGraph.addNode(new Node(2,4,"#"));
        System.out.println(gridGraph.toString());
    }
}

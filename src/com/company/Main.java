package com.company;

import com.company.bfs.DungeonProblem;
import com.company.graph.grid.Cell;
import com.company.graph.grid.GridGraph;

public class Main {

    public static void main(String[] args) {
        GridGraph gridGraph = new GridGraph(5);
        gridGraph.initGraph(".");
        gridGraph.addNode(new Cell(1,1),"S");
        gridGraph.addNode(new Cell(4,0), "E");
        gridGraph.addNode(new Cell(3,0),"#");
        gridGraph.addNode(new Cell(0,3), "#");
        gridGraph.addNode(new Cell(2,2), "#");
        gridGraph.addNode(new Cell(3,2), "#");
        gridGraph.addNode(new Cell(2,4), "#");
        System.out.println(gridGraph.toString());
        System.out.println(gridGraph.getNeighbours(new Cell(2,4)));
        DungeonProblem dp = new DungeonProblem(gridGraph);
        System.out.println(dp.getShortestPath());
    }
}

package com.company.bfs;

import com.company.graph.grid.Cell;
import com.company.graph.grid.GridGraph;

import java.util.*;

public class DungeonProblem {
    private static final String BLOCK = "#";
    private static final String START = "S";
    private static final String END = "E";
    private GridGraph<String> graph;
    private Queue<Cell> queue;
    private Set<Cell> visited;
    private int moves;

    public DungeonProblem(GridGraph<String> graph) {
        this.graph = graph;
        this.queue = new ArrayDeque<>();
        this.visited = new HashSet<>();
        this.moves = 0;
    }

    public int getShortestPath() {
        Cell initialCell = graph.getSellByUniqueValue(START);
        queue.add(initialCell);
        visited.add(initialCell);
        return bfs();
    }

    private int bfs() {
        int layer = 1;
        int temp = 0;
        while (!queue.isEmpty()) {
            moves++;
            while (layer > 0) {
                Cell cell = queue.poll();
                List<Cell> neighbours = graph.getNeighbours(cell);
                for (Cell c : neighbours) {
                    if (!visited.contains(c)) {
                        if (graph.getValueFromCell(c).equals(END)) {
                            return moves;
                        }
                        if (!graph.getValueFromCell(c).equals(BLOCK)) {
                            queue.add(c);
                            visited.add(c);
                        }
                    }
                }
                layer--;
                if (layer == 0) {
                    temp = queue.size();
                }
            }
            layer = temp;
        }
        return -1;
    }
}

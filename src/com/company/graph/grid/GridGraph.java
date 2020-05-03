package com.company.graph.grid;

import java.util.*;

public class GridGraph<T> {
    private Map<Cell, List<Cell>> graph;
    private int [] rowsDirections;
    private int [] columnDirections;
    private int size;

    public GridGraph(int size) {
        this.graph = new HashMap<>();
        this.size = size;
        // north, south, west, east
        this.columnDirections = new int[]{-1, 1, 0, 0};
        this.rowsDirections = new int[]{0,0,-1,1};
    }
    public void initGraph(T initValue){
        for (int i = 0; i< size;i++){
            for (int j = 0;j<size; j++){
                addNode(new ExtendedCell<T>(i,j,initValue));
            }
        }
    }

    public void addNode(Cell cell){
        graph.put(cell, cell.getNeighbours());
    }

    public Cell<T> getNode(String key){

    }

    public List<Cell> getNeighbours(Cell node) {
        List<Cell> nodes = graph.get(node);

        for (int i = 0; i<4;i++){

        }
        graph.put(node, nodes);
        return graph.get(node);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        T [][] arr = (T[][]) new Object[size][size];
        sb.append("Graph: \r\n");
        for (Cell node: graph.keySet()){
            int x = node.getX();
            int y = node.getY();
            arr[x][y] = (T)node.getValue();
        }
        for (int i = 0;i<size;i++){
           sb.append(Arrays.toString(arr[i]));
           sb.append("\r\n");
        }
        System.out.println(graph.size() + "   " + graph.keySet());
        return sb.toString();
    }
}

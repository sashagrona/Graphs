package com.company.graph.grid;

import java.util.*;

public class GridGraph<T> {
    private Map<Cell, List<Cell>> graph;
    private Map<Cell, T> cellsValueMap;
    private int[] rowsDirections;
    private int[] columnDirections;
    private int size;

    public GridGraph(int size) {
        this.graph = new HashMap<>();
        this.cellsValueMap = new HashMap<>();
        this.size = size;
        // north, south, west, east
        this.columnDirections = new int[]{-1, 1, 0, 0};
        this.rowsDirections = new int[]{0, 0, -1, 1};
    }

    public void initGraph(T initValue) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                addNode(new Cell(i, j), initValue);
            }
        }
    }

    public void addNode(Cell cell, T initValue) {
        graph.put(cell, getNeighbours(cell));
        cellsValueMap.put(cell, initValue);
    }

    public List<Cell> getNeighbours(Cell cell) {
        List<Cell> cells = graph.get(cell);
        if (cells == null) {
            cells = new ArrayList<>();
            for (int i = 0; i<4;i++){
                int x = cell.getX() + rowsDirections[i];
                int y = cell.getY() + columnDirections[i];
                if ((x>=0&&x<size)&&(y>=0&&y<size)){
                    cells.add(new Cell(x,y));
                }
            }
        }
        return cells;
    }

    public Cell getSellByUniqueValue(T t){
        for (Map.Entry<Cell, T> entry: cellsValueMap.entrySet()) {
            if (entry.getValue().equals(t)){
                return entry.getKey();
            }
        }
        return null;
    }
    public T getValueFromCell(Cell cell){
        return cellsValueMap.get(cell);
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        T[][] arr = (T[][]) new Object[size][size];
        sb.append("Graph: \r\n");
        for (Cell cell : cellsValueMap.keySet()) {
            int x = cell.getX();
            int y = cell.getY();
            arr[y][x] = cellsValueMap.get(cell);
        }
        for (int i = 0; i < size; i++) {
            sb.append(Arrays.toString(arr[i]));
            sb.append("\r\n");
        }
        return sb.toString();
    }
}

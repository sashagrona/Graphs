package com.company.graph.grid;

import java.util.ArrayList;
import java.util.List;

public class ExtendedCell<T> extends Cell {
    private T value;
    private List<Cell> cells;

    public ExtendedCell(int x, int y, T value) {
        super(x, y);
        this.value = value;
        this.cells = new ArrayList<>();
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public List<Cell> getCells() {
        return cells;
    }

    public void addNeighbour(Cell cell) {
        cells.add(cell);
    }

    @Override
    public List<Cell> getNeighbours(Cell cell) {
        return super.getNeighbours(cell);
    }
}

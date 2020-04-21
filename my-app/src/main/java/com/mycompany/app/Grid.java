package com.mycompany.app;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;

public class Grid {
    Graph graph;
    int size;

    public Grid(int size) {
        this.size = size * size;
        graph = new Graph(this.size);
        // [6, 7, 8]
        // [3, 4, 5]
        // [0, 1, 2]

        // var sizeRoot = (int) Math.sqrt(size);
        // for (int i = 0; i < size; i = i + sizeRoot) {
        // for (int j = 0; j < sizeRoot; j++) {
        // var cellNumber = i + j;
        // var cellAbove = cellNumber + sizeRoot;
        // var cellRight = cellNumber + 1;

        // if (cellAbove < size)
        // graph.addEdge(new Edge(cellNumber, cellAbove, 0));

        // if (cellRight % sizeRoot != 0)
        // graph.addEdge(new Edge(cellNumber, cellRight, 0));
        // }
        // }

        // for (int i = 0; i < size; i++) { // Row
        // // 0, 0
        // // row, 0,1
        // // col, 0,4

        // // Don't add Edge, if we are at the far right side of grid
        // var sizeRoot = (int) Math.sqrt(size);
        // if (i % sizeRoot != sizeRoot - 1)
        // graph.addEdge(new Edge(i, i + 1, 0));

        // // 0, 4
        // // 4, 9
        // // 9, 14
        // int cellAbove = (int) (i - 1 + sizeRoot);
        // if (cellAbove < size)
        // graph.addEdge(new Edge(i, (int) cellAbove, 0));
        // }
    }

    public String toString() {

        // Need to take it by row and col at a time
        // [6, 7, 8]
        // [3, 4, 5]
        // [0, 1, 2]
        var sizeRoot = (int) Math.sqrt(size);

        var output = "+" + "---+".repeat(sizeRoot) + "\n";
        // Row
        for (int i = 0; i < size; i = i + sizeRoot) {
            var bottom = "|";
            var top = "+";
            // Col
            for (int j = 0; j < sizeRoot; j++) {
                var cellNumber = i + j;
                var cellAbove = cellNumber + sizeRoot;
                var cellRight = cellNumber + 1;
                var body = "   ";
                var corner = "+";

                var eastBoundary = graph.isEdge(cellNumber, cellRight) ? " " : "|";
                var northBoundary = graph.isEdge(cellNumber, cellAbove) ? "   " : "---";

                bottom += body + eastBoundary;
                top += northBoundary + corner;
            }
            output = bottom + "\n" + output;
            output = top + "\n" + output;
        }
        return output;
    }

    public void binary_tree_maze() {
        for (int i = 0; i < this.size; i++) {
            var neighbors = new ArrayList<>();
            var maybeCellAbove = getCellAbove(i);
            var maybeCellRight = getCellToRight(i);
            if (!maybeCellRight.isEmpty())
                neighbors.add(maybeCellRight.get());
            if (!maybeCellAbove.isEmpty())
                neighbors.add(maybeCellAbove.get());

            // No Neighbors move on
            if (neighbors.size() <= 0)
                continue;

            var index = new Random().nextInt(neighbors.size());
            graph.addEdge(new Edge(i, (int) neighbors.get(index), 0));
        }
    }

    private Optional<Integer> getCellAbove(int cellNumber) {
        var sizeRoot = (int) Math.sqrt(size);
        var cellAbove = cellNumber + sizeRoot;

        return cellAbove < size ? Optional.of(cellAbove) : Optional.empty();
    }

    private Optional<Integer> getCellToRight(int cellNumber) {
        var sizeRoot = (int) Math.sqrt(size);
        var cellRight = cellNumber + 1;
        return cellRight % sizeRoot != 0 ? Optional.of(cellRight) : Optional.empty();
    }
}
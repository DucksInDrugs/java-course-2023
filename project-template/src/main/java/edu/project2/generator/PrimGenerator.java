package edu.project2.generator;

import edu.project2.maze.Cell;
import edu.project2.maze.Coordinate;
import edu.project2.maze.Maze;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class PrimGenerator implements Generator {
    @Override
    public Maze generate(int height, int width) {
        if (height <= 0 || width <= 0) {
            return null;
        }
        Random random = new Random();
        Cell[][] grid = new Cell[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                grid[i][j] = new Cell(new Coordinate(i, j), Cell.Type.WALL);
            }
        }
        Cell start = new Cell(new Coordinate(random.nextInt(height), random.nextInt(width)), Cell.Type.PASSAGE);
        Map<Cell, Cell> path = new HashMap<>(Map.of(start, start));
        while (!path.isEmpty()) {
            Cell current = path.keySet().stream().toList().get(random.nextInt(path.size()));
            Cell from = path.get(current);

            for (Cell between : List.of(current, getBetweenCoordinate(current, from))) {
                grid[between.coordinate().row()][between.coordinate().col()] = between;
            }
            path.remove(current);

            getFrontierCells(current.coordinate(), grid)
                .forEach(next -> path.put(next, current));
        }
        return new Maze(height, width, grid);
    }

    private Cell getBetweenCoordinate(Cell from, Cell to) {
        return new Cell(new Coordinate(
            from.coordinate().row() + (to.coordinate().row() - from.coordinate().row()) / 2,
            from.coordinate().col() + (to.coordinate().col() - from.coordinate().col()) / 2),
            Cell.Type.PASSAGE
        );
    }

    @SuppressWarnings("MagicNumber")
    private List<Cell> getFrontierCells(Coordinate source, Cell[][] grid) {
        int[][] biases = new int[][] {{-2, 0}, {0, 2}, {2, 0}, {-2, -2}, {-2, 2}, {0, -2}, {2, -2}, {2, 2}};
        List<Cell> frontiers = new ArrayList<>();

        for (var bias : biases) {
            Coordinate frontier = new Coordinate(source.row() + bias[0], source.col() + bias[1]);
            if (frontier.row() >= 0 && frontier.col() >= 0
                && frontier.row() < grid.length
                && frontier.col() < grid[0].length
                && grid[frontier.row()][frontier.col()].type() == Cell.Type.WALL) {
                frontiers.add(new Cell(frontier, Cell.Type.WALL));
            }
        }

        return frontiers;
    }
}

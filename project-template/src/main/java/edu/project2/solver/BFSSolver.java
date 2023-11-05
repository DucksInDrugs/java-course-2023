package edu.project2.solver;

import edu.project2.maze.Cell;
import edu.project2.maze.Coordinate;
import edu.project2.maze.Maze;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BFSSolver implements Solver {
    private static final int[][] DIRECTIONS = {
        {0, 1},
        {1, 0},
        {0, -1},
        {-1, 0}};

    @Override
    public List<Coordinate> solve(Maze maze, Coordinate start, Coordinate end) {
        if (maze == null || start == null
            || end == null || start.row() > maze.getHeight()
            || start.col() > maze.getWidth()
            || end.col() > maze.getWidth() || end.row() > maze.getHeight()) {
            return null;
        }
        Map<Cell, Cell> path = new HashMap<>();
        Queue<Cell> nextToVisit = new LinkedList<>();
        Cell startCell = new Cell(start, Cell.Type.PASSAGE);
        Cell endCell = new Cell(end, Cell.Type.PASSAGE);

        nextToVisit.add(startCell);
        while (!nextToVisit.isEmpty()) {
            Cell current = nextToVisit.poll();
            if (current.equals(endCell)) {
                break;
            }
            List<Cell> neighbours = addNeighbours(current, maze);
            for (var neighbour : neighbours) {
                if (!path.containsKey(neighbour)) {
                    nextToVisit.add(neighbour);
                    path.put(neighbour, current);
                }
            }
        }
        List<Coordinate> solveList = new ArrayList<>();
        while (!endCell.equals(startCell)) {
            solveList.add(endCell.coordinate());
            endCell = path.get(endCell);
        }
        solveList.add(startCell.coordinate());
        Collections.reverse(solveList);
        return solveList;
    }

    private List<Cell> addNeighbours(Cell current, Maze maze) {
        List<Cell> neighbours = new ArrayList<>();
        for (var neighbour : DIRECTIONS) {
            Coordinate neighbourCoordinate = new Coordinate(
                current.coordinate().row() + neighbour[1], current.coordinate().col() + neighbour[0]);
            if (!(neighbourCoordinate.row() < 0)
                && !(neighbourCoordinate.col() < 0)
                && neighbourCoordinate.col() < maze.getWidth()
                && neighbourCoordinate.row() < maze.getHeight()
                && maze.getGrid()[neighbourCoordinate.row()][neighbourCoordinate.col()].type() != Cell.Type.WALL) {
                neighbours.add(new Cell(neighbourCoordinate, Cell.Type.PASSAGE));
            }
        }
        return neighbours;
    }
}

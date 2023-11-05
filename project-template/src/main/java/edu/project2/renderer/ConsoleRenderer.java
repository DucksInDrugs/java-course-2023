package edu.project2.renderer;

import edu.project2.maze.Cell;
import edu.project2.maze.Coordinate;
import edu.project2.maze.Maze;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ConsoleRenderer implements Renderer {

    @Override
    public String render(Maze maze) {
        if (maze.getWidth() != maze.getGrid().length || maze.getHeight() != maze.getGrid()[0].length) {
            return null;
        }
        StringBuilder result = new StringBuilder();

        IntStream.range(0, maze.getHeight()).forEach(i -> result
            .append(Arrays.stream(maze.getGrid()[i])
                .map(cell -> cell.type().getMazeSymbol())
                .collect(Collectors.joining()))
            .append("\n"));

        return result.toString();
    }

    @Override
    public String render(Maze maze, List<Coordinate> path) {
        for (Coordinate coordinate : path) {
            if (coordinate.row() > maze.getHeight()
                || coordinate.row() < 0
                || coordinate.col() > maze.getWidth()
                || coordinate.col() < 0
                || maze.getGrid()[coordinate.row()][coordinate.col()].type() == Cell.Type.WALL) {
                return null;
            }
        }
        StringBuilder result = new StringBuilder(render(maze));

        path.forEach(coordinate -> {
            int symbolIndex = coordinate.row() * (maze.getWidth() + 1) + coordinate.col();

            result.replace(symbolIndex, symbolIndex + 1, "*");
        });

        return result.toString();
    }
}

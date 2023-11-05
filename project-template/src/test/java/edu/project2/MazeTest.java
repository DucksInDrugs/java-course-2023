package edu.project2;

import edu.project2.generator.PrimGenerator;
import edu.project2.maze.Cell;
import edu.project2.maze.Coordinate;
import edu.project2.maze.Maze;
import edu.project2.renderer.ConsoleRenderer;
import edu.project2.solver.BFSSolver;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class MazeTest {
    Maze maze = new Maze( 3, 3, new Cell[][] {
      new Cell[] {new Cell(new Coordinate(0, 0), Cell.Type.PASSAGE),
          new Cell(new Coordinate(0, 1), Cell.Type.WALL),
          new Cell(new Coordinate(0, 2), Cell.Type.PASSAGE)},
        new Cell[] {new Cell(new Coordinate(1, 0), Cell.Type.PASSAGE),
            new Cell(new Coordinate(1, 1), Cell.Type.WALL),
            new Cell(new Coordinate(1, 2), Cell.Type.PASSAGE)},
        new Cell[] {new Cell(new Coordinate(2, 0), Cell.Type.PASSAGE),
            new Cell(new Coordinate(2, 1), Cell.Type.PASSAGE),
            new Cell(new Coordinate(2, 2), Cell.Type.PASSAGE)}
    });
    ConsoleRenderer consoleRenderer = new ConsoleRenderer();
    BFSSolver solver = new BFSSolver();
    PrimGenerator generator = new PrimGenerator();

    @Test
    public void consoleRendererWithCorrectValuesTest() {
        String expected = "*X*\n" +
            "*X*\n" +
            "***\n";
        assertEquals(expected, consoleRenderer.render(maze));
    }

    @Test
    public void consoleRendererWithIncorrectValuesTest() {
        Maze incorrectMaze = new Maze( 5, 3, new Cell[][] {
            new Cell[] {new Cell(new Coordinate(0, 0), Cell.Type.PASSAGE),
                new Cell(new Coordinate(0, 1), Cell.Type.WALL),
                new Cell(new Coordinate(0, 2), Cell.Type.PASSAGE)},
            new Cell[] {new Cell(new Coordinate(1, 0), Cell.Type.PASSAGE),
                new Cell(new Coordinate(1, 1), Cell.Type.WALL),
                new Cell(new Coordinate(1, 2), Cell.Type.PASSAGE)},
            new Cell[] {new Cell(new Coordinate(2, 0), Cell.Type.PASSAGE),
                new Cell(new Coordinate(2, 1), Cell.Type.PASSAGE),
                new Cell(new Coordinate(2, 2), Cell.Type.PASSAGE)}
        });
        assertNull(consoleRenderer.render(incorrectMaze));
    }

    @Test
    public void consoleRendererWithPathTest() {
        String expected = "*X*\n" +
            "*X*\n" +
            "***\n";
        List<Coordinate> path = List.of(new Coordinate(0, 0), new Coordinate(1, 0),
            new Coordinate(2, 0), new Coordinate(2, 1), new Coordinate(2, 2),
            new Coordinate(1, 2), new Coordinate(0, 2));
        assertEquals(expected, consoleRenderer.render(maze, path));
    }

    @Test
    public void consoleRendererWithIncorrectPathTest() {
        List<Coordinate> path = List.of(new Coordinate(10, 0));
        assertNull(consoleRenderer.render(maze, path));
    }

    @Test
    public void BFSSolverWithCorrectValuesTest() {
        List<Coordinate> expected = List.of(new Coordinate(0,0), new Coordinate(1,0),
            new Coordinate(2,0), new Coordinate(2,1), new Coordinate(2,2),
            new Coordinate(1,2) ,new Coordinate(0,2));
        assertEquals(expected, solver.solve(maze, new Coordinate(0, 0), new Coordinate(0, 2)));
    }

    @Test
    public void BFSSolverWithIncorrectValuesTest() {
        assertNull(solver.solve(null, new Coordinate(0, 0), new Coordinate(0, 2)));
        assertNull(solver.solve(maze, null, new Coordinate(0, 2)));
        assertNull(solver.solve(maze, new Coordinate(0, 0), null));
        assertNull(solver.solve(maze, new Coordinate(4, 0), new Coordinate(0, 2)));
        assertNull(solver.solve(maze, new Coordinate(0, 4), new Coordinate(0, 2)));
        assertNull(solver.solve(maze, new Coordinate(0, 0), new Coordinate(4, 2)));
        assertNull(solver.solve(maze, new Coordinate(0, 0), new Coordinate(0, 4)));
    }

    @Test
    public void primGeneratorWithIncorrectValueReturnsNullTest() {
        assertNull(generator.generate(-1, 0));
        assertNull(generator.generate(0, -1));
    }
}

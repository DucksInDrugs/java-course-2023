package edu.project2.maze;

public record Cell(Coordinate coordinate, Type type) {
    public enum Type {
        WALL("X"),
        PASSAGE("*");
        private final String mazeSymbol;

        Type(String mazeSymbol) {
            this.mazeSymbol = mazeSymbol;
        }

        public String getMazeSymbol() {
            return mazeSymbol;
        }
    }
}

package edu.hw2.task2;

public class Square extends Rectangle {

    public Square(int edge) {
        super(edge, edge);
    }

    @Override
    public Rectangle setWidth(int edge) {
        return new Square(edge);
    }

    @Override
    public Rectangle setHeight(int edge) {
        return new Square(edge);
    }
}

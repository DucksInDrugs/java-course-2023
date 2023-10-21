package edu.hw2.task1;


public sealed interface Expr {
    double evaluate();

    public record Constant(double value) implements Expr {
        @Override
        public double evaluate() {
            return value;
        }
    }

    public record Negate(Expr value) implements Expr {
        @Override
        public double evaluate() {
            return -value.evaluate();
        }
    }

    public record Exponent(Expr base, double power) implements Expr {
        @Override
        public double evaluate() {
            return Math.pow(base.evaluate(), power);
        }
    }

    public record Addition(Expr firstValue, Expr secondValue) implements Expr {
        @Override
        public double evaluate() {
            return firstValue().evaluate() + secondValue().evaluate();
        }
    }

    public record Multiplication(Expr firstMultiplier, Expr secondMultiplier) implements Expr {
        @Override
        public double evaluate() {
            return firstMultiplier().evaluate() * secondMultiplier().evaluate();
        }
    }
}


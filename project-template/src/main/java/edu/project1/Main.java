package edu.project1;

import java.io.IOException;

public final class Main {
    private Main() {
    }

    public static void main(String[] args) throws IOException {
        ConsoleHangman game = new ConsoleHangman();

        game.run();
    }
}

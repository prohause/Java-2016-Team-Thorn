package game;

import display.Display;

public class Game {
    private Display display;

    public Game(String title) {
        this.display = new Display(title);
    }
}

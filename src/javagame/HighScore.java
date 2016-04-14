package javagame;

import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class HighScore extends BasicGameState {
    private Image background;
    private boolean quit = false;

    public HighScore(int state) {
    }

    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        background = new Image("res/background_highscore.jpg");
    }

    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        background.draw(0, 0);
        if (quit) {
            graphics.drawString("Resume(R)", 350, 200);
            graphics.drawString("Main Menu(M)", 350, 250);
            graphics.drawString("Quit Game (Q)", 350, 300);
            if (!quit) {
                graphics.clear();
            }
        }
    }

    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException {
        Input input = gameContainer.getInput();
        if (input.isKeyDown(Input.KEY_ESCAPE)) {
            quit = true;
        }

        if (quit) {
            if (input.isKeyDown(Input.KEY_R)) {
                quit = false;
            }

            if (input.isKeyDown(Input.KEY_M)) {
                stateBasedGame.enterState(0);
            }

            if (input.isKeyDown(Input.KEY_Q)) {
                System.exit(0);
            }
        }
    }

    public int getID() {
        return 2;
    }
}
package javagame;

import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class HighScore extends BasicGameState {


    Image background;
    boolean quit = false;


    public HighScore(int state) {


    }

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        background = new Image("res/background_highscore.jpg");

    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException
    {
        background.draw(0, 0);
        if (quit==true)
        {
            g.drawString("Resume(R)",350,200);
            g.drawString("Main Menu(M)",350,250);
            g.drawString("Quit Game (Q)",350,300);
            if (quit==false)
            {
                g.clear();
            }
        }

    }



    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
        Input input = gc.getInput();

        if (input.isKeyDown(Input.KEY_ESCAPE)) {
            quit = true;
        }
        if (quit == true) {
            if (input.isKeyDown(Input.KEY_R)) {
                quit = false;
            }
            if (input.isKeyDown(Input.KEY_M)) {
                sbg.enterState(0);
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
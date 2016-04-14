package javagame;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class MainGame extends StateBasedGame {
    private static final String GAME_NAME = "PackNakov!";
    private static final int LAUNCHER = 0;
    private static final int PLAY = 1;
    private static final int HIGHSCORE = 2;

    private MainGame(String GAME_NAME) {
        super(GAME_NAME);
        this.addState(new Menu(LAUNCHER));
        this.addState(new Play(PLAY));
        this.addState(new HighScore(HIGHSCORE));
    }

    public void initStatesList(GameContainer gc) throws SlickException {
        this.getState(LAUNCHER).init(gc, this);
        this.getState(PLAY).init(gc, this);
        this.getState(HIGHSCORE).init(gc, this);
        this.enterState(LAUNCHER); // initialstate - LAUNCHER
    }

    public static void main(String[] args) {
        AppGameContainer appGameContainer;
        try {
            appGameContainer = new AppGameContainer(new MainGame(GAME_NAME));
            appGameContainer.setDisplayMode(800, 600, false); //setting the default resolution , false means no fullscreen
            appGameContainer.start();
        } catch (SlickException ex) {
            ex.printStackTrace();
        }
    }
}

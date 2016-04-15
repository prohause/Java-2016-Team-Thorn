package javagame.states;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Menu extends BasicGameState {
    private String mouse = "";
    private Image launcherMenu;
    private Image playButton;
    private Image exitButton;
    private Image optionsButton;
    private Image highscoreButton;
    private Music openingmusic;

    public Menu(int state) {
    }

    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        launcherMenu = new Image("res/launchermenu.jpg");
        playButton = new Image("res/newgame.jpg");
        exitButton = new Image("res/exit.jpg");
        optionsButton = new Image("res/options.jpg");
        highscoreButton = new Image("res/highscores.jpg");
        openingmusic = new Music("res/pacnakov_openingmusic.ogg");
        openingmusic.loop();
    }

    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        int xPosition = Mouse.getX();
        int yPosition = Mouse.getY();
        launcherMenu.draw(0, 0);
        graphics.drawString(mouse, 100, 50);

        // if mouse hovering over the area a button is drawn
        if ((xPosition > 445 && xPosition < 668) && (yPosition > 303 && yPosition < 355)) {
            playButton.draw(440, 242);
        }

        if ((xPosition > 445 && xPosition < 668) && (yPosition > 220 && yPosition < 275)) {
            highscoreButton.draw(440, 322);
        }

        if ((xPosition > 445 && xPosition < 668) && (yPosition > 140 && yPosition < 195)) {
            optionsButton.draw(440, 405);
        }

        if ((xPosition > 445 && xPosition < 668) && (yPosition > 60 && yPosition < 115)) {
            exitButton.draw(440, 485);
        }
    }

    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException {
        int xPosition = Mouse.getX();
        int yPosition = Mouse.getY();
        mouse = "xPosition" + xPosition + "yPosition" + yPosition;
        if ((xPosition > 445 && xPosition < 668) && (yPosition > 303 && yPosition < 355)) {
            if (Mouse.isButtonDown(0)) {
                openingmusic.stop();
                stateBasedGame.enterState(1); //if button is clicked inside the area : Start a new game
            }
        }

        if ((xPosition > 445 && xPosition < 668) && (yPosition > 220 && yPosition < 275)) {
            if (Mouse.isButtonDown(0)) {
                openingmusic.stop();
                stateBasedGame.enterState(2); //if button is clicked inside the area : Open High Score
            }
        }

        if ((xPosition > 445 && xPosition < 668) && (yPosition > 60 && yPosition < 115)) {
            if (Mouse.isButtonDown(0)) {
                openingmusic.stop();
                System.exit(0); // if button is clicked exit the Launcher
            }
        }
    }

    public int getID() {
        return 0;
    }
}

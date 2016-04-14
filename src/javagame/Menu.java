package javagame;

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
        int xpos = Mouse.getX();
        int ypos = Mouse.getY();
        launcherMenu.draw(0, 0);
        graphics.drawString(mouse, 100, 50);

        // if mouse hovering over the area a button is drawed
        if ((xpos > 445 && xpos < 668) && (ypos > 303 && ypos < 355)) {
            playButton.draw(440, 242);
        }

        if ((xpos > 445 && xpos < 668) && (ypos > 220 && ypos < 275)) {
            highscoreButton.draw(440, 322);
        }

        if ((xpos > 445 && xpos < 668) && (ypos > 140 && ypos < 195)) {
            optionsButton.draw(440, 405);
        }

        if ((xpos > 445 && xpos < 668) && (ypos > 60 && ypos < 115)) {
            exitButton.draw(440, 485);
        }
    }


    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException {
        int xpos = Mouse.getX();
        int ypos = Mouse.getY();
        mouse = "xpos" + xpos + "ypos" + ypos;
        if ((xpos > 445 && xpos < 668) && (ypos > 303 && ypos < 355)) {
            if (Mouse.isButtonDown(0)) {
                openingmusic.stop();
                stateBasedGame.enterState(1); //if button is clicked inside the area : Start a new game
            }
        }

        if ((xpos > 445 && xpos < 668) && (ypos > 220 && ypos < 275)) {
            if (Mouse.isButtonDown(0)) {
                openingmusic.stop();
                stateBasedGame.enterState(2); //if button is clicked inside the area : Start a new game
            }
        }

        if ((xpos > 445 && xpos < 668) && (ypos > 60 && ypos < 115)) {
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

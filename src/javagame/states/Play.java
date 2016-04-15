package javagame.states;

import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.util.Random;

public class Play extends BasicGameState {
    private Animation nakov, nakovRight, nakovLeft, nakovUp, nakovDown;
    private Animation ghost, ghostRight, ghostLeft, ghostUp, ghostDown;
    private int[] duration = {130, 130, 130};
    private Image background;
    private boolean quit = false;
    private float nakovPositionX = 0;
    private float nakovPositionY = 0;
    private float ghostPositionX = 0;
    private float ghostPositionY = 0;
    private float ghostshiftX = ghostPositionX + 400;
    private float ghostshiftY = ghostPositionY + 300;
    private Random randomGen = new Random();
    private int theRandomNumber = randomGen.nextInt(4);

    public Play(int state) {
    }

    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        Music openingMusic;
        background = new Image("res/background.jpg");
        gameContainer.setShowFPS(true);
        openingMusic = new Music("res/pacnakov_openingmusic.ogg");
        openingMusic.loop();

        Image[] movingRight = {new Image("res/right1.png"), new Image("res/right2.png"), new Image("res/right3.png")};
        Image[] movingLeft = {new Image("res/left1.png"), new Image("res/left2.png"), new Image("res/left3.png")};
        Image[] movingUp = {new Image("res/up1.png"), new Image("res/up2.png"), new Image("res/up3.png")};
        Image[] movingDown = {new Image("res/down1.png"), new Image("res/down2.png"), new Image("res/down3.png")};

        nakovRight = new Animation(movingRight, duration, true);
        nakovLeft = new Animation(movingLeft, duration, true);
        nakovUp = new Animation(movingUp, duration, true);
        nakovDown = new Animation(movingDown, duration, true);
        nakov = nakovRight;

        Image[] ghostMovingRight = {new Image("res/inky.png"), new Image("res/blinky.png"), new Image("res/clyde.png")};
        Image[] ghostMovingLeft = {new Image("res/inky.png"), new Image("res/blinky.png"), new Image("res/clyde.png")};
        Image[] ghostMovingUp = {new Image("res/inky.png"), new Image("res/blinky.png"), new Image("res/clyde.png")};
        Image[] ghostMovingDown = {new Image("res/inky.png"), new Image("res/blinky.png"), new Image("res/clyde.png")};

        ghostRight = new Animation(ghostMovingRight, duration, true);
        ghostLeft = new Animation(ghostMovingLeft, duration, true);
        ghostDown = new Animation(ghostMovingDown, duration, true);
        ghostUp = new Animation(ghostMovingUp, duration, true);
        ghost = ghostRight;
    }

    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        background.draw(0, 0);
        nakov.draw(nakovPositionX, nakovPositionY);
        ghost.draw(ghostshiftX, ghostshiftY);
        graphics.drawString(("X" + ghostshiftX + " Y" + ghostshiftY), 200, 300);

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
        float nakovStep = 0.4f;
        float ghostStep = 0.4f;

        //up
        if (input.isKeyDown(Input.KEY_UP)) {
            nakov = nakovUp;
            nakovPositionY -= nakovStep;
            if (nakovPositionY < 0) {
                nakovPositionY += nakovStep;
            }
        //down
        } else if (input.isKeyDown(Input.KEY_DOWN)) {
            nakov = nakovDown;
            nakovPositionY += nakovStep;
            if (nakovPositionY > 550) {
                nakovPositionY -= nakovStep;
            }
        //left
        } else if (input.isKeyDown(Input.KEY_LEFT)) {
            nakov = nakovLeft;
            nakovPositionX -= nakovStep;
            if (nakovPositionX < 0) {
                nakovPositionX += nakovStep;
            }
        //right
        } else if (input.isKeyDown(Input.KEY_RIGHT)) {
            nakov = nakovRight;
            nakovPositionX += nakovStep;
            if (nakovPositionX > 750) {
                nakovPositionX -= nakovStep;
            }
        //quit
        } else if (input.isKeyDown(Input.KEY_ESCAPE)) {
            quit = true;
        }

        if (quit) {
            if (input.isKeyDown(Input.KEY_R)) {
                quit = false;
            } else if (input.isKeyDown(Input.KEY_M)) {
                stateBasedGame.enterState(0);
            } else if (input.isKeyDown(Input.KEY_Q)) {
                System.exit(0);
            }
        }
        switch (theRandomNumber) {
            case 0:
                ghostshiftY -= ghostStep;//up
                if (ghostshiftY < 0) {
                    ghostshiftY += ghostStep;
                    theRandomNumber = randomGen.nextInt(4);
                }
                break;
            case 1:
                ghostshiftY += ghostStep;//down
                if (ghostshiftY > 550) {
                    ghostshiftY -= ghostStep;
                    theRandomNumber = randomGen.nextInt(4);
                }
                break;
            case 2:
                ghostshiftX -= ghostStep;//left
                if (ghostshiftX < 0) {
                    ghostshiftX += ghostStep;
                    theRandomNumber = randomGen.nextInt(4);
                }
                break;
            case 3:
                ghostshiftX += ghostStep;//right
                if (ghostshiftX > 750) {
                    ghostshiftX -= ghostStep;
                    theRandomNumber = randomGen.nextInt(4);
                }
                break;
        }
    }

    public int getID() {
        return 1;
    }
}
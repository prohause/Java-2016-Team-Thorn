package javagame;

import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.util.Random;

public class Play extends BasicGameState {
    private Animation nakov, nakovRight, nakovLeft, nakovUp, nakovDown;
    private Animation ghost, ghostRight, ghostLeft, ghostUp , ghostDown;
    private int[] duration = {130, 130, 130};
    private Image background;
    private boolean quit = false;
    private float faceX = 0;
    private float faceY = 0;
    private float ghostPositionX=0;
    private float ghostPositionY=0;
    private float shiftX=ghostPositionX+400;
    private float shiftY=ghostPositionX+300;
    private float speed = 0.4f;
    private float ghostSpeed = 0.4f;
    private Random randomGen = new Random();
    private int theRandomNumber=randomGen.nextInt(4);
    private Music openingMusic;

    public Play(int state) {
    }

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        background = new Image("res/background.jpg");
        gc.setShowFPS(true);
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

        ghostRight = new Animation(ghostMovingRight,duration,true);
        ghostLeft = new Animation(ghostMovingLeft,duration,true);
        ghostDown = new Animation(ghostMovingDown,duration,true);
        ghostUp = new Animation(ghostMovingUp,duration,true);

        ghost = ghostRight;
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        background.draw(0, 0);
        nakov.draw(faceX, faceY);
        ghost.draw(shiftX,shiftY);
        g.drawString(("X"+shiftX+ " Y"+shiftY),200,300);

        if (quit) {
            g.drawString("Resume(R)", 350, 200);
            g.drawString("Main Menu(M)", 350, 250);
            g.drawString("Quit Game (Q)", 350, 300);
            if (!quit) {
                g.clear();
            }
        }
    }

    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
        Input input = gc.getInput();
        if (input.isKeyDown(Input.KEY_UP)) {
            nakov = nakovUp;
            faceY -= speed;
            if (faceY < 0) {
                faceY += speed;
            }
        }
        else if (input.isKeyDown(Input.KEY_DOWN)) {
            nakov = nakovDown;
            faceY += speed;
            if (faceY > 550) {
                faceY -= speed;
            }
        }

        else if (input.isKeyDown(Input.KEY_LEFT)) {
            nakov = nakovLeft;
            faceX -= speed;
            if (faceX < 0) {
                faceX += speed;
            }
        }

       else  if (input.isKeyDown(Input.KEY_RIGHT)) {
            nakov = nakovRight;
            faceX += speed;
            if (faceX > 750) {
                faceX -= speed;
            }
        }

       else if (input.isKeyDown(Input.KEY_ESCAPE)) {
            quit = true;
        }

        if (quit) {
            if (input.isKeyDown(Input.KEY_R)) {
                quit = false;
            }

            else if (input.isKeyDown(Input.KEY_M)) {
                sbg.enterState(0);
            }

            else if (input.isKeyDown(Input.KEY_Q)) {
                System.exit(0);
            }
        }
        switch (theRandomNumber) {
            case 0:
                shiftY -= ghostSpeed;//up
                if (shiftY < 0) {
                    shiftY += ghostSpeed;
                    theRandomNumber = randomGen.nextInt(4);
                }
                break;
            case 1:
                shiftY += ghostSpeed;//down
                if (shiftY > 550) {
                    shiftY -= ghostSpeed;
                    theRandomNumber = randomGen.nextInt(4);
                }
                break;

            case 2:
                shiftX -= ghostSpeed;//left
                if (shiftX < 0) {
                    shiftX += ghostSpeed;
                    theRandomNumber = randomGen.nextInt(4);

                }
                break;

            case 3:
                shiftX += ghostSpeed;//right
                if (shiftX > 750) {
                    shiftX -= ghostSpeed;
                    theRandomNumber = randomGen.nextInt(4);

                }
                break;

        }
    }

    public int getID() {
        return 1;
    }
}
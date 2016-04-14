package javagame;

import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Play extends BasicGameState {
    private Animation nakov, right, left, up, down;
    private int[] duration = {130, 130, 130};
    private Image background;
    private boolean quit = false;
    private float faceX = 0;
    private float faceY = 0;
    private float speed = 0.4f;
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

        right = new Animation(movingRight, duration, true);
        left = new Animation(movingLeft, duration, true);
        up = new Animation(movingUp, duration, true);
        down = new Animation(movingDown, duration, true);
        nakov = right;
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        background.draw(0, 0);
        nakov.draw(faceX, faceY);

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
            nakov = up;
            faceY -= speed;
            if (faceY < 0) {
                faceY += speed;
            }
        }
        else if (input.isKeyDown(Input.KEY_DOWN)) {
            nakov = down;
            faceY += speed;
            if (faceY > 550) {
                faceY -= speed;
            }
        }

        else if (input.isKeyDown(Input.KEY_LEFT)) {
            nakov = left;
            faceX -= speed;
            if (faceX < 0) {
                faceX += speed;
            }
        }

       else  if (input.isKeyDown(Input.KEY_RIGHT)) {
            nakov = right;
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
    }

    public int getID() {
        return 1;
    }
}
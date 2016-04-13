package javagame;

import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Play extends BasicGameState {

    Animation nakov, right, left, up, down;
    int[] duration = {130, 130, 130};
    Image background;
    boolean quit = false;
    float facex = 0;
    float facey = 0;
    float speed = 0.4f;
    Music openingmusic;


    public Play(int state) {

    }

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        background = new Image("res/background.jpg");
        gc.setShowFPS(true);
        openingmusic = new Music("res/pacnakov_openingmusic.ogg");
        openingmusic.loop();
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
        nakov.draw(facex, facey);

        if (quit==true){
            g.drawString("Resume(R)",350,200);
            g.drawString("Main Menu(M)",350,250);
            g.drawString("Quit Game (Q)",350,300);
           if (quit==false){
               g.clear();
           }
        }

    }

    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {

        Input input = gc.getInput();

        if (input.isKeyDown(Input.KEY_UP)) {
            nakov = up;
            facey -= speed;
            if (facey < 0) {
                facey += speed;
            }
        }
        if (input.isKeyDown(Input.KEY_DOWN)) {
            nakov = down;
            facey += speed;
            if (facey > 550) {
                facey -= speed;
            }
        }
        if (input.isKeyDown(Input.KEY_LEFT)) {
            nakov = left;
            facex -= speed;
            if (facex < 0) {
                facex += speed;
            }
        }
        if (input.isKeyDown(Input.KEY_RIGHT)) {
            nakov = right;
            facex += speed;
            if (facex > 750) {
                facex -= speed;
            }
        }
        if (input.isKeyDown(Input.KEY_ESCAPE)){
            quit=true;
        }
        if (quit==true){
            if (input.isKeyDown(Input.KEY_R)){
                quit=false;
            }
            if (input.isKeyDown(Input.KEY_M)){
                sbg.enterState(0);
            }
            if (input.isKeyDown(Input.KEY_Q)){
                System.exit(0);
            }
        }

    }

    public int getID() {
        return 1;
    }
}
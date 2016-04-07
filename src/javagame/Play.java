package javagame;

import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Play extends BasicGameState {

    Animation nakov, nakovRight, nakovLeft, nakovUp, nakovDown;
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
        background = new Image("res/background.png");
        gc.setShowFPS(false);
        openingmusic = new Music("res/pacnakov_openingmusic.ogg");
        openingmusic.loop();
        Image[] movingRight = {new Image("res/nakov-right1.png"), new Image("res/nakov-right2.png"), new Image("res/nakov-right3.png")};

        nakovRight = new Animation(movingRight, duration, true);

    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {

        background.draw(0, 0);
        nakovRight.draw(facex, facey);

    }

    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {

        Input input = gc.getInput();

        if (input.isKeyDown(Input.KEY_UP)) {
            facey -= speed;
            if (facey < 0) {
                facey += speed;
            }
        }
        if (input.isKeyDown(Input.KEY_DOWN)) {
            facey += speed;
            if (facey > 550) {
                facey -= speed;
            }
        }
        if (input.isKeyDown(Input.KEY_LEFT)) {
            facex -= speed;
            if (facex < 0) {
                facex += speed;
            }
        }
        if (input.isKeyDown(Input.KEY_RIGHT)) {
            facex += speed;
            if (facex > 765) {
                facex -= speed;
            }
        }

    }

    public int getID() {
        return 1;
    }
}
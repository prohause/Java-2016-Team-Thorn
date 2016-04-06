package javagame;

import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Play extends BasicGameState {

    Image face;
    float facex = 0;
    float facey = 0;
    Music openingmusic;

    public Play(int state) {

    }

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        face = new Image("res/face.png");
        gc.setShowFPS(false);
        openingmusic = new Music("res/pacnakov_openingmusic.ogg");
        openingmusic.loop();
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {

        g.drawImage(face, facex, facey);

    }

    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {

        Input input = gc.getInput();

        if (input.isKeyDown(Input.KEY_UP)) {
            facey -= 0.5;
            if (facey < 0) {
                facey += 0.5;
            }
        }
        if (input.isKeyDown(Input.KEY_DOWN)) {
            facey += 0.5;
            if (facey > 523) {
                facey -= 0.5;
            }
        }
        if (input.isKeyDown(Input.KEY_LEFT)) {
            facex -= 0.5;
            if (facex < 0) {
                facex += 0.5;
            }
        }
        if (input.isKeyDown(Input.KEY_RIGHT)) {
            facex += 0.5;
            if (facex > 725) {
                facex -= 0.5;
            }
        }

    }

    public int getID() {
        return 1;
    }
}
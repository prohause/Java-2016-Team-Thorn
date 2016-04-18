package Assets;


import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 * Created by Roni on 4/18/2016.
 */
public class NakovAssets {

    private Image[] movingRight;
    private Image[] movingLeft;
    private Image[] movingUp;
    private Image[] movingDown;

    public NakovAssets() {
        try {
            this.movingRight = new Image[]{new Image("res/right1.png"), new Image("res/right2.png"), new Image("res/right3.png")};
            this.movingLeft = new Image[]{new Image("res/left1.png"), new Image("res/left2.png"), new Image("res/left3.png")};
            this.movingUp = new Image[]{new Image("res/up1.png"), new Image("res/up2.png"), new Image("res/up3.png")};
            this.movingDown = new Image[]{new Image("res/down1.png"), new Image("res/down2.png"), new Image("res/down3.png")};
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

    public Image[] getMovingRight() {
        return movingRight;
    }

    public Image[] getMovingLeft() {
        return movingLeft;
    }

    public Image[] getMovingUp() {
        return movingUp;
    }

    public Image[] getMovingDown() {
        return movingDown;
    }
}

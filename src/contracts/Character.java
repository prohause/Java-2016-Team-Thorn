package contracts;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;

public interface Character {

    float getMoveSpeed();

    void setMoveSpeed(float moveSpeed);

    float getPositionX();

    void setPositionX(float posX);

    float getPositionY();

    void setPositionY(float posY);

    void setImage(Image image);

    Animation getMovingUp();

    void setMovingUp(Animation movingUp);

    Animation getMovingDown();

    void setMovingDown(Animation movingDown);

    Animation getMovingLeft();

    void setMovingLeft(Animation movingLeft);

    Animation getMovingRight();

    void setMovingRight(Animation movingRight);
}

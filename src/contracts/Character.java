package contracts;

import javafx.animation.Animation;
import javafx.scene.image.Image;

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

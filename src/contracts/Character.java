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

    void setImage(javafx.scene.image.Image image);

    Animation getMovingUp();

    void setMovingUp(Animation movingUp);

    void setMovingUp(javafx.animation.Animation movingUp);

    Animation getMovingDown();

    void setMovingDown(Animation movingDown);

    void setMovingDown(javafx.animation.Animation movingDown);

    Animation getMovingLeft();

    void setMovingLeft(Animation movingLeft);

    void setMovingLeft(javafx.animation.Animation movingLeft);

    Animation getMovingRight();

    void setMovingRight(Animation movingRight);

    void setMovingRight(javafx.animation.Animation movingRight);
}

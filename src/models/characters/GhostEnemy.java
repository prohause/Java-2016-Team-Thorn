package models.characters;

import javafx.animation.Animation;
import javafx.scene.image.Image;
import contracts.Character;

public abstract class GhostEnemy implements Character {
    private final int DEFAULT_GHOST_START_POSITION_X = 0;
    private final int DEFAULT_GHOST_START_POSITION_Y = 0;
    private final String ENEMY_NAME = "Ghost";

    @Override
    public float getMoveSpeed() {
        return 0;
    }

    @Override
    public void setMoveSpeed(float moveSpeed) {

    }

    @Override
    public float getPositionX() {
        return 0;
    }

    @Override
    public void setPositionX(float posX) {

    }

    @Override
    public float getPositionY() {
        return 0;
    }

    @Override
    public void setPositionY(float posY) {

    }

    @Override
    public void setImage(Image image) {

    }

    @Override
    public org.newdawn.slick.Animation getMovingUp() {
        return null;
    }

    @Override
    public void setMovingUp(Animation movingUp) {

    }

    @Override
    public org.newdawn.slick.Animation getMovingDown() {
        return null;
    }

    @Override
    public void setMovingDown(Animation movingDown) {

    }

    @Override
    public org.newdawn.slick.Animation getMovingLeft() {
        return null;
    }

    @Override
    public void setMovingLeft(Animation movingLeft) {

    }

    @Override
    public org.newdawn.slick.Animation getMovingRight() {
        return null;
    }

    @Override
    public void setMovingRight(Animation movingRight) {

    }
}

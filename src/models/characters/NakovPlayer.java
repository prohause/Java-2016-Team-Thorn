package models.characters;

import javafx.animation.Animation;
import javafx.scene.image.Image;
import contracts.Character;

public class NakovPlayer implements Character {
    private final int DEFAULT_NAKOV_START_POSITION_X = 0;
    private final int DEFAULT_NAKOV_START_POSITION_Y = 0;
    private final int DEFAULT_LIVES = 3;
    private final String PLAYER_NAME = "Nakov";
    private int lifes;
    private int level;
    private float moveSpeed;
    private float positionX;
    private float positionY;
    private Image image;
    private Animation staying, movingUp, movingDown, movingLeft, movingRight;

    public NakovPlayer(int lifes, float moveSpeed,float positionX, float positionY) {
        this.lifes = lifes;
        this.moveSpeed = moveSpeed;
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public int getLifes() {
        return 0;
    }

    public void setLifes(int lives) {

    }

    @Override
    public float getMoveSpeed() {
        return moveSpeed;
    }

    @Override
    public void setMoveSpeed(float moveSpeed) {
        this.moveSpeed = moveSpeed;
    }

    @Override
    public float getPositionX() {
        return positionX;
    }

    @Override
    public void setPositionX(float posX) {
        this.positionX += posX;
    }

    @Override
    public float getPositionY() {
        return positionY;
    }

    @Override
    public void setPositionY(float posY) {
        this.positionY += posY;
    }

    @Override
    public void setImage(Image image) {
        this.image = image;
    }

    @Override
    public Animation getMovingUp() {
        return movingUp;
    }

    @Override
    public void setMovingUp(Animation movingUp) {
        this.movingUp = movingUp;
    }

    @Override
    public Animation getMovingDown() {
        return movingDown;
    }

    @Override
    public void setMovingDown(Animation movingDown) {
        this.movingDown = movingDown;
    }

    @Override
    public Animation getMovingLeft() {
        return movingLeft;
    }

    @Override
    public void setMovingLeft(Animation movingLeft) {
        this.movingLeft = movingLeft;
    }

    @Override
    public Animation getMovingRight() {
        return movingRight;
    }

    @Override
    public void setMovingRight(Animation movingRight) {
        this.movingRight = movingRight;
    }
}
package models.characters;

import Assets.NakovAssets;
import contracts.Character;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;

public abstract class NakovPlayer implements Character {
    private final int DEFAULT_NAKOV_START_POSITION_X = 0;
    private final int DEFAULT_NAKOV_START_POSITION_Y = 0;
    private final int DEFAULT_LIVES = 3;
    private final String PLAYER_NAME = "Nakov";
    private int lifes;
    private int level;
    private float moveSpeed;
    private final float MOVE_SPEED = 0.4f;
    private float positionX;
    private float positionY;
    private Image image;
    private Animation movingUp, movingDown, movingLeft, movingRight, staying;
    private final int[] DURATION = {130, 130, 130};
    private NakovAssets nakovAssets = new NakovAssets();


    public NakovPlayer() {
        this.lifes = DEFAULT_LIVES;
        this.moveSpeed = MOVE_SPEED;
        this.positionX = DEFAULT_NAKOV_START_POSITION_X;
        this.positionY = DEFAULT_NAKOV_START_POSITION_Y;
        this.movingUp = new Animation(nakovAssets.getMovingUp(), DURATION, true);
        this.movingDown = new Animation(nakovAssets.getMovingDown(), DURATION, true);
        this.movingLeft = new Animation(nakovAssets.getMovingLeft(),DURATION,true);
        this.movingRight = new Animation(nakovAssets.getMovingRight(),DURATION,true);
        this.staying = movingRight;
    }

    public int getLifes() {
        return 0;
    }

    public void setLifes(int lifes) {

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

    }

    @Override
    public Animation getMovingUp() {
        return null;
    }

    @Override
    public void setMovingUp(Animation movingUp) {

    }

    @Override
    public Animation getMovingDown() {
        return null;
    }

    @Override
    public void setMovingDown(Animation movingDown) {

    }

    @Override
    public Animation getMovingLeft() {
        return null;
    }

    @Override
    public void setMovingLeft(Animation movingLeft) {

    }

    @Override
    public Animation getMovingRight() {
        return null;
    }

    @Override
    public void setMovingRight(Animation movingRight) {

    }

}
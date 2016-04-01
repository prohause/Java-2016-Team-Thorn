package javagame;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class MainGame extends StateBasedGame{
    public static final String GAME_NAME = "PackNakov!";
    public static final int LAUNCHER = 0;
    public static final int PLAY = 1;

    public MainGame(String GAME_NAME) {
        super(GAME_NAME);
        this.addState(new Menu(LAUNCHER));
        this.addState(new Play(PLAY));
    }
    public void initStatesList(GameContainer gc) throws SlickException{
        this.getState(LAUNCHER).init(gc,this);
        this.getState(PLAY).init(gc,this);
        this.enterState(LAUNCHER); // initialstate - LAUNCHER
    }
    public static void main(String[] args) {
        AppGameContainer appGc ;
        try{
            appGc = new AppGameContainer(new MainGame(GAME_NAME));
            appGc.setDisplayMode(800,640,false); //setting the default resolution , false means no fullscreen
            appGc.start();

        }catch(SlickException ex){
            ex.printStackTrace();
        }

    }
}

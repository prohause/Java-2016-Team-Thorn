package javagame.states;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Play extends BasicGameState {
    private Animation nakov, nakovRight, nakovLeft, nakovUp, nakovDown;
    private Animation ghost, ghostRight, ghostLeft, ghostUp, ghostDown;
    private int[] duration = {130, 130, 130};
    private Image background;
    private boolean quit = false;
    private float nakovPositionX = 0;
    private float nakovPositionY = 0;
    private float ghostPositionX = 0;
    private float ghostPositionY = 0;
    //private float ghostshiftX = ghostPositionX + 400;
    //private float ghostshiftY = ghostPositionY + 300;
    private Random randomGen = new Random();
    private int theRandomNumber = randomGen.nextInt(4);
    private final int width = 50;
    private final int height = 35;
    private ArrayList<StringBuilder> lines = new ArrayList<>();
    private int row = 0;
    private int col = 0;
    private int rows;
    private int cols;
    private Image beer, rakiq;


    public void readMaze() {
        try {
            Scanner sc = new Scanner(new File("res/maze.txt"));
            while (sc.hasNextLine()) {
                lines.add(new StringBuilder(sc.nextLine()));
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        rows = lines.size();
        cols = lines.get(0).length();
    }

    public char charAt(int row, int col) {
        return lines.get(row).charAt(col);
    }

    public Play(int state) {
    }

    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        Music openingMusic;
        background = new Image("res/background.jpg");
        gameContainer.setShowFPS(true);
        openingMusic = new Music("res/pacnakov_openingmusic.ogg");
        openingMusic.loop();

        Image[] movingRight = {new Image("res/right1.png"), new Image("res/right2.png"), new Image("res/right3.png")};
        Image[] movingLeft = {new Image("res/left1.png"), new Image("res/left2.png"), new Image("res/left3.png")};
        Image[] movingUp = {new Image("res/up1.png"), new Image("res/up2.png"), new Image("res/up3.png")};
        Image[] movingDown = {new Image("res/down1.png"), new Image("res/down2.png"), new Image("res/down3.png")};
        beer = new Image("res/beer.png");
        rakiq = new Image("res/rakiq.png");

        nakovRight = new Animation(movingRight, duration, true);
        nakovLeft = new Animation(movingLeft, duration, true);
        nakovUp = new Animation(movingUp, duration, true);
        nakovDown = new Animation(movingDown, duration, true);
        nakov = nakovRight;

        Image[] ghostMovingRight = {new Image("res/inky.png"), new Image("res/blinky.png"), new Image("res/clyde.png")};
        Image[] ghostMovingLeft = {new Image("res/inky.png"), new Image("res/blinky.png"), new Image("res/clyde.png")};
        Image[] ghostMovingUp = {new Image("res/inky.png"), new Image("res/blinky.png"), new Image("res/clyde.png")};
        Image[] ghostMovingDown = {new Image("res/inky.png"), new Image("res/blinky.png"), new Image("res/clyde.png")};

        ghostRight = new Animation(ghostMovingRight, duration, true);
        ghostLeft = new Animation(ghostMovingLeft, duration, true);
        ghostDown = new Animation(ghostMovingDown, duration, true);
        ghostUp = new Animation(ghostMovingUp, duration, true);
        ghost = ghostRight;
        nakovPositionX = 0;
        nakovPositionY = 0;
        readMaze();
        for (int r = 1; r < rows - 1; r++) {
            for (int c = 1; c < cols - 1; c++) {
                if (charAt(r, c) == '5') {
                    ghostPositionX = (c - 1) * 50;
                    ghostPositionY = (r - 15) * 50;
                }
                if (charAt(r, c) == '4') {
                    nakovPositionX = (c - 1) * 50;
                    nakovPositionY = (r - 15) * 50;
                }
            }
        }
    }

    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        background.draw(0, 0);
//         maze.draw(0,0);
        nakov.draw(nakovPositionX, nakovPositionY);
        ghost.draw(ghostPositionX, ghostPositionY);
        graphics.drawString(row + " " + col + " " + theRandomNumber, 200, 500);
        for (int r = 1; r < rows - 1; r++) {
            for (int c = 1; c < cols - 1; c++) {
                if (charAt(r, c) == '2') {
                    beer.draw((c - 1) * 50, (r - 1) * 50);
                }
                if (charAt(r, c) == '3') {
                    rakiq.draw((c - 1) * 50, (r - 1) * 50);
                }

            }
        }
        graphics.drawString(("X:" + Mouse.getX() + "Y" + Mouse.getY()), 100, 50);
        //  graphics.drawString(("X" + ghostshiftX + " Y" + ghostshiftY), 200, 300);
        if (quit) {
            graphics.drawString("Resume(R)", 350, 200);
            graphics.drawString("Main Menu(M)", 350, 250);
            graphics.drawString("Quit Game (Q)", 350, 300);
            if (!quit) {
                graphics.clear();
            }
        }
    }

    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException {

        Input input = gameContainer.getInput();
        lines.get(row).setCharAt(col, '1');

        float nakovStep = 0.4f;
        float ghostStep = 0.4f;
        row = (int) Math.round(nakovPositionY / 50) + 1;
        col = (int) Math.round(nakovPositionX / 50) + 1;

        //up
        if (input.isKeyDown(Input.KEY_UP) && row > 0) {
            if (charAt(row - 1, col) != '0') {
                nakov = nakovUp;
                //row--;
                nakovPositionY -= nakovStep;
                nakovPositionX = (col - 1) * 50;
            } else {
                if (nakovPositionY > (row - 1) * 50) {
                    nakovPositionY -= nakovStep;
                } else {
                    nakovPositionY = (row - 1) * 50;
                }
            }

           /* if (row + 1 > 0) {
                if (charAt(row-1, col) == '0') {
                    nakovPositionY += nakovStep;
                }
            }*/

            //down

        } else if (input.isKeyDown(Input.KEY_DOWN) && row < rows) {
            if (charAt(row + 1, col) != '0') {
                nakov = nakovDown;
                //row++;
                nakovPositionY += nakovStep;
                nakovPositionX = (col - 1) * 50;

            } else {
                if (nakovPositionY < (row - 1) * 50) {
                    nakovPositionY += nakovStep;
                } else {
                    nakovPositionY = (row - 1) * 50;
                }
            }

                /*if (row < 16) {
                    if (charAt(row, col) == '0') {
                        nakovPositionY -= nakovStep;
                    }
                }*/

        }
        //left

        else if (input.isKeyDown(Input.KEY_LEFT) && col > 0)

        {
            if (charAt(row, col - 1) != '0') {
                nakov = nakovLeft;
                //col--;
                nakovPositionX -= nakovStep;
                nakovPositionY = (row - 1) * 50;
            } else {
                if (nakovPositionX > (col - 1) * 50) {
                    nakovPositionX -= nakovStep;
                } else {
                    nakovPositionX = (col - 1) * 50;
                }
            }
           /* if (col + 1 > 0) {
                if (charAt(row, col) == '0') {
                    nakovPositionX += nakovStep;
                }
            }*/


            //right

        } else if (input.isKeyDown(Input.KEY_RIGHT) && col < cols) {
            if (charAt(row, col + 1) != '0') {
                nakov = nakovRight;
                //col++;
                nakovPositionX += nakovStep;
                nakovPositionY = (row - 1) * 50;
            } else {
                if (nakovPositionX < (col - 1) * 50) {
                    nakovPositionX += nakovStep;
                } else {
                    nakovPositionX = (col - 1) * 50;
                }
            }

            /*if (17 > col) {
                if (charAt(row, col) == '0') {
                    nakovPositionX -= nakovStep;
                }
            }*/

            //quit
        } else if (input.isKeyDown(Input.KEY_ESCAPE))

        {
            quit = true;
        }

        if (quit)

        {
            if (input.isKeyDown(Input.KEY_R)) {
                quit = false;
            } else if (input.isKeyDown(Input.KEY_M)) {
                stateBasedGame.enterState(0);
            } else if (input.isKeyDown(Input.KEY_Q)) {
                System.exit(0);
            }
        }

        switch (theRandomNumber)

        {
            case 0:
                ghostPositionY -= ghostStep;//up
                if (ghostPositionY < 0) {
                    ghostPositionY += ghostStep;
                    theRandomNumber = randomGen.nextInt(4);
                }
                break;
            case 1:
                ghostPositionY += ghostStep;//down
                if (ghostPositionY > 550) {
                    ghostPositionY -= ghostStep;
                    theRandomNumber = randomGen.nextInt(4);
                }
                break;
            case 2:
                ghostPositionX -= ghostStep;//left
                if (ghostPositionX < 0) {
                    ghostPositionX += ghostStep;
                    theRandomNumber = randomGen.nextInt(4);
                }
                break;
            case 3:
                ghostPositionX += ghostStep;//right
                if (ghostPositionX > 750) {
                    ghostPositionX -= ghostStep;
                    theRandomNumber = randomGen.nextInt(4);
                }
                break;
            default:
                break;
        }

    }

    public int getID() {
        return 1;
    }
}
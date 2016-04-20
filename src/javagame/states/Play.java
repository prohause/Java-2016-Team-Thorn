package javagame.states;

import contracts.CharacterFactory;
import modelFactories.GhostFactory;
import modelFactories.NakovFactory;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Play extends BasicGameState {
    CharacterFactory nakovFactory = new NakovFactory();
    CharacterFactory ghostFactory = new GhostFactory();

    private Animation nakov, nakovRight, nakovLeft, nakovUp, nakovDown;
    private Animation ghost;
    private int[] duration = {130, 130, 130};
    private Image miniBackground;
    private boolean quit = false;
    private float nakovPositionX = 0;
    private float nakovPositionY = 0;
    private float ghostPositionX = 0;
    private float ghostPositionY = 0;
    private Random randomGen = new Random();
    private int theRandomNumber = randomGen.nextInt(4);
    private static final int STEP = 50;
    private ArrayList<StringBuilder> lines = new ArrayList<>();
    private int row = 0;
    private int col = 0;
    private int ghostRow = 0;
    private int ghostCol = 0;
    private int rows;
    private int cols;
    private int score = 0;
    private Image beer, rakiq;
    final int ghostDuration = 300;
    private int count = 0;
    private long counter;

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
        miniBackground = new Image("res/miniBcg.png");
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

        ghost = new Animation(ghostMovingRight, duration, true);
        readMaze();
        for (int r = 1; r < rows - 1; r++) {
            for (int c = 1; c < cols - 1; c++) {
                if (charAt(r, c) == '5') {
                    ghostPositionX = (c - 1) * STEP;
                    ghostPositionY = (r - 15) * STEP;
                }
                if (charAt(r, c) == '4') {
                    nakovPositionX = (c - 1) * STEP;
                    nakovPositionY = (r - 15) * STEP;
                }
            }
        }
    }

    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {

        nakov.draw(nakovPositionX, nakovPositionY);
        ghost.draw(ghostPositionX, ghostPositionY);

        for (int r = 1; r < rows - 1; r++) {
            for (int c = 1; c < cols - 1; c++) {
                if (charAt(r, c) == '2') {
                    beer.draw((c - 1) * STEP, (r - 1) * STEP);
                }
                if (charAt(r, c) == '3') {
                    rakiq.draw((c - 1) * STEP, (r - 1) * STEP);
                }
            }
        }

        for (int r = 1; r < rows - 1; r++) {
            for (int c = 1; c < cols - 1; c++) {
                if (charAt(r, c) == '0') {
                    miniBackground.draw((c - 1) * STEP, (r - 1) * STEP);
                }
            }
        }
        graphics.drawString("Score: " + score, 650, 10);

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
        count++;
        Input input = gameContainer.getInput();
        if (lines.get(row).charAt(col) == '2') {
            score += 10;
        }
        if (lines.get(row).charAt(col) == '3') {
            score += 20;
        }
        if (lines.get(row).charAt(col) == '2' || lines.get(row).charAt(col) == '3') {
            lines.get(row).setCharAt(col, '1');
        }
        counter += delta;
        // every 2.5 seconds enters the loop and generates random row and col ,
        // checks if its empty and spawns a beer !
        if (counter >= 2500) {
            for (int i = 0; i < 50; i++) {
                int randomcol = ThreadLocalRandom.current().nextInt(0, cols);
                int randomrow = ThreadLocalRandom.current().nextInt(0, rows);
                if (lines.get(randomrow).charAt(randomcol) == '1') {
                    lines.get(randomrow).setCharAt(randomcol, '2');
                }
            }
            counter = 0;
        }

        float nakovStep = 0.4f;
        float ghostStep = 0.4f;
        row = Math.round(nakovPositionY / STEP) + 1;
        col = Math.round(nakovPositionX / STEP) + 1;
        ghostRow = Math.round(ghostPositionY / STEP) + 1;
        ghostCol = Math.round(ghostPositionX / STEP) + 1;

        //up
        if (input.isKeyDown(Input.KEY_UP) && row > 0) {
            if (charAt(row - 1, col) != '0') {
                nakov = nakovUp;

                nakovPositionY -= nakovStep;
                nakovPositionX = (col - 1) * STEP;
            } else {
                if (nakovPositionY > (row - 1) * STEP) {
                    nakovPositionY -= nakovStep;
                } else {
                    nakovPositionY = (row - 1) * STEP;
                    nakov = nakovUp;
                }
            }

            //down

        } else if (input.isKeyDown(Input.KEY_DOWN) && row < rows) {
            if (charAt(row + 1, col) != '0') {
                nakov = nakovDown;

                nakovPositionY += nakovStep;
                nakovPositionX = (col - 1) * STEP;

            } else {
                if (nakovPositionY < (row - 1) * STEP) {
                    nakovPositionY += nakovStep;
                } else {
                    nakovPositionY = (row - 1) * STEP;
                    nakov = nakovDown;
                }
            }
        }
        //left

        else if (input.isKeyDown(Input.KEY_LEFT) && col >= 0) {
            //teleportation left
            if (col == 0 && charAt(row, col) != '0') {
                nakovPositionX -= nakovStep;
                nakovPositionX = (cols - 2) * STEP;
                col = cols - 2;
            } else if (charAt(row, col - 1) != '0') {
                nakov = nakovLeft;
                nakovPositionX -= nakovStep;
                nakovPositionY = (row - 1) * STEP;
            } else {
                if (nakovPositionX > (col - 1) * STEP) {
                    nakovPositionX -= nakovStep;
                } else {
                    nakovPositionX = (col - 1) * STEP;
                    nakov = nakovLeft;
                }
            }

            //right
        } else if (input.isKeyDown(Input.KEY_RIGHT) && col < cols) {
            //teleportation right
            if (col == cols - 1 && charAt(row, col) != '0') {
                nakovPositionX += nakovStep;
                nakovPositionX = 0;
                col = 0;
            } else if (charAt(row, col + 1) != '0') {
                nakov = nakovRight;

                nakovPositionX += nakovStep;
                nakovPositionY = (row - 1) * STEP;
            } else {
                if (nakovPositionX < (col - 1) * STEP) {
                    nakovPositionX += nakovStep;
                } else {
                    nakovPositionX = (col - 1) * STEP;
                    nakov = nakovRight;
                }
            }

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

        if (ghostRow == row && ghostCol == col) {
            System.exit(0);
        }

        switch (theRandomNumber)

        {
            case 0:
                ghostPositionY -= ghostStep;//up
                ghostPositionX = (ghostCol - 1) * STEP;

                  if (ghostPositionY < 0 || charAt(ghostRow - 1, ghostCol) == '0' || charAt(ghostRow, ghostCol) == '6' && count > ghostDuration) {
                    ghostPositionY += ghostStep;
                     count = 0;
                    theRandomNumber = randomGen.nextInt(4);
                }
                break;
            case 1:

                ghostPositionY += ghostStep;//down
                ghostPositionX = (ghostCol - 1) * STEP;
                if (ghostPositionY > 550 || charAt(ghostRow + 1, ghostCol) == '0' || charAt(ghostRow, ghostCol) == '6' && count > ghostDuration) {
                    ghostPositionY -= ghostStep;
                    count = 0;
                    theRandomNumber = randomGen.nextInt(4);
                }
                break;
            case 2:
                ghostPositionX -= ghostStep;//left
                ghostPositionY = (ghostRow - 1) * STEP;
                if (ghostPositionX < 0 || charAt(ghostRow, ghostCol - 1) == '0' || charAt(ghostRow, ghostCol) == '6' && count > ghostDuration) {
                    ghostPositionX += ghostStep;
                    count = 0;
                    theRandomNumber = randomGen.nextInt(4);
                }
                break;
            case 3:
                ghostPositionX += ghostStep;//right
                ghostPositionY = (ghostRow - 1) * STEP;
                if (ghostPositionX > 750 || charAt(ghostRow, ghostCol + 1) == '0' || charAt(ghostRow, ghostCol) == '6' && count > ghostDuration) {
                    ghostPositionX -= ghostStep;
                    count = 0;
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
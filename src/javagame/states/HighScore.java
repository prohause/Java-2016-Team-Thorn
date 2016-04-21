package javagame.states;

import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import java.io.BufferedReader;

import java.io.*;
import java.util.*;

public class HighScore extends BasicGameState {
    private Image background;
    private boolean quit = false;

    public HighScore(int state) {
    }

    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        background = new Image("res/background_highscore.jpg");

        Play play = new Play(0);
        Integer localscore = play.score;



    }

    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        background.draw(0, 0);

        try
        {
            int j = 120;
            int i = 0;
            BufferedReader br = new BufferedReader(new FileReader("res/highscores.txt"));
                String line;
                List<String> scoreList = new ArrayList<>();
                while ((line = br.readLine()) != null) {
                    scoreList.add(line);
                    i = i+1;
                }
                Collections.sort(scoreList);
                 i = 0;
                int k = 0;

                for (k = 0; k < 5; k++)
                {
                    if ( k < scoreList.size() - 1 )
                    {
                        graphics.drawString("Score: " + scoreList.get(i), 420, j);
                        j += 35;
                        i += 1;
                    }
                }


        }

        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }




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





        if (input.isKeyDown(Input.KEY_ESCAPE)) {
            quit = true;
        }

        if (quit) {
            if (input.isKeyDown(Input.KEY_R)) {
                quit = false;
            }

            if (input.isKeyDown(Input.KEY_M)) {
                stateBasedGame.enterState(0);
            }

            if (input.isKeyDown(Input.KEY_Q)) {
                System.exit(0);
            }
        }
    }

    public int getID() {
        return 2;
    }
}
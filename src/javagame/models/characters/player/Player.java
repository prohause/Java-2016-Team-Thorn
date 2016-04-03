package javagame.models.characters.player;

import javagame.exeptions.GameCharacteristicOutOfRangeException;
import javagame.models.characters.Character;

/**
 * Created by Roni on 4/3/2016.
 */
public class Player extends Character {
    public Player(String id) throws GameCharacteristicOutOfRangeException {
        super(id);
    }
}

package javagame.models.characters;

import javagame.contracts.CharacterInterface;
import javagame.exeptions.GameCharacteristicOutOfRangeException;
import javagame.models.GameObject;

/**
 * Created by Roni on 4/3/2016.
 */
public abstract class Character extends GameObject implements CharacterInterface {
    public Character(String id) throws GameCharacteristicOutOfRangeException {
        super(id);
    }
}

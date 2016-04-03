package javagame.models.characters.enemy;

import javagame.exeptions.GameCharacteristicOutOfRangeException;
import javagame.models.characters.Character;

public abstract class Enemy extends Character {
    public Enemy(String id) throws GameCharacteristicOutOfRangeException {
        super(id);
    }
}

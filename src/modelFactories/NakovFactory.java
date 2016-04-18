package modelFactories;

import contracts.Character;
import contracts.CharacterFactory;
import models.characters.NakovPlayer;

/**
 * Created by Roni on 4/18/2016.
 */
public class NakovFactory implements CharacterFactory {

    Character character;

    @Override
    public void CreateCharacter() {
        this.character = new NakovPlayer();
    }

    @Override
    public void MoveCharacter() {

    }
}


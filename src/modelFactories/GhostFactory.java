package modelFactories;

import contracts.Character;
import contracts.CharacterFactory;
import models.characters.GhostEnemy;

/// add interface and logic
public class GhostFactory implements CharacterFactory {

    Character character;

    @Override
    public void CreateCharacter() {
        this.character = new GhostEnemy();
    }

    public void MoveCharacter() {

    }
}

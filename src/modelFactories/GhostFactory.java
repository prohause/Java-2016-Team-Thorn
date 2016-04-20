package modelFactories;

import contracts.Character;
import contracts.CharacterFactory;
import models.characters.GhostEnemy;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;

/// add interface and logic
public class GhostFactory implements CharacterFactory {

    Character character;

    @Override
    public void CreateCharacter() {
        this.character = new GhostEnemy() {
            @Override
            public void setImage(Image image) {

            }

            @Override
            public void setMovingUp(Animation movingUp) {

            }

            @Override
            public void setMovingDown(Animation movingDown) {

            }

            @Override
            public void setMovingLeft(Animation movingLeft) {

            }

            @Override
            public void setMovingRight(Animation movingRight) {

            }
        };
    }

    public void MoveCharacter() {

    }
}

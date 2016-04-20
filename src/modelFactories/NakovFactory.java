package modelFactories;

import contracts.Character;
import contracts.CharacterFactory;
import javafx.animation.Animation;
import javafx.scene.image.Image;
import models.characters.NakovPlayer;

/**
 * Created by Roni on 4/18/2016.
 */
public class NakovFactory implements CharacterFactory {

    Character character;

    @Override
    public void CreateCharacter() {
        this.character = new NakovPlayer() {
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

    @Override
    public void MoveCharacter() {

    }
}


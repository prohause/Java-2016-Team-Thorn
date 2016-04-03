package javagame.models.items;

import javagame.contracts.ItemInterface;
import javagame.exeptions.GameCharacteristicOutOfRangeException;
import javagame.models.GameObject;

public abstract class Item extends GameObject implements ItemInterface{
    public Item(String id) throws GameCharacteristicOutOfRangeException {
        super(id);
    }
}

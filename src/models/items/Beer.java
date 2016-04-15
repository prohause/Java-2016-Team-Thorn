package models.items;

import contracts.Character;
import contracts.Item;

public class Beer implements Item{

    @Override
    public int getItemID() {
        return 0;
    }

    @Override
    public void applyItemEffect(Character character) {

    }
}

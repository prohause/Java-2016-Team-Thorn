package modelFactories;

import contracts.Character;
import contracts.Collectables;
import models.items.Item;

public abstract class ItemFactory {
    Collectables item;

    public void CreateItem() {
        this.item = new Item() {
            @Override
            public int getItemID() {
                return 0;
            }

            @Override
            public void applyItemEffect(Character character) {

            }
        };
    }
}


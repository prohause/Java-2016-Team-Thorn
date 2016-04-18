package modelFactories;

import contracts.Collectables;
import models.items.Item;

public class ItemFactory {
    Collectables item;

    public void CreateItem() {
        this.item = new Item();
    }
}


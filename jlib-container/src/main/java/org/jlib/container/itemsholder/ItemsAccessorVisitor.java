package org.jlib.container.itemsholder;

import org.jlib.core.traverser.Traversable;

public interface ItemsAccessorVisitor<Item, Result> {

    public Result visitItem(Item item);

    public Result visitTraversable(Traversable<? extends Item> items);

    public Result visitContainsItem(ContainsItem<? extends Item> items);

    public <ItemsHolder extends Traversable<? extends Item> & ContainsItem<? extends Item>> /*
        */ Result visitContainsItemTraversable(ItemsHolder items);
}

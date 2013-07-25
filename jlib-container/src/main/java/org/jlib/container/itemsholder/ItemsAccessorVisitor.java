package org.jlib.container.itemsholder;

import org.jlib.core.traverser.Traversable;

import org.jlib.container.ContainsItem;

public interface ItemsAccessorVisitor<Item, Result> {

    public Result visitTraversable(Traversable<? extends Item> items);

    public Result visitContainsItem(ContainsItem<? extends Item> items);

    public <ItemsHolder extends Traversable<? extends Item> & ContainsItem<? extends Item>> /*
        */ Result visitContainsItemTraversable(ItemsHolder items);
}

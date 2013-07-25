package org.jlib.container.itemsholder;

import org.jlib.core.traverser.Traversable;

import org.jlib.container.ContainsItem;

public class ContainsItemTraversableItemsAccessor<Item, ItemsHolder extends Traversable<? extends Item> & ContainsItem<? extends Item>>
implements ItemsAccessor<Item> {

    private final ItemsHolder itemsHolder;

    public ContainsItemTraversableItemsAccessor(final ItemsHolder itemsHolder) {
        super();

        this.itemsHolder = itemsHolder;
    }

    @Override
    public <Result> Result accept(ItemsAccessorVisitor<Item, Result> visitor) {
        return visitor.visitContainsItemTraversable(itemsHolder);
    }
}

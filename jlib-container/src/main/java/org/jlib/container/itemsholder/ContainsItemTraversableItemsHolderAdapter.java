package org.jlib.container.itemsholder;

import org.jlib.core.traverser.Traversable;

import org.jlib.container.ContainsItem;

public class ContainsItemTraversableItemsHolderAdapter<Item, ItemsHolder extends Traversable<? extends Item> & ContainsItem<? extends Item>>
implements ItemsHolderAdapter<Item> {

    private final ItemsHolder itemsHolder;

    public ContainsItemTraversableItemsHolderAdapter(final ItemsHolder itemsHolder) {
        super();

        this.itemsHolder = itemsHolder;
    }

    @Override
    public <Result> Result accept(ItemsHolderVisitor<Item, Result> visitor) {
        return visitor.visitContainsItemTraversable(itemsHolder);
    }
}

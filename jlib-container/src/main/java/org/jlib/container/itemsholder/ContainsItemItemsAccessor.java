package org.jlib.container.itemsholder;

import org.jlib.container.ContainsItem;

public class ContainsItemItemsAccessor<Item>
implements ItemsAccessor<Item> {

    private final ContainsItem<? extends Item> containsItem;

    public ContainsItemItemsAccessor(final ContainsItem<? extends Item> containsItem) {
        super();

        this.containsItem = containsItem;
    }

    @Override
    public <Result> Result accept(ItemsAccessorVisitor<Item, Result> visitor) {
        return visitor.visitContainsItem(containsItem);
    }
}

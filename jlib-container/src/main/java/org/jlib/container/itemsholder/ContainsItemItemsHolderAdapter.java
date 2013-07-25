package org.jlib.container.itemsholder;

import org.jlib.container.ContainsItem;

public class ContainsItemItemsHolderAdapter<Item>
implements ItemsHolderAdapter<Item> {

    private final ContainsItem<? extends Item> containsItem;

    public ContainsItemItemsHolderAdapter(final ContainsItem<? extends Item> containsItem) {
        super();

        this.containsItem = containsItem;
    }

    @Override
    public <Result> Result accept(ItemsHolderVisitor<Item, Result> visitor) {
        return visitor.visitContainsItem(containsItem);
    }
}

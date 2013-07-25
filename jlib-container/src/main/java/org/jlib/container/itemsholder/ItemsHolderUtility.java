package org.jlib.container.itemsholder;

import org.jlib.core.traverser.Traversable;

import org.jlib.container.ContainsItem;

public final class ItemsHolderUtility {

    public static <Item> ItemsAccessor<Item> allOf(final Traversable<? extends Item> items) {
        return new ItemsAccessor<Item>() {

            @Override
            public <Result> Result accept(final ItemsAccessorVisitor<Item, Result> visitor) {
                return visitor.visitTraversable(items);
            }
        };
    }

    public static <Item> ItemsAccessor<Item> allOf(final ContainsItem<? extends Item> items) {
        return new ItemsAccessor<Item>() {

            @Override
            public <Result> Result accept(final ItemsAccessorVisitor<Item, Result> visitor) {
                return visitor.visitContainsItem(items);
            }
        };
    }

    public static <Item, ItemsHolder extends Traversable<? extends Item> & ContainsItem<Item>> /*
        */ ItemsAccessor<Item> allOfX(final ItemsHolder items) {
        return new ItemsAccessor<Item>() {

            @Override
            public <Result> Result accept(final ItemsAccessorVisitor<Item, Result> visitor) {
                return visitor.visitContainsItemTraversable(items);
            }
        };
    }


    private ItemsHolderUtility() {
    }
}

package org.jlib.container.itemsholder;

public interface ItemsAccessor<Item> {

    <Result> Result accept(ItemsAccessorVisitor<Item, Result> visitor);
}

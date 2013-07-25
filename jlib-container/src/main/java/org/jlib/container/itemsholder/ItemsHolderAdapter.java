package org.jlib.container.itemsholder;

public interface ItemsHolderAdapter<Item> {

    <Result> Result accept(ItemsHolderVisitor<Item, Result> visitor);
}

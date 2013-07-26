package org.jlib.container.ItemsSupplier;

public interface ItemsSupplier<Item> {

    <Result> Result accept(ItemsSupplierVisitor<Item, Result> visitor);
}

package org.jlib.container.itemssupplier;

public interface ItemsSupplierVisitor<Item, Result> {

    public Result visitPerferTraverse(ItemsSupplier<Item> items);

    public Result visitPreferContainsSingle(ItemsSupplier<Item> items);

    public Result visitPreferContainsMany(ItemsSupplier<Item> items);
}

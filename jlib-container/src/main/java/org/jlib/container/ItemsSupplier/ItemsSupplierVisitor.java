package org.jlib.container.ItemsSupplier;

import org.jlib.core.traverser.Traversable;

public interface ItemsSupplierVisitor<Item, Result> {

    public Result visitItem(Item item);

    public Result visitTraversable(Traversable<? extends Item> items);

    public Result visitContainsSingle(ContainsSingle<Item> items);

    public Result visitContainsMany(ContainsMany<Item> items);

    public <ContainsSingleTraversable extends Traversable<Item> & ContainsSingle<Item>> /*
        */ Result visitContainsSingleTraversable(ContainsSingleTraversable items);

    public <ContainsManyTraversable extends Traversable<Item> & ContainsMany<Item>> /*
        */ Result visitContainsManyTraversable(ContainsManyTraversable items);
}

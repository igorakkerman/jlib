package org.jlib.container.ItemsSupplier;

import org.jlib.core.traverser.Traversable;

import org.jlib.container.ContainsByTraversable;
import org.jlib.container.ContainsSingle;

public interface ItemsSupplierVisitor<Item, Result> {

    public Result visitTraversable(Traversable<? extends Item> items);

    public Result visitContainsSingle(ContainsSingle<Item> items);

    public Result visitContainsMany(ContainsByTraversable<Item> items);

    public <ContainsSingleTraversable extends Traversable<Item> & ContainsSingle<Item>> /*
        */ Result visitContainsSingleTraversable(ContainsSingleTraversable items);

    public <ContainsManyTraversable extends Traversable<Item> & ContainsByTraversable<Item>> /*
        */ Result visitContainsManyTraversable(ContainsManyTraversable items);
}

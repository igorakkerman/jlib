package org.jlib.container.itemssupplier;

import java.util.Iterator;

import org.jlib.core.traverser.InvalidTraversableStateException;

public interface ItemsSupplier<Item> {

    public boolean contains(Item item)
    throws InvalidTraversableStateException;

    public boolean contains(Iterable<Item> items)
    throws InvalidTraversableStateException;

    public Iterator<Item> createIterator()
    throws InvalidTraversableStateException;

    public <Result> Result accept(ItemsSupplierVisitor<Item, Result> visitor);
}

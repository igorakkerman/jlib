package org.jlib.container;

import org.jlib.core.traverser.Traversable;

public interface GodContainer<Item>
extends ToRandomAccessList<Item>,
        ContainsItemsByContainsTraversable<Item>,
        RetainItemsByTraversable<Item>,
        RemoveItemByItem<Item>,
        RemoveAllItems<Item>,
        ObservedRetainItemsByTraversable<Item>,
        ObservedRemoveItemByItem<Item>,
        ObservedRemoveAllItems<Item>,
        ItemOperationStrategy<Item>,Traversable<Item>,
        Iterable<Item> {

}

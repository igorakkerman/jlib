package org.jlib.container;

import org.jlib.core.traverser.Traversable;

public interface GodContainer<Item>
extends Contains<Item>,
        GetCount<Item>,
        IsEmpty<Item>,
        ObservedRemove<Item>,
        ObservedRemoveAll<Item>,
        ObservedRetain<Item>,
        Remove<Item>,
        RemoveAll<Item>,
        Retain<Item>,
        ToArray<Item>,
        ToRandomAccessList<Item>,
        ToSequentialList<Item>,
        ToSet<Item>,
        Traversable<Item>,
        Iterable<Item> {
    // unifying
}

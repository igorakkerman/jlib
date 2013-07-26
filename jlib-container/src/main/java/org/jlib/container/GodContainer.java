package org.jlib.container;

import org.jlib.core.traverser.Traversable;

public interface GodContainer<Item>
extends ContainsSingle<Item>,
        ContainsMany<Item>,
        GetCount<Item>,
        IsEmpty<Item>,
        ObservedRemoveMany<Item>,
        ObservedRemoveAll<Item>,
        ObservedRetain<Item>,
        RemoveSingle<Item>,
        RemoveMany<Item>,
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

package org.jlib.container.operation;

public interface GodContainer<Item>
extends ContainsSingle<Item>,
        ContainsMany<Item>,
        GetCount<Item>,
        IsEmpty<Item>,
        ObservedRemoveMany<Item>,
        ObservedRemoveAll<Item>,
        ObservedRetain<Item>,
        RemoveSingleByItem<Item>,
        RemoveManyByItem<Item>,
        RemoveAll<Item>,
        Retain<Item>,
        ToArray<Item>,
        ToRandomAccessList<Item>,
        ToSequentialList<Item>,
        ToSet<Item>,
        Iterable<Item>,
        java.lang.Iterable {
    // unifying
}

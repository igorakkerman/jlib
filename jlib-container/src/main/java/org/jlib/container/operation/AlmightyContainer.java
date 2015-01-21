package org.jlib.container.operation;

public interface AlmightyContainer<Item>
extends ContainsSingle<Item>,
        ContainsMany<Item>,
        Count<Item>,
        IsEmpty<Item>,
        ObservedRemoveMany<Item>,
        ObservedRemoveAll<Item>,
        ObservedRetain<Item>,
        RemoveSingleByValue<Item>,
        RemoveManyByValue<Item>,
        RemoveAll<Item>,
        Retain<Item>,
        ToArray<Item>,
        ToRandomAccessList<Item>,
        ToSequentialList<Item>,
        ToSet<Item>,
        Iterable<Item> {
    // unifying
}

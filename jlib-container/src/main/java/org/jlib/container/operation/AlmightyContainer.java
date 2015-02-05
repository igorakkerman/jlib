package org.jlib.container.operation;

public interface AlmightyContainer<Item>
extends ContainsSingle<Item>,
        ContainsMultiple<Item>,
        Count<Item>,
        IsEmpty<Item>,
        ObservedRemoveMultiple<Item>,
        ObservedRemoveAll<Item>,
        ObservedRetain<Item>,
        RemoveSingleByValue<Item>,
        RemoveMultipleByValue<Item>,
        RemoveAll<Item>,
        Retain<Item>,
        ToArray<Item>,
        ToRandomAccessList<Item>,
        ToSequentialList<Item>,
        ToSet<Item>,
        Iterable<Item> {
    // unifying
}

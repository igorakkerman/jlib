package org.jlib.container.itemssupplier;

import org.jlib.container.ContainsByIterable;
import org.jlib.container.ContainsSingle;

public interface ItemsSupplier<Item>
extends Iterable<Item>,
        ContainsSingle<Item>,
        ContainsByIterable<Item>,
        ItemsSupplierHost<Item> {
}

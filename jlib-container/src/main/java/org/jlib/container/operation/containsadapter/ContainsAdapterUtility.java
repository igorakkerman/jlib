package org.jlib.container.operation.containsadapter;

import java.util.Collection;

import org.jlib.core.array.ArrayUtility;

import org.jlib.container.operation.ContainsSingle;
import org.jlib.container.operation.InvalidContainerArgumentException;
import org.jlib.container.operation.InvalidContainerStateException;

import static org.jlib.core.iterator.TraversableUtility.singletonTraversable;
import static org.jlib.core.iterator.TraversableUtility.traversable;

public final class ContainsAdapterUtility {

    public static <Item> ContainsAdapter<Item> item(final Item suppliedItem) {

        return new ContainsAdapter<Item>(singletonTraversable(suppliedItem)) {

            @Override
            public boolean contains(final Item item)
            throws InvalidContainerArgumentException, InvalidContainerStateException {
                return suppliedItem.equals(item);
            }
        };
    }

    public static <Item, ContainsSingleTraversable extends ContainsSingle<Item> & Iterable<Item>> /*
               */ ContainsAdapter<Item> allOf(final ContainsSingleTraversable items) {

        return new ContainsAdapter<Item>(items) {

            @Override
            public boolean contains(final Item item)
            throws InvalidContainerArgumentException, InvalidContainerStateException {
                return items.contains(item);
            }
        };
    }

    public static <Item> ContainsAdapter<Item> allOf(final Iterable<Item> items) {

        return new IterativeContainsAdapter<>(items);
    }

    public static <Item> ContainsAdapter<Item> allOf(final Collection<Item> items) {

        return new ContainsAdapter<Item>(traversable(items)) {

            @Override
            public boolean contains(final Item item)
            throws InvalidContainerArgumentException, InvalidContainerStateException {
                return items.contains(item);
            }
        };
    }

    @SafeVarargs
    public static <Item> ContainsAdapter<Item> allOf(final Item... items) {

        return new IterativeContainsAdapter<>(ArrayUtility.traversable(items));
    }

    /** no visible constructor */
    private ContainsAdapterUtility() {
        // no visible constructor
    }
}

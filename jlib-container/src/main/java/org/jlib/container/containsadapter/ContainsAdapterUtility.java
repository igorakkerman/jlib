package org.jlib.container.containsadapter;

import java.util.Collection;

import org.jlib.core.array.ArrayIterable;
import org.jlib.core.traverser.InvalidTraversableArgumentException;
import org.jlib.core.traverser.InvalidTraversableStateException;
import org.jlib.core.traverser.Traversable;
import org.jlib.core.traverser.TraversableIterable;

import org.jlib.container.ContainsSingle;

import static java.util.Collections.singleton;

public final class ContainsAdapterUtility {

    public static <Item> ContainsAdapter<Item> item(final Item suppliedItem) {

        return new ContainsAdapter<Item>(singleton(suppliedItem)) {

            @Override
            public boolean contains(final Item item)
            throws InvalidTraversableArgumentException, InvalidTraversableStateException {
                return suppliedItem.equals(item);
            }
        };
    }

    public static <Item, ContainsSingleTraversable extends ContainsSingle<Item> & Traversable<Item>> /*
               */ ContainsAdapter<Item> allOf(final ContainsSingleTraversable items) {

        return new ContainsAdapter<Item>(new TraversableIterable<>(items)) {

            @Override
            public boolean contains(final Item item)
            throws InvalidTraversableArgumentException, InvalidTraversableStateException {
                return items.contains(item);
            }
        };
    }

    public static <Item> ContainsAdapter<Item> allOf(final Traversable<Item> items) {

        return new IterativeContainsAdapter<>(new TraversableIterable<>(items));
    }

    public static <Item> ContainsAdapter<Item> allOf(final Collection<Item> items) {

        return new ContainsAdapter<Item>(items) {

            @Override
            public boolean contains(final Item item)
            throws InvalidTraversableArgumentException, InvalidTraversableStateException {
                return items.contains(item);
            }
        };
    }

    @SafeVarargs
    public static <Item> ContainsAdapter<Item> allOf(final Item... items) {

        return new IterativeContainsAdapter<>(new ArrayIterable<>(items));
    }

    public static <Item> ContainsAdapter<Item> allOf(final Iterable<Item> items) {

        return new IterativeContainsAdapter<>(items);
    }

    private ContainsAdapterUtility() {
    }
}

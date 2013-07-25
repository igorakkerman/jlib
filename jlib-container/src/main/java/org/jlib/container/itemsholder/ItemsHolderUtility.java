package org.jlib.container.itemsholder;

import java.util.Collection;

import org.jlib.core.traverser.InvalidTraversableArgumentException;
import org.jlib.core.traverser.InvalidTraversableStateException;
import org.jlib.core.traverser.IterableTraversable;
import org.jlib.core.traverser.Traversable;
import org.jlib.core.traverser.Traverser;

import org.jlib.container.ContainsItem;

public final class ItemsHolderUtility {

    public static <Item> ItemsHolderAdapter<Item> allOf(final Collection<Item> items) {
        return new ContainsItemTraversableItemsHolderAdapter<>(items);
    }

    public static interface ContainsItemTraversableItemsHolderAdapter<Item>
    extends Traversable<Item>,
            ContainsItem<Item> {
        // unifying interface
    }

    private static class CollectionAdapter<Item> implements ContainsItemTraversableItemsHolderAdapter<Item> {

        private final Collection<Item> items;

        private CollectionAdapter(final Collection<Item> items) {
            super();

            this.items = items;
        }

        @Override
        public boolean containsItem(final Item item)
        throws InvalidTraversableArgumentException, InvalidTraversableStateException {
            return items.contains(item);
        }

        @Override
        public Traverser<Item> createTraverser() {

            // TODO: create static method in appropriate place
            return new IterableTraversable<>(items).createTraverser();
        }
    }

    private ItemsHolderUtility() {
    }
}

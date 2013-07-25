package org.jlib.container.itemsholder;

import java.util.Collection;

import org.jlib.core.traverser.InvalidTraversableArgumentException;
import org.jlib.core.traverser.InvalidTraversableStateException;
import org.jlib.core.traverser.IterableTraversable;
import org.jlib.core.traverser.Traversable;
import org.jlib.core.traverser.Traverser;

import org.jlib.container.ContainsItem;

public final class ItemsHolderUtility {

    public static <Item> ItemsAccessor<Item> allOf(final Traversable<Item> items) {
        return new ItemsAccessor<Item>() {

            @Override
            public <Result> Result accept(final ItemsAccessorVisitor<Item, Result> visitor) {
                return visitor.visitTraversable(items);
            }
        };
    }

    public static <Item> ItemsAccessor<Item> allOf(final ContainsItem<Item> items) {
        return new ItemsAccessor<Item>() {

            @Override
            public <Result> Result accept(final ItemsAccessorVisitor<Item, Result> visitor) {
                return visitor.visitContainsItem(items);
            }
        };
    }

    public static <Item, ItemsHolder extends Traversable<Item> & ContainsItem<Item>> /*
        */ ItemsAccessor<Item> allOfX(final ItemsHolder items) {
        return new ItemsAccessor<Item>() {

            @Override
            public <Result> Result accept(final ItemsAccessorVisitor<Item, Result> visitor) {
                return visitor.visitContainsItemTraversable(items);
            }
        };
    }

    public static interface TraversableContainsItem<Item>
    extends Traversable<Item>,
            ContainsItem<Item> {
        // unifying interface
    }

    public static class CollectionContainsItemTraversable<Item>
    implements Traversable<Item>,
               ContainsItem<Item> {

        private final Collection<Item> items;

        public CollectionContainsItemTraversable(final Collection<Item> items) {
            super();

            this.items = items;
        }

        @Override
        public boolean containsItem(final Item item)
        throws InvalidTraversableArgumentException, InvalidTraversableStateException {
            return items.contains(item);
        }

        @Override
        @SuppressWarnings("unchecked") // TODO: find out why
        public Traverser<Item> createTraverser() {
            return new IterableTraversable(items).createTraverser();
        }
    }

    @SuppressWarnings("unchecked") // TODO: find out why
    public static <Item> ItemsAccessor<Item> allOf(final Collection<Item> items) {
        return allOfX(new CollectionContainsItemTraversable(items));
    }

    private ItemsHolderUtility() {
    }
}

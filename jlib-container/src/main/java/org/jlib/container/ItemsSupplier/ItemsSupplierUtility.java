package org.jlib.container.itemssupplier;

import java.util.Collection;

import org.jlib.core.array.ArrayTraverser;
import org.jlib.core.traverser.InvalidTraversableArgumentException;
import org.jlib.core.traverser.InvalidTraversableStateException;
import org.jlib.core.traverser.IterableTraverser;
import org.jlib.core.traverser.Traversable;
import org.jlib.core.traverser.Traverser;

import org.jlib.container.Contains;
import org.jlib.container.ContainsByTraversable;

public final class ItemsSupplierUtility {

    public static abstract class PreferTraverseItemsSupplier<Item>
    implements ItemsSupplier<Item> {

        private final ItemsSupplier<Item> items;

        protected PreferTraverseItemsSupplier(final ItemsSupplier<Item> items) {
            super();

            this.items = items;
        }

        @Override
        public <Result> Result accept(final ItemsSupplierVisitor<Item, Result> visitor) {
            return visitor.visitPerferTraverse(items);
        }
    }

    public static abstract class PreferContainsSingleItemsSupplier<Item>
    implements ItemsSupplier<Item> {

        private final ItemsSupplier<Item> items;

        protected PreferContainsSingleItemsSupplier(final ItemsSupplier<Item> items) {
            super();

            this.items = items;
        }

        @Override
        public <Result> Result accept(final ItemsSupplierVisitor<Item, Result> visitor) {
            return visitor.visitPreferContainsSingle(items);
        }
    }

    public static abstract class PreferContainsManyItemsSupplier<Item>
    implements ItemsSupplier<Item> {

        private final ItemsSupplier<Item> items;

        protected PreferContainsManyItemsSupplier(final ItemsSupplier<Item> items) {
            super();

            this.items = items;
        }

        @Override
        public <Result> Result accept(final ItemsSupplierVisitor<Item, Result> visitor) {
            return visitor.visitPreferContainsMany(items);
        }
    }

    public static <Item> items<Item> allOfContainsSingle(final Contains<Item> items) {
        return new items<Item>() {

            @Override
            public <Result> Result accept(final ItemsSupplierVisitor<Item, Result> visitor) {
                return visitor.visitPreferContainsSingle(items);
            }
        };
    }

    public static <Item, TraversableContains extends Traversable<Item> & Contains<Item>> /*
        */ items<Item> allOfContainsSingleTraverable(final TraversableContains items) {
        return new items<Item>() {

            @Override
            public <Result> Result accept(final ItemsSupplierVisitor<Item, Result> visitor) {
                return visitor.visitContainsSingleTraversable(items);
            }
        };
    }

    public static <Item> items<Item> allOfContainsMany(final ContainsByTraversable<Item> items) {
        return new items<Item>() {

            @Override
            public <Result> Result accept(final ItemsSupplierVisitor<Item, Result> visitor) {
                return visitor.visitPreferContainsMany(items);
            }
        };
    }

    public static <Item, TraversableContains extends Traversable<Item> & ContainsByTraversable<Item>> /*
        */ items<Item> allOfContainsManyTraversable(final TraversableContains items) {
        return new items<Item>() {

            @Override
            public <Result> Result accept(final ItemsSupplierVisitor<Item, Result> visitor) {
                return visitor.visitContainsManyTraversable(items);
            }
        };
    }

    public static interface ContainsSingleTraversable<Item>
    extends Traversable<Item>,
            Contains<Item> {
        // unifying interface
    }

    public static interface ContainsManyTraversable<Item>
    extends Traversable<Item>,
            ContainsByTraversable<Item> {
        // unifying interface
    }

    public static <Item> items<Item> allOf(final Collection<Item> items) {

        return allOfContainsSingleTraverable(new ContainsSingleTraversable<Item>() {

            @Override
            public boolean contains(final Item item)
            throws InvalidTraversableArgumentException, InvalidTraversableStateException {
                return items.contains(item);
            }

            @Override
            public Traverser<Item> createTraverser() {
                return new IterableTraverser<>(items);
            }
        });
    }

    @SafeVarargs
    public static <Item> ItemsSupplier<Item> allOf(final Item... items) {

        return allOfTraversable(new Traversable<Item>() {

            @Override
            public Traverser<Item> createTraverser() {
                return new ArrayTraverser<>(items);
            }
        });
    }

    public static <Item> ItemsSupplier<Item> allOf(final Iterable<Item> items) {

        return allOfTraversable(new Traversable<Item>() {

            @Override
            public Traverser<Item> createTraverser() {
                return new IterableTraverser<>(items);
            }
        });
    }

    private itemsUtility() {
    }
}

package org.jlib.container.ItemsSupplier;

import java.util.Collection;

import org.jlib.core.array.ArrayTraverser;
import org.jlib.core.traverser.InvalidTraversableArgumentException;
import org.jlib.core.traverser.InvalidTraversableStateException;
import org.jlib.core.traverser.IterableTraverser;
import org.jlib.core.traverser.Traversable;
import org.jlib.core.traverser.Traverser;

import org.jlib.container.ContainsByTraversable;
import org.jlib.container.ContainsSingle;

public final class ItemsSupplierUtility {

    public static <Item> ItemsSupplier<Item> allOfTraversable(final Traversable<Item> items) {
        return new ItemsSupplier<Item>() {

            @Override
            public <Result> Result accept(final ItemsSupplierVisitor<Item, Result> visitor) {
                return visitor.visitTraversable(items);
            }
        };
    }

    public static <Item> ItemsSupplier<Item> allOfContainsSingle(final ContainsSingle<Item> items) {
        return new ItemsSupplier<Item>() {

            @Override
            public <Result> Result accept(final ItemsSupplierVisitor<Item, Result> visitor) {
                return visitor.visitContainsSingle(items);
            }
        };
    }

    public static <Item, TraversableContains extends Traversable<Item> & ContainsSingle<Item>> /*
        */ ItemsSupplier<Item> allOfContainsSingleTraverable(final TraversableContains items) {
        return new ItemsSupplier<Item>() {

            @Override
            public <Result> Result accept(final ItemsSupplierVisitor<Item, Result> visitor) {
                return visitor.visitContainsSingleTraversable(items);
            }
        };
    }

    public static <Item> ItemsSupplier<Item> allOfContainsMany(final ContainsByTraversable<Item> items) {
        return new ItemsSupplier<Item>() {

            @Override
            public <Result> Result accept(final ItemsSupplierVisitor<Item, Result> visitor) {
                return visitor.visitContainsMany(items);
            }
        };
    }

    public static <Item, TraversableContains extends Traversable<Item> & ContainsByTraversable<Item>> /*
        */ ItemsSupplier<Item> allOfContainsManyTraversable(final TraversableContains items) {
        return new ItemsSupplier<Item>() {

            @Override
            public <Result> Result accept(final ItemsSupplierVisitor<Item, Result> visitor) {
                return visitor.visitContainsManyTraversable(items);
            }
        };
    }

    public static interface ContainsSingleTraversable<Item>
    extends Traversable<Item>,
            ContainsSingle<Item> {
        // unifying interface
    }

    public static interface ContainsManyTraversable<Item>
    extends Traversable<Item>,
            ContainsByTraversable<Item> {
        // unifying interface
    }

    public static <Item> ItemsSupplier<Item> allOf(final Collection<Item> items) {

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

    private ItemsSupplierUtility() {
    }
}

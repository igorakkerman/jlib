package org.jlib.container.sequence.index.array;

import java.util.Collection;

import org.jlib.container.Container;
import org.jlib.container.IllegalContainerArgumentException;
import org.jlib.container.sequence.ObservedPrependSequence;
import org.jlib.container.sequence.Sequence;
import org.jlib.core.observer.ValueObserver;

import static org.jlib.container.sequence.SequenceUtility.singleton;
import static org.jlib.core.array.ArrayUtility.iterable;

/**
 * {@link ReplaceAppendArraySequence} from which Items can be hd at its ends,
 * that is, its head and tail.
 * 
 * @param <Item>
 *        type of items held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public class ReplaceAppendPrependArraySequence<Item>
extends ReplaceAppendArraySequence<Item>
implements ObservedPrependSequence<Item> {

    /**
     * Creates a new {@link ReplaceAppendPrependArraySequence} with the
     * specified first and last indices.
     * 
     * @param firstIndex
     *        integer specifying the first index
     * 
     * @param lastIndex
     *        integer specifying the last index
     * 
     * @throws IllegalArgumentException
     *         if {@code lastIndex > firstIndex}
     */
    protected ReplaceAppendPrependArraySequence(final int firstIndex, final int lastIndex) {
        super(firstIndex, lastIndex);
    }

    @Override
    public void prepend(final Item item) {
        // intentionally not using SequenceUtility for efficiency
        prepend(singleton(item));
    }

    @Override
    public void prepend(final Container<? extends Item> items) {
        // intentionally not using SequenceUtility for efficiency
        prepend(items, items.getItemsCount());
    }

    @Override
    public void prepend(final Collection<? extends Item> items) {
        // intentionally not using SequenceUtility for efficiency
        prepend(items, items.size());
    }

    @Override
    @SuppressWarnings("unchecked")
    public final void prepend(final Item... items) {
        // intentionally not using SequenceUtility for efficiency
        prepend(iterable(items), items.length);
    }

    @Override
    @SuppressWarnings("unchecked")
    public final void prepend(final Item item, final ValueObserver<Item>... observers)
    throws IllegalContainerArgumentException {
        prepend(singleton(item), 1, observers);
    }

    @Override
    @SuppressWarnings("unchecked")
    public final void prepend(final Container<? extends Item> items, final ValueObserver<Item>... observers)
    throws IllegalContainerArgumentException {
        prepend(items, items.getItemsCount(), observers);
    }

    @Override
    @SuppressWarnings("unchecked")
    public final void prepend(final Collection<? extends Item> items, final ValueObserver<Item>... observers)
    throws IllegalContainerArgumentException {
        prepend(items, items.size(), observers);
    }

    @Override
    @SuppressWarnings("unchecked")
    public final void prepend(final ValueObserver<Item>[] observers, final Item... items)
    throws IllegalContainerArgumentException {
        prepend(iterable(items), items.length, observers);
    }

    /**
     * Prepends all Items contained by the specified {@link Container} to this
     * {@link ObservedPrependSequence}.
     * 
     * @param items
     *        {@link Iterable} providing the Items to add
     * 
     * @param prependedItemsCount
     *        integer specifying the number of added Items; {@code items} must
     *        provide at least these {@code addedItemsCount} Items
     * 
     * @param observers
     *        comma separated sequence of {@link ValueObserver} instances
     *        attending the operation
     * 
     * @throws RuntimeException
     *         if a {@link ValueObserver} operation throws this
     *         {@link RuntimeException}
     */
    @SafeVarargs
    private final void prepend(final Iterable<? extends Item> items, final int prependedItemsCount,
                               final ValueObserver<Item>... observers) {
        assertCapacityWithHole(getItemsCount() + prependedItemsCount, 0, prependedItemsCount);

        int itemArrayIndex = 0;

        for (final Item item : items)
            replaceDelegateArrayItem(item, itemArrayIndex ++, observers);

        setFirstIndex(getFirstIndex() - prependedItemsCount);
    }
}

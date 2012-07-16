package org.jlib.container.sequence.index.array;

import java.util.Collection;

import org.jlib.core.observer.ValueObserver;

import static org.jlib.core.array.ArrayUtility.iterable;

import org.jlib.container.Container;
import org.jlib.container.IllegalContainerArgumentException;
import org.jlib.container.sequence.InvalidSequenceItemsCountException;
import org.jlib.container.sequence.ObservedPrependSequence;
import org.jlib.container.sequence.Sequence;
import org.jlib.container.sequence.index.InvalidSequenceIndexRangeException;

import static org.jlib.container.sequence.SequenceUtility.singleton;

/**
 * {@link ReplaceAppendArraySequence} from which Items can be hd at its ends,
 * that is, its head and tail.
 * 
 * @param <Item>
 *        type of items held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public class ReplacePrependAppendArraySequence<Item>
extends ReplaceAppendArraySequence<Item>
implements ObservedPrependSequence<Item> {

    /**
     * Creates a new uninitialized {@link ReplacePrependAppendArraySequence}
     * with the specified first and last indices.
     * 
     * @param firstIndex
     *        integer specifying the initial first index
     * 
     * @param lastIndex
     *        integer specifying the initial last index
     * 
     * @throws InvalidSequenceIndexRangeException
     *         if {@code lastIndex < firstIndex}
     */
    protected ReplacePrependAppendArraySequence(final int firstIndex, final int lastIndex)
    throws InvalidSequenceIndexRangeException {
        super(firstIndex, lastIndex);
    }

    /**
     * Creates a new {@link ReplacePrependAppendArraySequence} with a first
     * index of {@code 0} and the specified number of Items.
     * 
     * @param itemsCount
     *        integer specifying the initial number of Items
     * 
     * @throws InvalidSequenceItemsCountException
     *         if {@code itemsCount < 1}
     */
    protected ReplacePrependAppendArraySequence(final int itemsCount)
    throws InvalidSequenceItemsCountException {
        super(itemsCount);
    }

    /**
     * Creates a new {@link ReplacePrependAppendArraySequence} with a first
     * index of {@code 0} containing the specified Items.
     * 
     * @param items
     *        comma separated sequence of Items to store
     */
    @SafeVarargs
    public ReplacePrependAppendArraySequence(final Item... items) {
        super(items);
    }

    /**
     * Creates a new {@link ReplacePrependAppendArraySequence} with the
     * specified first index containing the specified Items.
     * 
     * @param firstIndex
     *        integer specifying the first index
     * 
     * @param items
     *        comma separated sequence of Items to store
     */
    @SafeVarargs
    public ReplacePrependAppendArraySequence(final int firstIndex, final Item... items) {
        super(firstIndex, items);
    }

    /**
     * Creates a new {@link ReplacePrependAppendArraySequence} with a first
     * index of {@code 0} containing the specified Items.
     * 
     * @param items
     *        {@link Collection} of Items to store
     */
    public ReplacePrependAppendArraySequence(final Collection<? extends Item> items) {
        super(items);
    }

    /**
     * Creates a new {@link ReplacePrependAppendArraySequence} with the
     * specified first index containing the specified Items.
     * 
     * @param firstIndex
     *        integer specifying the first index
     * 
     * @param items
     *        {@link Collection} of Items to store
     */
    public ReplacePrependAppendArraySequence(final int firstIndex, final Collection<? extends Item> items) {
        super(firstIndex, items);
    }

    /**
     * Creates a new {@link ReplacePrependAppendArraySequence} with a first
     * index of {@code 0} containing the specified Items.
     * 
     * @param items
     *        {@link Container} of Items to store
     */
    public ReplacePrependAppendArraySequence(final Container<? extends Item> items) {
        super(items);
    }

    /**
     * Creates a new {@link ReplacePrependAppendArraySequence} with the
     * specified first index containing the specified Items.
     * 
     * @param firstIndex
     *        integer specifying the first index
     * 
     * @param items
     *        {@link Container} of Items to store
     */
    public ReplacePrependAppendArraySequence(final int firstIndex, final Container<? extends Item> items) {
        super(firstIndex, items);
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

    // FIXME: implement
    private final void prepend(final Iterable<? extends Item> items, final int prependedItemsCount) {

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
            replaceDelegateArrayItem(itemArrayIndex ++, item, observers);

        setFirstIndex(getFirstIndex() - prependedItemsCount);
    }
}

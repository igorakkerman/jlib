package org.jlib.container.sequence.index.array;

import java.util.Collection;

import org.jlib.core.observer.ValueObserver;

import org.jlib.container.ContainerUtility;
import org.jlib.container.ObservedRemoveAllContainer;
import org.jlib.container.sequence.IllegalSequenceStateException;
import org.jlib.container.sequence.InvalidSequenceItemsCountException;
import org.jlib.container.sequence.Sequence;
import org.jlib.container.sequence.index.InvalidSequenceIndexRangeException;

/**
 * {@link ReplaceInsertArraySequence} to which Items can be added.
 * 
 * @param <Item>
 *        type of items held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public class ReplaceInsertRemoveAllArraySequence<Item>
extends ReplaceInsertRemoveArraySequence<Item>
implements ObservedRemoveAllContainer<Item> {

    /**
     * Creates a new uninitialized {@link ReplaceInsertRemoveAllArraySequence}
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
    protected ReplaceInsertRemoveAllArraySequence(final int firstIndex, final int lastIndex)
    throws InvalidSequenceIndexRangeException {
        super(firstIndex, lastIndex);
    }

    /**
     * Creates a new {@link ReplaceInsertRemoveAllArraySequence} with a first
     * index of {@code 0} and the specified number of Items.
     * 
     * @param itemsCount
     *        integer specifying the initial number of Items
     * 
     * @throws InvalidSequenceItemsCountException
     *         if {@code itemsCount < 1}
     */
    protected ReplaceInsertRemoveAllArraySequence(final int itemsCount)
    throws InvalidSequenceItemsCountException {
        super(itemsCount);
    }

    /**
     * Creates a new {@link ReplaceInsertRemoveAllArraySequence} with a first
     * index of {@code 0} containing the specified Items.
     * 
     * @param items
     *        comma separated sequence of Items to store
     */
    @SafeVarargs
    public ReplaceInsertRemoveAllArraySequence(final Item... items) {
        super(items);
    }

    /**
     * Creates a new {@link ReplaceInsertRemoveAllArraySequence} with the
     * specified first index containing the specified Items.
     * 
     * @param firstIndex
     *        integer specifying the first index
     * 
     * @param items
     *        comma separated sequence of Items to store
     */
    @SafeVarargs
    public ReplaceInsertRemoveAllArraySequence(final int firstIndex, final Item... items) {
        super(firstIndex, items);
    }

    /**
     * Creates a new {@link ReplaceInsertRemoveAllArraySequence} with a first
     * index of {@code 0} containing the specified Items.
     * 
     * @param items
     *        {@link Collection} of Items to store
     */
    public ReplaceInsertRemoveAllArraySequence(final Collection<? extends Item> items) {
        super(items);
    }

    /**
     * Creates a new {@link ReplaceInsertRemoveAllArraySequence} with the
     * specified first index containing the specified Items.
     * 
     * @param firstIndex
     *        integer specifying the first index
     * 
     * @param items
     *        {@link Collection} of Items to store
     */
    public ReplaceInsertRemoveAllArraySequence(final int firstIndex, final Collection<? extends Item> items) {
        super(firstIndex, items);
    }

    /**
     * Creates a new {@link ReplaceInsertRemoveAllArraySequence} with a first
     * index of {@code 0} containing the specified Items.
     * 
     * @param items
     *        {@link Sequence} of Items to store
     */
    public ReplaceInsertRemoveAllArraySequence(final Sequence<? extends Item> items) {
        super(items);
    }

    /**
     * Creates a new {@link ReplaceInsertRemoveAllArraySequence} with the
     * specified first index containing the specified Items.
     * 
     * @param firstIndex
     *        integer specifying the first index
     * 
     * @param items
     *        {@link Sequence} of Items to store
     */
    public ReplaceInsertRemoveAllArraySequence(final int firstIndex, final Sequence<? extends Item> items) {
        super(firstIndex, items);
    }

    @Override
    public void removeAll()
    throws IllegalSequenceStateException {
        ContainerUtility.removeAll(this);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void removeAll(final ValueObserver<Item>... observers)
    throws IllegalSequenceStateException {
        ContainerUtility.removeAll(this, observers);
    }
}

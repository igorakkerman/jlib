package org.jlib.container.sequence.index.array;

import java.util.Collection;

import org.jlib.core.observer.ValueObserver;

import org.jlib.container.Container;
import org.jlib.container.sequence.InvalidSequenceItemsCountException;
import org.jlib.container.sequence.Sequence;
import org.jlib.container.sequence.index.DefaultReplaceIndexSequenceTraverser;
import org.jlib.container.sequence.index.InvalidSequenceIndexRangeException;
import org.jlib.container.sequence.index.ObservedReplaceIndexSequence;
import org.jlib.container.sequence.index.ObservedReplaceIndexSequenceTraverser;
import org.jlib.container.sequence.index.ReplaceIndexSequence;
import org.jlib.container.sequence.index.SequenceIndexOutOfBoundsException;
import org.jlib.container.sequence.index.SubReplaceIndexSequence;

/**
 * {@link ArraySequence} allowing its Items to be replaced.
 * 
 * @param <Item>
 *        type of the items of the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public class ReplaceArraySequence<Item>
extends ArraySequence<Item>
implements ObservedReplaceIndexSequence<Item> {

    /**
     * Creates a new uninitialized {@link ReplaceArraySequence} with the
     * specified first and last indices.
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
    protected ReplaceArraySequence(final int firstIndex, final int lastIndex)
    throws InvalidSequenceIndexRangeException {
        super(firstIndex, lastIndex);
    }

    /**
     * Creates a new {@link ReplaceArraySequence} with a first index of
     * {@code 0} and the specified number of Items.
     * 
     * @param itemsCount
     *        integer specifying the initial number of Items
     * 
     * @throws InvalidSequenceItemsCountException
     *         if {@code itemsCount < 1}
     */
    protected ReplaceArraySequence(final int itemsCount)
    throws InvalidSequenceItemsCountException {
        super(itemsCount);
    }

    /**
     * Creates a new {@link ReplaceArraySequence} with a first index of
     * {@code 0} containing the specified Items.
     * 
     * @param items
     *        comma separated sequence of Items to store
     */
    @SafeVarargs
    public ReplaceArraySequence(final Item... items) {
        super(items);
    }

    /**
     * Creates a new {@link ReplaceArraySequence} with the specified first index
     * containing the specified Items.
     * 
     * @param firstIndex
     *        integer specifying the first index
     * 
     * @param items
     *        comma separated sequence of Items to store
     */
    @SafeVarargs
    public ReplaceArraySequence(final int firstIndex, final Item... items) {
        super(firstIndex, items);
    }

    /**
     * Creates a new {@link ReplaceArraySequence} with a first index of
     * {@code 0} containing the specified Items.
     * 
     * @param items
     *        {@link Collection} of Items to store
     */
    public ReplaceArraySequence(final Collection<? extends Item> items) {
        super(items);
    }

    /**
     * Creates a new {@link ReplaceArraySequence} with the specified first index
     * containing the specified Items.
     * 
     * @param firstIndex
     *        integer specifying the first index
     * 
     * @param items
     *        {@link Collection} of Items to store
     */
    public ReplaceArraySequence(final int firstIndex, final Collection<? extends Item> items) {
        super(firstIndex, items);
    }

    /**
     * Creates a new {@link ReplaceArraySequence} with a first index of
     * {@code 0} containing the specified Items.
     * 
     * @param items
     *        {@link Container} of Items to store
     */
    public ReplaceArraySequence(final Container<? extends Item> items) {
        super(items);
    }

    /**
     * Creates a new {@link ReplaceArraySequence} with the specified first index
     * containing the specified Items.
     * 
     * @param firstIndex
     *        integer specifying the first index
     * 
     * @param items
     *        {@link Container} of Items to store
     */
    public ReplaceArraySequence(final int firstIndex, final Container<? extends Item> items) {
        super(firstIndex, items);
    }

    @Override
    // raising visibility from protected to public
    public void replace(final int index, final Item newItem)
    throws SequenceIndexOutOfBoundsException {
        super.replace(index, newItem);
    }

    @Override
    @SafeVarargs
    // raising visibility from protected to public
    public final void replace(final int index, final Item newItem, final ValueObserver<Item>... observers)
    throws SequenceIndexOutOfBoundsException {
        super.replace(index, newItem, observers);
    }

    @Override
    public ReplaceIndexSequence<Item> getSubsequenceView(final int fromIndex, final int toIndex)
    throws SequenceIndexOutOfBoundsException, InvalidSequenceIndexRangeException {
        return new SubReplaceIndexSequence<>(this, fromIndex, toIndex);
    }

    @Override
    public ObservedReplaceIndexSequenceTraverser<Item> createTraverser()
    throws SequenceIndexOutOfBoundsException {
        return new DefaultReplaceIndexSequenceTraverser<>(this);
    }

    @Override
    public ObservedReplaceIndexSequenceTraverser<Item> createTraverser(final int startIndex)
    throws SequenceIndexOutOfBoundsException {
        return new DefaultReplaceIndexSequenceTraverser<>(this, startIndex);
    }

    @Override
    @SuppressWarnings("unchecked")
    public ObservedReplaceIndexSequenceTraverser<Item> createTraverser(final ValueObserver<Item>... observers) {
        ObservedReplaceIndexSequenceTraverser<Item> traverser = createTraverser();
        traverser.
    }
}

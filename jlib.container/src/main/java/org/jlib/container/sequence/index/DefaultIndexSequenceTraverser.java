package org.jlib.container.sequence.index;

import org.jlib.container.sequence.AbstractSequenceTraverser;
import org.jlib.container.sequence.NoNextItemException;
import org.jlib.container.sequence.NoPreviousItemException;
import org.jlib.container.sequence.Sequence;
import org.jlib.core.reference.InitializedValueHolder;
import org.jlib.core.reference.NoValueSetException;
import org.jlib.core.reference.UninitializedValueHolder;
import org.jlib.core.reference.ValueHolder;

/**
 * Default implementation of an {@link IndexSequenceTraverser}.
 * 
 * @param <Item>
 *        type of items held in the {@link Sequence}
 * 
 * @param <Sequenze>
 *        type of the traversed {@link IndexSequence}
 * 
 * @author Igor Akkerman
 */
public class DefaultIndexSequenceTraverser<Item, Sequenze extends IndexSequence<Item>>
extends AbstractSequenceTraverser<Item, Sequenze>
implements IndexSequenceTraverser<Item> {

    /** index of the next traversed Item */
    private int nextItemIndex;

    /** {@link ValueHolder} for the index of the last accessed Item */
    private ValueHolder<Integer> lastAccessedItemIndexHolder = new UninitializedValueHolder<Integer>() {

        @Override
        public void set(final Integer index) {
            lastAccessedItemIndexHolder = new InitializedValueHolder<Integer>(index);
        }
    };

    /**
     * Creates a new {@link DefaultIndexSequenceTraverser} over the Items of the
     * specified {@link IndexSequence} beginning at its first index.
     * 
     * @param sequence
     *        {@link IndexSequence} to traverse
     */
    public DefaultIndexSequenceTraverser(final Sequenze sequence) {
        super(sequence);

        nextItemIndex = sequence.getFirstIndex();
    }

    /**
     * Creates a new {@link DefaultIndexSequenceTraverser} over the Items of the
     * specified {@link IndexSequence} beginning the traversal at the specified
     * index.
     * 
     * @param sequence
     *        {@link IndexSequence} to traverse
     * 
     * @param initialNextItemIndex
     *        integer specifying the index of the initial next Item
     * 
     * @throws SequenceIndexOutOfBoundsException
     *         if
     *         {@code initialNextItemIndex < sequence.getFirstIndex() || initialNextItemIndex > sequence.getLastIndex()}
     */
    public DefaultIndexSequenceTraverser(final Sequenze sequence, final int initialNextItemIndex) {
        super(sequence);

        IndexSequenceUtility.assertIndexValid(sequence, initialNextItemIndex);

        nextItemIndex = initialNextItemIndex;
    }

    @Override
    public boolean isPreviousItemAccessible() {
        return nextItemIndex - 1 >= getSequence().getFirstIndex();
    }

    @Override
    public boolean isNextItemAccessible() {
        return nextItemIndex <= getSequence().getLastIndex();
    }

    @Override
    public final Item getPreviousItem()
    throws NoPreviousItemException {
        try {
            final Item sequenceItem = getSequenceItem(nextItemIndex - 1);

            nextItemIndex --;  // allow decrementation only if no exception is thrown

            return sequenceItem;
        }
        catch (final SequenceIndexOutOfBoundsException exception) {
            throw new NoPreviousItemException(getSequence(), exception);
        }
    }

    @Override
    public Item getNextItem()
    throws NoNextItemException {
        try {
            final Item sequenceItem = getSequenceItem(nextItemIndex);

            nextItemIndex ++; // allow incrementation only if no exception is thrown

            return sequenceItem;
        }
        catch (final SequenceIndexOutOfBoundsException exception) {
            throw new NoNextItemException(getSequence(), exception);
        }
    }

    /**
     * Returns the Item stored at the specified index in the {@link Sequence}
     * 
     * @param itemIndex
     *        integer specifying the index of the Item
     * 
     * @return Item stored at {@code itemIndex}
     * 
     * @throws SequenceIndexOutOfBoundsException
     *         if {@code itemIndex} is out of the index bounds
     */
    private Item getSequenceItem(final int itemIndex)
    throws SequenceIndexOutOfBoundsException {
        final Item item = getSequence().get(itemIndex);

        setLastAccessedItemIndex(itemIndex);

        return item;
    }

    @Override
    public int getPreviousItemIndex()
    throws NoPreviousItemException {
        if (!isPreviousItemAccessible())
            throw new NoPreviousItemException(getSequence());

        return nextItemIndex - 1;
    }

    @Override
    public int getNextItemIndex() {
        if (!isNextItemAccessible())
            throw new NoPreviousItemException(getSequence());

        return nextItemIndex;
    }

    /**
     * Returns the index of the last Item accessed by this
     * {@link DefaultIndexSequenceTraverser}.
     * 
     * @return integer specifying the index of the last accessed Item
     * 
     * @throws NoValueSetException
     *         if no Item has been accessed
     */
    protected int getLastAccessedItemIndex()
    throws NoValueSetException {
        return lastAccessedItemIndexHolder.get();
    }

    /**
     * Registers the index of the last Item accessed by this
     * {@link DefaultIndexSequenceTraverser}.
     * 
     * @param lastAccessedItemIndex
     *        integer specifying the index
     */
    protected void setLastAccessedItemIndex(final int lastAccessedItemIndex) {
        lastAccessedItemIndexHolder.set(lastAccessedItemIndex);
    }
}
package org.jlib.container.sequence.index;

import org.jlib.container.sequence.AbstractSequenceTraverserState;
import org.jlib.container.sequence.NoSuchSequenceItemException;
import org.jlib.container.sequence.Sequence;
import org.jlib.container.sequence.SequenceTraverserState;

/**
 * {@link SequenceTraverserState} of an {@link IndexSequenceTraverser}.
 * 
 * @param <Item>
 *        type of the items held in the {@link Sequence}
 * 
 * @param <Sequenze>
 *        type of the traversed {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public abstract class MiddleOfIndexSequenceTraverserState<Item, Sequenze extends IndexSequence<Item>>
extends AbstractSequenceTraverserState<Item, Sequenze>
implements IndexSequenceTraverserState<Item> {

    /** index of the next Item */
    private int nextItemIndex;

    /** index of recently returned Item */
    private int recentlyReturnedItemIndex;

    /**
     * Creates a new {@link MiddleOfIndexSequenceTraverserState}.
     * 
     * @param sequence
     *        traversed {@link IndexSequence}
     */
    public MiddleOfIndexSequenceTraverserState(final Sequenze sequence) {
        super(sequence);
    }

    @Override
    public boolean hasPrevious() {
        return true;
    }

    @Override
    public boolean hasNextItem() {
        return true;
    }

    @Override
    public Item getNextItem()
    throws NoSuchSequenceItemException {
        try {
            return getSequenceItem(recentlyReturnedItemIndex = nextItemIndex ++);
        }
        catch (final SequenceIndexOutOfBoundsException exception) {
            throw new NoSuchSequenceItemException(getSequence(), exception);
        }
    }

    @Override
    public Item previous() {
        try {
            return getSequenceItem(recentlyReturnedItemIndex = nextItemIndex -- - 1);
        }
        catch (final SequenceIndexOutOfBoundsException exception) {
            throw new NoSuchSequenceItemException(getSequence(), exception);
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
        return getSequence().get(itemIndex);
    }

    @Override
    public IndexSequenceTraverserState<Item> getPreviousState() {
        return getReturnedItemState();
    }

    @Override
    public IndexSequenceTraverserState<Item> getNextState() {
        return getReturnedItemState();
    }

    /**
     * Returns the new {@link SequenceTraverserState} after returning an Item.
     * 
     * @return new {@link SequenceTraverserState}
     */
    protected abstract IndexSequenceTraverserState<Item> getReturnedItemState();

    @Override
    public int getPreviousItemIndex() {
        return nextItemIndex - 1;
    }

    @Override
    public int getNextItemIndex() {
        return nextItemIndex;
    }

    /**
     * Registers the index of the next Item of the {@link IndexSequence}.
     * 
     * @param nextItemIndex
     *        integer specifying the index of the next Item
     */
    public void setNextItemIndex(final int nextItemIndex) {
        this.nextItemIndex = nextItemIndex;
    }

    /**
     * Returns the index of the recently returned Item by this
     * {@link MiddleOfIndexSequenceTraverserState}.
     * 
     * @return integer specifying the recentlyReturnedItemIndex
     */
    protected int getRecentlyRetrievedItemIndex() {
        return recentlyReturnedItemIndex;
    }
}

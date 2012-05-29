package org.jlib.container.sequence.index;

import org.jlib.container.sequence.Sequence;

/**
 * {@link MiddleOfIndexSequenceTraverserState} targeting a
 * {@link ReplaceIndexSequence}.
 * 
 * @param <Item>
 *        type of the items held in the {@link Sequence}
 * 
 * @param <Sequenze>
 *        type of the traversed {@link ReplaceIndexSequence}
 * 
 * @author Igor Akkerman
 */
public abstract class MiddleOfReplaceIndexSequenceTraverserState<Item, Sequenze extends ReplaceIndexSequence<Item>>
extends MiddleOfIndexSequenceTraverserState<Item, Sequenze>
implements ReplaceIndexSequenceTraverserState<Item> {

    /**
     * Creates a new {@link MiddleOfReplaceIndexSequenceTraverserState}.
     * 
     * @param sequence
     *        traversed {@link Sequence}
     */
    public MiddleOfReplaceIndexSequenceTraverserState(final Sequenze sequence) {
        super(sequence);
    }

    @Override
    public ReplaceIndexSequenceTraverserState<Item> getReplacedState() {
        return this;
    }

    @Override
    public void replace(final Item newItem) {
        getSequence().replace(getRecentlyRetrievedItemIndex(), newItem);
    }

    /** index of the last accessed item */
    private int lastAccessedItemIndex;

    /**
     * Registers the lastAccessedItemIndex of this
     * {@link AccessedMiddleOfReplaceIndexSequenceTraverserState}.
     * 
     * @param lastAccessedItemIndex
     *        integer specifying the lastAccessedItemIndex
     */
    public void setLastAccessedItemIndex(final int lastAccessedItemIndex) {
        this.lastAccessedItemIndex = lastAccessedItemIndex;
    }

    @Override
    public void replace(final Item newItem) {
        getSequence().replace(lastAccessedItemIndex, newItem);
    }
}

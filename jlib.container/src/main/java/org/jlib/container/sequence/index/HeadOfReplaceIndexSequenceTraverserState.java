package org.jlib.container.sequence.index;

import org.jlib.container.sequence.NoPreviousSequenceItemException;
import org.jlib.container.sequence.Sequence;

/**
 * {@link HeadOfIndexSequenceTraverserState} targeting a
 * {@link ReplaceIndexSequence}.
 * 
 * @param <Item>
 *        type of the items held in the {@link Sequence}
 * 
 * @param <Sequenze>
 *        type of the traversed {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public abstract class HeadOfReplaceIndexSequenceTraverserState<Item, Sequenze extends ReplaceIndexSequence<Item>>
extends AbstractReplaceIndexSequenceTraverserState<Item, Sequenze> {

    /**
     * Creates a new {@link HeadOfReplaceIndexSequenceTraverserState}.
     * 
     * @param sequence
     *        traversed {@link IndexSequence}
     */
    public HeadOfReplaceIndexSequenceTraverserState(final Sequenze sequence) {
        super(sequence);
    }

    @Override
    public boolean isPreviousItemAccessible() {
        return false;
    }

    @Override
    public int getPreviousItemIndex()
    throws NoPreviousSequenceItemException {
        throw new NoPreviousSequenceItemException(getSequence());
    }

    @Override
    public Item doGetPreviousItem()
    throws NoPreviousSequenceItemException {
        throw new NoPreviousSequenceItemException(getSequence());
    }

    @Override
    public ReplaceIndexSequenceTraverserState<Item> getPreviousState() {
        return this;
    }

    @Override
    public boolean isNextItemAccessible() {
        return true;
    }

    @Override
    public int getNextItemIndex() {
        return getSequence().getFirstIndex();
    }

    @Override
    public Item doGetNextItem() {
        return getSequence().getFirstItem();
    }
}

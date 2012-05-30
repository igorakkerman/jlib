package org.jlib.container.sequence.index;

import org.jlib.container.sequence.NoPreviousSequenceItemException;
import org.jlib.container.sequence.Sequence;

/**
 * {@link IndexSequenceTraverserState} at the head of an {@link IndexSequence}.
 * 
 * @param <Item>
 *        type of the items held in the {@link Sequence}
 * 
 * @param <Sequenze>
 *        type of the traversed {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public abstract class HeadOfIndexSequenceTraverserState<Item, Sequenze extends IndexSequence<Item>>
extends AbstractIndexSequenceTraverserState<Item, Sequenze> {

    /**
     * Creates a new {@link HeadOfIndexSequenceTraverserState}.
     * 
     * @param sequence
     *        traversed {@link IndexSequence}
     */
    public HeadOfIndexSequenceTraverserState(final Sequenze sequence) {
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
    public IndexSequenceTraverserState<Item> getPreviousState() {
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

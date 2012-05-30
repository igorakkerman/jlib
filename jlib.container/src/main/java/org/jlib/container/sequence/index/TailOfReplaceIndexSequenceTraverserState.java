package org.jlib.container.sequence.index;

import org.jlib.container.sequence.NoNextSequenceItemException;
import org.jlib.container.sequence.NoPreviousSequenceItemException;
import org.jlib.container.sequence.Sequence;

/**
 * {@link TailOfIndexSequenceTraverserState} targeting a
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
public abstract class TailOfReplaceIndexSequenceTraverserState<Item, Sequenze extends ReplaceIndexSequence<Item>>
extends AbstractReplaceIndexSequenceTraverserState<Item, Sequenze> {

    /**
     * Creates a new {@link TailOfReplaceIndexSequenceTraverserState}.
     * 
     * @param sequence
     *        traversed {@link IndexSequence}
     */
    public TailOfReplaceIndexSequenceTraverserState(final Sequenze sequence) {
        super(sequence);
    }

    @Override
    public boolean isPreviousItemAccessible() {
        return true;
    }

    @Override
    public int getPreviousItemIndex() {
        return getSequence().getLastIndex();
    }

    @Override
    public Item doGetPreviousItem()
    throws NoPreviousSequenceItemException {
        return getSequence().getLastItem();
    }

    @Override
    public boolean isNextItemAccessible() {
        return false;
    }

    @Override
    public int getNextItemIndex()
    throws NoNextSequenceItemException {
        throw new NoNextSequenceItemException(getSequence());
    }

    @Override
    public Item doGetNextItem()
    throws NoNextSequenceItemException {
        throw new NoNextSequenceItemException(getSequence());
    }

    @Override
    public ReplaceIndexSequenceTraverserState<Item> getNextState() {
        return this;
    }
}

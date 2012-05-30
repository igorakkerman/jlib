package org.jlib.container.sequence.index;

import org.jlib.container.sequence.NoNextSequenceItemException;
import org.jlib.container.sequence.NoPreviousSequenceItemException;
import org.jlib.container.sequence.Sequence;
import org.jlib.container.sequence.SequenceTraverser;

/**
 * {@link IndexSequenceTraverserState} when a {@link SequenceTraverser} is at
 * the beginning of an {@link IndexSequence}.
 * 
 * @param <Item>
 *        type of the items held in the {@link Sequence}
 * 
 * @param <Sequenze>
 *        type of the traversed {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public abstract class TailOfIndexSequenceTraverserState<Item, Sequenze extends IndexSequence<Item>>
extends AbstractIndexSequenceTraverserState<Item, Sequenze> {

    /**
     * Creates a new {@link TailOfIndexSequenceTraverserState}.
     * 
     * @param sequence
     *        traversed {@link IndexSequence}
     */
    public TailOfIndexSequenceTraverserState(final Sequenze sequence) {
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
    public IndexSequenceTraverserState<Item> getNextState() {
        return this;
    }
}

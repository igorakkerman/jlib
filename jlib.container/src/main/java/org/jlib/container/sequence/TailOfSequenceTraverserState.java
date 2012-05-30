package org.jlib.container.sequence;

import org.jlib.container.sequence.index.IndexSequence;
import org.jlib.container.sequence.index.IndexSequenceTraverserState;

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
public abstract class TailOfSequenceTraverserState<Item, Sequenze extends Sequence<Item>>
extends AbstractSequenceTraverserState<Item, Sequenze> {

    /**
     * Creates a new {@link TailOfSequenceTraverserState}.
     * 
     * @param sequence
     *        traversed {@link Sequence}
     */
    public TailOfSequenceTraverserState(final Sequenze sequence) {
        super(sequence);
    }

    @Override
    public boolean isPreviousItemAccessible() {
        return true;
    }

    @Override
    public boolean isNextItemAccessible() {
        return false;
    }

    @Override
    public Item getNextItem()
    throws NoNextSequenceItemException {
        throw new NoNextSequenceItemException(getSequence());
    }

    @Override
    public SequenceTraverserState<Item> getNextState() {
        return this;
    }
}

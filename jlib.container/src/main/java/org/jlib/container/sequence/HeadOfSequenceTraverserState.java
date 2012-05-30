package org.jlib.container.sequence;

import org.jlib.container.sequence.index.IndexSequence;
import org.jlib.container.sequence.index.IndexSequenceTraverserState;

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
public abstract class HeadOfSequenceTraverserState<Item, Sequenze extends Sequence<Item>>
extends AbstractSequenceTraverserState<Item, Sequenze> {

    /**
     * Creates a new {@link HeadOfSequenceTraverserState}.
     * 
     * @param sequence
     *        traversed {@link IndexSequence}
     */
    public HeadOfSequenceTraverserState(final Sequenze sequence) {
        super(sequence);
    }

    @Override
    public boolean isPreviousItemAccessible() {
        return false;
    }

    @Override
    public Item getPreviousItem()
    throws NoPreviousSequenceItemException {
        throw new NoPreviousSequenceItemException(getSequence());
    }

    @Override
    public SequenceTraverserState<Item> getPreviousState() {
        return this;
    }

    @Override
    public boolean isNextItemAccessible() {
        return true;
    }
}

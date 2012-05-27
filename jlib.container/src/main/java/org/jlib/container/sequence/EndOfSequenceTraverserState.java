package org.jlib.container.sequence;

import java.util.NoSuchItemException;

/**
 * {@link SequenceTraverserState} when a {@link SequenceTraverser} has reached the
 * end of the non-empty {@link Sequence}.
 * 
 * @param <Item>
 *        type of the items held in the {@link Sequence}
 * 
 * @param <Sequenze>
 *        type of the traversed {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public abstract class EndOfSequenceTraverserState<Item, Sequenze extends Sequence<Item>>
extends AbstractSequenceTraverserState<Item, Sequenze> {

    /**
     * Creates a new {@link EndOfSequenceTraverserState}.
     * 
     * @param sequence
     *        traversed {@link Sequence}
     */
    public EndOfSequenceTraverserState(final Sequenze sequence) {
        super(sequence);
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Item next()
    throws NoSuchItemException {
        throw new NoSuchItemException();
    }

    @Override
    public SequenceTraverserState<Item> getNextState() {
        return this;
    }

    @Override
    public boolean hasPrevious() {
        return true;
    }
}

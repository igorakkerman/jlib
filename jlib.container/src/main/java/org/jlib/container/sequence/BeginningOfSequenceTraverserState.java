package org.jlib.container.sequence;

import java.util.NoSuchItemException;

/**
 * {@link SequenceTraverserState} when a {@link SequenceTraverser} is at the
 * beginning of the non-empty {@link Sequence}.
 * 
 * @param <Item>
 *        type of the items held in the {@link Sequence}
 * 
 * @param <Sequenze>
 *        type of the traversed {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public abstract class BeginningOfSequenceTraverserState<Item, Sequenze extends Sequence<Item>>
extends AbstractSequenceTraverserState<Item, Sequenze> {

    /**
     * Creates a new {@link BeginningOfSequenceTraverserState}.
     * 
     * @param sequence
     *        traversed {@link Sequence}
     */
    public BeginningOfSequenceTraverserState(final Sequenze sequence) {
        super(sequence);
    }

    @Override
    public boolean hasPrevious() {
        return false;
    }

    @Override
    public Item previous()
    throws NoSuchItemException {
        throw new NoSuchItemException();
    }

    @Override
    public SequenceTraverserState<Item> getPreviousState() {
        return this;
    }

    @Override
    public boolean hasNextItem() {
        return true;
    }
}

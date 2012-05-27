package org.jlib.container.sequence.index;

import org.jlib.container.sequence.BeginningOfSequenceTraverserState;
import org.jlib.container.sequence.NoSuchSequenceItemException;
import org.jlib.container.sequence.Sequence;
import org.jlib.container.sequence.SequenceTraverser;

/**
 * {@link IndexSequenceTraverserState} when a {@link SequenceTraverser} is at the
 * beginning of an {@link IndexSequence}.
 * 
 * @param <Item>
 *        type of the items held in the {@link Sequence}
 * 
 * @param <Sequenze>
 *        type of the traversed {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public abstract class BeginningOfIndexSequenceTraverserState<Item, Sequenze extends IndexSequence<Item>>
extends BeginningOfSequenceTraverserState<Item, Sequenze>
implements IndexSequenceTraverserState<Item> {

    /**
     * Creates a new {@link BeginningOfIndexSequenceTraverserState}.
     * 
     * @param sequence
     *        traversed {@link IndexSequence}
     */
    public BeginningOfIndexSequenceTraverserState(final Sequenze sequence) {
        super(sequence);
    }

    @Override
    public int getPreviousItemIndex()
    throws NoSuchSequenceItemException {
        throw new NoSuchSequenceItemException(getSequence());
    }

    @Override
    public int getNextItemIndex() {
        return getSequence().getFirstIndex();
    }

    @Override
    public Item next() {
        return getSequence().getFirst();
    }

    @Override
    public IndexSequenceTraverserState<Item> getPreviousState() {
        return this;
    }
}

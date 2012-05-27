package org.jlib.container.sequence.index;

import org.jlib.container.sequence.EndOfSequenceTraverserState;
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
public abstract class EndOfIndexSequenceTraverserState<Item, Sequenze extends IndexSequence<Item>>
extends EndOfSequenceTraverserState<Item, Sequenze>
implements IndexSequenceTraverserState<Item> {

    /**
     * Creates a new {@link EndOfIndexSequenceTraverserState}.
     * 
     * @param sequence
     *        traversed {@link IndexSequence}
     */
    public EndOfIndexSequenceTraverserState(final Sequenze sequence) {
        super(sequence);
    }

    @Override
    public int getPreviousItemIndex() {
        return getSequence().getLastIndex();
    }

    @Override
    public int getNextItemIndex()
    throws NoSuchSequenceItemException {
        throw new NoSuchSequenceItemException(getSequence());
    }

    @Override
    public Item previous()
    throws NoSuchSequenceItemException {
        return getSequence().getLast();
    }

    @Override
    public IndexSequenceTraverserState<Item> getNextState() {
        return this;
    }
}

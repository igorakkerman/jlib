package org.jlib.container.sequence.index;

import org.jlib.container.sequence.HeadOfSequenceTraverserState;
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
public abstract class BeginningOfReplaceIndexSequenceTraverserState<Item, Sequenze extends ReplaceIndexSequence<Item>>
extends HeadOfSequenceTraverserState<Item, Sequenze>
implements IndexSequenceTraverserState<Item> {

    /**
     * Creates a new {@link BeginningOfReplaceIndexSequenceTraverserState}.
     * 
     * @param sequence
     *        traversed {@link IndexSequence}
     */
    public BeginningOfReplaceIndexSequenceTraverserState(final Sequenze sequence) {
        super(sequence);
    }

    @Override
    public int getPreviousItemIndex()
    throws NoSuchSequenceItemException {
        throw new NoPreviousSequenceItemException(getSequence());
    }

    @Override
    public int getNextItemIndex() {
        return getSequence().getFirstIndex();
    }

    @Override
    public Item getNextItem() {
        return getSequence().getFirstItem();
    }

    @Override
    public IndexSequenceTraverserState<Item> getPreviousState() {
        return this;
    }
}

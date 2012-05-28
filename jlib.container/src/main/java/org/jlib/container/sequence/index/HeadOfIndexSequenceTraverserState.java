package org.jlib.container.sequence.index;

import org.jlib.container.sequence.HeadOfSequenceTraverserState;
import org.jlib.container.sequence.NoPreviousSequenceItemException;
import org.jlib.container.sequence.Sequence;

/**
 * {@link HeadOfSequenceTraverserState} for an {@link IndexSequenceTraverser}.
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
extends HeadOfSequenceTraverserState<Item, Sequenze>
implements IndexSequenceTraverserState<Item> {

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
    public int getPreviousItemIndex()
    throws NoPreviousSequenceItemException {
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

package org.jlib.container.sequence.index;

import org.jlib.container.sequence.NoItemToReplaceException;
import org.jlib.container.sequence.Sequence;

/**
 * {@link HeadOfIndexSequenceTraverserState} for a
 * {@link ReplaceIndexSequenceStateTraverser} is at the beginning of an
 * {@link IndexSequence}. This can occur when an Item has been
 * 
 * @param <Item>
 *        type of the items held in the {@link Sequence}
 * 
 * @param <Sequenze>
 *        type of the traversed {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public abstract class AccessedHeadOfReplaceIndexSequenceTraverserState<Item, Sequenze extends ReplaceIndexSequence<Item>>
extends HeadOfReplaceIndexSequenceTraverserState<Item, Sequenze> {

    /**
     * Creates a new {@link AccessedHeadOfReplaceIndexSequenceTraverserState}.
     * 
     * @param sequence
     *        traversed {@link ReplaceIndexSequence}
     */
    public AccessedHeadOfReplaceIndexSequenceTraverserState(final Sequenze sequence) {
        super(sequence);
    }

    @Override
    public void replace(final Item newItem)
    throws NoItemToReplaceException {
        getSequence().replace(getSequence().getFirstIndex(), newItem);
    }
}
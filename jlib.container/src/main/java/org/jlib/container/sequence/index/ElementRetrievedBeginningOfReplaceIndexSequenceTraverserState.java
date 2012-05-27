package org.jlib.container.sequence.index;

import org.jlib.container.sequence.NoItemToReplaceException;
import org.jlib.container.sequence.Sequence;
import org.jlib.container.sequence.SequenceTraverser;

/**
 * {@link ReplaceIndexSequenceTraverserState} when a {@link SequenceTraverser} is
 * at the beginning of an {@link IndexSequence}.
 * 
 * @param <Item>
 *        type of the items held in the {@link Sequence}
 * 
 * @param <Sequenze>
 *        type of the traversed {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public abstract class ItemRetrievedBeginningOfReplaceIndexSequenceTraverserState<Item, Sequenze extends ReplaceIndexSequence<Item>>
extends BeginningOfIndexSequenceTraverserState<Item, Sequenze>
implements ReplaceIndexSequenceTraverserState<Item> {

    /**
     * Creates a new
     * {@link ItemRetrievedBeginningOfReplaceIndexSequenceTraverserState}.
     * 
     * @param sequence
     *        traversed {@link Sequence}
     */
    public ItemRetrievedBeginningOfReplaceIndexSequenceTraverserState(final Sequenze sequence) {
        super(sequence);
    }

    @Override
    public ReplaceIndexSequenceTraverserState<Item> getPreviousState() {
        return this;
    }

    @Override
    public void replace(final Item item)
    throws NoItemToReplaceException {
        getSequence().replace(getSequence().getFirstIndex(), item);
    }
}

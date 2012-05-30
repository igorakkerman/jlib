package org.jlib.container.sequence.index;

import org.jlib.container.sequence.NoItemToReplaceException;
import org.jlib.container.sequence.Sequence;
import org.jlib.core.reference.NoValueSetException;

/**
 * Skeletal implementation of an {@link IndexSequenceTraverserState}.
 * 
 * @param <Item>
 *        type of items held in the {@link Sequence}
 * 
 * @param <Sequenze>
 *        type of the traversed {@link IndexSequence}
 * 
 * @author Igor Akkerman
 */
public abstract class AbstractReplaceIndexSequenceTraverserState<Item, Sequenze extends ReplaceIndexSequence<Item>>
extends AbstractIndexSequenceTraverserState<Item, Sequenze>
implements ReplaceIndexSequenceTraverserState<Item> {

    /**
     * Creates a new {@link AbstractReplaceIndexSequenceTraverserState}.
     * 
     * @param sequence
     *        traversed {@link ReplaceIndexSequence}
     */
    public AbstractReplaceIndexSequenceTraverserState(final Sequenze sequence) {
        super(sequence);
    }

    @Override
    public void replace(final Item newItem)
    throws NoItemToReplaceException {
        try {
            getSequence().replace(getLastAccessedItemIndex(), newItem);
        }
        catch (final NoValueSetException exception) {
            throw new NoItemToReplaceException(getSequence(), exception);
        }
    }

    @Override
    public ReplaceIndexSequenceTraverserState<Item> getReplacedState() {
        return this;
    }

}

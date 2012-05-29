package org.jlib.container.sequence.index;

import org.jlib.container.sequence.Sequence;

/**
 * {@link MiddleOfIndexSequenceTraverserState} targeting a
 * {@link ReplaceIndexSequence}.
 * 
 * @param <Item>
 *        type of the items held in the {@link Sequence}
 * 
 * @param <Sequenze>
 *        type of the traversed {@link ReplaceIndexSequence}
 * 
 * @author Igor Akkerman
 */
public abstract class MiddleOfReplaceIndexSequenceTraverserState<Item, Sequenze extends ReplaceIndexSequence<Item>>
extends MiddleOfIndexSequenceTraverserState<Item, Sequenze>
implements ReplaceIndexSequenceTraverserState<Item> {

    /**
     * Creates a new {@link MiddleOfReplaceIndexSequenceTraverserState}.
     * 
     * @param sequence
     *        traversed {@link Sequence}
     */
    public MiddleOfReplaceIndexSequenceTraverserState(final Sequenze sequence) {
        super(sequence);
    }

    @Override
    public ReplaceIndexSequenceTraverserState<Item> getReplacedState() {
        return this;
    }

    @Override
    public void replace(final Item item) {
        getSequence().replace(getRecentlyRetrievedItemIndex(), item);
    }
}

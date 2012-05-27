package org.jlib.container.sequence.index;

import org.jlib.container.sequence.Sequence;

/**
 * {@link MiddleOfIndexSequenceTraverserState} of a
 * {@link ReplaceIndexSequenceTraverser}.
 * 
 * @param <Item>
 *        type of the items held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public abstract class MiddleOfReplaceIndexSequenceTraverserState<Item>
extends MiddleOfIndexSequenceTraverserState<Item>
implements ReplaceIndexSequenceTraverserState<Item> {

    /**
     * Creates a new {@link MiddleOfReplaceIndexSequenceTraverserState}.
     */
    public MiddleOfReplaceIndexSequenceTraverserState() {
        super();
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

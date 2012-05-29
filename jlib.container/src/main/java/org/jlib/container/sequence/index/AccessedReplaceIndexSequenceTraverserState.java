package org.jlib.container.sequence.index;

import org.jlib.container.sequence.ReplaceSequenceTraverserState;

public class ReturnedItemReplaceIndexSequenceTraverserState<Item>
extends IndexSequenceTraverserState<Item>
implements ReplaceSequenceTraverserState<Item> {

    private int lastReturnedItemIndex;

    private final ReplaceIndexSequence<Item> sequence;

    /**
     * Creates a new {@link ReturnedItemReplaceIndexSequenceTraverserState}.
     */
    public ReturnedItemReplaceIndexSequenceTraverserState(final ReplaceIndexSequenceStateTraverser<Item> parentTraverser) {
        super(parentTraverser);

        sequence = parentTraverser.getSequence();
    }

    /**
     * Registers the lastReturnedItemIndex of this
     * {@link ReturnedItemReplaceIndexSequenceTraverserState}.
     * 
     * @param lastReturnedItemIndex
     *        {@link int} specifying the lastReturnedItemIndex
     */
    public void setLastReturnedItemIndex(final int lastReturnedItemIndex) {
        this.lastReturnedItemIndex = lastReturnedItemIndex;
    }

    @Override
    public void replace(final Item item)
    throws IllegalStateException {

    }

    @Override
    public ReplaceSequenceTraverserState<Item> getReplacedState() {
        return null;
    }
}

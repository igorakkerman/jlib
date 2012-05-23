package org.jlib.container.sequence.index;

import org.jlib.container.sequence.ReplaceSequenceIteratorState;

public class ReturnedElementReplaceIndexSequenceIteratorState<Element>
extends IndexSequenceIteratorState<Element>
implements ReplaceSequenceIteratorState<Element> {

    private int lastReturnedElementIndex;

    private final ReplaceIndexSequence<Element> sequence;

    /**
     * Creates a new {@link ReturnedElementReplaceIndexSequenceIteratorState}.
     */
    public ReturnedElementReplaceIndexSequenceIteratorState(final ReplaceIndexSequenceStateIterator<Element> parentIterator) {
        super(parentIterator);

        sequence = parentIterator.getSequence();
    }

    /**
     * Registers the lastReturnedElementIndex of this
     * {@link ReturnedElementReplaceIndexSequenceIteratorState}.
     * 
     * @param lastReturnedElementIndex
     *        {@link int} specifying the lastReturnedElementIndex
     */
    public void setLastReturnedElementIndex(final int lastReturnedElementIndex) {
        this.lastReturnedElementIndex = lastReturnedElementIndex;
    }

    @Override
    public void replace(final Element element)
    throws IllegalStateException {

    }

    @Override
    public ReplaceSequenceIteratorState<Element> getReplaceState() {
        return null;
    }
}

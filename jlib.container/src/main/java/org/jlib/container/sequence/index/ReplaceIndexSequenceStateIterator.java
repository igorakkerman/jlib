package org.jlib.container.sequence.index;


/**
 * 
 * 
 * @author Igor Akkerman
 */
public class ReplaceIndexSequenceStateIterator<Element>
extends StateIndexSequenceIterator<Element>
implements ReplaceIndexSequenceIterator<Element> {

    private ReplaceIndexSequence<Element> sequence;

    private IndexSequenceIteratorState<Element> elementReturnedState;

    private IndexSequenceIteratorState<Element> noElementReturnedState;

    /**
     * Creates a new {@link ReplaceIndexSequenceStateIterator}.
     */
    public ReplaceIndexSequenceStateIterator(final ReplaceIndexSequence<Element> sequence) {
        super(sequence);

        this.sequence = sequence;
    }

    /**
     * Creates a new {@link ReplaceIndexSequenceStateIterator}.
     */
    public ReplaceIndexSequenceStateIterator(final ReplaceIndexSequence<Element> sequence, final int startIndex) {
        super(sequence, startIndex);
    }

    @Override
    public void replace(final Element element)
    throws IllegalStateException {
        currentState.replace(element);
    }

    ReplaceIndexSequence<Element> getSequence() {
        return sequence;
    }
}

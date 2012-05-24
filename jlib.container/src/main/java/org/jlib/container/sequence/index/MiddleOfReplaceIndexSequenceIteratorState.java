package org.jlib.container.sequence.index;

import org.jlib.container.sequence.Sequence;

/**
 * {@link MiddleOfIndexSequenceIteratorState} of a
 * {@link ReplaceIndexSequenceIterator}.
 * 
 * @param <Element>
 *        type of the elements held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public abstract class MiddleOfReplaceIndexSequenceIteratorState<Element>
extends MiddleOfIndexSequenceIteratorState<Element>
implements ReplaceIndexSequenceIteratorState<Element> {

    /** targeted {@link ReplaceIndexSequence} */
    private final ReplaceIndexSequence<Element> sequence;

    /**
     * Creates a new {@link MiddleOfReplaceIndexSequenceIteratorState}.
     * 
     * @param sequence
     *        targeted {@link ReplaceIndexSequence}
     */
    public MiddleOfReplaceIndexSequenceIteratorState(final ReplaceIndexSequence<Element> sequence) {
        super(sequence);

        this.sequence = sequence;
    }

    @Override
    public ReplaceIndexSequenceIteratorState<Element> getReplacedState() {
        return this;
    }

    @Override
    public void replace(final Element element) {
        sequence.replace(getRecentlyRetrievedElementIndex(), element);
    }
}

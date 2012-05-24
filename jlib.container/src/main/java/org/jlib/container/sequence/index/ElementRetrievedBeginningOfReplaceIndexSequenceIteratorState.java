package org.jlib.container.sequence.index;

import org.jlib.container.sequence.BeginningOfSequenceIteratorState;
import org.jlib.container.sequence.NoElementToReplaceException;
import org.jlib.container.sequence.Sequence;
import org.jlib.container.sequence.SequenceIterator;

/**
 * {@link ReplaceIndexSequenceIteratorState} when a {@link SequenceIterator} is
 * at the beginning of an {@link IndexSequence}.
 * 
 * @param <Element>
 *        type of the elements held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public abstract class ElementRetrievedBeginningOfReplaceIndexSequenceIteratorState<Element>
extends BeginningOfSequenceIteratorState<Element>
implements ReplaceIndexSequenceIteratorState<Element> {

    /** traversed {@link ReplaceIndexSequence} */
    private final ReplaceIndexSequence<Element> sequence;

    /**
     * Creates a new {@link ElementRetrievedBeginningOfReplaceIndexSequenceIteratorState}.
     * 
     * @param sequence
     *        traversed {@link ReplaceIndexSequence}
     */
    public ElementRetrievedBeginningOfReplaceIndexSequenceIteratorState(final ReplaceIndexSequence<Element> sequence) {
        super();

        this.sequence = sequence;
    }

    @Override
    public ReplaceIndexSequenceIteratorState<Element> getPreviousState() {
        return this;
    }

    @Override
    public void replace(final Element element)
    throws NoElementToReplaceException {
        sequence.replace(sequence.getFirstIndex(), element);
    }
}

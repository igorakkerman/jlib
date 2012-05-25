package org.jlib.container.sequence.index;

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
extends BeginningOfIndexSequenceIteratorState<Element>
implements ReplaceIndexSequenceIteratorState<Element> {

    /**
     * Creates a new
     * {@link ElementRetrievedBeginningOfReplaceIndexSequenceIteratorState}.
     */
    public ElementRetrievedBeginningOfReplaceIndexSequenceIteratorState() {
        super();
    }

    @Override
    public ReplaceIndexSequenceIteratorState<Element> getPreviousState() {
        return this;
    }

    @Override
    public void replace(final Element element)
    throws NoElementToReplaceException {
        getSequence().replace(getSequence().getFirstIndex(), element);
    }
}

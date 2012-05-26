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
 * @param <Sequenze>
 *        type of the traversed {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public abstract class ElementRetrievedBeginningOfReplaceIndexSequenceIteratorState<Element, Sequenze extends ReplaceIndexSequence<Element>>
extends BeginningOfIndexSequenceIteratorState<Element, Sequenze>
implements ReplaceIndexSequenceIteratorState<Element> {

    /**
     * Creates a new
     * {@link ElementRetrievedBeginningOfReplaceIndexSequenceIteratorState}.
     * 
     * @param sequence
     *        traversed {@link Sequence}
     */
    public ElementRetrievedBeginningOfReplaceIndexSequenceIteratorState(final Sequenze sequence) {
        super(sequence);
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

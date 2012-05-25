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

    /**
     * Creates a new {@link MiddleOfReplaceIndexSequenceIteratorState}.
     */
    public MiddleOfReplaceIndexSequenceIteratorState() {
        super();
    }

    @Override
    public ReplaceIndexSequenceIteratorState<Element> getReplacedState() {
        return this;
    }

    @Override
    public void replace(final Element element) {
        getSequence().replace(getRecentlyRetrievedElementIndex(), element);
    }
}

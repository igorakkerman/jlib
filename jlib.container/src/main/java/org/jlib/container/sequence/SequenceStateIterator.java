package org.jlib.container.sequence;

import java.util.NoSuchElementException;

/**
 * {@link SequenceIterator} using {@link SequenceIteratorState} instances.
 * 
 * @param <Element>
 *        type of the elements held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public class SequenceStateIterator<Element>
extends AbstractSequenceIterator<Element> {

    /** current {@link SequenceIteratorState} */
    private SequenceIteratorState<Element> currentState;

    /**
     * Creates a new {@link SequenceStateIterator}.
     * 
     * @param initialState
     *        initial {@link SequenceIteratorState}
     */
    public SequenceStateIterator(final SequenceIteratorState<Element> initialState) {
        currentState = initialState;
    }

    @Override
    public final boolean hasPrevious() {
        return currentState.hasPrevious();
    }

    @Override
    public final Element previous()
    throws NoSuchElementException {
        final Element previousElement = currentState.previous();

        currentState = currentState.getPreviousState();

        return previousElement;
    }

    @Override
    public final boolean hasNext() {
        return currentState.hasNext();
    }

    @Override
    public final Element next()
    throws NoSuchElementException {
        final Element nextElement = currentState.next();

        currentState = currentState.getNextState();

        return nextElement;
    }
}

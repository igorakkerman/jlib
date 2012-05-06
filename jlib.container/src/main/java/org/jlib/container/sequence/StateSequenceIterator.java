package org.jlib.container.sequence;

import java.util.NoSuchElementException;

import org.jlib.container.sequence.replace.ReplaceStateSequenceIterator;

/**
 * {@link AbstractSequenceIterator} using {@link SequenceIteratorState}
 * instances.
 * 
 * @param <Element>
 *        type of the elements held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public class StateSequenceIterator<Element>
extends AbstractSequenceIterator<Element> {

    /** current {@link SequenceIteratorState} */
    private SequenceIteratorState<Element> currentState;

    /**
     * Creates a new {@link ReplaceStateSequenceIterator}.
     * 
     * @param initialState
     *        initial {@link SequenceIteratorState}
     */
    public StateSequenceIterator(final SequenceIteratorState<Element> initialState) {
        currentState = initialState;
    }

    @Override
    public boolean hasPrevious() {
        return currentState.hasPrevious();
    }

    @Override
    public Element previous()
    throws NoSuchElementException {
        final Element previousElement = currentState.previous();

        currentState = currentState.getPreviousState();

        return previousElement;
    }

    @Override
    public boolean hasNext() {
        return currentState.hasNext();
    }

    @Override
    public Element next()
    throws NoSuchElementException {
        final Element nextElement = currentState.next();

        currentState = currentState.getNextState();

        return nextElement;
    }
}

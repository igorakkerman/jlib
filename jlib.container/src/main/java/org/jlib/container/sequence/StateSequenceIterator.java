package org.jlib.container.sequence;

import java.util.NoSuchElementException;

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
     * Creates a new {@link StateSequenceIterator}.
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
        try {
            return currentState.previous();
        }
        finally {
            currentState = currentState.getPreviousState();
        }
    }

    @Override
    public boolean hasNext() {
        return currentState.hasNext();
    }

    @Override
    public Element next()
    throws NoSuchElementException {
        try {
            return currentState.next();
        }
        finally {
            currentState = currentState.getNextState();
        }
    }
}

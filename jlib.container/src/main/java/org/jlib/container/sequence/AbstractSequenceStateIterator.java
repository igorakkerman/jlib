package org.jlib.container.sequence;

import java.util.NoSuchElementException;

/**
 * Skeletal implementation of a {@link SequenceIterator} using
 * {@link SequenceIteratorState} instances.
 * 
 * @param <Element>
 *        type of the elements held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public abstract class AbstractSequenceStateIterator<Element>
extends AbstractSequenceIterator<Element> {

    /**
     * Creates a new {@link AbstractSequenceStateIterator}.
     */
    protected AbstractSequenceStateIterator() {
        super();
    }

    @Override
    public final boolean hasPrevious() {
        return getCurrentState().hasPrevious();
    }

    @Override
    public final Element previous()
    throws NoSuchElementException {
        final Element previousElement = getCurrentState().previous();

        setCurrentStateToPrevious();

        return previousElement;
    }

    @Override
    public final boolean hasNext() {
        return getCurrentState().hasNext();
    }

    @Override
    public final Element next()
    throws NoSuchElementException {
        final Element nextElement = getCurrentState().next();

        setCurrentStateToNext();

        return nextElement;
    }

    /**
     * Returns the current {@link SequenceIteratorState} of this
     * {@link AbstractSequenceStateIterator}.
     * 
     * @return current {@link SequenceIteratorState}
     */
    protected abstract SequenceIteratorState<Element> getCurrentState();

    /**
     * Registers the current {@link SequenceIteratorState} of this
     * {@link AbstractSequenceStateIterator} to the
     * {@link SequenceIteratorState} returned by
     * {@code getCurrentState().getPreviousState()}.
     */
    protected abstract void setCurrentStateToPrevious();

    /**
     * Registers the current {@link SequenceIteratorState} of this
     * {@link AbstractSequenceStateIterator} to the
     * {@link SequenceIteratorState} returned by
     * {@code getCurrentState().getNextState()}.
     */
    protected abstract void setCurrentStateToNext();
}

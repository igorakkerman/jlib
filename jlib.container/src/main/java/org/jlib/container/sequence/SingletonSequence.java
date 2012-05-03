package org.jlib.container.sequence;

import java.util.NoSuchElementException;

import org.jlib.container.IteratorState;

/**
 * Sequence containing exactly one Element.
 * 
 * @param <Element>
 *        type of the element held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
class SingletonSequence<Element>
extends AbstractNonEmptySequence<Element> {

    /** sole element of this {@link SingletonSequence} */
    private final Element element;

    /** current {@link IteratorState} */
    private IteratorState<Element> currentState;

    /**
     * Sole Element {@link IteratorState} (initial state).
     */
    private class SoleElementState
    extends IteratorState<Element> {

        @Override
        public boolean hasNext() {
            return true;
        }

        @Override
        public Element next() {
            return element;
        }

        @Override
        public IteratorState<Element> getNextState() {
            return new NoNextElementState();
        }
    }

    /**
     * No next Element {@link IteratorState} (post-initial state).
     */
    private class NoNextElementState
    extends IteratorState<Element> {

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Element next()
        throws NoSuchElementException {
            throw new NoSuchElementException();
        }

        @Override
        public IteratorState<Element> getNextState() {
            return this;
        }
    }

    /**
     * Creates a new {@link SingletonSequence} with the specified Element.
     * 
     * @param element
     *        sole Element in this {@link SingletonSequence}
     */
    public SingletonSequence(final Element element) {
        this.element = element;

        currentState = new SoleElementState();
    }

    @Override
    public SequenceIterator<Element> createIterator() {
        return new AbstractSequenceIterator<Element>() {

            @Override
            public boolean hasPrevious() {
                return false;
            }

            @Override
            public Element previous()
            throws NoSuchElementException {
                throw new NoSuchElementException();
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
        };
    }

    @Override
    public int getSize() {
        return 1;
    }
}

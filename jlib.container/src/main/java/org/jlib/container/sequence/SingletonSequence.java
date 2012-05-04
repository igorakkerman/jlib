package org.jlib.container.sequence;

import java.util.NoSuchElementException;

import org.jlib.core.iterator.IteratorState;

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
    private SequenceIteratorState<Element> currentState;

    /** sole instance of {@link SoleElementPreviousState} */
    private final SequenceIteratorState<Element> soleElementPreviousState = new SoleElementPreviousState();

    /** sole instance of {@link SoleElementNextState} */
    private final SequenceIteratorState<Element> soleElementNextState = new SoleElementNextState();

    /**
     * Sole Element {@link IteratorState} (initial state).
     */
    private class SoleElementNextState
    extends SequenceIteratorState<Element> {

        /**
         * Creates a new {@link SoleElementNextState}.
         */
        public SoleElementNextState() {
            super();
        }

        @Override
        public boolean hasNext() {
            return true;
        }

        @Override
        public Element next() {
            return element;
        }

        @Override
        public SequenceIteratorState<Element> getNextState() {
            return soleElementPreviousState;
        }

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
        public SequenceIteratorState<Element> getPreviousState() {
            return this;
        }
    }

    /**
     * No next Element {@link IteratorState} (post-initial state).
     */
    private class SoleElementPreviousState
    extends SequenceIteratorState<Element> {

        /**
         * Creates a new {@link SoleElementPreviousState}.
         */
        public SoleElementPreviousState() {
            super();
        }

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
        public SequenceIteratorState<Element> getNextState() {
            return this;
        }

        @Override
        public boolean hasPrevious() {
            return true;
        }

        @Override
        public Element previous()
        throws NoSuchElementException {
            return element;
        }

        @Override
        public SequenceIteratorState<Element> getPreviousState() {
            return soleElementNextState;
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

        currentState = new SoleElementNextState();
    }

    @Override
    public SequenceIterator<Element> createIterator() {
        return new AbstractSequenceIterator<Element>() {

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
        };
    }

    @Override
    public int getSize() {
        return 1;
    }
}

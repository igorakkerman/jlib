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

    /** sole instance of {@link BeginningOfSequenceState} */
    private final SequenceIteratorState<Element> beginningOfSequenceState = new BeginningOfSequenceState();

    /** sole instance of {@link EndOfSequenceState} */
    private final SequenceIteratorState<Element> endOfSequenceState = new EndOfSequenceState();

    /**
     * Sole Element {@link IteratorState} (initial state).
     */
    private class BeginningOfSequenceState
    extends BeginningOfSequenceIteratorState<Element> {

        /**
         * Creates a new {@link BeginningOfSequenceState}.
         */
        public BeginningOfSequenceState() {
            super();
        }

        @Override
        public Element next() {
            return element;
        }

        @Override
        public SequenceIteratorState<Element> getNextState() {
            return endOfSequenceState;
        }
    }

    /**
     * No next Element {@link IteratorState} (post-initial state).
     */
    private class EndOfSequenceState
    extends EndOfSequenceIteratorState<Element> {

        /**
         * Creates a new {@link EndOfSequenceState}.
         */
        public EndOfSequenceState() {
            super();
        }

        @Override
        public Element previous()
        throws NoSuchElementException {
            return element;
        }

        @Override
        public SequenceIteratorState<Element> getPreviousState() {
            return beginningOfSequenceState;
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

        currentState = new BeginningOfSequenceState();
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

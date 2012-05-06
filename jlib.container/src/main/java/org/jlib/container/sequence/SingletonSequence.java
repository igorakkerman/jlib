package org.jlib.container.sequence;


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

    /** beginning of the {@link SingletonSequence} {@link SequenceIteratorState} */
    private final SequenceIteratorState<Element> beginningOfSequenceState =
        new BeginningOfSequenceIteratorState<Element>() {

            @Override
            public Element next() {
                return element;
            }

            @Override
            public SequenceIteratorState<Element> getNextState() {
                return endOfSequenceState;
            }
        };

    /** end of the {@link SingletonSequence} {@link SequenceIteratorState} */
    private final SequenceIteratorState<Element> endOfSequenceState = new EndOfSequenceIteratorState<Element>() {

        @Override
        public Element previous() {
            return element;
        }

        @Override
        public SequenceIteratorState<Element> getPreviousState() {
            return beginningOfSequenceState;
        }
    };

    /**
     * Creates a new {@link SingletonSequence} with the specified Element.
     * 
     * @param element
     *        sole Element in this {@link SingletonSequence}
     */
    public SingletonSequence(final Element element) {
        this.element = element;
    }

    @Override
    public SequenceIterator<Element> createIterator() {
        return new StateSequenceIterator<Element>(beginningOfSequenceState);
    }

    @Override
    public int getSize() {
        return 1;
    }
}

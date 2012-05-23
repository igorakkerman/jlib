package org.jlib.container.sequence;

/**
 * {@link SequenceIterator} using {@link SequenceIteratorState} instances.
 * 
 * @param <Element>
 *        type of the elements held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public class DefaultSequenceStateIterator<Element>
extends AbstractSequenceStateIterator<Element> {

    /** current {@link SequenceIteratorState} */
    private SequenceIteratorState<Element> currentState;

    /**
     * Creates a new {@link DefaultSequenceStateIterator} for the specified
     * initial {@link SequenceIteratorState}.
     * 
     * @param initialState
     *        initial {@link SequenceIteratorState}
     */
    public DefaultSequenceStateIterator(final SequenceIteratorState<Element> initialState) {
        super();

        currentState = initialState;
    }

    @Override
    protected SequenceIteratorState<Element> getCurrentState() {
        return currentState;
    }

    @Override
    protected void setCurrentStateToPrevious() {
        currentState = currentState.getPreviousState();
    }

    @Override
    protected void setCurrentStateToNext() {
        currentState = currentState.getNextState();
    }
}

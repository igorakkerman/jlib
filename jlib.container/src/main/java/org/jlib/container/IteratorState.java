package org.jlib.container;

/**
 * Iterator state.
 * 
 * @param <Element>
 *        type of the elements held in the {@link Container}
 */
public abstract class IteratorState<Element>
extends AbstractIterator<Element> {

    /**
     * Returns the next {@link IteratorState}
     * 
     * @return next {@link IteratorState}
     */
    public abstract IteratorState<Element> getNextState();
}

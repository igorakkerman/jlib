package org.jlib.core.iterator;

import java.util.Iterator;


/**
 * Iterator state.
 * 
 * @param <Item>
 *        type of the items traversed by the {@link Iterator}.
 */
public abstract class IteratorState<Item>
extends AbstractIterator<Item> {

    /**
     * Returns the next {@link IteratorState}
     * 
     * @return next {@link IteratorState}
     */
    public abstract IteratorState<Item> getNextState();
}

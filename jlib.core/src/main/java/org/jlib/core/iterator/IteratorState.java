package org.jlib.core.iterator;

import java.util.Iterator;

/**
 * Iterator state.
 * 
 * @param <Item>
 *        type of the items traversed by the {@link Iterator}.
 */
public interface IteratorState<Item>
extends Iterator<Item> {

    /**
     * Returns the next {@link IteratorState}
     * 
     * @return next {@link IteratorState}
     */
    public IteratorState<Item> getNextState();
}

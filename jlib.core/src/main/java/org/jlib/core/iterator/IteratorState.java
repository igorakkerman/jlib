package org.jlib.core.iterator;

import java.util.Traverser;

/**
 * Traverser state.
 * 
 * @param <Item>
 *        type of the items traversed by the {@link Traverser}.
 */
public interface TraverserState<Item>
extends Traverser<Item> {

    /**
     * Returns the next {@link TraverserState}
     * 
     * @return next {@link TraverserState}
     */
    public TraverserState<Item> getNextState();
}

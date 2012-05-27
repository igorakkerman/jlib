package org.jlib.container;

/**
 * {@link Traverser} allowing returned Items to be removed.
 * 
 * @param <Item>
 *        type of traversed items
 * 
 * @author Igor Akkerman
 */
public interface RemoveTraverser<Item>
extends Traverser<Item> {

    /**
     * Removes the last Item returned by this {@link RemoveTraverser} .
     * 
     * @throws IllegalStateException
     *         if not called immediately after a call to {@link #next()} or an
     *         appropriate method
     */
    public void remove()
    throws IllegalStateException;
}

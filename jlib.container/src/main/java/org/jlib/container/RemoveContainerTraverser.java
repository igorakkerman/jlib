package org.jlib.container;


/**
 * {@link Traverser} over a {@link RemoveContainer}.
 * 
 * @param <Item>
 *        type of items held in the {@link Container}
 * 
 * @author Igor Akkerman
 */
public interface RemoveContainerTraverser<Item>
extends Traverser<Item> {

    /**
     * Removes the last Item returned by this {@link RemoveContainerTraverser} .
     * 
     * @throws IllegalStateException
     *         if not called immediately after a call to {@link #next()} or an
     *         appropriate method
     */
    public void remove()
    throws IllegalStateException;
}

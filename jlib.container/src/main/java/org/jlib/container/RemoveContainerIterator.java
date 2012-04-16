package org.jlib.container;

import java.util.Iterator;

/**
 * {@link Iterator} over a {@link RemoveContainer}.
 * 
 * @param <Element>
 *        type of elements held in the {@link Container}
 * 
 * @author Igor Akkerman
 */
public interface RemoveContainerIterator<Element>
extends Iterator<Element> {

    /**
     * Removes the last Element returned by this {@link RemoveContainerIterator}
     * .
     * 
     * @throws IllegalStateException
     *         if not called immediately after a call to {@link #next()} or an
     *         appropriate method
     */
    @Override
    public void remove()
    throws IllegalStateException;
}

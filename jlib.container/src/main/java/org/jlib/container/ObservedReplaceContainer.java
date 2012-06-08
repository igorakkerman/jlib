package org.jlib.container;

import org.jlib.container.sequence.Sequence;
import org.jlib.core.observer.ItemObserver;
import org.jlib.core.observer.ItemObserverException;
import org.jlib.core.traverser.ObservedReplaceTraverser;

/**
 * {@link ReplaceContainer} traversed by an {@link ObservedReplaceContainer}.
 * 
 * @param <Item>
 *        type of items held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public interface ObservedReplaceContainer<Item>
extends ReplaceContainer<Item> {

    /**
     * Creates a new {@link ObservedReplaceTraverser} over this
     * {@link ObservedReplaceContainer} with the specified {@link ItemObserver}
     * instances.
     * 
     * @param observers
     *        comma separated sequence of {@link ItemObserver} instances
     *        attending Item removals
     * 
     * @return newly created {@link ObservedReplaceTraverser}
     * 
     * @throws ItemObserverException
     *         if an error occurs during the {@link ItemObserver} operation
     */
    public ObservedReplaceTraverser<Item> createTraverser(@SuppressWarnings({ "unchecked", /* "varargs" */}) ItemObserver<Item>... observers);
}

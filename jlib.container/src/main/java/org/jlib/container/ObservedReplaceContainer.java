package org.jlib.container;

import org.jlib.container.sequence.Sequence;
import org.jlib.core.observer.ValueObserver;
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
     * {@link ObservedReplaceContainer} with the specified {@link ValueObserver}
     * instances.
     * 
     * @param observers
     *        comma separated sequence of {@link ValueObserver} instances
     *        attending Item removals
     * 
     * @return newly createTraverser}
     * 
     * @throws RuntimeException
     *         if a {@link ValueObserver} operation throws this
     *         {@link RuntimeException}
     */
    public ObservedReplaceTraverser<Item> createTraverser(@SuppressWarnings({ "unchecked", /* "varargs" */}) ValueObserver<Item>... observers);
}

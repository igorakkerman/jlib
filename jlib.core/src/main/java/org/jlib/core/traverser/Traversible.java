package org.jlib.core.traverser;

/**
 * {@link Object} traversible by a {@link Traverser}.
 * 
 * @param <Item>
 *        type of items returned by the {@link Traverser}
 * 
 * @author Igor Akkerman
 */
public interface Traversible<Item> {

    /**
     * Returns a new {@link Traverser} over this {@link Traversible}.
     * 
     * @return newly created {@link Traverser}
     */
    public Traverser<Item> createTraverser();
}

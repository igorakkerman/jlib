package org.jlib.core.traverser;

/**
 * {@link Object} traversible by a {@link TwoWayTraverser}.
 * 
 * @param <Item>
 *        type of items returned by the {@link Traverser}
 * 
 * @author Igor Akkerman
 */
public interface TwoWayTraversible<Item>
extends Traversible<Item> {

    /**
     * Returns a new {@link TwoWayTraverser} over the Items of this
     * {@link TwoWayTraversible}.
     * 
     * @return newly createTraverser}
     */
    public TwoWayTraverser<Item> createTraverser();
}

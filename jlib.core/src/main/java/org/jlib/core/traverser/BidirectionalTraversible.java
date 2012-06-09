package org.jlib.core.traverser;

/**
 * {@link Object} traversible by a {@link BidirectionalTraverser}.
 * 
 * @param <Item>
 *        type of items returned by the {@link Traverser}
 * 
 * @author Igor Akkerman
 */
public interface BidirectionalTraversible<Item>
extends Traversible<Item> {

    /**
     * Returns a new {@link BidirectionalTraverser} over this
     * {@link BidirectionalTraversible}.
     * 
     * @return newly created {@link Traverser}
     */
    @Override
    public BidirectionalTraverser<Item> createTraverser();
}

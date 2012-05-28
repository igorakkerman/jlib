package org.jlib.core.traverser;

/**
 * {@link Traversible} allowing Items to be removed.
 * 
 * @param <Item>
 *        type of items returned by the {@link Traverser}
 * 
 * @author Igor Akkerman
 */
public interface RemoveTraversible<Item>
extends Traversible<Item> {

    /**
     * Returns a new {@link RemoveTraverser} over this {@link RemoveTraversible}
     * .
     * 
     * @return newly created {@link RemoveTraverser}
     */
    @Override
    public RemoveTraverser<Item> createTraverser();
}

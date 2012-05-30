package org.jlib.core.traverser;

/**
 * Provider of Items in a specified order.
 * 
 * @param <Item>
 *        type of items provided by the {@link Traverser}
 * 
 * @author Igor Akkerman
 */
public interface Traverser<Item> {

    /**
     * Returns the next Item traversed by this {@link Traverser}.
     * 
     * @return next Item
     * 
     * @throws IllegalTraverserStateException
     *         if this {@link Traverser} has no next Item
     */
    public Item getNextItem()
    throws IllegalTraverserStateException;

    /**
     * Returns whether this {@link Traverser} has a next Item.
     * 
     * @return {@code true} if there is a next Item; {@code false} otherwise
     */
    public boolean isNextItemAccessible();
}

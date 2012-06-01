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
     * @throws NoNextItemException
     *         if this {@link Traverser} has no next Item
     */
    public Item getNextItem()
    throws NoNextItemException;

    /**
     * Returns whether this {@link Traverser} has a next Item.
     * 
     * @return {@code true} if there is a next Item; {@code false} otherwise
     */
    public boolean isNextItemAccessible();
}

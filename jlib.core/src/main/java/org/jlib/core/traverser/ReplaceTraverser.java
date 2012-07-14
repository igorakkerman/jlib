package org.jlib.core.traverser;

/**
 * {@link Traverser} over replaceable Items.
 * 
 * @param <Item>
 *        type of the traversed items
 * 
 * @author Igor Akkerman
 */
public interface ReplaceTraverser<Item>
extends Traverser<Item> {

    /**
     * Replaces the last traversed Item with the specified Item.
     * 
     * @param newItem
     *        Item by which the former Item is replaced
     * 
     * @throws IllegalTraverserStateException
     *         if no Item has been traversed by this {@link ReplaceTraverser}
     */
    public void replace(final Item newItem)
    throws IllegalTraverserStateException;

}

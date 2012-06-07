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
     * Replaces the last Item returned by {@code next()} with the specified
     * value.
     * 
     * @param newItem
     *        Item by which the former Item is replaced
     * 
     * @throws IllegalTraverserStateException
     *         if no Item has been returned by this {@link ReplaceTraverser}
     */
    public void replace(final Item newItem)
    throws IllegalTraverserStateException;
}

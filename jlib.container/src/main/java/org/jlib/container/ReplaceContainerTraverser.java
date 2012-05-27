package org.jlib.container;

import org.jlib.container.sequence.ReplaceSequenceTraverser;

/**
 * {@link Traverser} over an {@link ReplaceContainer} allowing the modification
 * of the last traversed Item.
 * 
 * @param <Item>
 *        type of the items held in the {@link Container}
 * 
 * @author Igor Akkerman
 */
public interface ReplaceContainerTraverser<Item>
extends Traverser<Item> {

    /**
     * Replaces the last Item returned by {@code next()} with the specified
     * value.
     * 
     * @param newItem
     *        Item by which the former Item is replaced
     * 
     * @throws IllegalStateException
     *         if no Item has been returned by this
     *         {@link ReplaceSequenceTraverser}
     */
    public void replace(final Item newItem)
    throws IllegalStateException;
}

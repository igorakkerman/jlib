package org.jlib.core.observer;

import org.jlib.core.IllegalJlibArgumentException;
import org.jlib.core.IllegalJlibStateException;

/**
 * {@link Object} allowing an Item to be replaced.
 * 
 * @param <Item>
 *        type of replaced item
 * 
 * @author Igor Akkerman
 */
public interface Replaceable<Item> {

    /**
     * Replaces an Item by the specified new Item.
     * 
     * @param newItem
     *        new Item
     * 
     * @throws IllegalJlibArgumentException
     *         if {@code newItem} causes an error
     * 
     * @throws IllegalJlibStateException
     *         if an error occurs during the operation
     */
    public void replace(final Item newItem)
    throws IllegalJlibArgumentException, IllegalJlibStateException;
}

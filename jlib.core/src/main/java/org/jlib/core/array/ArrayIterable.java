package org.jlib.core.array;

import java.util.Traverser;

/**
 * Wrapper for an array allowing it to be used as {@link Iterable}.
 * 
 * @param <Item>
 *        type of the items held in the array
 * 
 * @author Igor Akkerman
 */
public class ArrayIterable<Item>
implements Iterable<Item> {

    /** array to traverse */
    private final Item[] array;

    /**
     * Creates a new {@link ArrayIterable} for the specified array.
     * 
     * @param array
     *        array of Items to traverse
     */
    public ArrayIterable(final Item[] array) {
        this.array = array;
    }

    // @see java.lang.Iterable#iterator()
    @Override
    public Traverser<Item> iterator() {
        return new ArrayTraverser<Item>(array);
    }
}

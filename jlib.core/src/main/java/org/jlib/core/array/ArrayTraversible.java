package org.jlib.core.array;

import org.jlib.core.traverser.Traverser;
import org.jlib.core.traverser.Traversible;

/**
 * Wrapper for an array allowing it to be used as {@link Traversible}.
 * 
 * @param <Item>
 *        type of the items held in the array
 * 
 * @author Igor Akkerman
 */
public class ArrayTraversible<Item>
implements Traversible<Item> {

    /** array to traverse */
    private final Item[] array;

    /**
     * Creates a new {@link ArrayTraversible} for the specified array.
     * 
     * @param array
     *        array of Items to traverse
     */
    public ArrayTraversible(final Item[] array) {
        this.array = array;
    }

    @Override
    public Traverser<Item> createTraverser() {
        return new ArrayTraverser<Item>(array);
    }
}

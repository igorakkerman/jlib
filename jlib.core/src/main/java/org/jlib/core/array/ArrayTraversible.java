package org.jlib.core.array;

import org.jlib.core.traverser.TwoWayTraverser;
import org.jlib.core.traverser.TwoWayTraversible;

/**
 * Wrapper for an array allowing it to be used as {@link TwoWayTraversible}.
 * 
 * @param <Item>
 *        type of the items held in the array
 * 
 * @author Igor Akkerman
 */
public class ArrayTraversible<Item>
implements TwoWayTraversible<Item> {

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
    public TwoWayTraverser<Item> createTraverser() {
        return new ArrayTraverser<>(array);
    }
}

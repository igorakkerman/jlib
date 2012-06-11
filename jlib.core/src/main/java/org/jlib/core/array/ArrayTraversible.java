package org.jlib.core.array;

import org.jlib.core.traverser.BidirectionalTraverser;
import org.jlib.core.traverser.BidirectionalTraversible;
import org.jlib.core.traverser.Traverser;

/**
 * Wrapper for an array allowing it to be used as
 * {@link BidirectionalTraversible}.
 * 
 * @param <Item>
 *        type of the items held in the array
 * 
 * @author Igor Akkerman
 */
public class ArrayTraversible<Item>
implements BidirectionalTraversible<Item> {

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
        return createBidirectionalTraverser();
    }

    @Override
    public BidirectionalTraverser<Item> createBidirectionalTraverser() {
        return new ArrayTraverser<Item>(array);
    }
}

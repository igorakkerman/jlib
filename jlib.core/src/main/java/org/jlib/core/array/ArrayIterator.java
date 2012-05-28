package org.jlib.core.array;

import java.util.Traverser;

import org.jlib.core.iterator.AbstractIterator;

/**
 * {@link Traverser} over the items of an array.
 * 
 * @param <Item>
 *        type of the items held in the array
 * 
 * @author Igor Akkerman
 */
public class ArrayTraverser<Item>
extends AbstractIterator<Item> {

    /** array to traverse */
    private final Item[] array;

    /** length of the array */
    private final int arrayLength;

    /** current index */
    private int currentIndex = 0;

    /**
     * Creates a new {@link ArrayTraverser}.
     * 
     * @param array
     *        array to traverse
     */
    public ArrayTraverser(final Item[] array) {
        this(array, 0);
    }

    /**
     * Creates a new {@link ArrayTraverser} beginning the iteration at the
     * specified initial index.
     * 
     * @param array
     *        array to traverse
     * @param initialIndex
     *        integer specifying the initial index
     */
    public ArrayTraverser(final Item[] array, final int initialIndex) {
        this.array = array;
        arrayLength = array.length;
        currentIndex = initialIndex;
    }

    // @see java.util.Traverser#hasNext()
    @Override
    public boolean hasNextItem() {
        return currentIndex <= arrayLength - 1;
    }

    // @see java.util.Traverser#next()
    @Override
    public Item getNextItem() {
        return array[currentIndex ++];
    }
}

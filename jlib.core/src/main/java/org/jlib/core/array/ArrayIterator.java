package org.jlib.core.array;

import java.util.Iterator;

import org.jlib.core.iterator.AbstractIterator;

/**
 * {@link Iterator} over the items of an array.
 * 
 * @param <Item>
 *        type of the items held in the array
 * 
 * @author Igor Akkerman
 */
public class ArrayIterator<Item>
extends AbstractIterator<Item> {

    /** array to traverse */
    private final Item[] array;

    /** length of the array */
    private final int arrayLength;

    /** current index */
    private int currentIndex = 0;

    /**
     * Creates a new {@link ArrayIterator}.
     * 
     * @param array
     *        array to traverse
     */
    public ArrayIterator(final Item[] array) {
        this(array, 0);
    }

    /**
     * Creates a new {@link ArrayIterator} beginning the iteration at the
     * specified initial index.
     * 
     * @param array
     *        array to traverse
     * @param initialIndex
     *        integer specifying the initial index
     */
    public ArrayIterator(final Item[] array, final int initialIndex) {
        this.array = array;
        arrayLength = array.length;
        currentIndex = initialIndex;
    }

    // @see java.util.Iterator#hasNext()
    @Override
    public boolean hasNext() {
        return currentIndex < arrayLength;
    }

    // @see java.util.Iterator#next()
    @Override
    public Item next() {
        return array[currentIndex ++];
    }
}

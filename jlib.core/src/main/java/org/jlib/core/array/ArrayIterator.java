package org.jlib.core.array;

import java.util.Iterator;

/**
 * {@link Iterator} over the elements of an array.
 * 
 * @param <Element>
 *        type of the elements held in the array
 * 
 * @author Igor Akkerman
 */
public class ArrayIterator<Element>
implements Iterator<Element> {

    /** array to traverse */
    private final Element[] array;

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
    public ArrayIterator(final Element[] array) {
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
    public ArrayIterator(final Element[] array, final int initialIndex) {
        this.array = array;
        arrayLength = array.length;
        currentIndex = initialIndex;
    }

    // @see java.util.Iterator#hasNext()
    @Override
    public boolean hasNext() {
        return currentIndex <= arrayLength - 1;
    }

    // @see java.util.Iterator#next()
    @Override
    public Element next() {
        return array[currentIndex ++];
    }

    // @see java.util.Iterator#remove()
    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

}

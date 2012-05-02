package org.jlib.core.array;

import java.util.Iterator;

/**
 * Wrapper for an array allowing it to be used as {@link Iterable}.
 * 
 * @param <Element>
 *        type of the elements held in the array
 * 
 * @author Igor Akkerman
 */
public class ArrayIterable<Element>
implements Iterable<Element> {

    /** array to traverse */
    private final Element[] array;

    /**
     * Creates a new {@link ArrayIterable} for the specified array.
     * 
     * @param array
     *        array of Elements to traverse
     */
    public ArrayIterable(final Element[] array) {
        this.array = array;
    }

    // @see java.lang.Iterable#iterator()
    @Override
    public Iterator<Element> iterator() {
        return new ArrayIterator<Element>(array);
    }
}

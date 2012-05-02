package org.jlib.core.array;

/**
 * Utility for arrays.
 * 
 * @author Igor Akkerman
 */
public final class ArrayUtility {

    /** no visible constructor */
    private ArrayUtility() {}

    /**
     * Returns a new {@link Iterable} adapter for the specified array.
     * 
     * @param <Element>
     *        type of the elements held in the array
     * 
     * @param array
     *        array of Elements to traverse
     * 
     * @return {@link Iterable} adapter for {@code array}
     */
    public static <Element> Iterable<Element> iterable(final Element[] array) {
        return new ArrayIterable<>(array);
    }
}

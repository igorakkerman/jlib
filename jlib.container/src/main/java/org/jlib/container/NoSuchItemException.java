package org.jlib.container;

/**
 * Exception thrown when a requested
 * 
 * @author Igor Akkerman
 */
public class NoSuchItemException
extends IllegalStateException {

    /** requested Item */
    private final Object item;

    /**
     * Creates a new NoSuchItemException.
     * 
     * @param item
     *        requested Item
     */
    public NoSuchItemException(final Object item) {
        this.item = item;
    }

    /**
     * Returns the item of this {@link NoSuchItemException}.
     * 
     * @return {@link Object} specifying the item
     */
    public Object getItem() {
        return item;
    }
}

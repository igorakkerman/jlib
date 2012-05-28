package org.jlib.container;

/**
 * Exception thrown when a requested Item is now found.
 * 
 * @author Igor Akkerman
 */
public class NoSuchItemException
extends IllegalStateException {

    /** serialVersionUID */
    private static final long serialVersionUID = 7038464143575268543L;

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

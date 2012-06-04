package org.jlib.container;

/**
 * {@link IllegalContainerArgumentException} thrown when a {@link Container}
 * does not contain the specified Item to remove.
 * 
 * @author Igor Akkerman
 */
public class NoSuchItemToRemoveException
extends IllegalContainerArgumentException {

    /** serialVersionUID */
    private static final long serialVersionUID = -2921569537644842654L;

    /** Item to remove */
    private final Object item;

    /**
     * Creates a new {@link NoSuchItemToRemoveException}.
     * 
     * @param container
     *        referenced {@link Container}
     * 
     * @param item
     *        Item to remove
     */
    public NoSuchItemToRemoveException(final Container<?> container, final Object item) {
        this(container, item, null);
    }

    /**
     * Creates a new {@link NoSuchItemToRemoveException}.
     * 
     * @param container
     *        referenced {@link Container}
     * 
     * @param item
     *        Item to remove
     * 
     * @param cause
     *        Throwable that caused this {@link NoSuchItemToRemoveException}
     */
    public NoSuchItemToRemoveException(final Container<?> container, final Object item, final Throwable cause) {
        super(container, "{1}: {2}", item);

        this.item = item;
    }

    /**
     * Returns the Item to remove.
     * 
     * @return Item to remove
     */
    public Object getItem() {
        return item;
    }
}

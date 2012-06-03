package org.jlib.container;

/**
 * {@link IllegalJlibStateException} thrown during the handling of a
 * {@link Container} listener.
 * 
 * @author Igor Akkerman
 */
public abstract class ContainerListenerException
extends IllegalJlibStateException {

    /** serialVersionUID */
    private static final long serialVersionUID = 2302026114454404812L;

    /** referenced {@link Container} */
    private final Container<?> container;

    /** referenced Item */
    private final Object item;

    /**
     * Creates a new {@link ContainerListenerException}.
     * 
     * @param container
     *        {@link Container} to which {@code addedItem} is added
     * 
     * @param item
     *        Item added to {@code container}
     * 
     * @param messagePattern
     *        {@link String} specifying the message pattern
     * 
     * @param cause
     *        {@link Throwable} that caused this
     *        {@link ContainerListenerException}
     * 
     * @param messageArguments
     *        comma separated sequence of {@link Object} message arguments
     */
    public ContainerListenerException(final Container<?> container, final Object item, final String messagePattern,
                                      final Throwable cause, final Object... messageArguments) {
        super(messagePattern, cause, messageArguments);

        this.container = container;
        this.item = item;
    }

    /**
     * Returns the {@link Container} to which {@code addedItem} is added.
     * 
     * @return {@link Container} to which {@code addedItem} is added
     */
    public Container<?> getContainer() {
        return container;
    }

    /**
     * Returns the added Item.
     * 
     * @return added Item
     */
    public Object getAddedItem() {
        return item;
    }
}

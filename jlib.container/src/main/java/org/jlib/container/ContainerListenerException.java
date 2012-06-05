package org.jlib.container;

import org.jlib.core.IllegalJlibStateException;

/**
 * {@link IllegalJlibStateException} thrown during the handling of a
 * {@link Container} listener.
 * 
 * @author Igor Akkerman
 */
public abstract class ContainerListenerException
extends IllegalContainerStateException {

    /** serialVersionUID */
    private static final long serialVersionUID = 2302026114454404812L;

    /** handled Item */
    private final Object item;

    /**
     * Creates a new {@link ContainerListenerException}.
     * 
     * @param container
     *        {@link Container} to which {@code addedItem} is added
     * 
     * @param item
     *        handled Item
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
        super(container, messagePattern, cause, messageArguments);

        this.item = item;
    }

    /**
     * Returns the handled Item.
     * 
     * @return handled Item
     */
    public Object getItem() {
        return item;
    }
}

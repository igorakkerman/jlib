package org.jlib.container;

import org.jlib.core.IllegalJlibStateException;

/**
 * {@link IllegalJlibStateException} thrown during the handling of an added
 * Item.
 * 
 * @author Igor Akkerman
 */
public class ItemAddedListenerException
extends ContainerListenerException {

    /** serialVersionUID */
    private static final long serialVersionUID = -2504496105146397663L;

    /**
     * Creates a new {@link ItemAddedListenerException}.
     * 
     * @param container
     *        {@link Container} to which {@code addedItem} is added
     * 
     * @param addedItem
     *        Item added to {@code container}
     * 
     * @param messagePattern
     *        {@link String} specifying the message pattern
     * 
     * @param cause
     *        {@link Throwable} that caused this
     *        {@link ItemAddedListenerException}
     * 
     * @param messageArguments
     *        comma separated sequence of {@link Object} message arguments
     */
    public ItemAddedListenerException(final Container<?> container, final Object addedItem,
                                      final String messagePattern, final Throwable cause,
                                      final Object... messageArguments) {
        super(container, addedItem, messagePattern, cause, messageArguments);
    }
}

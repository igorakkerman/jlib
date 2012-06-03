package org.jlib.container;

/**
 * {@link IllegalJlibStateException} thrown during the handling of a removed
 * Item.
 * 
 * @author Igor Akkerman
 */
public class ItemRemovedListenerException
extends ContainerListenerException {

    /** serialVersionUID */
    private static final long serialVersionUID = -2504496105146397663L;

    /**
     * Creates a new {@link ItemRemovedListenerException}.
     * 
     * @param container
     *        {@link Container} from which {@code addedItem} is removed
     * 
     * @param removedItem
     *        Item removed from {@code container}
     * 
     * @param messagePattern
     *        {@link String} specifying the message pattern
     * 
     * @param cause
     *        {@link Throwable} that caused this
     *        {@link ItemRemovedListenerException}
     * 
     * @param messageArguments
     *        comma separated sequence of {@link Object} message arguments
     */
    public ItemRemovedListenerException(final Container<?> container, final Object removedItem,
                                        final String messagePattern, final Throwable cause,
                                        final Object... messageArguments) {
        super(container, removedItem, messagePattern, cause, messageArguments);
    }
}

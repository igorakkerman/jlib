package org.jlib.container;

/**
 * {@link ContainerListenerException} thrown during an Item removal.
 * 
 * @author Igor Akkerman
 */
public class RemoveObserverException
extends ContainerListenerException {

    /** serialVersionUID */
    private static final long serialVersionUID = -2504496105146397663L;

    /**
     * Creates a new {@link RemoveObserverException}.
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
     *        {@link RemoveObserverException}
     * 
     * @param messageArguments
     *        comma separated sequence of {@link Object} message arguments
     */
    public RemoveObserverException(final Container<?> container, final Object removedItem,
                                      final String messagePattern, final Throwable cause,
                                      final Object... messageArguments) {
        super(container, removedItem, messagePattern, cause, messageArguments);
    }
}

package org.jlib.container;

import org.jlib.core.IllegalJlibStateException;


/**
 * {@link IllegalJlibStateException} caused by a {@link Container}.
 * 
 * @author Igor Akkerman
 */
public abstract class IllegalContainerStateException
extends IllegalJlibStateException {

    /** serialVersionUID */
    private static final long serialVersionUID = -5372709827038391318L;

    /** referenced {@link Container} */
    private Container<?> container;

    /**
     * Creates a new {@link IllegalContainerStateException}.
     * 
     * @param container
     *        referenced {@link Container}
     * 
     * @param messagePattern
     *        {@link String} specifying the message pattern
     * 
     * @param messageArguments
     *        comma separated sequence of {@link Object} message arguments
     */
    public IllegalContainerStateException(final Container<?> container, final String messagePattern,
                                          final Object... messageArguments) {
        this(container, messagePattern, (Throwable) null, messageArguments);
        this.container = container;
    }

    /**
     * Creates a new {@link IllegalContainerStateException}.
     * 
     * @param container
     *        referenced {@link Container}
     * 
     * @param messagePattern
     *        {@link String} specifying the message pattern
     * 
     * @param cause
     *        {@link Throwable} that caused this
     *        {@link IllegalContainerStateException}
     * 
     * @param messageArguments
     *        comma separated sequence of {@link Object} message arguments
     */
    public IllegalContainerStateException(final Container<?> container, final String messagePattern,
                                          final Throwable cause, final Object... messageArguments) {
        super(messagePattern, cause, container, messageArguments);
    }

    /**
     * Returns the referenced {@link Container}.
     * 
     * @return referenced {@link Container}
     */
    public Container<?> getContainer() {
        return container;
    }
}

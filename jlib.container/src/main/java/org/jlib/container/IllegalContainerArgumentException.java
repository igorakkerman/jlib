package org.jlib.container;

import java.text.MessageFormat;

/**
 * {@link IllegalArgumentException} referencing a {@link Container}.
 * 
 * @author Igor Akkerman
 */
public abstract class IllegalContainerArgumentException
extends IllegalArgumentException {

    /** serialVersionUID */
    private static final long serialVersionUID = 2421922462571124521L;

    /** referenced {@link Container} */
    private final Container<?> container;

    /**
     * Creates a new {@link IllegalContainerArgumentException}.
     * 
     * @param container
     *        referenced {@link Container}
     */
    public IllegalContainerArgumentException(final Container<?> container) {
        this(container, "{1}");
    }

    /**
     * Creates a new {@link IllegalContainerArgumentException}.
     * 
     * @param container
     *        referenced {@link Container}
     * 
     * @param messagePattern
     *        String specifying the pattern of the error message
     * 
     * @param messageParameters
     *        sequence of {@link Object} message parameters
     */
    public IllegalContainerArgumentException(final Container<?> container, final String messagePattern,
                                             final Object... messageParameters) {

        this(container, messagePattern, null, messageParameters);
    }

    /**
     * Creates a new {@link IllegalContainerArgumentException}.
     * 
     * @param container
     *        referenced {@link Container}
     * 
     * @param messagePattern
     *        String specifying the pattern of the error message
     * 
     * @param cause
     *        Throwable that caused this
     *        {@link IllegalContainerArgumentException}
     * 
     * @param messageParameters
     *        sequence of {@link Object} message parameters
     */
    public IllegalContainerArgumentException(final Container<?> container, final String messagePattern,
                                             final Throwable cause, final Object... messageParameters) {

        super(MessageFormat.format(messagePattern, container, messageParameters), cause);

        this.container = container;
    }

    /**
     * Returns the {@link Container} reference by this
     * {@link IllegalContainerArgumentException}.
     * 
     * @return referenced {@link Container}
     */
    public Container<?> getContainer() {
        return container;
    }
}

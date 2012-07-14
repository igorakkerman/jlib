package org.jlib.container;

import org.jlib.core.traverser.IllegalTraversibleArgumentException;

/**
 * {@link IllegalArgumentException} referencing a {@link Container}.
 * 
 * @author Igor Akkerman
 */
public abstract class IllegalContainerArgumentException
extends IllegalTraversibleArgumentException {

    /** serialVersionUID */
    private static final long serialVersionUID = 4325711014434407944L;

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
     * @param messageArguments
     *        sequence of {@link Object} message arguments
     */
    public IllegalContainerArgumentException(final Container<?> container, final String messagePattern,
                                             final Object... messageArguments) {

        this(container, messagePattern, null, messageArguments);
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
     * @param messageArguments
     *        sequence of {@link Object} message arguments
     */
    public IllegalContainerArgumentException(final Container<?> container, final String messagePattern,
                                             final Throwable cause, final Object... messageArguments) {

        super(container, messagePattern, cause, messageArguments);

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

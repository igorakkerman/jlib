package org.jlib.container.collection;

import org.jlib.container.Container;
import org.jlib.container.IllegalContainerArgumentException;

/**
 * {@link IllegalContainerArgumentException} thrown when an argument caused an
 * error in a delegate {@link Object}.
 * 
 * @author Igor Akkerman
 */
public class IllegalContainerDelegateArgumentException
extends IllegalContainerArgumentException {

    /** serialVersionUID */
    private static final long serialVersionUID = 8427879807874812907L;

    /** delegate {@link Object} */
    private final Object delegate;

    /**
     * Creates a new {@link IllegalContainerDelegateArgumentException}.
     * 
     * @param container
     *        referenced {@link Container}
     * 
     * @param delegate
     *        delegate {@link Object}
     * 
     * @param argument
     *        argument {@link Object} that caused the error
     * 
     * @param messagePattern
     *        {@link String} specifying the error message pattern
     * 
     * @param cause
     *        Throwable that caused this
     *        {@link IllegalContainerDelegateArgumentException}
     * 
     * @param messageArguments
     *        comma separated sequence of {@link Object} message arguments
     */
    public IllegalContainerDelegateArgumentException(final Container<?> container, final Object delegate,
                                                     final Object argument, final String messagePattern,
                                                     final Throwable cause, final Object... messageArguments) {
        super(container, messagePattern, cause, delegate, argument, messageArguments);

        this.delegate = delegate;
    }

    /**
     * Returns the delegate.
     * 
     * @return delegate {@link Object}
     */
    public Object getDelegate() {
        return delegate;
    }
}

package org.jlib.container.collection;

import org.jlib.container.Container;
import org.jlib.container.IllegalContainerArgumentException;
import org.jlib.container.IllegalContainerStateException;

/**
 * {@link IllegalContainerArgumentException} thrown when a delegate object
 * signals an error.
 * 
 * @author Igor Akkerman
 */
public class IllegalContainerDelegateStateException
extends IllegalContainerStateException {

    /** serialVersionUID */
    private static final long serialVersionUID = 8427879807874812907L;

    /** delegate {@link Object} */
    private final Object delegate;

    /**
     * Creates a new {@link IllegalContainerDelegateStateException}.
     * 
     * @param container
     *        referenced {@link Container}
     * 
     * @param delegate
     *        delegate Object
     * 
     * @param messagePattern
     *        {@link String} specifying the error message pattern
     * 
     * @param cause
     *        Throwable that caused this
     *        {@link IllegalContainerDelegateStateException}
     * 
     * @param messageArguments
     *        comma separated sequence of {@link Object} message arguments
     */
    public IllegalContainerDelegateStateException(final Container<?> container, final Object delegate,
                                                  final String messagePattern, final Throwable cause,
                                                  final Object... messageArguments) {
        super(container, messagePattern, cause, delegate, messageArguments);

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

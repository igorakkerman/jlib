package org.jlib.core.traverser;

/**
 * {@link IllegalTraverserStateException} thrown when there is no next Item to
 * return by a {@link Traverser}.
 * 
 * @author Igor Akkerman
 */
public class NoPreviousItemException
extends IllegalTraverserStateException {

    /**
     * Creates a new {@link NoPreviousItemException}.
     * 
     * @param traversible
     *        traversed {@link Traversible}
     */
    public NoPreviousItemException(final Traversible<?> traversible) {
        super(traversible);
    }

    /**
     * Creates a new {@link NoPreviousItemException} with the specified cause.
     * 
     * @param traversible
     *        traversed {@link Traversible}
     * 
     * @param cause
     *        {@link Throwable} that caused this {@link NoPreviousItemException}
     */
    public NoPreviousItemException(final Traversible<?> traversible, final Throwable cause) {
        super(traversible, cause);
    }

    /**
     * Creates a new {@link NoPreviousItemException} with the specified cause.
     * 
     * @param traversible
     *        traversed {@link Traversible}
     * 
     * @param messagePattern
     *        {@link String} specifying the error message pattern
     * 
     * @param messageArguments
     *        comma separated sequence of {@link Object} instances specifying
     *        the message arguments
     */
    public NoPreviousItemException(final Traversible<?> traversible, final String messagePattern,
                               final Object... messageArguments) {
        super(traversible, messagePattern, messageArguments);
    }

    /**
     * Creates a new {@link NoPreviousItemException} with the specified cause.
     * 
     * @param traversible
     *        traversed {@link Traversible}
     * 
     * @param messagePattern
     *        {@link String} specifying the error message pattern
     * 
     * @param cause
     *        {@link Throwable} that caused this {@link NoPreviousItemException}
     * 
     * @param messageArguments
     *        comma separated sequence of {@link Object} instances specifying
     *        the message arguments
     */
    public NoPreviousItemException(final Traversible<?> traversible, final String messagePattern, final Throwable cause,
                               final Object... messageArguments) {
        super(traversible, messagePattern, cause, messageArguments);
    }
}

package org.jlib.core.traverser;

/**
 * {@link IllegalTraverserStateException} thrown when there is Item to remove by
 * a {@link Traverser}.
 * 
 * @author Igor Akkerman
 */
public class NoItemToRemoveException
extends IllegalTraverserStateException {

    /**
     * Creates a new {@link NoItemToRemoveException}.
     */
    public NoItemToRemoveException() {
        super();
    }

    /**
     * Creates a new {@link NoItemToRemoveException} with the specified cause.
     * 
     * @param cause
     *        {@link Throwable} that caused this {@link NoItemToRemoveException}
     */
    public NoItemToRemoveException(final Throwable cause) {
        super(cause);
    }
}

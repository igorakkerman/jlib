package org.jlib.core.traverser;

/**
 * {@link IllegalTraverserStateException} thrown when there is no next Item to
 * return by a {@link Traverser}.
 * 
 * @author Igor Akkerman
 */
public class NoNextItemException
extends IllegalTraverserStateException {

    /**
     * Creates a new {@link NoNextItemException}.
     */
    public NoNextItemException() {
        super();
    }

    /**
     * Creates a new {@link NoNextItemException} with the specified cause.
     * 
     * @param cause
     *        {@link Throwable} that caused this {@link NoNextItemException}
     */
    public NoNextItemException(final Throwable cause) {
        super(cause);
    }
}

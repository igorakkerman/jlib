package org.jlib.core.traverser;

/**
 * {@link IllegalTraverserStateException} thrown when there is Item to remove by
 * a {@link Traverser}.
 * 
 * @author Igor Akkerman
 */
public class NoItemToReplaceException
extends IllegalTraverserStateException {

    /**
     * Creates a new {@link NoItemToReplaceException}.
     * 
     * @param traversible
     *        traversed {@link Traversible}
     */
    public NoItemToReplaceException(final Traversible<?> traversible) {
        super(traversible);
    }

    /**
     * Creates a new {@link NoItemToReplaceException} with the specified cause.
     * 
     * @param traversible
     *        traversed {@link Traversible}
     * 
     * @param cause
     *        {@link Throwable} that caused this
     *        {@link NoItemToReplaceException}
     */
    public NoItemToReplaceException(final Traversible<?> traversible, final Throwable cause) {
        super(traversible, cause);
    }
}

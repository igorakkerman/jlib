package org.jlib.core.traverser;

/**
 * {@link IllegalTraverserStateException} thrown when there is Item to remove by
 * a {@link Traverser}.
 * 
 * @author Igor Akkerman
 */
public class NoItemToRemoveException
extends IllegalTraverserStateException {

    /** serialVersionUID */
    private static final long serialVersionUID = -5330769541839992129L;

    /**
     * Creates a new {@link NoItemToRemoveException}.
     * 
     * @param traversible
     *        traversed {@link Traversible}
     */
    public NoItemToRemoveException(final Traversible<?> traversible) {
        super(traversible);
    }

    /**
     * Creates a new {@link NoItemToRemoveException} with the specified cause.
     * 
     * @param traversible
     *        traversed {@link Traversible}
     * 
     * @param cause
     *        {@link Throwable} that caused this {@link NoItemToRemoveException}
     */
    public NoItemToRemoveException(final Traversible<?> traversible, final Throwable cause) {
        super(traversible, cause);
    }
}

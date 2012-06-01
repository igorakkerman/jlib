package org.jlib.core.traverser;

/**
 * {@link IllegalTraverserStateException} thrown when the traversed
 * {@link Traversible} claims a state error.
 * 
 * @author Igor Akkerman
 */
public class IllegalTraversibleStateException
extends IllegalTraverserStateException {

    /**
     * Creates a new {@link IllegalTraversibleStateException}.
     * 
     * @param traversible
     *        traversed {@link Traversible}
     * 
     * @param cause
     *        {@link Throwable} that caused this
     *        {@link IllegalTraversibleStateException}
     */
    public IllegalTraversibleStateException(final Traversible<?> traversible, final Throwable cause) {
        super(traversible, cause);
    }
}

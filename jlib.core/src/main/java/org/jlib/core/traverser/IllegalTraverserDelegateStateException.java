package org.jlib.core.traverser;

/**
 * {@link IllegalTraverserStateException} thrown when the delegate
 * 
 * @author Igor Akkerman
 */
public class IllegalTraverserDelegateStateException
extends IllegalTraverserStateException {

    /**
     * Creates a new {@link IllegalTraverserDelegateStateException}.
     * 
     * @param cause
     *        {@link Throwable} that caused this
     *        {@link IllegalTraverserDelegateStateException}
     */
    public IllegalTraverserDelegateStateException(final Throwable cause) {
        super(cause);
    }
}

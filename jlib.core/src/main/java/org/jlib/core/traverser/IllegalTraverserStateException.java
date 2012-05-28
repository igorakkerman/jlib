package org.jlib.core.traverser;


/**
 * Exception thrown when an illegal state has been reached in a
 * {@link Traverser}.
 * 
 * @author Igor Akkerman
 */
public abstract class IllegalTraverserStateException
extends RuntimeException {

    /** serialVersionUID */
    private static final long serialVersionUID = -5070211173782251202L;

    /**
     * Creates a new {@link IllegalTraverserStateException}.
     */
    public IllegalTraverserStateException() {
        super();
    }

    /**
     * Creates a new {@link IllegalTraverserStateException}.
     * 
     * @param cause
     *        {@link Throwable} that caused this
     *        {@link IllegalThreadStateException}
     */
    public IllegalTraverserStateException(final Throwable cause) {
        super(cause);
    }
}

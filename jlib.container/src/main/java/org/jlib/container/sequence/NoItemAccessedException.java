package org.jlib.container.sequence;

/**
 * {@link IllegalSequenceTraverserStateException} thrown when a requested Item
 * has not been previously accessed.
 * 
 * @author Igor Akkerman
 */
public class NoItemAccessedException
extends Exception {

    /** serialVersionUID */
    private static final long serialVersionUID = -375876005222159877L;

    /**
     * Creates a new {@link NoItemAccessedException}.
     */
    public NoItemAccessedException() {
        super();
    }
}

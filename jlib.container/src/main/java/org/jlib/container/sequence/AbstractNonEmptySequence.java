package org.jlib.container.sequence;

/**
 * Skeletal implementation of a non-empty {@link Sequence}.
 * 
 * @param <Element>
 *        type of elements held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public abstract class AbstractNonEmptySequence<Element>
extends AbstractSequence<Element> {

    /**
     * Creates a new AbstractNonEmptySequence.
     */
    public AbstractNonEmptySequence() {
        super();
    }

    @Override
    public final boolean isEmpty() {
        return false;
    }
}

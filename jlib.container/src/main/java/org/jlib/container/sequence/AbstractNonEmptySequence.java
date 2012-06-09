package org.jlib.container.sequence;

/**
 * Skeletal implementation of a non-empty {@link Sequence}.
 * 
 * @param <Item>
 *        type of items held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public abstract class AbstractNonEmptySequence<Item>
extends AbstractSequence<Item> {

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

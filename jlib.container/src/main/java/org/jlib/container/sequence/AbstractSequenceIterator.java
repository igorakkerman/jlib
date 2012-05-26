package org.jlib.container.sequence;

import org.jlib.core.iterator.AbstractIterator;

/**
 * Skeletal implementation of a {@link SequenceIterator}.
 * 
 * @param <Element>
 *        type of the elements held in the {@link Sequence}
 * 
 * @param <Sequenze>
 *        type of the traversed {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public abstract class AbstractSequenceIterator<Element, Sequenze extends Sequence<Element>>
extends AbstractIterator<Element>
implements SequenceIterator<Element> {

    /** traversed {@link Sequence} */
    private Sequenze sequence;

    /**
     * Creates a new {@link AbstractSequenceIterator}.
     * 
     * @param sequence
     *        traversed {@link Sequence}
     */
    public AbstractSequenceIterator(final Sequenze sequence) {
        super();
    }

    /**
     * Returns the traversed {@link Sequence}.
     * 
     * @return traversed {@link Sequence}
     */
    protected Sequenze getSequence() {
        return sequence;
    }
}

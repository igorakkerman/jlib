package org.jlib.container.sequence;

/**
 * Skeletal implementation of an {@link ReplaceIndexSequence}.
 * 
 * @param <Element>
 *        type of elements held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public abstract class AbstractReplaceIndexSequence<Element>
extends AbstractIndexSequence<Element>
implements ReplaceIndexSequence<Element> {

    /**
     * Creates a new AbstractReplaceIndexSequence.
     */
    public AbstractReplaceIndexSequence() {
        super();
    }

    @Override
    public ReplaceIndexSequenceIterator<Element> createIterator() {
        return new DefaultReplaceIndexSequenceIterator<>(this);
    }
    
    @Override
    public ReplaceIndexSequenceIterator<Element> createIterator(final int startIndex)
    throws SequenceIndexOutOfBoundsException {
        return new DefaultReplaceIndexSequenceIterator<>(this, startIndex);
    }
}

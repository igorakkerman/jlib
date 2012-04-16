package org.jlib.container.sequence;


/**
 * Skeletal implementation of an {@link IndexSequence}.
 * 
 * @param <Element>
 *        type of elements held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public abstract class AbstractIndexSequence<Element>
extends AbstractSequence<Element>
implements IndexSequence<Element> {
    
    /**
     * Creates a new {@link AbstractIndexSequence}.
     */
    public AbstractIndexSequence() {
        super();
    }
    
    @Override
    public IndexSequenceIterator<Element> createIterator() {
        return new DefaultIndexSequenceIterator<>(this);
    }
}

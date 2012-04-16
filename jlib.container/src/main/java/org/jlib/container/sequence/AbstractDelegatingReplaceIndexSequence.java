package org.jlib.container.sequence;

/**
 * Skeletal implementation of an {@link ReplaceIndexSequence}.
 * 
 * TODO: create a more general skeletal implementation and call this one
 * DelegatingReplaceIndexSequence
 * 
 * @param <Element>
 *        type of elements held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public abstract class AbstractDelegatingReplaceIndexSequence<Element>
extends AbstractDelegatingIndexSequence<Element>
implements ReplaceIndexSequence<Element> {

    /**
     * Creates a new {@link AbstractDelegatingReplaceIndexSequence}.
     */
    protected AbstractDelegatingReplaceIndexSequence() {
        super();
    }

    /**
     * Returns the {@link ReplaceIndexSequence} containing the {@code Elements}
     * of this {@link AbstractDelegatingReplaceIndexSequence}.
     * 
     * @return the delegate {@link ReplaceIndexSequence}
     */
    @Override
    protected abstract ReplaceIndexSequence<Element> getDelegateSequence();


    @Override
    public void set(int index, Element element)
    throws SequenceIndexOutOfBoundsException {
        getDelegateSequence().set(index, element);
    }


    @Override
    public ReplaceIndexSequenceIterator<Element> createIterator() {
        return getDelegateSequence().createIterator();
    }


    @Override
    public ReplaceIndexSequenceIterator<Element> createIterator(int startIndex)
    throws SequenceIndexOutOfBoundsException {
        return getDelegateSequence().createIterator(startIndex);
    }
}

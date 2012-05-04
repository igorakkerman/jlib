package org.jlib.container.sequence;

/**
 * {@link ArraySequence} allowing its Elements to be replaced.
 * 
 * @param <Element>
 *        type of the elements of the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public class ReplaceArraySequence<Element>
extends ArraySequence<Element>
implements ReplaceIndexSequence<Element> {

    /**
     * Creates a new {@link ReplaceArraySequence}.
     * 
     * @param firstIndex
     *        first index of this {@link ReplaceArraySequence}
     * 
     * @param lastIndex
     *        last index of this {@link ReplaceArraySequence}
     */
    protected ReplaceArraySequence(final int firstIndex, final int lastIndex) {
        super(firstIndex, lastIndex);
    }

    @Override
    // raising visibility from protected to public
    public void replace(final int index, final Element element)
    throws SequenceIndexOutOfBoundsException {
        super.replace(index, element);
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

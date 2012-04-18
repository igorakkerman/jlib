package org.jlib.container.sequence;

import java.util.ArrayList;
import java.util.List;

/**
 * Non-empty {@link IndexSequence}.
 * 
 * @param <Element>
 *        type of the elements of the sequence
 * 
 * @author Igor Akkerman
 */
public abstract class AbstractNonEmptyIndexSequence<Element>
extends AbstractNonEmptySequence<Element>
implements IndexSequence<Element> {

    /** current minimum index of this sequence */
    protected int firstIndex;

    /** current maximum index of this sequence */
    protected int lastIndex;

    /**
     * Creates a new AbstractNonEmptyIndexSequence with the specified minimum
     * and maximum indices. Classes extending this class must initialize the
     * Element store.
     * 
     * @param firstIndex
     *        integer specifying the initial minimum index of this ArraySequence
     * 
     * @param lastIndex
     *        integer specifying the maximum index of this ArraySequence
     * 
     * @throws IllegalArgumentException
     *         if {@code  lastIndex < firstIndex}
     */
    public AbstractNonEmptyIndexSequence(final int firstIndex, final int lastIndex) {
        super();

        this.firstIndex = firstIndex;
        this.lastIndex = lastIndex;

        if (lastIndex < firstIndex)
            throw new IllegalArgumentException("lastIndex == " + lastIndex + " < " + firstIndex + " == firstIndex");
    }

    @Override
    public int getFirstIndex() {
        return firstIndex;
    }

    @Override
    public int getLastIndex() {
        return lastIndex;
    }

    @Override
    public int getSize() {
        return lastIndex - firstIndex + 1;
    }

    @Override
    public int indexOf(final Element searchedElement) {
        for (int index = firstIndex; index <= lastIndex; index ++) {
            final Element sequenceElement = get(index);
            if (sequenceElement == searchedElement || sequenceElement != null &&
                sequenceElement.equals(searchedElement))
                return index;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(final Element element) {
        Element sequenceElement;
        for (int index = lastIndex; index >= firstIndex; index --) {
            sequenceElement = get(index);
            if (sequenceElement == element || sequenceElement != null && sequenceElement.equals(element))
                return index;
        }
        return -1;
    }

    @Override
    public IndexSequenceIterator<Element> createIterator() {
        return createIterator(firstIndex);
    }

    @Override
    public IndexSequenceIterator<Element> createIterator(final int startIndex)
    throws SequenceIndexOutOfBoundsException {
        return new DefaultIndexSequenceIterator<Element>(this, startIndex);
    }

    @Override
    public List<Element> createSubList(final int fromIndex, final int toIndex)
    throws IllegalArgumentException, SequenceIndexOutOfBoundsException {
        if (fromIndex > toIndex)
            throw new IllegalArgumentException();

        final List<Element> list = new ArrayList<Element>(getSize());
        for (int index = fromIndex; index <= toIndex; index ++)
            list.add(get(index));

        return list;
    }

    @Override
    public IndexSequence<Element> createSubSequence(final int fromIndex, final int toIndex)
    throws IllegalArgumentException, SequenceIndexOutOfBoundsException {
        if (fromIndex > toIndex)
            throw new IllegalArgumentException();

        final ReplaceIndexSequence<Element> sequence = new ArraySequence<Element>(fromIndex, toIndex);
        for (int index = fromIndex; index <= toIndex; index ++)
            sequence.replace(index, get(index));

        return sequence;
    }

    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder(8 * getSize());

        final IndexSequenceIterator<Element> iterator = createIterator();

        stringBuilder.append('[');

        stringBuilder.append(iterator.nextIndex());
        stringBuilder.append('=');
        stringBuilder.append(iterator.next());

        while (iterator.hasNext()) {
            stringBuilder.append(", ");
            stringBuilder.append(iterator.nextIndex());
            stringBuilder.append('=');
            stringBuilder.append(iterator.next());
        }

        stringBuilder.append(']');

        return stringBuilder.toString();
    }
}

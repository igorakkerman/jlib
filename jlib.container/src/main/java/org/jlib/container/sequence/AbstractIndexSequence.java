package org.jlib.container.sequence;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Non-empty {@link IndexSequence}.
 * 
 * @param <Element>
 *        type of the elements of the sequence
 * 
 * @author Igor Akkerman
 */
public abstract class AbstractIndexSequence<Element>
extends AbstractNonEmptySequence<Element>
implements IndexSequence<Element> {

    /** current minimum index of this sequence */
    private final int firstIndex;

    /** current maximum index of this sequence */
    private final int lastIndex;

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
    public AbstractIndexSequence(final int firstIndex, final int lastIndex) {
        super();

        this.firstIndex = firstIndex;
        this.lastIndex = lastIndex;

        if (lastIndex < firstIndex)
            throw new IllegalArgumentException("lastIndex == " + lastIndex + " < " + firstIndex + " == firstIndex");
    }

    /**
     * Asserts that the specified index is inside the valid bounds of this
     * {@link AbstractIndexSequence}.
     * 
     * @param index
     *        integer specifying the index to verify
     * 
     * @throws SequenceIndexOutOfBoundsException
     *         if {@code index} is out of the {@link ArraySequence} bounds
     */
    protected void assertIndexValid(final int index)
    throws SequenceIndexOutOfBoundsException {
        if (index < firstIndex || index > lastIndex)
            throw new SequenceIndexOutOfBoundsException(this, index);
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
    public int getFirstIndexOf(final Element searchedElement)
    throws NoSuchElementException {
        for (int index = firstIndex; index <= lastIndex; index ++)
            if (get(index).equals(searchedElement))
                return index;

        throw new NoSuchElementException();
    }

    @Override
    public int getLastIndexOf(final Element searchedElement) {
        for (int index = lastIndex; index >= firstIndex; index --)
            if (get(index).equals(searchedElement))
                return index;

        throw new NoSuchElementException();
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

        final ReplaceIndexSequence<Element> sequence =
            ArraySequenceCreator.<Element> createSequence(fromIndex, toIndex);

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

    @Override
    public IndexSequenceIterator<Element> createIterator() {
        return new DefaultIndexSequenceIterator<>(this);
    }

    @Override
    public IndexSequenceIterator<Element> createIterator(final int startIndex)
    throws SequenceIndexOutOfBoundsException {
        return new DefaultIndexSequenceIterator<>(this, startIndex);
    }

    @Override
    public int getFirstIndexOf(final Element element)
    throws NoSuchElementException {
        final int lastIndex = getLastIndex();

        for (int index = getFirstIndex(); index <= lastIndex; index ++)
            if (get(index).equals(element))
                return index;

        throw new NoSuchElementException(element.toString());
    }

    @Override
    public int getLastIndexOf(final Element element)
    throws NoSuchElementException {
        final int firstIndex = getFirstIndex();

        for (int index = getLastIndex(); index >= firstIndex; index --)
            if (get(index).equals(element))
                return index;

        throw new NoSuchElementException(element.toString());
    }

    @Override
    public IndexSequence<Element> createSubSequence(final int fromIndex, final int toIndex)
    throws IllegalArgumentException, SequenceIndexOutOfBoundsException {
        final ReplaceIndexSequence<Element> subSequence = new ArraySequence<>(toIndex - fromIndex + 1);

        for (int index = fromIndex; index <= toIndex; index ++)
            subSequence.replace(index, get(index));

        return subSequence;
    }

    @Override
    public List<Element> createSubList(final int fromIndex, final int toIndex)
    throws IllegalArgumentException, SequenceIndexOutOfBoundsException {
        final List<Element> subList = new ArrayList<Element>(toIndex - fromIndex + 1);

        for (int index = fromIndex; index <= toIndex; index ++)
            subList.add(get(index));

        return subList;
    }

    @Override
    public int getSize() {
        return getLastIndex() - getFirstIndex() + 1;
    }

}

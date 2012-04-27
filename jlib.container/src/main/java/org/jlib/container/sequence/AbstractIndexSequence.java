package org.jlib.container.sequence;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Skeletal implementation of an {@link IndexSequence}.
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
     * @throws InvalidSequenceIndexRangeException
     *         if {@code  lastIndex < firstIndex}
     */
    public AbstractIndexSequence(final int firstIndex, final int lastIndex) {
        super();

        this.firstIndex = firstIndex;
        this.lastIndex = lastIndex;

        if (firstIndex < lastIndex)
            throw new InvalidSequenceIndexRangeException(this, firstIndex, lastIndex);
    }

    @Override
    public final Element get(final int index)
    throws SequenceIndexOutOfBoundsException {
        assertIndexValid(index);

        return getStoredElement(index);
    }

    /**
     * Returns the Element stored at the specified index expecting the index to
     * be valid.
     * 
     * @param index
     *        integer specifying the valid index
     * 
     * @return Element stored at {@code index}
     */
    protected abstract Element getStoredElement(final int index);

    @Override
    public int getFirstIndexOf(final Element element)
    throws NoSuchElementException {
        for (int index = firstIndex; index <= lastIndex; index ++)
            if (getStoredElement(index).equals(element))
                return index;

        throw new NoSuchElementException(element.toString());
    }

    @Override
    public int getLastIndexOf(final Element element)
    throws NoSuchElementException {
        for (int index = lastIndex; index >= firstIndex; index --)
            if (getStoredElement(index).equals(element))
                return index;

        throw new NoSuchElementException(element.toString());
    }

    @Override
    public IndexSequenceIterator<Element> createIterator() {
        return createIterator(firstIndex);
    }

    @Override
    public IndexSequenceIterator<Element> createIterator(final int startIndex)
    throws SequenceIndexOutOfBoundsException {
        return new DefaultIndexSequenceIterator<>(this, startIndex);
    }

    @Override
    public List<Element> createSubList(final int fromIndex, final int toIndex)
    throws IllegalArgumentException, SequenceIndexOutOfBoundsException {
        assertIndexRangeValid(fromIndex, toIndex);

        final List<Element> subList = new ArrayList<Element>(getSize());

        for (int index = fromIndex; index <= toIndex; index ++)
            subList.add(getStoredElement(index));

        return subList;
    }

    @Override
    public IndexSequence<Element> createSubSequence(final int fromIndex, final int toIndex)
    throws IllegalArgumentException, SequenceIndexOutOfBoundsException {
        assertIndexRangeValid(fromIndex, toIndex);

        final ArraySequence<Element> sequence =
            ArraySequenceCreator.<Element> getInstance().createSequence(fromIndex, toIndex);

        for (int index = fromIndex; index <= toIndex; index ++)
            sequence.replaceStoredElement(index, getStoredElement(index));

        return sequence;
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

    /**
     * Asserts that the specified from and to indices are valid, that is,
     * {@code getFirstIndex() <= fromIndex <= toIndex <= getLastIndex()}.
     * 
     * @param fromIndex
     *        integer specifying the from index
     * 
     * @param toIndex
     *        integer specifying the to index
     * 
     * @throws SequenceIndexOutOfBoundsException
     *         if {@code fromIndex > toIndex}
     */
    private void assertIndexRangeValid(final int fromIndex, final int toIndex) {
        if (fromIndex < firstIndex)
            throw new SequenceIndexOutOfBoundsException(this, fromIndex, "fromIndex == " + fromIndex + " < " +
                                                                         firstIndex + " == firstIndex");
        if (toIndex > lastIndex)
            throw new SequenceIndexOutOfBoundsException(this, toIndex, "toIndex == " + toIndex + " < " + lastIndex +
                                                                       " == lastIndex");

        if (toIndex < fromIndex)
            throw new InvalidSequenceIndexRangeException(this, fromIndex, toIndex);
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
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder(8 * getSize());

        final IndexSequenceIterator<Element> iterator = createIterator();

        stringBuilder.append('[');

        stringBuilder.append(iterator.nextIndex());
        stringBuilder.append(": ");
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

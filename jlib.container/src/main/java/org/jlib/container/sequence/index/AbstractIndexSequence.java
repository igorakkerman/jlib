package org.jlib.container.sequence.index;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.jlib.container.sequence.AbstractNonEmptySequence;
import org.jlib.container.sequence.array.ArraySequence;
import org.jlib.container.sequence.array.ArraySequenceCreator;

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
    private int firstIndex;

    /** current maximum index of this sequence */
    private int lastIndex;

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
        return new StateIndexSequenceIterator<>(this, startIndex);
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
        if (index < firstIndex)
            throw new SequenceIndexOutOfBoundsException(this, index, "index == " + index + " < " + firstIndex +
                                                                     " == firstIndex");

        if (index > lastIndex)
            throw new SequenceIndexOutOfBoundsException(this, index, "index == " + index + " > " + lastIndex +
                                                                     " == lastIndex");
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

        final IndexSequenceIterator<Element> elementsIterator = createIterator();

        stringBuilder.append('[');

        getNextElementString(stringBuilder, elementsIterator);

        while (elementsIterator.hasNext()) {
            stringBuilder.append(", ");
            getNextElementString(stringBuilder, elementsIterator);
        }

        stringBuilder.append(']');

        return stringBuilder.toString();
    }

    /**
     * Appends a {@link String} representation of the next Element returned by
     * the specified {@link IndexSequenceIterator} to the specified
     * {@link StringBuilder}.
     * 
     * @param stringBuilder
     *        {@link StringBuilder} to which the Element representation is
     *        appended
     * 
     * @param elementsIterator
     *        {@link IndexSequenceIterator} providing the Element
     */
    private void getNextElementString(final StringBuilder stringBuilder,
                                      final IndexSequenceIterator<Element> elementsIterator) {
        stringBuilder.append(elementsIterator.getNextElementIndex());
        stringBuilder.append(": ");
        stringBuilder.append(elementsIterator.next());
    }

    /**
     * Registers the first index of this {@link AbstractIndexSequence}.
     * 
     * @param firstIndex
     *        integer specifying the first index
     */
    protected void setFirstIndex(final int firstIndex) {
        this.firstIndex = firstIndex;
    }

    /**
     * Registers the last index of this {@link AbstractIndexSequence}.
     * 
     * @param lastIndex
     *        integer specifying the last index
     */
    protected void setLastIndex(final int lastIndex) {
        this.lastIndex = lastIndex;
    }
}

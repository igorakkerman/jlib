package org.jlib.container.sequence.index;

import java.util.ArrayList;
import java.util.List;

import org.jlib.container.sequence.AbstractNonEmptySequence;
import org.jlib.container.sequence.SequenceTraverser;
import org.jlib.container.sequence.index.array.ArraySequence;

import static org.jlib.container.sequence.index.IndexSequenceUtility.assertIndexRangeValid;
import static org.jlib.container.sequence.index.IndexSequenceUtility.assertIndexValid;

/**
 * Skeletal implementation of an {@link IndexSequence}.
 * 
 * @param <Item>
 *        type of the items of the sequence
 * 
 * @author Igor Akkerman
 */
public abstract class AbstractIndexSequence<Item>
extends AbstractNonEmptySequence<Item>
implements IndexSequence<Item> {

    /** current minimum index of this sequence */
    private int firstIndex;

    /** current maximum index of this sequence */
    private int lastIndex;

    /**
     * Creates a new AbstractNonEmptyIndexSequence with the specified minimum
     * and maximum indices. Classes extending this class must initialize the
     * Item store.
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
    public final Item get(final int index)
    throws SequenceIndexOutOfBoundsException {
        assertIndexValid(this, index);

        return getStoredItem(index);
    }

    /**
     * Returns the Item stored at the specified index expecting the index to be
     * valid.
     * 
     * @param index
     *        integer specifying the valid index
     * 
     * @return Item stored at {@code index}
     */
    protected abstract Item getStoredItem(final int index);

    @Override
    public final Item getFirstItem() {
        return getStoredItem(firstIndex);
    }

    @Override
    public final Item getLastItem() {
        return getStoredItem(lastIndex);
    }

    @Override
    public final int getFirstIndexOf(final Item item)
    throws NoSuchSequenceItemException {
        for (int index = firstIndex; index <= lastIndex; index ++)
            if (getStoredItem(index).equals(item))
                return index;

        throw new NoSuchSequenceItemException(this, item);
    }

    @Override
    public final int getLastIndexOf(final Item item)
    throws NoSuchSequenceItemException {
        for (int index = lastIndex; index >= firstIndex; index --)
            if (getStoredItem(index).equals(item))
                return index;

        throw new NoSuchSequenceItemException(this, item);
    }

    @Override
    public final IndexSequenceTraverser<Item> createTraverser() {
        return createIndexSequenceTraverser();
    }

    @Override
    public final SequenceTraverser<Item> createSequenceTraverser() {
        return createIndexSequenceTraverser();
    }

    @Override
    public final IndexSequenceTraverser<Item> createIndexSequenceTraverser() {
        return createIndexSequenceTraverser(firstIndex);
    }

    @Override
    public final IndexSequenceTraverser<Item> createIndexSequenceTraverser(final int startIndex)
    throws SequenceIndexOutOfBoundsException {
        return new DefaultIndexSequenceTraverser<>(this, startIndex);
    }

    @Override
    public final List<Item> createSubList(final int fromIndex, final int toIndex)
    throws IllegalArgumentException, SequenceIndexOutOfBoundsException {
        assertIndexRangeValid(this, fromIndex, toIndex);

        final List<Item> subList = new ArrayList<>(getSize());

        for (int index = fromIndex; index <= toIndex; index ++)
            subList.add(getStoredItem(index));

        return subList;
    }

    @Override
    public final IndexSequence<Item> createSubSequence(final int fromIndex, final int toIndex)
    throws IllegalArgumentException, SequenceIndexOutOfBoundsException {
        assertIndexRangeValid(this, fromIndex, toIndex);

        final AbstractInitializeableIndexSequence<Item> sequence =
            ArraySequence.<Item> getCreator().createSequence(fromIndex, toIndex);

        for (int index = fromIndex; index <= toIndex; index ++)
            sequence.replaceStoredItem(index, getStoredItem(index));

        return sequence;
    }

    @Override
    public final int getFirstIndex() {
        return firstIndex;
    }

    @Override
    public final int getLastIndex() {
        return lastIndex;
    }

    @Override
    public final int getSize() {
        return lastIndex - firstIndex + 1;
    }

    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder(8 * getSize());

        final IndexSequenceTraverser<Item> itemsTraverser = createTraverser();

        stringBuilder.append('[');

        getNextItemString(stringBuilder, itemsTraverser);

        while (itemsTraverser.isNextItemAccessible()) {
            stringBuilder.append(", ");
            getNextItemString(stringBuilder, itemsTraverser);
        }

        stringBuilder.append(']');

        return stringBuilder.toString();
    }

    /**
     * Appends a {@link String} representation of the next Item returned by the
     * specified {@link IndexSequenceTraverser} to the specified
     * {@link StringBuilder}.
     * 
     * @param stringBuilder
     *        {@link StringBuilder} to which the Item representation is appended
     * 
     * @param itemsTraverser
     *        {@link IndexSequenceTraverser} providing the Item
     */
    private void getNextItemString(final StringBuilder stringBuilder, final IndexSequenceTraverser<Item> itemsTraverser) {
        stringBuilder.append(itemsTraverser.getNextItemIndex());
        stringBuilder.append(": ");
        stringBuilder.append(itemsTraverser.getNextItem());
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

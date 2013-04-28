package org.jlib.container.sequence.index;

import org.jlib.container.Container;
import org.jlib.container.IllegalContainerArgumentException;
import org.jlib.container.IllegalContainerStateException;
import org.jlib.container.ObservedRemoveContainer;
import org.jlib.container.sequence.IllegalSequenceArgumentException;
import org.jlib.container.sequence.IllegalSequenceStateException;
import org.jlib.core.observer.ObserverUtility;
import org.jlib.core.observer.ValueObserver;
import org.jlib.core.operator.HandledOperator;
import org.jlib.core.operator.OperatorException;

/**
 * {@link IndexSequence} utility.
 * 
 * @author Igor Akkerman
 */
public final class IndexSequenceUtility {

    /** no visible constructor */
    private IndexSequenceUtility() {}

    /**
     * Asserts that the specified index is inside the valid bounds of the
     * specified {@link IndexSequence}.
     * 
     * @param sequence
     *        verified {@link IndexSequence}
     * 
     * @param index
     *        integer specifying the index to verify
     * 
     * @throws SequenceIndexOutOfBoundsException
     *         if
     *         {@code index < sequence.getFirstIndex() || index > sequence.getLastIndex()}
     */
    public static void assertIndexValid(final IndexSequence<?> sequence, final int index)
    throws SequenceIndexOutOfBoundsException {
        final int firstIndex = sequence.getFirstIndex();

        if (index < firstIndex)
            throw new SequenceIndexOutOfBoundsException(sequence, index, "index == " + index + " < " + firstIndex +
                                                                         " == firstIndex");

        final int lastIndex = sequence.getLastIndex();

        if (index > lastIndex)
            throw new SequenceIndexOutOfBoundsException(sequence, index, "index == " + index + " > " + lastIndex +
                                                                         " == lastIndex");
    }

    /**
     * Asserts that the specified <em>from</em> and <em>to</em> indices are
     * valid, that is,
     * {@code sequence.getFirstIndex() <= fromIndex <= toIndex <= sequence.getLastIndex()}
     * .
     * 
     * @param sequence
     *        verified {@link IndexSequence}
     * 
     * @param fromIndex
     *        integer specifying the from index
     * 
     * @param toIndex
     *        integer specifying the to index
     * 
     * @throws SequenceIndexOutOfBoundsException
     *         if
     *         {@code fromIndex < getFirstIndex() || toIndex > getLastIndex()}
     * 
     * @throws InvalidSequenceIndexRangeException
     *         if {@code fromIndex > toIndex}
     */
    public static void assertIndexRangeValid(final IndexSequence<?> sequence, final int fromIndex, final int toIndex)
    throws SequenceIndexOutOfBoundsException, InvalidSequenceIndexRangeException {
        final int firstIndex = sequence.getFirstIndex();

        if (fromIndex < firstIndex)
            throw new SequenceIndexOutOfBoundsException(sequence, fromIndex, "fromIndex == " + fromIndex + " < " +
                                                                             firstIndex + " == firstIndex");

        final int lastIndex = sequence.getLastIndex();

        if (toIndex > lastIndex)
            throw new SequenceIndexOutOfBoundsException(sequence, toIndex, "toIndex == " + toIndex + " < " + lastIndex +
                                                                           " == lastIndex");

        if (toIndex < fromIndex)
            throw new InvalidSequenceIndexRangeException(sequence, fromIndex, toIndex);
    }

    /**
     * Removes the specified Item from the specified {@link RemoveIndexSequence}
     * .
     * 
     * @param <Item>
     *        type of the items held in the {@link Container}
     * 
     * @param sequence
     *        {@link ObservedRemoveContainer} containing the Item
     * 
     * @param itemIndex
     *        index of the Item to remove
     * 
     * @param observers
     *        comma separated sequence of {@link ValueObserver} instances
     *        attending the removal
     * 
     * @throws IllegalSequenceArgumentException
     *         if the operation cannot be completed due to some property of
     *         {@code itemIndex}
     * 
     * @throws IllegalSequenceStateException
     *         if an error occurs during the operation
     * 
     * @throws RuntimeException
     *         if a {@link ValueObserver} operation throws this
     *         {@link RuntimeException}
     */
    @SuppressWarnings("unchecked")
    public static <Item> void remove(final RemoveIndexSequence<Item> sequence, final int itemIndex,
                                     final ValueObserver<Item>... observers)
    throws IllegalSequenceArgumentException, IllegalSequenceStateException, RuntimeException {

        ObserverUtility.operate(new HandledOperator() {

            @Override
            public void operate()
            throws OperatorException, RuntimeException {
                try {
                    sequence.remove(itemIndex);
                }
                catch (IllegalContainerArgumentException | IllegalContainerStateException exception) {
                    throw new OperatorException("remove: {0}", exception, itemIndex);
                }
            }
        },

        sequence.get(itemIndex), observers);
    }
}

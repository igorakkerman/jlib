package org.jlib.container.sequence.index;

import org.jlib.container.sequence.Sequence;

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
     *         if {@code index} is out of the {@link IndexSequence} bounds
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
     *         if {@code fromIndex > toIndex}
     */
    public static void assertIndexRangeValid(final IndexSequence<?> sequence, final int fromIndex, final int toIndex) {
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

    // @formatter:off
    /**
     * <p>
     * Creates a new {@link IndexSequence} containing the specified Integer
     * Elements having a specified first index. That is, the index of the first
     * Element of the specified sequence in the newly created
     * {@link IndexSequence} can be specified. The fixed size of the newly
     * created {@link IndexSequence} is the size of the specified sequence.
     * </p>
     * <p>
     * It doesn't know whether the first parameter is meant to be the minimum
     * index of the {@link IndexSequence} or the first Element of the sequence.
     * You could pass an array of {@link Integer} values instead which is the
     * equivalent to the sequence form for the argument
     * {@code Integer... elements} but the newly created class provides an
     * easier way: the factory methods
     * {@link #createIntegerIndexSequence(IndexSequenceCreator, Integer...)} or
     * {@link #createIntegerIndexSequenceFrom(IndexSequenceCreator, int, Integer[])}. The latter form takes
     * the minimum index as first argument.
     * </p>
     * 
     * {@literal
     *     // possible but not handy
     *     IndexSequence&lt;Integer&gt; integerSequence = createIntegerIndexSequence&lt;Integer&gt;new Integer[] 1, 2, 3, 4, 5, 6 });
     * 
     *     IndexSequence&lt;Integer&gt; integerSequence = createIntegerIndexSequence&lt;Integer&gt;(1, new Integer[] { 1, 2, 3, 4, 5, 6 });
     * 
     *     // easier to use (needs the static import of the factory method(s))
     *     IndexSequence&lt;Integer&gt; integerSequence = createIntegerSequence(1, 2, 3, 4, 5);
     * 
     *     IndexSequence&lt;Integer&gt; integerSequence = createIntegerSequenceFrom(1, 1, 2, 3, 4, 5);
     * }
     * 
     * @param <Sequenze>
     *        type of the {@link InitializeableIndexSequence} created
     * 
     * @param indexSequenceCreator
     *        {@link IndexSequenceCreator} to use
     * 
     * @param firstIndex
     *        integer specifying the minimum index
     * 
     * @param elements
     *        comma separated sequence of {@link Integer} Elements to store
     * 
     * @return new {@link IndexSequence} of {@link Integer} Elements
     */
    public static <Sequenze extends InitializeableIndexSequence<Integer>> 
                  Sequenze createIntegerIndexSequenceFrom(final IndexSequenceCreator<Integer, Sequenze> indexSequenceCreator,
                                                          final int firstIndex, final Integer... elements) {
        // @formatter:on
        return indexSequenceCreator.createSequence(firstIndex, elements);
    }

    /**
     * Creates a new {@link Sequence} containing the specified Integer Elements
     * having a first index of {@code 0}. The fixed size of the {@link Sequence}
     * is the size of the specified sequence.
     * 
     * @param <Sequenze>
     *        type of the {@link InitializeableIndexSequence} created
     * 
     * @param indexSequenceCreator
     *        {@link IndexSequenceCreator} to use
     * 
     * @param elements
     *        comma separated sequence of {@link Integer} elements to store
     * 
     * @return the newly created {@link Sequence}
     */
    // @formatter:off
    public static <Sequenze extends InitializeableIndexSequence<Integer>> 
                  Sequenze createIntegerIndexSequence(final IndexSequenceCreator<Integer, Sequenze> indexSequenceCreator,
                                                      final Integer... elements) {
        // @formatter:on
        return createIntegerIndexSequenceFrom(indexSequenceCreator, 0, elements);
    }
}

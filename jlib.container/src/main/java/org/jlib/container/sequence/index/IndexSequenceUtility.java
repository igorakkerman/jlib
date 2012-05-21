package org.jlib.container.sequence.index;

import java.util.Collection;

import org.jlib.container.Container;
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

    /**
     * Returns a new {@link IndexSequence} created by the specified
     * {@link IndexSequenceCreator} with the specified first and last indices.
     * 
     * @param <Element>
     *        type of elements held in the {@link Sequence}
     * 
     * @param <Sequenze>
     *        concrete type of the created {@link IndexSequence}
     * 
     * @param indexSequenceCreator
     *        {@link IndexSequenceCreator} used for creation
     * 
     * @param firstIndex
     *        integer specifying the first index
     * 
     * @param lastIndex
     *        integer specifying the lastindex
     * 
     * @return newly created {@link IndexSequence}
     */
    // @formatter:off
    public static <Element, Sequenze extends InitializeableIndexSequence<Element>> 
                  Sequenze createSequence(final IndexSequenceCreator<Sequenze> indexSequenceCreator,
                                          final int firstIndex, final int lastIndex) {
        return indexSequenceCreator.createSequence(firstIndex, lastIndex);
    }

    /**
     * Creates a new {@link InitializeableIndexSequence} containing the
     * specified Elements. That is, the index of the first Element of the
     * specified sequence in this Sequence is 0. The fixed size of the
     * {@link InitializeableIndexSequence} is the size of the specified
     * sequence.
     * 
     * @param indexSequenceCreator
     *        {@link IndexSequenceCreator} to use
     * 
     * @param elements
     *        comma separated sequence of Elements to store
     * 
     * @return the newly created {@link InitializeableIndexSequence}
     */
    @SafeVarargs
    // @formatter:off
    public static <Element, Sequenze extends InitializeableIndexSequence<Element>> 
                  Sequenze createASequence(final IndexSequenceCreator<Sequenze> indexSequenceCreator,
                                           final Element... elements) {
    // @formatter:on
        return createSequence(indexSequenceCreator, 0, elements);
    }

    /**
     * Creates a new {@link InitializeableIndexSequence} containing the
     * specified Elements having a specified first index. That is, the index of
     * the first Element of the specified sequence in the
     * {@link InitializeableIndexSequence} can be specified. The fixed size of
     * the {@link InitializeableIndexSequence} is the size of the specified
     * sequence.
     * 
     * @param indexSequenceCreator
     *        {@link IndexSequenceCreator} to use
     * 
     * @param firstIndex
     *        integer specifying the first index of the
     *        {@link InitializeableIndexSequence}
     * 
     * @param elements
     *        comma separated sequence of Elements to store
     * 
     * @return newly created {@link InitializeableIndexSequence}
     */
    @SafeVarargs
    // @formatter:off
    public static <Element, Sequenze extends InitializeableIndexSequence<Element>> 
                  Sequenze createSequence(final IndexSequenceCreator<Sequenze> indexSequenceCreator,
                                          final int firstIndex, final Element... elements) {
    // @formatter:on
        final int elementsCount = elements.length;

        final int lastIndex = firstIndex + elementsCount - 1;

        final Sequenze sequence = createSequence(indexSequenceCreator, firstIndex, lastIndex);

        for (int index = firstIndex, arrayElementIndex = 0; index <= lastIndex; index ++, arrayElementIndex ++)
            sequence.replace(index, elements[arrayElementIndex]);

        return sequence;
    }

    /**
     * Creates a new {@link InitializeableIndexSequence} with a first index of
     * {@code 0} and the specified size.
     * 
     * @param indexSequenceCreator
     *        {@link IndexSequenceCreator} to use
     * 
     * @param size
     *        integer specifying the size of the new
     *        {@link InitializeableIndexSequence}
     * 
     * @return the new {@link InitializeableIndexSequence}
     * 
     * @throws IllegalArgumentException
     *         if {@code size < 1}
     */
    // @formatter:off
    public static <Element, Sequenze extends InitializeableIndexSequence<Element>> 
                  Sequenze createSequence(final IndexSequenceCreator<Sequenze> indexSequenceCreator,
                                          final int size)
    throws IllegalArgumentException {
    // @formatter:on
        if (size < 1)
            throw new IllegalArgumentException("size == " + size + " < 1");

        return createSequence(indexSequenceCreator, 0, size - 1);
    }

    /**
     * Creates a new {@link InitializeableIndexSequence} containing the Elements
     * of the specified Container. The index of the first Element of the
     * specified Container in the {@link InitializeableIndexSequence} is 0. The
     * fixed size of the {@link InitializeableIndexSequence} is the size of the
     * specified Container.
     * 
     * @param indexSequenceCreator
     *        {@link IndexSequenceCreator} to use
     * 
     * @param container
     *        Container of which the Elements are copied to the
     *        {@link InitializeableIndexSequence}
     * 
     * @return the newly created {@link InitializeableIndexSequence}
     * 
     * @throws IllegalArgumentException
     *         if {@code collection} is {@code null}
     */
    // @formatter:off
    public static <Element, Sequenze extends InitializeableIndexSequence<Element>> 
    Sequenze createSequence(final IndexSequenceCreator<Sequenze> indexSequenceCreator,
                            final Container<Element> container) {
    // @formatter:on
        return createSequence(indexSequenceCreator, 0, container);
    }

    /**
     * Creates a new {@link InitializeableIndexSequence} containing the Elements
     * of the specified Java Container. The index of the first Element of the
     * specified Container in the {@link InitializeableIndexSequence} is 0. The
     * fixed size of the {@link InitializeableIndexSequence} is the size of the
     * specified Container.
     * 
     * @param indexSequenceCreator
     *        {@link IndexSequenceCreator} to use
     * 
     * @param collection
     *        Collection of which the Elements are copied to the
     *        {@link InitializeableIndexSequence}
     * 
     * @return the newly created {@link InitializeableIndexSequence}
     */
    // @formatter:off
    public static <Element, Sequenze extends InitializeableIndexSequence<Element>> 
    Sequenze createSequence(final IndexSequenceCreator<Sequenze> indexSequenceCreator,
                            final Collection<Element> collection) {
    // @formatter:on
        return createSequence(indexSequenceCreator, 0, collection);
    }

    /**
     * Creates a new {@link InitializeableIndexSequence} containing the Elements
     * of the specified Container having a specified first index. That is, the
     * index of the first Element of the specified collection in the
     * {@link InitializeableIndexSequence} can be specified. The fixed size of
     * the {@link InitializeableIndexSequence} is the size of the specified
     * Container.
     * 
     * @param indexSequenceCreator
     *        {@link IndexSequenceCreator} to use
     * 
     * @param firstIndex
     *        integer specifying the first index of the
     *        {@link InitializeableIndexSequence}. The first Element of
     *        {@code collection} is stored at this index of the newly created
     *        {@link InitializeableIndexSequence}.
     * 
     * @param elements
     *        Container of which the Elements are copied to the
     *        {@link InitializeableIndexSequence}
     * 
     * @return the newly created {@link InitializeableIndexSequence}
     * 
     * @throws IllegalArgumentException
     *         if {@code firstIndex < 0}
     */
    // @formatter:off
    public static <Element, Sequenze extends InitializeableIndexSequence<Element>> 
    Sequenze createSequence(final IndexSequenceCreator<Sequenze> indexSequenceCreator,
                            final int firstIndex, final Container<Element> elements)
    throws IllegalArgumentException {
    // @formatter:on
        final Sequenze sequence = createSequence(indexSequenceCreator, firstIndex, firstIndex + elements.getSize() - 1);

        int index = firstIndex;

        for (final Element element : elements)
            sequence.replaceStoredElement(index ++, element);

        return sequence;
    }

    /**
     * Creates a new {@link InitializeableIndexSequence} containing the Elements
     * of the specified Container having a specified first index. That is, the
     * index of the first Element of the specified collection in the
     * {@link InitializeableIndexSequence} can be specified. The fixed size of
     * the {@link InitializeableIndexSequence} is the size of the specified
     * Container.
     * 
     * @param indexSequenceCreator
     *        {@link IndexSequenceCreator} to use
     * 
     * @param firstIndex
     *        integer specifying the first index of the
     *        {@link InitializeableIndexSequence}. The first Element of
     *        {@code collection} is stored at this index of the newly created
     *        {@link InitializeableIndexSequence}.
     * 
     * @param elements
     *        {@link Collection} containing the Elements for the
     *        {@link InitializeableIndexSequence}
     * 
     * @return newly created {@link InitializeableIndexSequence}
     * 
     * @throws IllegalArgumentException
     *         if {@code firstIndex < 0}
     */
    // @formatter:off
    public static <Element, Sequenze extends InitializeableIndexSequence<Element>> 
    Sequenze createSequence(final IndexSequenceCreator<Sequenze> indexSequenceCreator,
                            final int firstIndex, final Collection<Element> elements)
    throws IllegalArgumentException {
    // @formatter:on
        final Sequenze sequence = createSequence(indexSequenceCreator, firstIndex, firstIndex + elements.size() - 1);

        int index = firstIndex;

        for (final Element element : elements)
            sequence.replaceStoredElement(index ++, element);

        return sequence;
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
                  Sequenze createIntegerIndexSequenceFrom(final IndexSequenceCreator<Sequenze> indexSequenceCreator,
                                                     final int firstIndex, final Integer... elements) {
        // @formatter:on
        return createSequence(indexSequenceCreator, firstIndex, elements);
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
                  Sequenze createIntegerIndexSequence(final IndexSequenceCreator<Sequenze> indexSequenceCreator,
                                                      final Integer... elements) {
        // @formatter:on
        return createIntegerIndexSequenceFrom(indexSequenceCreator, 0, elements);
    }

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
}

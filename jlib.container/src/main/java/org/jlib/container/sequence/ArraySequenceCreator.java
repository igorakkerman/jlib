package org.jlib.container.sequence;

import java.util.Collection;
import java.util.Iterator;

import org.jlib.container.Container;

/**
 * {@link IndexSequenceCreator} for {@link ArraySequence} instances.
 * 
 * @param <Element>
 *        type of the elements held in every created {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public class ArraySequenceCreator<Element>
extends IndexSequenceCreator<ArraySequence<Element>, Element> {

    /** sole {@link ArraySequenceCreator} instance */
    private static final ArraySequenceCreator<?> INSTANCE = new ArraySequenceCreator<>();

    /**
     * Returns the sole {@link ArraySequenceCreator} instance.
     * 
     * @return sole {@link ArraySequenceCreator} instance
     */
    @SuppressWarnings("unchecked")
    public static <Element> ArraySequenceCreator<Element> getInstance() {
        return (ArraySequenceCreator<Element>) INSTANCE;
    }

    // @formatter:off   
    /**
     * Creates a new ArraySequence containing the specified Integer Elements
     * having a specified first index. That is, the index of the first Element
     * of the specified sequence in this ArraySequence can be specified. The
     * fixed size of this ArraySequence is the size of the specified sequence.
     * 
     * It doesn't know whether the first parameter is meant to be the minimum
     * index of the ArraySequence or the first Element of the sequence. You
     * could pass a Java array of Integers instead which is the equivalent to
     * the sequence form for the argument {@code Integer... elements} but this
     * class provides an easier way: the factory methods
     * {@link #createIntegerSequence(Integer...)} or
     * {@link #createIntegerSequenceFrom(int, Integer[])}. The latter form takes the
     * minimum index as first argument.
     * 
     * {@literal
     * // possible but not handy ArraySequence&lt;Integer&gt; integerArray = new
     * ArraySequence&lt;Integer&gt;(new Integer[] 1, 2, 3, 4, 5, 6 }
     * );
     * 
     * ArraySequence&lt;Integer&gt; integerArray = new
     * ArraySequence&lt;Integer&gt;(1, new Integer[] { 1, 2, 3, 4, 5, 6 });
     * 
     * // easier to use (needs the static import of the factory method(s))
     * ArraySequence&lt;Integer&gt; integerArray = createIntegerArray(1, 2, 3,
     * 4, 5);
     * 
     * ArraySequence&lt;Integer&gt; integerArray = createIntegerArrayFrom(1, 1,
     * 2, 3, 4, 5); }
     * 
     * @param firstIndex
     *        integer specifying the minimum index of this ArraySequence
     * 
     * @param elements
     *        comma separated sequence of Integer elements to store or Java
     *        array containing those Elements
     * 
     * @return the new ArraySequence of Integers
     */
    // @formatter:on
    public static ArraySequence<Integer> createIntegerSequenceFrom(final int firstIndex, final Integer... elements) {
        return ArraySequenceCreator.<Integer> getInstance().createSequence(firstIndex, elements);
    }

    /**
     * Creates a new {@link Sequence} containing the specified Integer Elements
     * having a first index of {@code 0}. The fixed size of the {@link Sequence}
     * is the size of the specified sequence.
     * 
     * @param elements
     *        comma separated sequence of Integer elements to store or Java
     *        array containing those Elements
     * 
     * @return the newly created {@link Sequence}
     */
    public static ArraySequence<Integer> createIntegerSequence(final Integer... elements) {
        return createIntegerSequenceFrom(0, elements);
    }

    /**
     * Creates a new {@link ArraySequenceCreator}.
     */
    protected ArraySequenceCreator() {
        super();
    }

    @Override
    public ArraySequence<Element> createSequence(final int firstIndex, final int lastIndex)
    throws IllegalArgumentException {
        return new ArraySequence<>(firstIndex, lastIndex);
    }

    /**
     * Creates a new ArraySequence containing the Elements of the specified
     * Container having a specified first index. That is, the index of the first
     * Element of the specified collection in this ArraySequence can be
     * specified. The fixed size of this ArraySequence is the size of the
     * specified Container.
     * 
     * @param firstIndex
     *        integer specifying the minimum index of this ArraySequence. The
     *        first Element of {@code collection} is stored at this index of
     *        this ArraySequence.
     * 
     * @param elements
     *        Container of which the Elements are copied to this ArraySequence
     */
    @Override
    public ArraySequence<Element> createSequence(final int firstIndex, final Container<Element> elements)
    throws IllegalArgumentException {
        final ArraySequence<Element> sequence = createSequence(firstIndex, firstIndex + elements.getSize() - 1);

        int index = firstIndex;
        for (final Iterator<Element> collectionIterator = elements.iterator(); collectionIterator.hasNext(); index ++)
            sequence.replaceStoredElement(index, collectionIterator.next());

        return sequence;
    }

    /**
     * Creates a new ArraySequence containing the Elements of the specified
     * Container having a specified first index. That is, the index of the first
     * Element of the specified collection in this ArraySequence can be
     * specified. The fixed size of this ArraySequence is the size of the
     * specified Container.
     * 
     * @param firstIndex
     *        integer specifying the minimum index of this ArraySequence. The
     *        first Element of {@code collection} is stored at this index of
     *        this ArraySequence.
     * 
     * @param collection
     *        Container of which the Elements are copied to this ArraySequence
     * 
     * @throws IllegalArgumentException
     *         if {@code firstIndex < 0}
     */
    @Override
    public ArraySequence<Element> createSequence(final int firstIndex, final Collection<Element> collection)
    throws IllegalArgumentException {
        final ArraySequence<Element> sequence = createSequence(firstIndex, firstIndex + collection.size() - 1);

        int index = firstIndex;
        for (final Iterator<Element> collectionIterator = collection.iterator(); collectionIterator.hasNext(); index ++)
            sequence.replaceStoredElement(index, collectionIterator.next());

        return sequence;
    }
}

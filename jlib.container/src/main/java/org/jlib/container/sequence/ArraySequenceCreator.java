package org.jlib.container.sequence;

import java.util.Collection;
import java.util.Iterator;

import org.jlib.container.Container;

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

    /**
     * Creates a new {@link ArraySequenceCreator}.
     */
    private ArraySequenceCreator() {
        super();
    }

    /**
     * It doesn't know whether the first parameter is meant to be the minimum
     * index of the ArraySequence or the first Element of the sequence. You
     * could pass a Java array of Integers instead which is the equivalent to
     * the sequence form for the argument {@code Integer... elements} but this
     * class provides an easier way: the factory methods
     * {@link #createIntegerArray(Integer[])} or
     * {@link #createIntegerArrayFrom(int, Integer[])}. The latter form takes
     * the minimum index as first argument.
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
     */

    @Override
    public ArraySequence<Element> createSequence(final int firstIndex, final int lastIndex)
    throws IllegalArgumentException {
        return new ArraySequence<>(firstIndex, lastIndex);
    }

    @Override
    public ArraySequence<Element> createSequence(final int size)
    throws IllegalArgumentException {
        if (size <= 0)
            throw new IllegalArgumentException("size == " + size + " <= 0");

        return new ArraySequence<Element>(0, size - 1);
    }

    @Override
    public ArraySequence<Element> createSequence(final Element... elements) {
        return createSequence(0, elements);
    }

    /**
     * Creates a new ArraySequence containing the specified Elements having a
     * specified first index. That is, the index of the first Element of the
     * specified sequence in this ArraySequence can be specified. The fixed size
     * of this ArraySequence is the size of the specified sequence.
     * 
     * @param firstIndex
     *        integer specifying the minimum index of this ArraySequence
     * 
     * @param elements
     *        comma separated sequence of Elements to store or Java array
     *        containing those Elements
     */
    @Override
    public ArraySequence<Element> createSequence(final int firstIndex,
                                                 @SuppressWarnings("unchecked") final Element... elements) {
        final int lastIndex = firstIndex + elements.length - 1;

        final ArraySequence<Element> sequence = createSequence(firstIndex, lastIndex);

        for (int index = firstIndex, arrayIndex = 0; index <= lastIndex; index ++, arrayIndex ++)
            sequence.replace(index, elements[arrayIndex]);

        return sequence;
    }

    /**
     * Creates a new ArraySequence containing the specified Integer Elements
     * having a specified first index. That is, the index of the first Element
     * of the specified sequence in this ArraySequence can be specified. The
     * fixed size of this ArraySequence is the size of the specified sequence.
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
    public ArraySequence<Integer> createIntegerSequence(final int firstIndex, final Integer... elements) {
        return createSequence(firstIndex, (Integer[]) elements);
    }

    /**
     * Creates a new ArraySequence containing the Elements of the specified
     * Container. The index of the first Element of the specified Container in
     * this ArraySequence is 0. The fixed size of this ArraySequence is the size
     * of the specified Container.
     * 
     * @param collection
     *        Container of which the Elements are copied to this ArraySequence
     * 
     * @throws IllegalArgumentException
     *         if {@code collection} is {@code null}
     */
    @Override
    public ArraySequence<Element> createSequence(final Container<Element> collection) {
        createSequence(0, collection);
    }

    /**
     * Creates a new ArraySequence containing the Elements of the specified Java
     * Container. The index of the first Element of the specified Container in
     * this ArraySequence is 0. The fixed size of this ArraySequence is the size
     * of the specified Container.
     * 
     * @param collection
     *        Collection of which the Elements are copied to this ArraySequence
     */
    @Override
    public ArraySequence<Element> createSequence(final Collection<Element> collection) {
        createSequence(0, collection);
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
     * 
     * @throws IllegalArgumentException
     *         if {@code firstIndex < 0}
     */
    @Override
    public ArraySequence<Element> createSequence(final int firstIndex, final Container<Element> elements)
    throws IllegalArgumentException {
        createSequence(firstIndex, firstIndex + elements.getSize() - 1);

        int arrayIndex = firstIndex;
        for (final Iterator<Element> collectionIterator = elements.iterator(); collectionIterator.hasNext(); arrayIndex ++)
            delegateSequence.replace(arrayIndex, collectionIterator.next());
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
        createSequence(firstIndex, firstIndex + collection.size() - 1);

        int arrayIndex = firstIndex;
        for (final Iterator<Element> collectionIterator = collection.iterator(); collectionIterator.hasNext(); arrayIndex ++)
            delegateSequence.replace(arrayIndex, collectionIterator.next());
    }

}

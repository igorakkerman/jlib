package org.jlib.container.sequence;

import java.util.Collection;
import java.util.Iterator;

import org.jlib.container.Container;
import org.jlib.container.sequence.ArraySequence.NonEmptyArraySequence;

public class ArraySequenceCreator
extends SequenceCreator<ArraySequence<?>> {

    public ArraySequenceCreator() {
        super();
    }

    @Override
    public ArraySequence<?> createSequence() {
        return null;
    }

    
    /**
     * Creates a new ArraySequence initially filled with {@code null} Elements.
     * 
     * @param firstIndex
     *        integer specifying the minimum index of this ArraySequencey
     * 
     * @param lastIndex
     *        integer specifying the maximum index of this ArraySequence
     * 
     * @throws IllegalArgumentException
     *         if {@code firstIndex < 0 || lastIndex < firstIndex}
     */
    public ArraySequence(final int firstIndex, final int lastIndex)
    throws IllegalArgumentException {
        super();

        delegateSequence = new NonEmptyArraySequence<>(firstIndex, lastIndex);
    }

    /**
     * Creates a new initially blank {@link ArraySequence}.
     * 
     * @param size
     *        integer specifying the size of this ArraySequence
     * 
     * @throws IllegalArgumentException
     *         if {@code size <= 0}
     */
    public ArraySequence(final int size)
    throws IllegalArgumentException {
        delegateSequence =
            size != 0 ? new NonEmptyArraySequence<Element>(0, size - 1)
                     : EmptyReplaceIndexSequence.<Element> getInstance();
    }

    /**
     * Creates a new ArraySequence containing the specified Elements. That is,
     * the index of the first Element of the specified sequence in this
     * ArraySequence is 0. The fixed size of this ArraySequence is the size of
     * the specified sequence.
     * 
     * @param elements
     *        comma separated sequence of Elements to store or Java array
     *        containing those Elements
     */
    @SafeVarargs
    public ArraySequence(final Element... elements) {
        this(0, elements);
    }

    /**
     * Creates a new ArraySequence containing the specified Integer Elements.
     * That is, the index of the first Element of the specified sequence in this
     * ArraySequence is 0. The fixed size of this ArraySequence is the size of
     * the specified sequence.
     * 
     * @param elements
     *        comma separated sequence of Integer Elements to store or Java
     *        array containing those Elements
     * 
     * @return the new ArraySequence of Integers
     */
    public static ArraySequence<Integer> createIntegerArray(final Integer... elements) {
        return new ArraySequence<Integer>(0, elements);
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
    @SafeVarargs
    public ArraySequence(final int firstIndex, final Element... elements) {
        this(firstIndex, firstIndex + elements.length - 1);

        for (int elementsIndex = 0, arrayIndex = firstIndex; elementsIndex < elements.length; elementsIndex ++, arrayIndex ++)
            delegateSequence.replace(arrayIndex, elements[elementsIndex]);
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
    public static ArraySequence<Integer> createIntegerArrayFrom(final int firstIndex, final Integer... elements) {
        return new ArraySequence<Integer>(firstIndex, elements);
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
    public ArraySequence(final Container<Element> collection) {
        this(0, collection);
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
    public ArraySequence(final Collection<Element> collection) {
        this(0, collection);
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
    public ArraySequence(final int firstIndex, final Container<Element> elements)
    throws IllegalArgumentException {
        this(firstIndex, firstIndex + elements.getSize() - 1);

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
    public ArraySequence(final int firstIndex, final Collection<Element> collection)
    throws IllegalArgumentException {
        this(firstIndex, firstIndex + collection.size() - 1);

        int arrayIndex = firstIndex;
        for (final Iterator<Element> collectionIterator = collection.iterator(); collectionIterator.hasNext(); arrayIndex ++)
            delegateSequence.replace(arrayIndex, collectionIterator.next());
    }

}

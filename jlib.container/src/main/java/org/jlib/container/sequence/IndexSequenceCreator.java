package org.jlib.container.sequence;

import java.util.Collection;

import org.jlib.container.Container;

/**
 * Creator of instances of a certain type of {@link Sequence Sequences}.
 * 
 * @param <Sequenze>
 *        type of the created {@link Sequence} instances
 * 
 * @param <Element>
 *        type of the elements held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
@SuppressWarnings("unchecked")
public abstract class IndexSequenceCreator<Sequenze extends AbstractIndexSequence<Element>, Element> {

    /**
     * Creates a new {@link IndexSequenceCreator}.
     */
    protected IndexSequenceCreator() {
        super();
    }

    /**
     * Creates a new initially blank {@link Sequence}.
     * 
     * @param firstIndex
     *        integer specifying the first index of the {@link Sequence}
     * 
     * @param lastIndex
     *        integer specifying the last index of the {@link Sequence}
     * 
     * @return the newly created {@link Sequence}
     * 
     * @throws IllegalArgumentException
     *         if {@code firstIndex < 0 || lastIndex < firstIndex}
     */
    public abstract Sequenze createSequence(final int firstIndex, final int lastIndex)
    throws IllegalArgumentException;

    /**
     * Creates a new initially blank {@link Sequence}.
     * 
     * @param size
     *        integer specifying the size of the {@link Sequence}
     * 
     * @return the newly created {@link Sequence}
     * 
     * @throws IllegalArgumentException
     *         if {@code size <= 0}
     */
    public Sequenze createSequence(final int size)
    throws IllegalArgumentException {
        return createSequence(0, size - 1);
    }

    /**
     * Creates a new {@link Sequence} containing the specified Elements. That
     * is, the index of the first Element of the specified sequence in this
     * Sequence is 0. The fixed size of the {@link Sequence} is the size of the
     * specified sequence.
     * 
     * @param elements
     *        comma separated sequence of Elements to store or Java array
     *        containing those Elements
     * 
     * @return the newly created {@link Sequence}
     */
    public Sequenze createSequence(final Element... elements) {
        return createSequence(0, elements);
    }

    /**
     * Creates a new {@link Sequence} containing the specified Integer Elements.
     * That is, the index of the first Element of the specified sequence in this
     * Sequence is 0. The fixed size of the {@link Sequence} is the size of the
     * specified sequence.
     * 
     * @param elements
     *        comma separated sequence of Integer Elements to store or Java
     *        array containing those Elements
     * 
     * @return the newly created {@link Sequence}
     */
    public Sequenze createIntegerSequence(final Integer... elements) {
        return createSequence((Element[]) elements);
    }

    /**
     * Creates a new {@link Sequence} containing the specified Elements having a
     * specified first index. That is, the index of the first Element of the
     * specified sequence in the {@link Sequence} can be specified. The fixed
     * size of the {@link Sequence} is the size of the specified sequence.
     * 
     * @param firstIndex
     *        integer specifying the minimum index of the {@link Sequence}
     * 
     * @param elements
     *        comma separated sequence of Elements to store or Java array
     *        containing those Elements
     * 
     * @return the newly created {@link Sequence}
     */
    public Sequenze createSequence(final int firstIndex, @SuppressWarnings("unchecked") final Element... elements) {
        final int elementsCount = elements.length;

        final int lastIndex = firstIndex + elementsCount - 1;

        final AbstractIndexSequence<Element> sequence = createSequence(firstIndex, lastIndex);

        for (int elementIndex = firstIndex, arrayElementIndex = 0; elementIndex <= lastIndex; elementIndex ++, arrayElementIndex ++)
            sequence.replace(elementIndex, elements[arrayElementIndex]);

    }

    /**
     * Creates a new {@link Sequence} containing the specified Integer Elements
     * having a specified first index. That is, the index of the first Element
     * of the specified sequence in the {@link Sequence} can be specified. The
     * fixed size of the {@link Sequence} is the size of the specified sequence.
     * 
     * @param firstIndex
     *        integer specifying the minimum index of the {@link Sequence}
     * 
     * @param elements
     *        comma separated sequence of Integer elements to store or Java
     *        array containing those Elements
     * 
     * @return the newly created {@link Sequence}
     */
    public abstract Sequenze createIntegerSequenceFrom(final int firstIndex, final Integer... elements);

    /**
     * Creates a new {@link Sequence} containing the Elements of the specified
     * Container. The index of the first Element of the specified Container in
     * the {@link Sequence} is 0. The fixed size of the {@link Sequence} is the
     * size of the specified Container.
     * 
     * @param collection
     *        Container of which the Elements are copied to the {@link Sequence}
     * 
     * @return the newly created {@link Sequence}
     * 
     * @throws IllegalArgumentException
     *         if {@code collection} is {@code null}
     */
    public abstract Sequenze createSequence(final Container<Element> collection);

    /**
     * Creates a new {@link Sequence} containing the Elements of the specified
     * Java Container. The index of the first Element of the specified Container
     * in the {@link Sequence} is 0. The fixed size of the {@link Sequence} is
     * the size of the specified Container.
     * 
     * @param collection
     *        Collection of which the Elements are copied to the
     *        {@link Sequence}
     * 
     * @return the newly created {@link Sequence}
     */
    public abstract Sequenze createSequence(final Collection<Element> collection);

    /**
     * Creates a new {@link Sequence} containing the Elements of the specified
     * Container having a specified first index. That is, the index of the first
     * Element of the specified collection in the {@link Sequence} can be
     * specified. The fixed size of the {@link Sequence} is the size of the
     * specified Container.
     * 
     * @param firstIndex
     *        integer specifying the minimum index of the {@link Sequence}. The
     *        first Element of {@code collection} is stored at this index of
     *        this Sequence.
     * 
     * @param elements
     *        Container of which the Elements are copied to the {@link Sequence}
     * 
     * @return the newly created {@link Sequence}
     * 
     * @throws IllegalArgumentException
     *         if {@code firstIndex < 0}
     */
    public abstract Sequenze createSequence(final int firstIndex, final Container<Element> elements)
    throws IllegalArgumentException;

    /**
     * Creates a new {@link Sequence} containing the Elements of the specified
     * Container having a specified first index. That is, the index of the first
     * Element of the specified collection in the {@link Sequence} can be
     * specified. The fixed size of the {@link Sequence} is the size of the
     * specified Container.
     * 
     * @param firstIndex
     *        integer specifying the minimum index of the {@link Sequence}. The
     *        first Element of {@code collection} is stored at this index of
     *        this Sequence.
     * 
     * @param collection
     *        Container of which the Elements are copied to the {@link Sequence}
     * 
     * @return the newly created {@link Sequence}
     * 
     * @throws IllegalArgumentException
     *         if {@code firstIndex < 0}
     */
    public abstract Sequenze createSequence(final int firstIndex, final Collection<Element> collection)
    throws IllegalArgumentException;
}

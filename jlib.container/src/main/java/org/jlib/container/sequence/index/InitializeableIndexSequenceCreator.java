package org.jlib.container.sequence.index;

import java.util.Collection;

import org.jlib.container.Container;

/**
 * Creator of instances of a subtype of {@link InitializeableIndexSequence}.
 * 
 * @param <Element>
 *        type of the elements held in the {@link InitializeableIndexSequence}
 * 
 * @param <Sequenze>
 *        type of the created {@link InitializeableIndexSequence}
 * 
 * @author Igor Akkerman
 */
public abstract class InitializeableIndexSequenceCreator<Element, Sequenze extends InitializeableIndexSequence<Element>> {

    /**
     * Creates a new {@link InitializeableIndexSequenceCreator}.
     */
    protected InitializeableIndexSequenceCreator() {
        super();
    }

    /**
     * Creates a new initially blank {@link InitializeableIndexSequence}. s
     * 
     * @param firstIndex
     *        integer specifying the first index of the
     *        {@link InitializeableIndexSequence}
     * 
     * @param lastIndex
     *        integer specifying the last index of the
     *        {@link InitializeableIndexSequence}
     * 
     * @return the newly created {@link InitializeableIndexSequence}
     * 
     * @throws IllegalArgumentException
     *         if {@code firstIndex < 0 || lastIndex < firstIndex}
     */
    public abstract Sequenze createSequence(final int firstIndex, final int lastIndex)
    throws IllegalArgumentException;

    /**
     * Creates a new {@link InitializeableIndexSequence} containing the
     * specified Elements. That is, the index of the first Element of the
     * specified sequence in this Sequence is 0. The fixed size of the
     * {@link InitializeableIndexSequence} is the size of the specified
     * sequence.
     * 
     * @param elements
     *        comma separated sequence of Elements to store
     * 
     * @return the newly created {@link InitializeableIndexSequence}
     */
    @SafeVarargs
    public final Sequenze createSequence(final Element... elements) {
        return createSequence(0, elements);
    }

    /**
     * Creates a new {@link InitializeableIndexSequence} containing the
     * specified Elements having a specified first index. That is, the index of
     * the first Element of the specified sequence in the
     * {@link InitializeableIndexSequence} can be specified. The fixed size of
     * the {@link InitializeableIndexSequence} is the size of the specified
     * sequence.
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
    public final Sequenze createSequence(final int firstIndex, final Element... elements) {
        final int elementsCount = elements.length;

        final int lastIndex = firstIndex + elementsCount - 1;

        final Sequenze sequence = createSequence(firstIndex, lastIndex);

        for (int index = firstIndex, arrayElementIndex = 0; index <= lastIndex; index ++, arrayElementIndex ++)
            sequence.replace(index, elements[arrayElementIndex]);

        return sequence;
    }

    /**
     * Creates a new {@link InitializeableIndexSequence} with a first index of
     * {@code 0} and the specified size.
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
    public final Sequenze createSequence(final int size)
    throws IllegalArgumentException {
        if (size < 1)
            throw new IllegalArgumentException("size == " + size + " < 1");

        return createSequence(0, size - 1);
    }

    /**
     * Creates a new {@link InitializeableIndexSequence} containing the Elements
     * of the specified Container. The index of the first Element of the
     * specified Container in the {@link InitializeableIndexSequence} is 0. The
     * fixed size of the {@link InitializeableIndexSequence} is the size of the
     * specified Container.
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
    public final Sequenze createSequence(final Container<Element> container) {
        return createSequence(0, container);
    }

    /**
     * Creates a new {@link InitializeableIndexSequence} containing the Elements
     * of the specified Java Container. The index of the first Element of the
     * specified Container in the {@link InitializeableIndexSequence} is 0. The
     * fixed size of the {@link InitializeableIndexSequence} is the size of the
     * specified Container.
     * 
     * @param collection
     *        Collection of which the Elements are copied to the
     *        {@link InitializeableIndexSequence}
     * 
     * @return the newly created {@link InitializeableIndexSequence}
     */
    public final Sequenze createSequence(final Collection<Element> collection) {
        return createSequence(0, collection);
    }

    /**
     * Creates a new {@link InitializeableIndexSequence} containing the Elements
     * of the specified Container having a specified first index. That is, the
     * index of the first Element of the specified collection in the
     * {@link InitializeableIndexSequence} can be specified. The fixed size of
     * the {@link InitializeableIndexSequence} is the size of the specified
     * Container.
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
    public final Sequenze createSequence(final int firstIndex, final Container<Element> elements)
    throws IllegalArgumentException {
        final Sequenze sequence = createSequence(firstIndex, firstIndex + elements.getSize() - 1);

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
    public final Sequenze createSequence(final int firstIndex, final Collection<Element> elements)
    throws IllegalArgumentException {
        final Sequenze sequence = createSequence(firstIndex, firstIndex + elements.size() - 1);

        int index = firstIndex;

        for (final Element element : elements)
            sequence.replaceStoredElement(index ++, element);

        return sequence;
    }
}

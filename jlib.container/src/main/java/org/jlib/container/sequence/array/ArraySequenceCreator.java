package org.jlib.container.sequence.array;

import java.util.Collection;

import org.jlib.container.Container;
import org.jlib.container.sequence.Sequence;
import org.jlib.container.sequence.index.IndexSequenceCreator;

/**
 * {@link IndexSequenceCreator} forinstances.
 * 
 * @param <Element>
 *        type of the elements held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */

// TODO: Javadoc still from old Array class

public class ArraySequenceCreator<Element>
extends IndexSequenceCreator<Element, ArraySequence<Element>> {

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
    protected ArraySequenceCreator() {
        super();
    }

    @Override
    public ArraySequence<Element> createSequence(final int firstIndex, final int lastIndex)
    throws IllegalArgumentException {
        return new ArraySequence<Element>(firstIndex, lastIndex);
    }

    /**
     * Creates a new {@link ArraySequence} containing the Elements of the
     * specified Container having a specified first index. That is, the index of
     * the first Element of the specified collection in the newly created
     * {@link ArraySequence} can be specified. The fixed size of the newly
     * created {@link ArraySequence} is the size of the specified Container.
     * 
     * @param firstIndex
     *        integer specifying the minimum index of the newly created
     *        {@link ArraySequence}. The first Element of {@code collection} is
     *        stored at the newly created index of the newly created
     *        {@link ArraySequence}.
     * 
     * @param elements
     *        Container of which the Elements are copied to the newly created
     *        {@link ArraySequence}
     */
    @Override
    public ArraySequence<Element> createSequence(final int firstIndex, final Container<Element> elements)
    throws IllegalArgumentException {
        final ArraySequence<Element> sequence = createSequence(firstIndex, firstIndex + elements.getSize() - 1);

        int index = firstIndex;

        for (final Element element : elements)
            sequence.replaceStoredElement(index ++, element);

        return sequence;
    }

    /**
     * Creates a newcontaining the Elements of the specified {@link Collection}
     * having a specified first index. That is, the index of the first Element
     * of the specified {@link Collection} in the newly created can be
     * specified. The fixed size of the newly created {@link ArraySequence} is
     * the size of the specified Container.
     * 
     * @param firstIndex
     *        integer specifying the first index of the newly created
     *        ArraySequence. The Elements of {@code collection} are stored
     *        beginning from the newly created index of the newly created
     *        {@link ArraySequence}
     * 
     * @param elements
     *        {@link Collection} containing the Elements of the new
     *        {@link ArraySequence}
     * 
     * @throws IllegalArgumentException
     *         if {@code firstIndex < 0}
     */
    @Override
    public ArraySequence<Element> createSequence(final int firstIndex, final Collection<Element> elements)
    throws IllegalArgumentException {
        final ArraySequence<Element> sequence = createSequence(firstIndex, firstIndex + elements.size() - 1);

        int index = firstIndex;

        for (final Element element : elements)
            sequence.replaceStoredElement(index ++, element);

        return sequence;
    }
}

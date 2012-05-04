package org.jlib.container.sequence;

import java.util.Collection;

import org.jlib.container.Container;
import org.jlib.container.ContainerUtility;

import static org.jlib.container.sequence.SequenceUtility.singleton;
import static org.jlib.core.array.ArrayUtility.iterable;

/**
 * {@link ReplaceArraySequence} to which Elements can be added.
 * 
 * @param <Element>
 *        type of elements held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public class AddReplaceArraySequence<Element>
extends ReplaceArraySequence<Element>
implements AddIndexSequence<Element> {

    /**
     * Creates a new {@link AddReplaceArraySequence} with the specified first
     * and last indices.
     * 
     * @param firstIndex
     *        integer specifying the first index
     * 
     * @param lastIndex
     *        integer specifying the last index
     * 
     * @throws IllegalArgumentException
     *         if {@code lastIndex > firstIndex}
     */
    protected AddReplaceArraySequence(final int firstIndex, final int lastIndex) {
        super(firstIndex, lastIndex);
    }

    @Override
    public void add(final Element element) {
        addAll(singleton(element));
    }

    @Override
    public void addAll(final Container<? extends Element> elements) {
        final int addedElementsCount = elements.getSize();

        assertCapacity(getSize() + addedElementsCount);

        int elementArrayIndex = getSize();

        for (final Element element : elements)
            replaceDelegateArrayElement(elementArrayIndex ++, element);

        setLastIndex(getLastIndex() + addedElementsCount);
    }

    @Override
    public void addAll(final Collection<? extends Element> elements) {
        ContainerUtility.addAll(this, elements);
    }

    @Override
    public void addAll(@SuppressWarnings("unchecked") final Element... elements) {
        ContainerUtility.addAll(this, iterable(elements));
    }

    @Override
    public DefaultAddReplaceIndexSequenceIterator<Element> createIterator() {
        return new DefaultAddReplaceIndexSequenceIterator<Element>(this);
    }

    @Override
    public void insert(final int index, final Element element) {
        insert(index, singleton(element));
    }

    @Override
    public void insert(final int index, final Iterable<? extends Element> elements) {
        final int insertedElementsCount = elements.getSize();

        final int newSize = getSize() + insertedElementsCount;
        final int delegateArrayInsertIndex = getDelegateArrayIndex(index);

        assertCapacityWithHole(newSize, delegateArrayInsertIndex, insertedElementsCount);

        int delegateArrayIndex = delegateArrayInsertIndex;
        for (final Element element : elements)
            replaceDelegateArrayElement(delegateArrayIndex ++, element);

        setLastIndex(getLastIndex() + insertedElementsCount);
    }

    @Override
    public AddReplaceIndexSequenceIterator<Element> createIterator(final int startIndex)
    throws SequenceIndexOutOfBoundsException {
        return new DefaultAddReplaceIndexSequenceIterator<Element>(this, startIndex);
    }
}

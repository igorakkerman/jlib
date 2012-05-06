package org.jlib.container.sequence.add;

import java.util.Collection;

import org.jlib.container.Container;
import org.jlib.container.ContainerUtility;
import org.jlib.container.sequence.Sequence;
import org.jlib.container.sequence.array.ReplaceArraySequence;
import org.jlib.container.sequence.replace.DefaultReplaceIndexSequenceIterator;
import org.jlib.container.sequence.replace.ReplaceIndexSequenceIterator;

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
    public ReplaceIndexSequenceIterator<Element> createIterator() {
        return new DefaultReplaceIndexSequenceIterator<Element>(this);
    }
}

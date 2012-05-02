package org.jlib.container.sequence;

import java.util.Collection;

import org.jlib.container.Container;
import org.jlib.container.ContainerUtility;

import static org.jlib.core.array.ArrayUtility.iterable;

/**
 * {@link ReplaceArraySequence} to which Elements can be added.
 * 
 * @param <Element>
 *        type of elements held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public class AddArraySequence<Element>
extends ReplaceArraySequence<Element>
implements AddIndexSequence<Element> {

    /**
     * Creates a new {@link AddArraySequence} with the specified first and last
     * indices.
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
    protected AddArraySequence(final int firstIndex, final int lastIndex) {
        super(firstIndex, lastIndex);
    }

    @Override
    public void add(final Element element) {
        final int newLastIndex = getLastIndex() + 1;

        assertCapacity(getSize() + 1);
        setLastIndex(newLastIndex);
        replaceStoredElement(newLastIndex, element);
    }

    @Override
    public void addAll(final Container<? extends Element> elements) {
        final int new LastIndex = getLastIndex() + elements.getSize();
        
        ContainerUtility.addAll(this, elements);
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
        // FIXME: implement
    }

    @Override
    public void insert(final int index, final Container<? extends Element> elements) {
        // FIXME: implement
    }
}

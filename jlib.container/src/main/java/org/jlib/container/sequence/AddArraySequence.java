package org.jlib.container.sequence;

import java.util.Collection;

import org.jlib.container.Container;

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
implements AddSequence<Element> {

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
    public AddArraySequence(final int firstIndex, final int lastIndex) {
        super(firstIndex, lastIndex);
    }

    @Override
    public void add(final Element element) {
        // TODO: implement
    }

    @Override
    public void addAll(final Container<? extends Element> elements) {
        for (final Element element : elements)
            add(element);
    }

    @Override
    public void addAll(final Collection<? extends Element> elements) {
        for (final Element element : elements)
            add(element);
    }

    @Override
    public void addAll(@SuppressWarnings("unchecked") final Element... elements) {
        for (final Element element : elements)
            add(element);
    }

    public <Iter extends AddIndexSequenceIterator<Element> & ReplaceIndexSequenceIterator<Element>> Iter createIterator() {
        return new DefaultAddIndexSequenceIterator<Element>(this);
    }
}

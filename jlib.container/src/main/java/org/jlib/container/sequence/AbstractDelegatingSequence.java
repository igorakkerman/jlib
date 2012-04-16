/*
 * jlib - The Free Java Library
 *
 *    http://www.jlib.org
 *
 * Copyright (c) 2006-2008 Igor Akkerman
 *
 * jlib is distributed under the
 *
 *    COMMON PUBLIC LICENSE VERSION 1.0
 *
 *    http://www.opensource.org/licenses/cpl1.0.php
 */

package org.jlib.container.sequence;

import java.util.Collection;
import java.util.List;

import org.jlib.container.Container;

/**
 * {@link Sequence} delegating all calls to its methods to the equivalent
 * methods of a delegate {@link Sequence}. The delegate {@link Sequence} may be
 * modified at any time allowing to dynamically switch to the contents and the
 * behaviour of another {@link Sequence}.
 * 
 * @param <Element>
 *        type of elements held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public abstract class AbstractDelegatingSequence<Element>
extends AbstractSequence<Element>
implements Sequence<Element> {

    /**
     * Creates a new {@link AbstractDelegatingSequence}.
     */
    protected AbstractDelegatingSequence() {
        super();
    }

    /**
     * Returns the {@link Sequence} containing the {@code Elements} of this
     * {@link AbstractDelegatingSequence}.
     * 
     * @return the delegate {@link Sequence}
     */
    protected abstract Sequence<Element> getDelegateSequence();

    @Override
    public boolean isEmpty() {
        return getDelegateSequence().isEmpty();
    }

    @Override
    public int getSize() {
        return getDelegateSequence().getSize();
    }

    @Override
    public boolean contains(final Element element) {
        return getDelegateSequence().contains(element);
    }

    @Override
    public boolean containsAll(Container<? extends Element> elements) {
        return getDelegateSequence().containsAll(elements);
    }

    @Override
    public boolean containsAll(Collection<? extends Element> elements) {
        return getDelegateSequence().containsAll(elements);
    }

    @Override
    public boolean containsAll(@SuppressWarnings({ "unchecked", /* "varargs" */}) Element... elements) {
        return getDelegateSequence().containsAll(elements);
    }

    @Override
    public List<Element> toCollection() {
        return getDelegateSequence().toCollection();
    }

    @Override
    public Element[] toArray() {
        return getDelegateSequence().toArray();
    }

    @Override
    public SequenceIterator<Element> createIterator() {
        return getDelegateSequence().createIterator();
    }

    @Override
    public boolean equals(Object otherObject) {
        if (!(otherObject instanceof IndexSequence<?>))
            return false;

        @SuppressWarnings("unchecked")
        final IndexSequence<Element> otherSequence = (IndexSequence<Element>) otherObject;

        return getDelegateSequence().equals(otherSequence);
    }

    @Override
    public int hashCode() {
        return getDelegateSequence().hashCode() << 2;
    }
}

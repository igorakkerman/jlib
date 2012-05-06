package org.jlib.container.sequence.empty;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.jlib.container.Container;
import org.jlib.container.sequence.AbstractSequence;
import org.jlib.container.sequence.Sequence;
import org.jlib.container.sequence.SequenceIterator;
import org.jlib.container.sequence.replace.ReplaceIndexSequence;

/**
 * Empty {@link Sequence}.
 * 
 * @param <Element>
 *        type of the elements
 * 
 * @author Igor Akkerman
 */
public class EmptySequence<Element>
extends AbstractSequence<Element> {

    /** sole instance of this class */
    private static final EmptySequence<?> INSTANCE = new EmptySequence<>();

    /**
     * Returns the sole instance of this class.
     * 
     * @return sole {@link ReplaceIndexSequence}
     */
    @SuppressWarnings("unchecked")
    public static <Element> EmptySequence<Element> getInstance() {
        return (EmptySequence<Element>) INSTANCE;
    }

    /**
     * Creates a new {@link EmptySequence}.
     */
    protected EmptySequence() {
        super();
    }

    @Override
    public SequenceIterator<Element> createIterator() {
        return EmptySequenceIterator.getInstance();
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public boolean contains(final Element element) {
        return false;
    }

    @Override
    public boolean containsAll(final Container<? extends Element> elements) {
        return false;
    }

    @Override
    public boolean containsAll(final Collection<? extends Element> elements) {
        return false;
    }

    @Override
    public boolean containsAll(@SuppressWarnings({ "unchecked", /* "varargs" */}) final Element... elements) {
        return false;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Element> toList() {
        return Collections.unmodifiableList(Collections.EMPTY_LIST);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Element[] toArray() {
        return (Element[]) new Object[0];
    }

    // equals/hashCode don't need to be extended as Object.equals already checks for identity
}

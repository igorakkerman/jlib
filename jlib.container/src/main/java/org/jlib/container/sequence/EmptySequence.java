package org.jlib.container.sequence;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import org.jlib.container.Container;

/**
 * Empty {@link ReplaceIndexSequence}. Its {@link #getFirstIndex()} and
 * {@link #getLastIndex()} methods always throw an {@link IllegalStateException}
 * .
 * 
 * @param <Element>
 *        type of the elements
 * 
 * @author Igor Akkerman
 */
public class EmptySequence<Element>
extends AbstractSequence<Element> {

    /** sole instance of this class */
    private static final EmptySequence<?> INSTANCE = new EmptySequence<Object>();

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
    public IndexSequenceIterator<Element> createIterator() {
        return EmptyIndexSequenceIterator.getInstance();
    }

    @Override
    public ReplaceIndexSequenceIterator<Element> createIterator(final int startIndex)
    throws SequenceIndexOutOfBoundsException {
        throw new SequenceIndexOutOfBoundsException(this, startIndex);
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
    public Element get(final int index)
    throws SequenceIndexOutOfBoundsException {
        throw new SequenceIndexOutOfBoundsException(this, index);
    }

    @Override
    public int getFirstIndex() {
        throw new IllegalStateException();
    }

    @Override
    public int getLastIndex() {
        throw new IllegalStateException();
    }

    @Override
    public int getFirstIndexOf(final Element element)
    throws NoSuchElementException {
        throw new NoSuchElementException();
    }

    @Override
    public int getLastIndexOf(final Element element)
    throws NoSuchElementException {
        throw new NoSuchElementException();
    }

    @Override
    public IndexSequence<Element> createSubSequence(final int fromIndex, final int toIndex)
    throws IllegalArgumentException, SequenceIndexOutOfBoundsException {
        throw new SequenceIndexOutOfBoundsException(this, fromIndex);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Element> toList() {
        return Collections.unmodifiableList(Collections.EMPTY_LIST);
    }

    @Override
    public List<Element> toCollection() {
        return toList();
    }

    @Override
    @SuppressWarnings("unchecked")
    public Element[] toArray() {
        return (Element[]) new Object[0];
    }

    @Override
    public List<Element> createSubList(final int fromIndex, final int toIndex)
    throws IllegalArgumentException, SequenceIndexOutOfBoundsException {
        throw new SequenceIndexOutOfBoundsException(this, fromIndex);
    }

    // equals/hashCode don't need to be extended as Object.equals already checks for identity
}

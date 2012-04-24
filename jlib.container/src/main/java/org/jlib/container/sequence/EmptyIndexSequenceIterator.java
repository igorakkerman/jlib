package org.jlib.container.sequence;

import java.util.NoSuchElementException;

/**
 * {@link IndexSequenceIterator} of an {@link EmptySequence}.
 * 
 * @param <Element>
 *        type of elements held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public class EmptyIndexSequenceIterator<Element>
implements IndexSequenceIterator<Element> {

    /** sole instance of this class */
    private static final EmptyIndexSequenceIterator<?> INSTANCE = new EmptyIndexSequenceIterator<Object>();

    /**
     * Returns the sole instance of this class.
     * 
     * @return sole {@link ReplaceIndexSequenceIterator}
     */
    @SuppressWarnings("unchecked")
    public static <Element> EmptyIndexSequenceIterator<Element> getInstance() {
        return (EmptyIndexSequenceIterator<Element>) INSTANCE;
    }

    /**
     * Creates a new {@link EmptyIndexSequenceIterator}.
     */
    protected EmptyIndexSequenceIterator() {
        super();
    }


    @Override
    public boolean hasPrevious() {
        return false;
    }


    @Override
    public boolean hasNext() {
        return false;
    }


    @Override
    public Element previous()
    throws NoSuchElementException {
        throw new NoSuchElementException();
    }


    @Override
    public Element next()
    throws NoSuchElementException {
        throw new NoSuchElementException();
    }


    @Override
    public int previousIndex() {
        throw new NoSuchElementException();
    }


    @Override
    public int nextIndex() {
        throw new NoSuchElementException();
    }

    @Override
    public void remove() 
    throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }
}

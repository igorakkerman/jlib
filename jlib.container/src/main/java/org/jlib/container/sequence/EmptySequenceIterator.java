package org.jlib.container.sequence;

import java.util.NoSuchElementException;

import org.jlib.core.iterator.AbstractIterator;

/**
 * {@link IndexSequenceIterator} of an {@link EmptySequence}.
 * 
 * @param <Element>
 *        type of elements held in the {@link Sequence}
 * 
 * @author Igor Akkerman
 */
public class EmptySequenceIterator<Element>
extends AbstractIterator<Element>
implements SequenceIterator<Element> {

    /** sole instance of this class */
    private static final EmptySequenceIterator<?> INSTANCE = new EmptySequenceIterator<>();

    /**
     * Returns the sole instance of this class.
     * 
     * @return sole {@link EmptySequenceIterator}
     */
    @SuppressWarnings("unchecked")
    public static <Element> EmptySequenceIterator<Element> getInstance() {
        return (EmptySequenceIterator<Element>) INSTANCE;
    }

    /**
     * Creates a new {@link EmptySequenceIterator}.
     */
    protected EmptySequenceIterator() {
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
}

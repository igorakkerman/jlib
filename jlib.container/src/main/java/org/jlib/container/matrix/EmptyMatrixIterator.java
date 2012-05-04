package org.jlib.container.matrix;

import java.util.NoSuchElementException;

import org.jlib.core.iterator.AbstractIterator;

/**
 * {@link MatrixIterator} of an {@link EmptyMatrix}. Implemented as a singleton.
 * 
 * @param <Entry>
 *        type of entries of the {@link Matrix}
 * 
 * @author Igor Akkerman
 */
public class EmptyMatrixIterator<Entry>
extends AbstractIterator<Entry>
implements ReplaceMatrixIterator<Entry> {

    /** sole {@link EmptyMatrixIterator} instance */
    private static final EmptyMatrixIterator<?> INSTANCE = new EmptyMatrixIterator<>();

    /**
     * Returns the sole {@link EmptyMatrixIterator} instance.
     * 
     * @return sole {@link EmptyMatrixIterator} instance
     */
    @SuppressWarnings("unchecked")
    public static <Entry> EmptyMatrixIterator<Entry> getInstance() {
        return (EmptyMatrixIterator<Entry>) INSTANCE;
    }

    /**
     * Creates a new {@link EmptyMatrixIterator}.
     */
    private EmptyMatrixIterator() {
        super();
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Entry next() {
        throw new NoSuchElementException();
    }

    @Override
    public boolean hasNextEntity() {
        return false;
    }

    @Override
    public void gotoNextEntity()
    throws IllegalStateException {
        throw new IllegalStateException();
    }

    @Override
    public void replace(final Entry element)
    throws IllegalStateException {
        throw new IllegalStateException();
    }
}

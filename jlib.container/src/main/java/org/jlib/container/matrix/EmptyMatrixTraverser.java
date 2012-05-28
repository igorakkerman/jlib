package org.jlib.container.matrix;

import java.util.NoSuchItemException;

import org.jlib.core.iterator.AbstractIterator;

/**
 * {@link MatrixTraverser} of an {@link EmptyMatrix}. Implemented as a singleton.
 * 
 * @param <Entry>
 *        type of entries of the {@link Matrix}
 * 
 * @author Igor Akkerman
 */
public class EmptyMatrixTraverser<Entry>
extends AbstractIterator<Entry>
implements ReplaceMatrixTraverser<Entry> {

    /** sole {@link EmptyMatrixTraverser} instance */
    private static final EmptyMatrixTraverser<?> INSTANCE = new EmptyMatrixTraverser<>();

    /**
     * Returns the sole {@link EmptyMatrixTraverser} instance.
     * 
     * @return sole {@link EmptyMatrixTraverser} instance
     */
    @SuppressWarnings("unchecked")
    public static <Entry> EmptyMatrixTraverser<Entry> getInstance() {
        return (EmptyMatrixTraverser<Entry>) INSTANCE;
    }

    /**
     * Creates a new {@link EmptyMatrixTraverser}.
     */
    private EmptyMatrixTraverser() {
        super();
    }

    @Override
    public boolean hasNextItem() {
        return false;
    }

    @Override
    public Entry getNextItem() {
        throw new NoSuchItemException();
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
    public void replace(final Entry item)
    throws IllegalStateException {
        throw new IllegalStateException();
    }
}

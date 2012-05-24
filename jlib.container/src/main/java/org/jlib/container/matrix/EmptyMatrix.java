package org.jlib.container.matrix;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.RandomAccess;

import org.jlib.container.Container;
import org.jlib.container.sequence.EmptySequence;
import org.jlib.container.sequence.Sequence;
import org.jlib.container.sequence.index.IndexSequence;

/**
 * Empty {@link Matrix}. Implemented as a singleton.
 * 
 * @author Igor Akkerman
 * 
 * @param <Entry>
 *        type of entries of the {@link Matrix}
 */
public class EmptyMatrix<Entry>
implements ReplaceMatrix<Entry>, RandomTraversalMatrix<Entry>, RandomAccess {

    /** empty array */
    private static final Object[] EMPTY_ARRAY = new Object[0];

    /** sole {@link EmptyMatrix} instance */
    private static final EmptyMatrix<?> INSTANCE = new EmptyMatrix<>();

    /**
     * Returns the sole {@link EmptyMatrix} instance.
     * 
     * @return sole {@link EmptyMatrix} instance
     */
    public static EmptyMatrix<?> getInstance() {
        return INSTANCE;
    }

    /**
     * Creates a new {@link EmptyMatrix}.
     */
    private EmptyMatrix() {
        super();
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public boolean contains(final Entry element) {
        return false;
    }

    @Override
    public boolean containsAll(final Container<? extends Entry> elements) {
        return false;
    }

    @Override
    public boolean containsAll(final Collection<? extends Entry> elements) {
        return false;
    }

    @Override
    public boolean containsAll(@SuppressWarnings("unchecked") final Entry... elements) {
        return false;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Collection<Entry> toCollection() {
        return Collections.EMPTY_SET;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Entry[] toArray() {
        return (Entry[]) EMPTY_ARRAY;
    }

    @Override
    public ReplaceMatrixIterator<Entry> createIterator() {
        return EmptyMatrixIterator.getInstance();
    }

    @Override
    public Iterator<Entry> iterator() {
        return createIterator();
    }

    @Override
    public Sequence<IndexSequence<Entry>> getRows() {
        return EmptySequence.getInstance();
    }

    @Override
    public Sequence<IndexSequence<Entry>> getColumns() {
        return EmptySequence.getInstance();
    }

    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public MatrixIterable<Entry> iteratedInOrder(final MatrixIterationOrder iterationOrder) {
        // the iteration order is void in an EmptyMatrix
        return this;
    }

    @Override
    public void setDefaultIterationOrder(final MatrixIterationOrder defaultIterationOrder) {
        // the iteration order is void in an EmptyMatrix
    }
}

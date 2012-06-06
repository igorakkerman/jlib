package org.jlib.container.matrix;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.RandomAccess;

import org.jlib.container.Container;
import org.jlib.container.ReplaceContainer;
import org.jlib.container.sequence.EmptySequence;
import org.jlib.container.sequence.Sequence;
import org.jlib.container.sequence.index.IndexSequence;
import org.jlib.core.traverser.ReplaceTraverser;
import org.jlib.core.traverser.Traverser;

/**
 * Empty {@link Matrix}. Implemented as a singleton.
 * 
 * @author Igor Akkerman
 * 
 * @param <Entry>
 *        type of entries of the {@link Matrix}
 */
public class EmptyMatrix<Entry>
implements ReplaceContainer<Entry>, RandomTraversalMatrix<Entry>, RandomAccess {

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
    public boolean contains(final Entry item) {
        return false;
    }

    @Override
    public boolean containsAll(final Container<? extends Entry> items) {
        return false;
    }

    @Override
    public boolean containsAll(final Collection<? extends Entry> items) {
        return false;
    }

    @Override
    public boolean containsAll(@SuppressWarnings("unchecked") final Entry... items) {
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
    public ReplaceTraverser<Entry> createReplaceTraverser() {
        return EmptyMatrixTraverser.getInstance();
    }

    @Override
    public MatrixTraverser<Entry> createMatrixTraverser() {
        return EmptyMatrixTraverser.getInstance();
    }

    @Override
    public Traverser<Entry> createTraverser() {
        return EmptyMatrixTraverser.getInstance();
    }

    @Override
    public Iterator<Entry> iterator() {
        return Collections.emptyIterator();
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
    public MatrixTraversible<Entry> iteratedInOrder(final MatrixTraversalOrder iterationOrder) {
        // the iteration order is void in an EmptyMatrix
        return this;
    }

    @Override
    public void setDefaultIterationOrder(final MatrixTraversalOrder defaultIterationOrder) {
        // the iteration order is void in an EmptyMatrix
    }
}

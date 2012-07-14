package org.jlib.container.matrix;

import java.util.RandomAccess;

import org.jlib.container.EmptyContainer;
import org.jlib.container.ReplaceContainer;
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
extends EmptyContainer<Entry>
implements RandomTraversalMatrix<Entry>, ReplaceContainer<Entry>, RandomAccess {

    /** sole {@link EmptyMatrix} instance */
    private static final EmptyMatrix<?> INSTANCE = new EmptyMatrix<>();

    /**
     * Returns the sole {@link EmptyMatrix} instance.
     * 
     * @return sole {@link EmptyMatrix} instance
     */
    @SuppressWarnings("unchecked")
    public static <Entry> EmptyMatrix<Entry> getInstance() {
        return (EmptyMatrix<Entry>) INSTANCE;
    }

    /**
     * Creates a new {@link EmptyMatrix}.
     */
    protected EmptyMatrix() {
        super();
    }

    @Override
    public final EmptyMatrixTraverser<Entry> createTraverser() {
        return EmptyMatrixTraverser.getInstance();
    }

    @Override
    public final Sequence<IndexSequence<Entry>> getRows() {
        return EmptySequence.getInstance();
    }

    @Override
    public final Sequence<IndexSequence<Entry>> getColumns() {
        return EmptySequence.getInstance();
    }

    @Override
    public final int getWidth() {
        return 0;
    }

    @Override
    public final int getHeight() {
        return 0;
    }

    @Override
    public final MatrixTraversible<Entry> traversedInOrder(final MatrixTraversalOrder iterationOrder) {
        // the iteration order is void in an EmptyMatrix
        return this;
    }

    @Override
    public final void setDefaultTraversalOrder(final MatrixTraversalOrder defaultIterationOrder) {
        // the iteration order is void in an EmptyMatrix
    }
}

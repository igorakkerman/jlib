package org.jlib.container.matrix;

import org.jlib.core.iterator.AbstractTraverser;

/**
 * Skeletal implementation of a {@link MatrixTraverser}.
 * 
 * @param <Entry>
 *        type of the entries of the {@link Matrix}
 * 
 * @author Igor Akkerman
 */
public abstract class AbstractMatrixTraverser<Entry>
extends AbstractTraverser<Entry>
implements MatrixTraverser<Entry> {

    /** {@link Matrix} traversed by this {@link AbstractMatrixTraverser} */
    private final Matrix<Entry> matrix;

    /**
     * Creates a new AbstractMatrixTraverser traversing the specified
     * {@link Matrix}.
     * 
     * @param matrix
     *        {@link Matrix} to traverse
     */
    public AbstractMatrixTraverser(final Matrix<Entry> matrix) {
        this.matrix = matrix;
    }

    /**
     * Returns the {@link Matrix} traversed by this
     * {@link AbstractMatrixTraverser}.
     * 
     * @return {@link Matrix} traversed by this {@link AbstractMatrixTraverser}
     */
    protected Matrix<Entry> getMatrix() {
        return matrix;
    }
}

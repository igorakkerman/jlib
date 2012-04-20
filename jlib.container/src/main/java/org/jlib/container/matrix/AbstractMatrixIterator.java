package org.jlib.container.matrix;

/**
 * Skeletal implementation of a {@link MatrixIterator}.
 * 
 * @param <Entry>
 *        type of the entries of the {@link Matrix}
 * 
 * @author Igor Akkerman
 */
public abstract class AbstractMatrixIterator<Entry>
implements MatrixIterator<Entry> {

    /** {@link Matrix} traversed by this {@link AbstractMatrixIterator} */
    private final Matrix<Entry> matrix;

    /**
     * Creates a new AbstractMatrixIterator traversing the specified
     * {@link Matrix}.
     * 
     * @param matrix
     *        {@link Matrix} to traverse
     */
    public AbstractMatrixIterator(final Matrix<Entry> matrix) {
        this.matrix = matrix;
    }

    /**
     * Returns the {@link Matrix} traversed by this
     * {@link AbstractMatrixIterator}.
     * 
     * @return {@link Matrix} traversed by this {@link AbstractMatrixIterator}
     */
    protected Matrix<Entry> getMatrix() {
        return matrix;
    }

    /**
     * Always throws a {@code UnsupportedOperationException} since a single Entry
     * cnanot be removed from a {@link Matrix}.
     * 
     * @throws UnsupportedOperationException
     *         always
     */
    @Override
    public void remove()
    throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }
}

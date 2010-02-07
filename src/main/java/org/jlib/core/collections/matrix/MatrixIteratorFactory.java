package org.jlib.core.collections.matrix;

/**
 * Skeletal implementation of an {@link Iterable} creating
 * {@link VerticalMatrixIterator VerticalMatrixIterators} over the Elements of a
 * {@link Matrix}.
 * 
 * @param <Element>
 *        type of the elements stored in the {@link Matrix}
 * @author Igor Akkerman
 */
public abstract class MatrixIteratorFactory<Element>
implements Iterable<Element> {

    /**
     * {@link Matrix} for which the {@link MatrixIterator MatrixIterators} are
     * being created
     */
    private Matrix<Element> matrix;

    /**
     * Creates a new MatrixIteratorFactory for a {@link Matrix} specified at a later
     * instant using {@link #setMatrix(Matrix)}.
     */
    public MatrixIteratorFactory() {
        super();
    }

    /**
     * Creates a new MatrixIteratorFactory for the specified {@link Matrix}.
     * 
     * @param matrix
     *        {@link Matrix} for which {@link MatrixIterator MatrixIterators}
     *        are being created by this MatrixIteratorFactory
     */
    public MatrixIteratorFactory(Matrix<Element> matrix) {
        this();
        this.matrix = matrix;
    }

    /**
     * Returns the {@link Matrix} for which {@link MatrixIterator
     * MatrixIterators} are being created by this MatrixIteratorFactory.
     * 
     * @return Matrix<Element> to iterate
     */
    public Matrix<Element> getMatrix() {
        return matrix;
    }

    /**
     * Registers the {@link Matrix} for which {@link MatrixIterator
     * MatrixIterators} are being created by this MatrixIteratorFactory.
     * 
     * @param matrix
     *        Matrix<Element> to iterate
     */
    public void setMatrix(Matrix<Element> matrix) {
        this.matrix = matrix;
    }

}

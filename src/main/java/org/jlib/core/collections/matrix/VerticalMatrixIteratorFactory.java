package org.jlib.core.collections.matrix;

/**
 * {@link MatrixIteratorFactory} creating {@link VerticalMatrixIterator
 * VerticalMatrixIterators} over the Elements of a {@link Matrix}.
 * 
 * @param <Element>
 *        type of the elements stored in the {@link Matrix}
 * @author Igor Akkerman
 */
public class VerticalMatrixIteratorFactory<Element>
extends MatrixIteratorFactory<Element> {

    /**
     * Creates a new VerticalMatrixIteratorFactory for a {@link Matrix} specified at a
     * later instant using {@link #setMatrix(Matrix)}.
     */
    public VerticalMatrixIteratorFactory() {
        super();
    }

    /**
     * Creates a new VerticalMatrixIteratorFactory for the specified {@link Matrix}.
     * 
     * @param matrix
     *        {@link Matrix} for which the {@link MatrixIterator
     *        MatrixIterators} are being created
     */
    public VerticalMatrixIteratorFactory(Matrix<Element> matrix) {
        super(matrix);
    }

    // @see java.lang.Iterable#iterator()
    @Override
    public MatrixIterator<Element> iterator() {
        return new VerticalMatrixIterator<Element>(getMatrix());
    }
}
package org.jlib.core.collections.matrix;

/**
 * {@link MatrixIteratorFactory} creating {@link HorizontalMatrixIterator
 * HorizontalMatrixIterators} over the Elements of a {@link Matrix}.
 * 
 * @param <Element>
 *        type of the elements stored in the {@link Matrix}
 * @author Igor Akkerman
 */
public class HorizontalMatrixIteratorFactory<Element>
extends MatrixIteratorFactory<Element> {

    /**
     * Creates a new HorizontalMatrixIteratorFactory for a {@link Matrix} specified at a
     * later instant using {@link #setMatrix(Matrix)}.
     */
    public HorizontalMatrixIteratorFactory() {
        super();
    }

    /**
     * Creates a new HorizontalMatrixIteratorFactory for the specified {@link Matrix}.
     * 
     * @param matrix
     *        {@link Matrix} for which the {@link MatrixIterator
     *        MatrixIterators} are being created
     */
    public HorizontalMatrixIteratorFactory(Matrix<Element> matrix) {
        super(matrix);
    }

    // @see java.lang.Iterable#iterator()
    @Override
    public MatrixIterator<Element> iterator() {
        return new HorizontalMatrixIterator<Element>(getMatrix());
    }
}
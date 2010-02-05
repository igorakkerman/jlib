package org.jlib.core.collections.matrix;

/**
 * {@link MatrixIteratorFactory} creating {@link VerticalMatrixIterator
 * VerticalMatrixIterators}.
 * 
 * @param <Element>
 *        type of the elements stored in the {@link Matrix}
 * @author Igor Akkerman
 */
public class VerticalMatrixIteratorFactory<Element>
implements MatrixIteratorFactory<Element> {

    /** sole VerticalMatrixIteratorFactory instance */
    private static final VerticalMatrixIteratorFactory<?> INSTANCE = new VerticalMatrixIteratorFactory<Object>();

    /**
     * Returns the sole VerticalMatrixIteratorFactory instance.
     * 
     * @param <Element>
     *        type of the elements stored in the {@link Matrix}
     * @return sole VerticalMatrixIteratorFactory instance
     */
    @SuppressWarnings("unchecked")
    public static <Element> VerticalMatrixIteratorFactory<Element> getInstance() {
        return (VerticalMatrixIteratorFactory<Element>) INSTANCE;
    }

    /**
     * Creates a new VerticalMatrixIteratorFactory.
     */
    private VerticalMatrixIteratorFactory() {
        super();
    }

    // @see org.jlib.core.collections.matrix.MatrixIteratorFactories.MatrixIteratorFactory#newMatrixIterator()
    @Override
    public MatrixIterator<Element> newMatrixIterator(Matrix<Element> matrix) {
        return new VerticalMatrixIterator<Element>(matrix);
    }
}
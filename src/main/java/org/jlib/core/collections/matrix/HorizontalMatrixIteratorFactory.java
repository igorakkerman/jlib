package org.jlib.core.collections.matrix;

/**
 * {@link MatrixIteratorFactory} creating {@link HorizontalMatrixIterator
 * HorizontalMatrixIterators}.
 * 
 * @param <Element>
 *        type of the elements stored in the {@link Matrix}
 * @author Igor Akkerman
 */
public class HorizontalMatrixIteratorFactory<Element>
implements MatrixIteratorFactory<Element> {

    /** sole HorizontalMatrixIteratorFactory instance */
    private static final HorizontalMatrixIteratorFactory<?> INSTANCE = new HorizontalMatrixIteratorFactory<Object>();

    /**
     * Returns the sole HorizontalMatrixIteratorFactory instance.
     * 
     * @param <Element>
     *        type of the elements stored in the {@link Matrix}
     * @return sole HorizontalMatrixIteratorFactory instance
     */
    @SuppressWarnings("unchecked")
    public static <Element> HorizontalMatrixIteratorFactory<Element> getInstance() {
        return (HorizontalMatrixIteratorFactory<Element>) INSTANCE;
    }

    /**
     * Creates a new HorizontalMatrixIteratorFactory.
     */
    private HorizontalMatrixIteratorFactory() {
        super();
    }

    // @see org.jlib.core.collections.matrix.MatrixIteratorFactories.MatrixIteratorFactory#newMatrixIterator()
    @Override
    public MatrixIterator<Element> newMatrixIterator(Matrix<Element> matrix) {
        return new HorizontalMatrixIterator<Element>(matrix);
    }
}
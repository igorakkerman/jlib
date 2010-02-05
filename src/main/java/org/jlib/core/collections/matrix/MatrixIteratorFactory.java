package org.jlib.core.collections.matrix;

/**
 * Abstract factory for {@link MatrixIterator MatrixIterators}.
 * 
 * @param <Element>
 *        type of the elements stored in the {@link Matrix}
 * @author Igor Akkerman
 */
public interface MatrixIteratorFactory<Element> {

    /**
     * Creates a new {@link MatrixIterator}. Implementations of this
     * interface decide of the actually instantiated implemnetation.
     * 
     * @param matrix
     *        {@link Matrix} for which the {@link MatrixIterator} is being
     *        created
     * @return {@link MatrixIterator} for {@code matrix}
     */
    MatrixIterator<Element> newMatrixIterator(Matrix<Element> matrix);
}
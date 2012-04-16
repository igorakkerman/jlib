package org.jlib.container.matrix;

/**
 * Skeletal implementation of an {@link Iterable} creating instances of
 * {@link VerticalMatrixIterator} over a {@link Matrix}.
 * 
 * @author Igor Akkerman
 */
public interface MatrixIterationOrder {

    /**
     * Creates a new {@link AbstractMatrixIterator} for the specified {@link Matrix}
     * 
     * @param matrix
     *        {@link Matrix} to traverse
     * 
     * @return new {@link AbstractMatrixIterator} over the Elements of
     *         {@code matrix}
     */
    public <Element> MatrixIterator<Element> createIterator(final ArraySequenceMatrix<Element> matrix);
}

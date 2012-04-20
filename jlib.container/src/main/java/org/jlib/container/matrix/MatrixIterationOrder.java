package org.jlib.container.matrix;

/**
 * Abstract factory for {@link MatrixIterator} instances, representing the
 * iteration order of a {@link RandomTraversalMatrix}.
 * 
 * @author Igor Akkerman
 */
public interface MatrixIterationOrder {

    /**
     * Creates a new {@link MatrixIterator} for the specified
     * {@link Matrix}
     * 
     * @param <Entry>
     *        type of the Entries of the {@link Matrix}
     * 
     * @param matrix
     *        {@link RandomTraversalMatrix} to traverse
     * 
     * @return new {@link MatrixIterator} over the Elements of
     *         {@code matrix}
     */
    public <Entry> MatrixIterator<Entry> createIterator(final RandomTraversalMatrix<Entry> matrix);
}

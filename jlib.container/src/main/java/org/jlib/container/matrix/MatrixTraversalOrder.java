package org.jlib.container.matrix;

/**
 * Abstract factory for {@link MatrixTraverser} instances, representing the
 * iteration order of a {@link RandomTraversalMatrix}.
 * 
 * @author Igor Akkerman
 */
public interface MatrixTraversalOrder {

    /**
     * Creates a new {@link MatrixTraverser} for the specified {@link Matrix}.
     * 
     * @param <Entry>
     *        type of the Entries of the {@link Matrix}
     * 
     * @param matrix
     *        {@link RandomTraversalMatrix} to traverse
     * 
     * @return new {@link MatrixTraverser} over the Items of {@code matrix}
     */
    public <Entry> MatrixTraverser<Entry> createTraverser(final RandomTraversalMatrix<Entry> matrix);
}

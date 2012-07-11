package org.jlib.container.matrix;

/**
 * {@link Iterable} providing a {@link MatrixTraverser} traversing the Items of
 * a {@link Matrix}.
 * 
 * @param <Entry>
 *        type of the entries returned by the {@link MatrixTraversible}.
 * 
 * @author Igor Akkerman
 */
public interface MatrixTraversible<Entry> {

    /**
     * Creates a {@link MatrixTraverser} traversing the Entries of this
     * {@link MatrixTraversible} in the default order. The default order may be
     * defined by the concrete implementation or even made customizable.
     * 
     * @return a new {@link MatrixTraverser} over the Entries of this
     *         {@link Matrix}
     */
    public MatrixTraverser<Entry> createTraverser();
}

package org.jlib.container.matrix;

import java.util.Iterator;
import java.util.RandomAccess;

import org.jlib.container.sequence.Sequence;

/**
 * {@link Matrix} traversable in various orders. A {@link Sequence} of all
 * columns or rows can be retrieved and the {@link Matrix} can be traversed by a
 * custom {@link MatrixIterator}. The default {@link MatrixIterator} returned by
 * {@link #createIterator()} and {@link #iterator()} can be customized using
 * {@link #setDefaultIterationOrder(MatrixIterationOrder)}. A
 * {@link RandomTraversalMatrix} is not necessarily a {@link RandomAccess}
 * {@link Matrix}.
 * 
 * @param <Entry>
 *        type of the entries of the Matrix
 * 
 * @see MatrixIterationOrder
 * 
 * @author Igor Akkerman
 */
public interface RandomTraversalMatrix<Entry>
extends Matrix<Entry> {

    /**
     * Returns the {@link Sequence} of the rows of this {@link Matrix}, each
     * provided as a {@link Sequence}.
     * 
     * @return IndexSequence of the MatrixRows of this ArraySequenceMatrix
     */
    public Sequence<? extends Sequence<Entry>> getColumns();

    /**
     * Returns the {@link Sequence} of the rows of this {@link Matrix}, each
     * provided as a {@link Sequence}.
     * 
     * @return IndexSequence of the MatrixRows of this ArraySequenceMatrix
     */
    public Sequence<? extends Sequence<Entry>> getRows();

    /**
     * <p>
     * Returns a {@link MatrixIterable} providing a {@link MatrixIterator}
     * traversing the Elements of this {@link Matrix} using the specified
     * {@link MatrixIterationOrder}.
     * </p>
     * <p>
     * Example:
     * </p>
     * 
     * <pre>
     * for (Integer matrixEntry : matrix.iteratedInOrder(VERTICAL)
     *     System.out.print(matrixEntry + " ");
     * </pre>
     * 
     * @param iterationOrder
     *        {@link MatrixIterationOrder} used by the returned {@link Iterable}
     * 
     * @return {@link MatrixIterable} providing a {@link MatrixIterator}
     *         traversing the Elements of this {@link Matrix} using the
     *         specified {@link MatrixIterationOrder}.
     */
    public MatrixIterable<Entry> iteratedInOrder(final MatrixIterationOrder iterationOrder);

    /**
     * Registers the {@link MatrixIterationOrder} used by each {@link Iterator}
     * returned by {@link #iterator()}.
     * 
     * @param defaultIterationOrder
     *        {@link MatrixIterationOrder} used by default {@link Iterator
     *        Iterators}
     */
    public void setDefaultIterationOrder(final MatrixIterationOrder defaultIterationOrder);
}

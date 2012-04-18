package org.jlib.container.matrix;

import org.jlib.container.sequence.Sequence;

/**
 * Sequence of elements of a {@link Matrix}, typically a row, column or
 * submatrix, but may be contain any entries of a {@link Matrix} in a predefined
 * order.
 * 
 * @param <Entry>
 *        type of the entries of the {@link Matrix}
 * 
 * @author Igor Akkerman
 */
public interface MatrixSubsequence<Entry>
extends Sequence<Entry> {
    /**
     * Returns the {@link Matrix} from which this {@link MatrixSubsequence} originates.
     *
     * @return {@link Matrix} from which this {@link MatrixSubsequence} originates
     */
    public Matrix<Entry> getMatrix();
}

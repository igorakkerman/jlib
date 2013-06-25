package org.jlib.container.matrix;

/**
 * {@link InvalidMatrixEntriesDimensionException} for a column with an invalid height.
 *
 * @author Igor Akkerman
 */
public class InvalidMatrixEntriesColumnHeightException
extends InvalidMatrixEntriesDimensionException {

    /**
     * Creates a new {@link InvalidMatrixEntriesColumnHeightException}.
     *
     * @param matrix
     *        referenced {@link Matrix}
     *
     * @param entries
     *        two-dimensional array of new Entries
     *
     * @param invalidColumnIndex
     *        integer specifying the index of the column having the invalid height
     *
     * @param invalidHeightValue
     *        integer specifying the invalid height value
     *
     * @param correctHeightValue
     *        integer specifying the correct height value
     */
    InvalidMatrixEntriesColumnHeightException(final Matrix<?> matrix, final Object[][] entries, final int invalidColumnIndex,
                                              final int invalidHeightValue, final int correctHeightValue) {

        super(matrix, entries, invalidColumnIndex, invalidHeightValue, correctHeightValue);
    }
}

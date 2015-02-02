package org.jlib.container.operation.matrix;

/**
 * {@link InvalidMatrixEntriesDimensionException} for a row with an invalid width.
 *
 * @author Igor Akkerman
 */
public abstract class InvalidMatrixEntriesRowWidthException
extends InvalidMatrixEntriesDimensionException {

    /**
     * Creates a new {@link InvalidMatrixEntriesRowWidthException}.
     *
     * @param matrix
     *        referenced {@link Matrix}
     *
     * @param entries
     *        two-dimensional array of new Entries
     *
     * @param invalidRowIndex
     *        integer specifying the index of the row having an invalid width
     *
     * @param invalidWidthValue
     *        integer specifying the invalid width value
     *
     * @param correctWidthValue
     *        integer specifying the correct dimension value
     */
    protected InvalidMatrixEntriesRowWidthException(final Matrix<?> matrix, final Object[][] entries, final int invalidRowIndex,
                                                    final int invalidWidthValue, final int correctWidthValue) {

        super(matrix, entries, invalidRowIndex, invalidWidthValue, correctWidthValue);
    }
}

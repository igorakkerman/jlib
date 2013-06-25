package org.jlib.container.matrix;

import org.jlib.core.exception.InvalidArgumentException;

/**
 * {@link InvalidArgumentException} thrown when an array of {@link Matrix} Entries is specified with either the
 * surrounding array or one of the contained arrays has invalid dimansions.
 *
 * @author Igor Akkerman
 */
public abstract class InvalidMatrixEntriesDimensionException
extends InvalidMatrixArgumentException {

    private final Object[][] entries;

    /** invalid dimension index */
    private final int index;

    /** invalid dimension value */
    private final int invalidValue;

    /** correct dimension value */
    private final int correctValue;

    /**
     * Creates a new {@link InvalidMatrixEntriesDimensionException}.
     *
     * @param matrix
     *        referenced {@link Matrix}
     *
     * @param invalidValue
     *        integer specifying the invalid dimension value
     *
     * @param correctValue
     *        integer specifying the correct dimension value
     */
    protected InvalidMatrixEntriesDimensionException(final Matrix<?> matrix, final Object[][] entries, final int index,
                                                     final int invalidValue, final int correctValue) {

        super(matrix, "[1]{2} != {3}, {0}", index, invalidValue, correctValue);
        this.entries = entries;

        this.index = index;
        this.invalidValue = invalidValue;
        this.correctValue = correctValue;
    }

    /**
     * Returns the index locating the invalid dimension value.
     *
     * @return integer specifying theindex
     */
    public int getIndex() {
        return index;
    }

    /**
     * Returns the invalid dimension value.
     *
     * @return integer specifying the invalid dimension value
     */
    public int getInvalidValue() {
        return invalidValue;
    }

    /**
     * Returns the correct dimension value.
     *
     * @return integer specifying the correct dimension value
     */
    public int getCorrectValue() {
        return correctValue;
    }
}

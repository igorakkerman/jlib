package org.jlib.container.matrix;

import org.jlib.core.language.InvalidArgumentException;

import org.jlib.container.InvalidContainerArgumentException;

import static org.jlib.core.language.ExceptionMessageUtility.message;

/**
 * {@link InvalidArgumentException} thrown when an array of {@link Matrix} Entries is specified with either the
 * surrounding array or one of the contained arrays has invalid dimansions.
 *
 * @author Igor Akkerman
 */
public abstract class InvalidMatrixEntriesDimensionException
extends InvalidContainerArgumentException {

    private static final long serialVersionUID = - 7552630985350522465L;

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

        super(matrix, message("[{0}]{1} != {2}", index, invalidValue, correctValue));
    }
}

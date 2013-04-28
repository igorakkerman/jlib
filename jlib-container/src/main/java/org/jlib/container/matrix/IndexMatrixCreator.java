package org.jlib.container.matrix;

/**
 * Creator of instances of a certain subtype of {@link IndexMatrix}.
 * 
 * @param <Metrix>
 *        type of the created {@link IndexMatrix} instances
 * 
 * @param <Entry>
 *        type of the entries of the {@link Matrix}
 * 
 * @author Igor Akkerman
 */
public abstract class IndexMatrixCreator<Metrix extends InitializeableIndexMatrix<Entry>, Entry> {

    /**
     * Creates a new {@link InitializeableIndexMatrix} with the specified
     * minimum and maximum column and row indices.
     * 
     * @param firstColumnIndex
     *        integer specifying the first column index
     * 
     * @param firstRowIndex
     *        integer specifying the first row index
     * 
     * @param lastColumnIndex
     *        integer specifying the last column index
     * 
     * @param lastRowIndex
     *        integer specifying the last row index
     * 
     * @return the new {@link InitializeableIndexMatrix}
     * 
     * @throws IllegalArgumentException
     *         if {@code lastColumnIndex < firstColumnIndex || lastRowIndex <
     *         firstRowIndex}
     */
    public abstract Metrix createMatrix(final int firstColumnIndex, final int firstRowIndex, final int lastColumnIndex,
                                        final int lastRowIndex);

    /**
     * Creates a new {@link InitializeableIndexMatrix} with the a minimum column
     * and row indices of {@code 0} and the specified width and height.
     * 
     * @param width
     *        integer specifying the width
     * 
     * @param height
     *        integer specifying the height
     * 
     * @return the new {@link InitializeableIndexMatrix}
     * 
     * @throws IllegalArgumentException
     *         if {@code width < 1 || height < 1}
     */
    public final Metrix createMatrix(final int width, final int height)
    throws IllegalArgumentException {
        assertDimensionValid("width", width);
        assertDimensionValid("height", height);

        return createMatrix(0, 0, width - 1, height - 1);
    }

    /**
     * Creates a new {@link InitializeableIndexMatrix} with the specified
     * minimum column and row indices, prefilled with the specified Entries.
     * 
     * @param firstColumnIndex
     *        integer specifying the first column index
     * 
     * @param firstRowIndex
     *        integer specifying the first row index
     * 
     * @param entries
     *        array of Entry items to be copied to the new
     *        {@link InitializeableIndexMatrix}
     * 
     * @return the new {@link InitializeableIndexMatrix}
     * 
     * @throws IllegalArgumentException
     *         if not all sub arrays have the same length
     */
    public final Metrix createMatrix(final int firstColumnIndex, final int firstRowIndex, final Entry[][] entries) {
        final int width = entries.length;
        assertDimensionValid("width", width);

        final int height = entries[0].length;
        assertDimensionValid("height", height);

        final Metrix matrix = createMatrix(firstColumnIndex, firstRowIndex, width, height);

        for (int arrayColumnIndex = 0, columnIndex = firstColumnIndex; arrayColumnIndex < width; arrayColumnIndex ++, columnIndex ++) {
            final Entry[] columnEntries = entries[arrayColumnIndex];
            if (columnEntries.length != height)
                throw new IllegalArgumentException("entries[" + arrayColumnIndex + "].length != entries[0].length");

            for (int arrayRowIndex = 0, rowIndex = firstRowIndex; arrayRowIndex < height; arrayRowIndex ++)
                matrix.replaceStoredEntry(columnIndex, rowIndex, entries[arrayColumnIndex][arrayRowIndex]);
        }

        return matrix;
    }

    /**
     * Creates a new {@link InitializeableIndexMatrix} with minimum column and
     * row indices of {@code 0}, prefilled with the specified Entries.
     * 
     * @param entries
     *        array of Entry items to be copied to the new
     *        {@link InitializeableIndexMatrix}
     * 
     * @return the new {@link InitializeableIndexMatrix}
     * 
     * @throws IllegalArgumentException
     *         if not all sub arrays have the same length
     */
    public final Metrix createMatrix(final Entry[][] entries) {
        return createMatrix(0, 0, entries);
    }

    /**
     * Verifies whether the specified {@link Matrix} dimension has a positive
     * value.
     * 
     * @param dimensionName
     *        String specifying the dimension name
     * 
     * @param dimensionValue
     *        integer specifying the dimension value
     * 
     * @throws IllegalArgumentException
     *         if {@code dimensionValue < 1}
     */
    private void assertDimensionValid(final String dimensionName, final int dimensionValue)
    throws IllegalArgumentException {
        if (dimensionValue < 1)
            throw new IllegalArgumentException(dimensionName + " == " + dimensionValue + " < 1");
    }
}

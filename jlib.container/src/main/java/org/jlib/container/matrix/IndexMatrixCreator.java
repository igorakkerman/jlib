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

    public abstract Metrix createMatrix(final int firstColumnIndex, final int firstRowIndex, final int lastColumnIndex,
                                        final int lastRowIndex);

    public final Metrix createMatrix(final int width, final int height)
    throws IllegalArgumentException {
        assertDimensionValid("width", width);
        assertDimensionValid("height", height);

        return createMatrix(0, 0, width - 1, height - 1);
    }

    public final Metrix createMatrix(final Entry[][] entries, final int firstColumnIndex, final int firstRowIndex) {
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

    public final Metrix createMatrix(final Entry[][] entries) {
        return createMatrix(entries, 0, 0);
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

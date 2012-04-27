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
public abstract class IndexMatrixCreator<Metrix extends IndexMatrix<Entry>, Entry> {

    public abstract Metrix createMatrix(final int firstColumnIndex, final int firstRowIndex, final int lastColumnIndex,
                                        final int lastRowIndex);

    public Metrix createMatrix(final int width, final int height)
    throws IllegalArgumentException {
        assertDimensionValid("width", width);
        assertDimensionValid("height", height);

        return createMatrix(0, 0, width - 1, height - 1);
    }

    public Metrix createMatrix(final Entry[][] entries) {
        final int width = entries.length;
        assertDimensionValid("width", width);
        
        final int height = entries[0].length;
        assertDimensionValid("height", height);
        
        for (int arrayColumnIndex = 0; arrayColumnIndex < width; arrayColumnIndex ++)
            final Entry[] columnEntries = entries[arrayColumnIndex];
            if (columnEntries.length != height)
                throw new IllegalArgumentException("entries[" + arrayColumnIndex + "].length != entries[0].length");
        
            for (int arrayRowIndex = 0; arrayRowIndex < width; arrayRowIndex ++) {
                
            }
        }
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

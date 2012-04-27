package org.jlib.container.matrix;

public class MatrixIndexOutOfBoundsException
extends IndexOutOfBoundsException {

    private final IndexMatrix<?> matrix;

    private final int columnIndex;

    private final int rowIndex;

    public MatrixIndexOutOfBoundsException(final IndexMatrix<?> matrix, final int columnIndex, final int rowIndex,
                                           final String message) {
        super(message + ": [" + columnIndex + ", " + rowIndex + "] " + matrix);

        this.matrix = matrix;
        this.columnIndex = columnIndex;
        this.rowIndex = rowIndex;
    }

    /**
     * Returns the {@link IndexMatrix} of this
     * {@link MatrixIndexOutOfBoundsException}.
     * 
     * @return the IndexMatrix<?>
     */
    public IndexMatrix<?> getMatrix() {
        return matrix;
    }

    /**
     * Returns the column index of this {@link MatrixIndexOutOfBoundsException}.
     * 
     * @return int specifying the column index
     */
    public int getColumnIndex() {
        return columnIndex;
    }

    /**
     * Returns the row index of this {@link MatrixIndexOutOfBoundsException}.
     * 
     * @return int specifying the row index
     */
    public int getRowIndex() {
        return rowIndex;
    }
}

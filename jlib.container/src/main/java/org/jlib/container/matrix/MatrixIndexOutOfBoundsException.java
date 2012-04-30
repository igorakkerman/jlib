package org.jlib.container.matrix;

/**
 * Exception thrown when a {@link IndexMatrix} is accessed with an invalid
 * index.
 * 
 * @author Igor Akkerman
 */
public class MatrixIndexOutOfBoundsException
extends IndexOutOfBoundsException {

    /** serialVersionUID */
    private static final long serialVersionUID = -1022358594354919533L;

    /** {@link IndexMatrix} */
    private final IndexMatrix<?> matrix;

    /** column index */
    private final int columnIndex;

    /** row index */
    private final int rowIndex;

    /**
     * Creates a new {@link MatrixIndexOutOfBoundsException} for the specified
     * indices.
     * 
     * @param matrix
     *        {@link IndexMatrix} accessed with an invalid index
     * 
     * @param columnIndex
     *        integer specifying the used columnIndex
     * 
     * @param rowIndex
     *        integer specifying the user rowIndex
     * 
     * @param message
     *        String specifying the message explaining the invalid access
     */
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
     * @return integer specifying the column index
     */
    public int getColumnIndex() {
        return columnIndex;
    }

    /**
     * Returns the row index of this {@link MatrixIndexOutOfBoundsException}.
     * 
     * @return integer specifying the row index
     */
    public int getRowIndex() {
        return rowIndex;
    }
}

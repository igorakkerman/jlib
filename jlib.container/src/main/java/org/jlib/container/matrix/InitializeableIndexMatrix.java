package org.jlib.container.matrix;

public abstract class InitializeableIndexMatrix<Entry>
extends AbstractIndexMatrix<Entry> {

    /**
     * Creates a new {@link InitializeableIndexMatrix}.
     * 
     * @param firstColumnIndex
     *        integer specifying the index of the first column
     * 
     * @param firstRowIndex
     *        integer specifying the index of the first row
     * 
     * @param lastColumnIndex
     *        integer specifying the index of the last column
     * 
     * @param lastRowIndex
     *        integer specifying the index of the last row
     */
    public InitializeableIndexMatrix(final int firstColumnIndex, final int firstRowIndex, final int lastColumnIndex,
                                     final int lastRowIndex) {

        super(firstColumnIndex, firstRowIndex, lastColumnIndex, lastRowIndex);
    }

    protected void replace(final int columnIndex, final int rowIndex, final Entry entry)
    throws MatrixIndexOutOfBoundsException {
        assertIndicesValid(columnIndex, rowIndex);

        replaceStoredEntry(columnIndex, rowIndex, entry);
    }

    protected abstract void replaceStoredEntry(final int columnIndex, final int rowIndex, final Entry entry);

}

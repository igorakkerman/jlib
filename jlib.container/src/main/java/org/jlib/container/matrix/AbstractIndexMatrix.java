package org.jlib.container.matrix;

import org.jlib.container.sequence.AbstractIndexSequence;
import org.jlib.container.sequence.Sequence;
import org.jlib.container.sequence.SequenceIndexOutOfBoundsException;

/**
 * Skeletal implementation of an {@link IndexMatrix}.
 * 
 * @param <Entry>
 *        type of the entries of the {@link IndexMatrix}
 * 
 * @author Igor Akkerman
 */
public abstract class AbstractIndexMatrix<Entry>
extends AbstractMatrix<Entry>
implements IndexMatrix<Entry> {

    /** first column index */
    private final int firstColumnIndex;

    /** last column index */
    private final int lastColumnIndex;

    /** first row index */
    private final int firstRowIndex;

    /** last row index */
    private final int lastRowIndex;

    /**
     * Creates a new {@link AbstractIndexMatrix}.
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
    public AbstractIndexMatrix(final int firstColumnIndex, final int firstRowIndex, final int lastColumnIndex,
                               final int lastRowIndex) {
        super();

        this.firstColumnIndex = firstColumnIndex;
        this.lastColumnIndex = lastColumnIndex;
        this.firstRowIndex = firstRowIndex;
        this.lastRowIndex = lastRowIndex;
    }

    /**
     * Returns the index of the first column of this {@link AbstractIndexMatrix}
     * .
     * 
     * @return integer specifying the index of the first column
     */
    @Override
    public int getFirstColumnIndex() {
        return firstColumnIndex;
    }

    /**
     * Returns the index of the last column of this {@link AbstractIndexMatrix}.
     * 
     * @return integer specifying the index of the last column
     */
    @Override
    public int getLastColumnIndex() {
        return lastColumnIndex;
    }

    /**
     * Returns the firstRowIndex of this {@link AbstractIndexMatrix}.
     * 
     * @return int specifying the firstRowIndex
     */
    @Override
    public int getFirstRowIndex() {
        return firstRowIndex;
    }

    /**
     * Returns the lastRowIndex of this {@link AbstractIndexMatrix}.
     * 
     * @return int specifying the lastRowIndex
     */
    @Override
    public int getLastRowIndex() {
        return lastRowIndex;
    }

    /**
     * Returns the Element stored at the specified column and row in this
     * ArrayMatrix.
     * 
     * @param columnIndex
     *        integer specifying the column of the stored Element
     * @param rowIndex
     *        integer specifying the row of the stored Element
     * @return Element stored at the specified position in this ArrayMatrix
     * @throws SequenceIndexOutOfBoundsException
     *         if {@code nextColumnIndex < getMinColumnIndex() ||
     *         nextColumnIndex > getMaxColumnIndex() || nextRowIndex <
     *         getMinRowIndex || nextRowIndex > getMaxRowIndex()}
     */
    @Override
    public final Entry get(final int columnIndex, final int rowIndex)
    throws MatrixIndexOutOfBoundsException {
        assertIndicesValid(columnIndex, rowIndex);

        return getStoredEntry(columnIndex, rowIndex);
    }

    protected abstract Entry getStoredEntry(final int columnIndex, final int rowIndex);

    @Override
    public Sequence<? extends IndexMatrixColumn<Entry>> getColumns() {
        return new AbstractIndexSequence<IndexMatrixColumn<Entry>>(firstColumnIndex, lastColumnIndex) {

            @Override
            public IndexMatrixColumn<Entry> getStoredElement(final int columnIndex) {
                return getColumn(columnIndex);
            }
        };
    }

    @Override
    public Sequence<? extends IndexMatrixRow<Entry>> getRows() {
        return new AbstractIndexSequence<IndexMatrixRow<Entry>>(firstRowIndex, lastRowIndex) {

            @Override
            public IndexMatrixRow<Entry> getStoredElement(final int rowIndex) {
                return getRow(rowIndex);
            }
        };
    }

    protected void assertIndicesValid(final int columnIndex, final int rowIndex)
    throws MatrixIndexOutOfBoundsException {

        if (columnIndex < firstColumnIndex)
            throw new MatrixIndexOutOfBoundsException(this, columnIndex, rowIndex, "columnIndex == " + columnIndex +
                                                                                   " < " + firstColumnIndex +
                                                                                   " firstColumnIndex");

        if (columnIndex > lastColumnIndex)
            throw new MatrixIndexOutOfBoundsException(this, columnIndex, rowIndex, "columnIndex == " + columnIndex +
                                                                                   " > " + lastColumnIndex +
                                                                                   " lastColumnIndex");

        if (rowIndex < firstRowIndex)
            throw new MatrixIndexOutOfBoundsException(this, columnIndex, rowIndex, "rowIndex == " + rowIndex + " < " +
                                                                                   firstRowIndex + " firstRowIndex");

        if (rowIndex > lastRowIndex)
            throw new MatrixIndexOutOfBoundsException(this, columnIndex, rowIndex, "rowIndex == " + rowIndex + " > " +
                                                                                   lastRowIndex + " lastRowIndex");
    }
}

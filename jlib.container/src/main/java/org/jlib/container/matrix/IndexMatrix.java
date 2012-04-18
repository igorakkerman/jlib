package org.jlib.container.matrix;

import org.jlib.container.sequence.SequenceIndexOutOfBoundsException;

/**
 * Indexed {@link Matrix}.
 * 
 * @param <Element>
 *        type of the elements held in the ArraySequenceMatrix
 * 
 * @param <ColumnIndex>
 *        type of column indices
 * 
 * @param <RowIndex>
 *        type of row indices
 * 
 * @author Igor Akkerman
 */

public interface IndexMatrix<ColumnIndex, RowIndex, Element>
extends Matrix<Element> {

    /**
     * Returns the Element stored at the specified column and row in this
     * ArraySequenceMatrix.
     * 
     * @param columnIndex
     *        integer specifying the column of the stored Element
     * 
     * @param rowIndex
     *        integer specifying the row of the stored Element
     * 
     * @return Element stored at the specified position in this
     *         ArraySequenceMatrix
     * 
     * @throws SequenceIndexOutOfBoundsException
     *         if {@code nextColumnIndex < getMinColumnIndex() ||
     *         nextColumnIndex > getMaxColumnIndex() || nextRowIndex <
     *         getMinRowIndex || nextRowIndex > getMaxRowIndex()}
     */
    public Element get(final ColumnIndex columnIndex, final RowIndex rowIndex)
    throws SequenceIndexOutOfBoundsException;

    /**
     * Registers the Element to store at the specified column and row in this
     * ArraySequenceMatrix.
     * 
     * @param columnIndex
     *        integer specifying the column of the Element to store
     * 
     * @param rowIndex
     *        integer specifying the row of the Element to store
     * 
     * @param element
     *        Element to store. {@code null} is a valid Element.
     * 
     * @throws SequenceIndexOutOfBoundsException
     *         if {@code nextColumnIndex < getMinColumnIndex() ||
     *         nextColumnIndex > getMaxColumnIndex() || nextRowIndex <
     *         getMinRowIndex || nextRowIndex > getMaxRowIndex()}
     */
    public void set(final ColumnIndex columnIndex, final RowIndex rowIndex, final Element element);

    /**
     * Returns a IndexMatrixColumn representing the specified column of this
     * ArraySequenceMatrix.
     * 
     * @param columnIndex
     *        integer specifying the index of the column
     * 
     * @return IndexMatrixColumn representing the column with {@code nextColumnIndex}
     */
    public IndexMatrixColumn<Element> getColumn(final ColumnIndex columnIndex);

    /**
     * Returns a IndexMatrixColumn representing the specified portion of the
     * specified column of this ArraySequenceMatrix.
     * 
     * @param columnIndex
     *        integer specifying the index of the column
     * 
     * @param firstRowIndex
     *        integer specifying the first row index of the portion of the
     *        column
     * 
     * @param lastRowindex
     *        integer specifying the last row index of the portion of the
     *        column
     * 
     * @return IndexMatrixColumn representing the specified portion of the column
     *         with {@code nextColumnIndex}
     */
    public IndexMatrixColumn<Element> getColumn(final ColumnIndex columnIndex, final RowIndex firstRowIndex,
                                           final RowIndex lastRowindex);

    /**
     * Returns a IndexMatrixRow representing the specified row of this
     * ArraySequenceMatrix.
     * 
     * @param rowIndex
     *        integer specifying the index of the row
     * 
     * @return IndexMatrixRow representing the row with {@code nextRowIndex}
     */
    public IndexMatrixRow<Element> getRow(final RowIndex rowIndex);

    /**
     * Returns a IndexMatrixRow representing the specified portion of the specified
     * row of this ArraySequenceMatrix.
     * 
     * @param rowIndex
     *        integer specifying the index of the row
     * 
     * @param firstColumnIndex
     *        integer specifying the first column index of the portion of the
     *        row
     * 
     * @param lastColumnIndex
     *        integer specifying the last column index of the portion of the
     *        row
     * 
     * @return IndexMatrixRow representing the specified portion of the row with
     *         {@code nextRowIndex}
     */
    public IndexMatrixRow<Element> getRow(final RowIndex rowIndex, final ColumnIndex firstColumnIndex, final ColumnIndex lastColumnIndex);

    /**
     * Returns the first column index of this ArraySequenceMatrix.
     * 
     * @return integer specifying the minimum column of this ArraySequenceMatrix
     */
    public ColumnIndex getFirstColumnIndex();

    /**
     * Returns the last column index of this ArraySequenceMatrix.
     * 
     * @return integer specifying the maximum column of this ArraySequenceMatrix
     */
    public ColumnIndex getLastColumnIndex();

    /**
     * Returns the first row index of this ArraySequenceMatrix.
     * 
     * @return integer specifying the minimum row of this ArraySequenceMatrix
     */
    public RowIndex getFirstRowIndex();

    /**
     * Returns the last row index of this ArraySequenceMatrix.
     * 
     * @return integer specifying the maximum row of this ArraySequenceMatrix
     */
    public RowIndex getLastRowIndex();
}

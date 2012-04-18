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
     * Returns a MatrixColumn representing the specified column of this
     * ArraySequenceMatrix.
     * 
     * @param columnIndex
     *        integer specifying the index of the column
     * 
     * @return MatrixColumn representing the column with {@code nextColumnIndex}
     */
    public MatrixColumn<Element> getColumn(final ColumnIndex columnIndex);

    /**
     * Returns a MatrixColumn representing the specified portion of the
     * specified column of this ArraySequenceMatrix.
     * 
     * @param columnIndex
     *        integer specifying the index of the column
     * 
     * @param minimumRowIndex
     *        integer specifying the minimum row index of the portion of the
     *        column
     * 
     * @param maximumRowIndex
     *        integer specifying the maximum row index of the portion of the
     *        column
     * 
     * @return MatrixColumn representing the specified portion of the column
     *         with {@code nextColumnIndex}
     */
    public MatrixColumn<Element> getColumn(final ColumnIndex columnIndex, final RowIndex minimumRowIndex,
                                           final int maximumRowIndex);

    /**
     * Returns a MatrixRow representing the specified row of this
     * ArraySequenceMatrix.
     * 
     * @param rowIndex
     *        integer specifying the index of the row
     * 
     * @return MatrixRow representing the row with {@code nextRowIndex}
     */
    public MatrixRow<Element> getRow(final RowIndex rowIndex);

    /**
     * Returns a MatrixRow representing the specified portion of the specified
     * row of this ArraySequenceMatrix.
     * 
     * @param rowIndex
     *        integer specifying the index of the row
     * 
     * @param firstColumnIndex
     *        integer specifying the minimum column index of the portion of the
     *        row
     * 
     * @param lastColumnIndex
     *        integer specifying the maximum column index of the portion of the
     *        row
     * 
     * @return MatrixRow representing the specified portion of the row with
     *         {@code nextRowIndex}
     */
    public MatrixRow<Element> getRow(final RowIndex rowIndex, final int firstColumnIndex, final int lastColumnIndex);

    /**
     * Returns the minimum column index of this ArraySequenceMatrix.
     * 
     * @return integer specifying the minimum column of this ArraySequenceMatrix
     */
    public ColumnIndex getFirstColumnIndex();

    /**
     * Returns the maximum column index of this ArraySequenceMatrix.
     * 
     * @return integer specifying the maximum column of this ArraySequenceMatrix
     */
    public ColumnIndex getLastColumnIndex();

    /**
     * Returns the minimum row index of this ArraySequenceMatrix.
     * 
     * @return integer specifying the minimum row of this ArraySequenceMatrix
     */
    public RowIndex getFirstRowIndex();

    /**
     * Returns the maximum row index of this ArraySequenceMatrix.
     * 
     * @return integer specifying the maximum row of this ArraySequenceMatrix
     */
    public RowIndex getLastRowIndex();
}

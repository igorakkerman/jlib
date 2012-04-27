package org.jlib.container.matrix;

import java.util.RandomAccess;

import org.jlib.container.sequence.IndexSequence;
import org.jlib.container.sequence.SequenceIndexOutOfBoundsException;

/**
 * Indexed {@link Matrix} providing {@link RandomAccess} to its entries.
 * 
 * @param <Entry>
 *        type of the elements held in the ArrayMatrix
 * 
 * @author Igor Akkerman
 */

public interface IndexMatrix<Entry>
extends RandomTraversalMatrix<Entry>, RandomAccess {

    /**
     * Returns the Element stored at the specified column and row in this
     * {@link IndexMatrix}.
     * 
     * @param columnIndex
     *        integer specifying the column of the stored Element
     * 
     * @param rowIndex
     *        integer specifying the row of the stored Element
     * 
     * @return Element stored at the specified position in this
     *         ArrayMatrix
     * 
     * @throws SequenceIndexOutOfBoundsException
     *         if {@code nextint < getMinint() ||
     *         nextint > getMaxint() || nextint <
     *         getMinint || nextint > getMaxint()}
     */
    public Entry get(final int columnIndex, final int rowIndex)
    throws SequenceIndexOutOfBoundsException;

    /**
     * Returns the specified {@link IndexMatrixColumn} of this
     * {@link IndexMatrix}.
     * 
     * @param columnIndex
     *        integer specifying the index of the column
     * 
     * @return IndexMatrixColumn representing the column with {@code nextint}
     */
    public IndexMatrixColumn<Entry> getColumn(final int columnIndex);

    /**
     * Returns the specified {@link IndexMatrixColumn} of the specified column
     * of this {@link IndexMatrix}.
     * 
     * @param columnIndex
     *        integer specifying the index of the column
     * 
     * @param firstRowIndex
     *        integer specifying the first row index of the portion of the
     *        column
     * 
     * @param lastRowIndex
     *        integer specifying the last row index of the portion of the column
     * 
     * @return IndexMatrixColumn representing the specified portion of the
     *         column with {@code nextint}
     */
    public IndexMatrixColumn<Entry> getColumn(final int columnIndex, final int firstRowIndex, final int lastRowIndex);

    /**
     * Returns the specified {@link IndexMatrixRow} of this {@link IndexMatrix}.
     * 
     * @param rowIndex
     *        integer specifying the index of the row
     * 
     * @return IndexMatrixRow representing the row with {@code nextint}
     */
    public IndexMatrixRow<Entry> getRow(final int rowIndex);

    /**
     * Returns the specified {@link IndexMatrixRow} of this {@link IndexMatrix}.
     * 
     * @param rowIndex
     *        integer specifying the index of the row
     * 
     * @param firstColumnIndex
     *        integer specifying the first column index of the portion of the
     *        row
     * 
     * @param lastColumnIndex
     *        integer specifying the last column index of the portion of the row
     * 
     * @return IndexMatrixRow representing the specified portion of the row with
     *         {@code nextint}
     */
    public IndexSequence<Entry> getRow(final int rowIndex, final int firstColumnIndex, final int lastColumnIndex);

    /**
     * Returns the first column index of this {@link IndexMatrix}.
     * 
     * @return integer specifying the minimum column of this {@link IndexMatrix}
     */
    public int getFirstColumnIndex();

    /**
     * Returns the last column index of this {@link IndexMatrix}.
     * 
     * @return integer specifying the maximum column of this {@link IndexMatrix}
     */
    public int getLastColumnIndex();

    /**
     * Returns the first row index of this {@link IndexMatrix}.
     * 
     * @return integer specifying the minimum row of this {@link IndexMatrix}
     */
    public int getFirstRowIndex();

    /**
     * Returns the last row index of this {@link IndexMatrix}.
     * 
     * @return integer specifying the maximum row of this {@link IndexMatrix}
     */
    public int getLastRowIndex();
}

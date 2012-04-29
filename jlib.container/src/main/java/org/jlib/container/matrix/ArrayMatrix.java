/*
 * jlib - The Free Java Library
 *
 *    http://www.jlib.org
 *
 * Copyright (c) 2006-2008 Igor Akkerman
 *
 * jlib is distributed under the
 *
 *    COMMON PUBLIC LICENSE VERSION 1.0
 *
 *    http://www.opensource.org/licenses/cpl1.0.php
 */

// TODO: MatrixIndexOutOfBoundsException
// TODO: separate empty matrices from ArrayMatrix class or use delegates

package org.jlib.container.matrix;

import java.util.Iterator;

import org.jlib.container.sequence.IndexSequence;

/**
 * {@link IndexMatrix} backed by an {@link ArraySequence}.
 * 
 * @param <Entry>
 *        type of the entries held in the {@link ArrayMatrix}
 * 
 * @author Igor Akkerman
 */
public class ArrayMatrix<Entry>
extends InitializeableIndexMatrix<Entry>
implements IndexMatrix<Entry> {

    /**
     * delegate array of Entry items containing the data of this
     * {@link ArrayMatrix}
     */
    private Entry[][] delegateArray;

    /**
     * {@link MatrixIterationOrder} used by each {@link Iterator} returned by
     * {@link #iterator()}.
     */
    private MatrixIterationOrder defaultIterationOrder;

    @Override
    protected Entry getStoredEntry(final int columnIndex, final int rowIndex) {
        return getDelegateArrayEntry(getDelegateArrayColumnIndex(columnIndex), rowIndex);
    }

    @Override
    protected void replaceStoredEntry(final int columnIndex, final int rowIndex, final Entry entry) {
        replaceDelegateArrayEntry(getDelegateArrayColumnIndex(columnIndex), getDelegateArrayRowIndex(rowIndex), entry);
    }

    private void replaceDelegateArrayEntry(final int arrayColumnIndex, final int arrayRowIndex, final Entry entry) {
        delegateArray[arrayColumnIndex][arrayRowIndex] = entry;
    }

    private Entry getDelegateArrayEntry(final int arrayColumnIndex, final int arrayRowIndex) {
        return delegateArray[arrayColumnIndex][arrayRowIndex];
    }

    private int getDelegateArrayColumnIndex(final int columnIndex) {
        return columnIndex - getFirstColumnIndex();
    }

    private int getDelegateArrayRowIndex(final int rowIndex) {
        return rowIndex - getFirstRowIndex();
    }

    /**
     * Returns a MatrixColumn representing the specified column of this
     * ArrayMatrix.
     * 
     * @param columnIndex
     *        integer specifying the index of the column
     * @return MatrixColumn representing the column with {@code nextColumnIndex}
     */
    @Override
    public IndexSequence<Entry> getColumn(final int columnIndex) {
        return new DefaultMatrixColumn<Entry>(this, columnIndex);
    }

    /**
     * Returns a MatrixColumn representing the specified portion of the
     * specified column of this ArrayMatrix.
     * 
     * @param columnIndex
     *        integer specifying the index of the column
     * @param firstRowIndex
     *        integer specifying the first row index of the portion of the
     *        column
     * @param lastRowIndex
     *        integer specifying the last row index of the portion of the column
     * @return MatrixColumn representing the specified portion of the column
     *         with {@code nextColumnIndex}
     */
    @Override
    public IndexSequence<Entry> getColumn(final int columnIndex, @SuppressWarnings("hiding") final int firstRowIndex,
                                          @SuppressWarnings("hiding") final int lastRowIndex) {
        return new DefaultMatrixColumn<Entry>(this, columnIndex, firstRowIndex, lastRowIndex);
    }

    /**
     * Returns a MatrixRow representing the specified row of this ArrayMatrix.
     * 
     * @param rowIndex
     *        integer specifying the index of the row
     * @return MatrixRow representing the row with {@code nextRowIndex}
     */
    @Override
    public MatrixRow<Entry> getRow(final int rowIndex) {
        return new DefaultMatrixRow<Entry>(this, rowIndex);
    }

    /**
     * Returns a MatrixRow representing the specified portion of the specified
     * row of this ArrayMatrix.
     * 
     * @param rowIndex
     *        integer specifying the index of the row
     * @param firstColumnIndex
     *        integer specifying the first column index of the portion of the
     *        row
     * @param lastColumnIndex
     *        integer specifying the last column index of the portion of the row
     * @return MatrixRow representing the specified portion of the row with
     *         {@code nextRowIndex}
     */
    // TODO: maybe it would be more appropriate to name these kinds of parameters using start/end or first/last
    @Override
    public MatrixRow<Entry> getRow(final int rowIndex, @SuppressWarnings("hiding") final int firstColumnIndex,
                                   @SuppressWarnings("hiding") final int lastColumnIndex) {
        return new DefaultMatrixRow<Entry>(this, rowIndex, firstColumnIndex, lastColumnIndex);
    }

    /**
     * Returns the Sequence of the MatrixRows of this ArrayMatrix.
     * 
     * @return IndexSequence of the MatrixRows of this ArrayMatrix
     */
    @Override
    public IndexSequence<MatrixRow<Entry>> getRows() {
        return new IndexMatrixRow<Entry>(this);
    }

    /**
     * Returns the Sequence of the MatrixColumns of this ArrayMatrix.
     * 
     * @return {@link IndexSequence} of the {@link MatrixColumn MatrixColumns}
     *         of this {@link ArrayMatrix}
     */
    @Override
    public IndexSequence<MatrixColumn<Entry>> getColumns() {
        return new MatrixColumnsSequence<Entry>(this);
    }

    /**
     * Returns the first column index of this ArrayMatrix.
     * 
     * @return {@link Integer} specifying the minimum column of this ArrayMatrix
     */
    @Override
    public Integer getFirstColumnIndex() {
        return firstColumnIndex;
    }

    /**
     * Returns the last column index of this ArrayMatrix.
     * 
     * @return {@link Integer} specifying the maximum column of this ArrayMatrix
     */
    @Override
    public int getLastColumnIndex() {
        return lastColumnIndex;
    }

    /**
     * Returns the first row index of this ArrayMatrix.
     * 
     * @return {@link Integer} specifying the minimum row of this ArrayMatrix
     */
    @Override
    public int getFirstRowIndex() {
        return firstRowIndex;
    }

    /**
     * Returns the last row index of this ArrayMatrix.
     * 
     * @return integer specifying the maximum row of this ArrayMatrix
     */
    @Override
    public int getLastRowIndex() {
        return lastRowIndex;
    }

    /**
     * Returns the width of this ArrayMatrix.
     * 
     * @return integer specifying the width
     */
    @Override
    public int getWidth() {
        return width;
    }

    /**
     * Returns the height of this ArrayMatrix.
     * 
     * @return integer specifying the height
     */
    @Override
    public int getHeight() {
        return height;
    }

    /**
     * Creates a {@link AbstractIndexMatrixIterator} traversing the Elements of
     * this {@link ArrayMatrix}. The order in which the Elements are traversed
     * is specified using
     * {@link #setDefaultIterationOrder(MatrixIterationOrder)}.
     * 
     * @return a new {@link AbstractIndexMatrixIterator} for this ArrayMatrix
     * 
     * @see #setDefaultIterationOrder(MatrixIterationOrder)
     * @see MatrixIterationOrder
     */
    @Override
    public MatrixIterator<Entry> createIterator() {
        return defaultIterationOrder.createIterator(this);
    }

    /**
     * Registers the {@link MatrixIterationOrder} used by each {@link Iterator}
     * returned by {@link #iterator()}.
     * 
     * @param defaultIterationOrder
     *        {@link MatrixIterationOrder} used by default {@link Iterator
     *        Iterators}
     */
    @Override
    public void setDefaultIterationOrder(final MatrixIterationOrder defaultIterationOrder) {
        this.defaultIterationOrder = defaultIterationOrder;
    }

    @Override
    public String toString() {
        return delegateArray.toString();
    }
}
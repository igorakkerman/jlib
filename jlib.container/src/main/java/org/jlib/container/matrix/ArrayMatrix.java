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

package org.jlib.container.matrix;

/**
 * {@link IndexMatrix} backed by an array.
 * 
 * @param <Entry>
 *        type of the entries held in the {@link ArrayMatrix}
 * 
 * @author Igor Akkerman
 */
public class ArrayMatrix<Entry>
extends InitializeableIndexMatrix<Entry> {

    /**
     * delegate array of Entry items containing the data of this
     * {@link ArrayMatrix}
     */
    private Entry[][] delegateArray;

    /**
     * Creates a new {@link ArrayMatrix} with the specified first and last
     * column and row indices.
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
     *        integer specifying the index of the lastrow
     */
    protected ArrayMatrix(final int firstColumnIndex, final int firstRowIndex, final int lastColumnIndex,
                          final int lastRowIndex) {
        super(firstColumnIndex, firstRowIndex, lastColumnIndex, lastRowIndex);
    }

    @Override
    protected Entry getStoredEntry(final int columnIndex, final int rowIndex) {
        return getDelegateArrayEntry(getDelegateArrayColumnIndex(columnIndex), rowIndex);
    }

    @Override
    protected void replaceStoredEntry(final int columnIndex, final int rowIndex, final Entry entry) {
        replaceDelegateArrayEntry(getDelegateArrayColumnIndex(columnIndex), getDelegateArrayRowIndex(rowIndex), entry);
    }

    /**
     * Replaces the Entry of the delegate array specified by its array indices
     * by the specified Entry.
     * 
     * @param arrayColumnIndex
     *        integer specifying the array column index
     * 
     * @param arrayRowIndex
     *        integer specifying the array row index
     * 
     * @param entry
     *        Entry replacing the former Entry
     */
    private void replaceDelegateArrayEntry(final int arrayColumnIndex, final int arrayRowIndex, final Entry entry) {
        delegateArray[arrayColumnIndex][arrayRowIndex] = entry;
    }

    /**
     * Returns the Entry of the delegate array specified by its array indices.
     * 
     * @param arrayColumnIndex
     *        integer specifying the array column index
     * 
     * @param arrayRowIndex
     *        integer specifying the array row index
     * 
     * @return Entry stored in the delegate array at
     *         {@code array[arrayColumnIndex][arrayRowIndex]}
     */
    private Entry getDelegateArrayEntry(final int arrayColumnIndex, final int arrayRowIndex) {
        return delegateArray[arrayColumnIndex][arrayRowIndex];
    }

    /**
     * Returns the array column index corresponding to the specified column
     * index.
     * 
     * @param columnIndex
     *        integer specifying the column index
     * 
     * @return integer specifying the corresponding array column index
     */
    private int getDelegateArrayColumnIndex(final int columnIndex) {
        return columnIndex - getFirstColumnIndex();
    }

    /**
     * Returns the array row index corresponding to the specified row index.
     * 
     * @param rowIndex
     *        integer specifying the row index
     * 
     * @return integer specifying the corresponding array row index
     */
    private int getDelegateArrayRowIndex(final int rowIndex) {
        return rowIndex - getFirstRowIndex();
    }
}

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
}

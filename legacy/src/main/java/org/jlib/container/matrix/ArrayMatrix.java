/*
 * jlib - Open Source Java Library
 *
 *     www.jlib.org
 *
 *
 *     Copyright 2005-2013 Igor Akkerman
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 */

package org.jlib.container.operation.matrix;

/**
 * {@link IndexMatrix} backed by an array.
 *
 * @param <Entry>
 *        type of the entries held in the {@link ArrayMatrix}
 *
 * @author Igor Akkerman
 */
public class ArrayMatrix<Entry>
/*extends InitializeableIndexMatrix<Entry>*/ {

    /**
     * delegate array of Entry items containing the data of this
     * {@link ArrayMatrix}
     */
    private Entry[][] delegateArray;

//    /**
//     * Creates a new {@link ArrayMatrix} with the specified first and last
//     * column and row indices.
//     *
//     * @param firstColumnIndex
//     *        integer specifying the index of the first column
//     *
//     * @param firstRowIndex
//     *        integer specifying the index of the first row
//     *
//     * @param lastColumnIndex
//     *        integer specifying the index of the last column
//     *
//     * @param lastRowIndex
//     *        integer specifying the index of the lastrow
//     */
//    protected ArrayMatrix(final int firstColumnIndex, final int firstRowIndex, final int lastColumnIndex, final int lastRowIndex) {
//        super(firstColumnIndex, firstRowIndex, lastColumnIndex, lastRowIndex);
//    }
//
//    @Override
//    protected Entry getStoredEntry(final int columnIndex, final int rowIndex) {
//        return getDelegateArrayEntry(getDelegateArrayColumnIndex(columnIndex), rowIndex);
//    }
//
//    @Override
//    protected void replaceStoredEntry(final int columnIndex, final int rowIndex, final Entry entry) {
//        replaceDelegateArrayEntry(getDelegateArrayColumnIndex(columnIndex), getDelegateArrayRowIndex(rowIndex), entry);
//    }
//
//    /**
//     * Replaces the Entry of the delegate array specified by its array indices
//     * by the specified Entry.
//     *
//     * @param arrayColumnIndex
//     *        integer specifying the array column index
//     *
//     * @param arrayRowIndex
//     *        integer specifying the array row index
//     *
//     * @param entry
//     *        Entry replacing the former Entry
//     */
//    private void replaceDelegateArrayEntry(final int arrayColumnIndex, final int arrayRowIndex, final Entry entry) {
//        delegateArray[arrayColumnIndex][arrayRowIndex] = entry;
//    }
//
//    /**
//     * Returns the Entry of the delegate array specified by its array indices.
//     *
//     * @param arrayColumnIndex
//     *        integer specifying the array column index
//     *
//     * @param arrayRowIndex
//     *        integer specifying the array row index
//     *
//     * @return Entry stored in the delegate array at
//     *         {@code array[arrayColumnIndex][arrayRowIndex]}
//     */
//    private Entry getDelegateArrayEntry(final int arrayColumnIndex, final int arrayRowIndex) {
//        return delegateArray[arrayColumnIndex][arrayRowIndex];
//    }
//
//    /**
//     * Returns the array column index corresponding to the specified column
//     * index.
//     *
//     * @param columnIndex
//     *        integer specifying the column index
//     *
//     * @return integer specifying the corresponding array column index
//     */
//    private int getDelegateArrayColumnIndex(final int columnIndex) {
//        return columnIndex - getFirstColumnIndex();
//    }
//
//    /**
//     * Returns the array row index corresponding to the specified row index.
//     *
//     * @param rowIndex
//     *        integer specifying the row index
//     *
//     * @return integer specifying the corresponding array row index
//     */
//    private int getDelegateArrayRowIndex(final int rowIndex) {
//        return rowIndex - getFirstRowIndex();
//    }
}

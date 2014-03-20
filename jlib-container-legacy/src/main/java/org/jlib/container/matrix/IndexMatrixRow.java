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
 * Row of an {@link IndexMatrix}.
 *
 * @param <Entry>
 *        type of the items in the IndexMatrix
 *
 * @author Igor Akkerman
 */
class IndexMatrixRow<Entry>
extends IndexMatrixEntity<Entry> {

    /**
     * Creates a new {@link IndexMatrixRow} representation of the specified row
     * of the specified {@link IndexMatrix}.
     *
     * @param matrix
     *        {@link IndexMatrix} owning this {@link IndexMatrixRow}
     *
     * @param rowIndex
     *        integer specifying the index of this {@link IndexMatrixRow}
     */
    protected IndexMatrixRow(final IndexMatrix<Entry> matrix, final int rowIndex) {
        super(matrix, rowIndex);
    }

    /**
     * Creates a new {@link IndexMatrixColumn} representation of the specified
     * part of the specified row of the specified {@link IndexMatrix}.
     *
     * @param matrix
     *        {@link IndexMatrix} owning this {@link IndexMatrixRow}
     *
     * @param rowIndex
     *        integer specifying the index of this {@link IndexMatrixRow}
     *
     * @param firstColumnIndex
     *        integer specifying the first row index of the column part
     *
     * @param lastColumnIndex
     *        integer specifying the last row index of the column part
     */
    protected IndexMatrixRow(final IndexMatrix<Entry> matrix, final int rowIndex, final int firstColumnIndex, final int lastColumnIndex) {
        super(matrix, rowIndex, firstColumnIndex, lastColumnIndex);
    }

    /**
     * Returns the Entry stored at the specified column index in this
     * {@link IndexMatrixRow}.
     *
     * @param columnIndex
     *        integer specifying the column index
     *
     * @return Entry stored at {@code columnIndex}
     */
    @Override
    protected Entry getStoredItem(final int columnIndex) {
        return getMatrixEntry(columnIndex, getEntityIndex());
    }
}

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

package org.jlib.container.matrix;

/**
 * Column of an {@link IndexMatrix}.
 *
 * @param <Entry>
 *        type of the items in the IndexMatrix
 *
 * @author Igor Akkerman
 */
class IndexMatrixColumn<Entry>
extends IndexMatrixEntity<Entry> {

    /**
     * Creates a new {@link IndexMatrixColumn} representation of the specified
     * column of the specified {@link IndexMatrix}.
     *
     * @param matrix
     *        {@link IndexMatrix} owning this {@link IndexMatrixColumn}
     *
     * @param columnIndex
     *        integer specifying the index of this {@link IndexMatrixColumn}
     */
    protected IndexMatrixColumn(final IndexMatrix<Entry> matrix, final int columnIndex) {
        super(matrix, columnIndex);
    }

    /**
     * Creates a new {@link IndexMatrixColumn} representation of the specified
     * part of the specified column of the specified {@link IndexMatrix}.
     *
     * @param matrix
     *        {@link IndexMatrix} owning this {@link IndexMatrixColumn}
     *
     * @param columnIndex
     *        integer specifying the index of this {@link IndexMatrixColumn}
     *
     * @param firstRowIndex
     *        integer specifying the first row index of the column part
     *
     * @param lastRowIndex
     *        integer specifying the last row index of the column part
     */
    protected IndexMatrixColumn(final IndexMatrix<Entry> matrix, final int columnIndex, final int firstRowIndex, final int lastRowIndex) {
        super(matrix, columnIndex, firstRowIndex, lastRowIndex);
    }

    /**
     * Returns the Entry stored at the specified row index in this
     * {@link IndexMatrixColumn}.
     *
     * @param rowIndex
     *        integer specifying the row index
     *
     * @return Entry stored at {@code rowIndex}
     */
    @Override
    protected Entry getStoredItem(final int rowIndex) {
        return getMatrixEntry(getEntityIndex(), rowIndex);
    }

    @Override
    @SuppressWarnings("unchecked")
    public IndexMatrixColumn clone() {
        return (IndexMatrixColumn) super.clone();
    }
}

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
 * {@link AbstractIndexMatrix} that can be initialized.
 *
 * @param <Entry>
 *        type of entried of the {@link Matrix}
 *
 * @author Igor Akkerman
 */
public abstract class InitializeableIndexMatrix<Entry>
extends AbstractIndexMatrix<Entry> {

    /**
     * Creates a new {@link InitializeableIndexMatrix}.
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
    public InitializeableIndexMatrix(final int firstColumnIndex, final int firstRowIndex, final int lastColumnIndex, final int lastRowIndex) {

        super(firstColumnIndex, firstRowIndex, lastColumnIndex, lastRowIndex);
    }

    /**
     * Replaces the Entry stored at the spcified column and row indices in this
     * {@link InitializeableIndexMatrix} by the specified Entry.
     *
     * @param columnIndex
     *        integer specifying the column index
     *
     * @param rowIndex
     *        integer specifying the row index
     *
     * @param entry
     *        Entry replacing the former Entry
     *
     * @throws MatrixIndexOutOfBoundsException
     *         if
     *         {@code columnIndex < getFirstColumnIndex() || columnIndex > getLastColumnIndex || rowIndex < getFirstRowIndex() || rowIndex > getLastRowIndex()}
     */
    protected void replace(final int columnIndex, final int rowIndex, final Entry entry)
    throws MatrixIndexOutOfBoundsException {
        assertIndicesValid(columnIndex, rowIndex);

        replaceStoredEntry(columnIndex, rowIndex, entry);
    }

    /**
     * Replaces the Entry stored at the spcified column and row indices in this
     * {@link InitializeableIndexMatrix} by the specified Entry, assuming that
     * the specified indices are valid.
     *
     * @param columnIndex
     *        integer specifying the valid column index
     *
     * @param rowIndex
     *        integer specifying the valid row index
     *
     * @param entry
     *        Entry replacing the former Entry
     */
    protected abstract void replaceStoredEntry(int columnIndex, int rowIndex, Entry entry);
}

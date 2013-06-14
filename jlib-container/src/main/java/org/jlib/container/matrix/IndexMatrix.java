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

import org.jlib.container.sequence.index.IndexSequence;
import org.jlib.container.sequence.index.SequenceIndexOutOfBoundsException;

import java.util.RandomAccess;

/**
 * Indexed {@link Matrix} providing {@link RandomAccess} to its entries.
 *
 * @param <Entry>
 *        type of the items held in the ArrayMatrix
 *
 * @author Igor Akkerman
 */

public interface IndexMatrix<Entry>
extends RandomTraversalMatrix<Entry>, RandomAccess {

    /**
     * Returns the Item stored at the specified column and row in this
     * {@link IndexMatrix}.
     *
     * @param columnIndex
     *        integer specifying the column of the stored Item
     *
     * @param rowIndex
     *        integer specifying the row of the stored Item
     *
     * @return Item stored at the specified position in this
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

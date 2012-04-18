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

import org.jlib.container.sequence.IndexSequence;

/**
 * Row or partial row of a ArraySequenceMatrix.
 * 
 * @param <ColumnIndex>
 *        type of the {@link IndexMatrix} column indices
 * 
 * @param <RowIndex>
 *        type of the {@link IndexMatrix} row indices
 * 
 * @param <Entry>
 *        type of the entries of the {@link IndexMatrix}
 * 
 * @author Igor Akkerman
 */
public interface IndexMatrixRow<ColumnIndex, RowIndex, Entry>
extends MatrixSubsequence<Entry>, IndexSequence<Entry> {

    /**
     * Returns the {@link IndexMatrix} of which this {@link IndexMatrixRow}
     * represents the row or the range of a row.
     * 
     * @return {@link IndexMatrix} of which this {@link IndexMatrixRow}
     *         represents the row or the range of a row
     */
    public IndexMatrix<?, RowIndex, Entry> getMatrix();

    /**
     * Returns the index of the row that this IndexMatrixRow represents.
     * 
     * @return integer specifying the index of the row that this IndexMatrixRow
     *         represents
     */
    public RowIndex getRowIndex();

    /**
     * Returns the first column index of the range of the row that this
     * IndexMatrixColumn represents.
     * 
     * @return integer specifying the first column index of the range of the row
     *         that this IndexMatrixColumn represents
     */
    public ColumnIndex getFirstColumnIndex();

    /**
     * Returns the last column index of the range of the row that this
     * IndexMatrixColumn represents.
     * 
     * @return integer specifying the last column index of the range of the row
     *         that this IndexMatrixColumn represents
     */
    public ColumnIndex getLastColumnIndex();
}

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

import org.jlib.container.sequence.ReplaceIndexSequence;

/**
 * Column or partial column of a ArraySequenceMatrix.
 *
 * @param <Element>
 *        type of elements in the ArraySequenceMatrix
 * @author Igor Akkerman
 */
public interface IndexMatrixColumn<Element>
extends ReplaceIndexSequence<Element> {

    /**
     * Returns the ArraySequenceMatrix of which this IndexMatrixColumn represents the column or the range of
     * a column.
     *
     * @return ArraySequenceMatrix of which this IndexMatrixColumn represents the column or the range of a
     *         column
     */
    public ArraySequenceMatrix<Element> getMatrix();

    /**
     * Returns the first row index of the range of the column that this IndexMatrixColumn
     * represents.
     *
     * @return integer specifying the first row index of the range of the column that
     *         this IndexMatrixColumn represents
     */
    public RowIndex getFirstRowIndex();

    /**
     * Returns the last row index of the range of the column that this IndexMatrixColumn
     * represents.
     *
     * @return integer specifying the last row index of the range of the column that
     *         this IndexMatrixColumn represents
     */
    public RowIndex getMaximumRowIndex();

    /**
     * Returns the index of the column that this IndexMatrixColumn represents.
     *
     * @return integer specifying the index of the column that this IndexMatrixColumn
     *         represents
     */
    public ColumnIndex getColumnIndex();

}

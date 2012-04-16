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
public interface MatrixColumn<Element>
extends ReplaceIndexSequence<Element> {

    /**
     * Returns the ArraySequenceMatrix of which this MatrixColumn represents the column or the range of
     * a column.
     *
     * @return ArraySequenceMatrix of which this MatrixColumn represents the column or the range of a
     *         column
     */
    public ArraySequenceMatrix<Element> getMatrix();

    /**
     * Returns the minimum row index of the range of the column that this MatrixColumn
     * represents.
     *
     * @return integer specifying the minimum row index of the range of the column that
     *         this MatrixColumn represents
     */
    public int getMinimumRowIndex();

    /**
     * Returns the maximum row index of the range of the column that this MatrixColumn
     * represents.
     *
     * @return integer specifying the maximum row index of the range of the column that
     *         this MatrixColumn represents
     */
    public int getMaximumRowIndex();

    /**
     * Returns the index of the column that this MatrixColumn represents.
     *
     * @return integer specifying the index of the column that this MatrixColumn
     *         represents
     */
    public int getColumnIndex();

}

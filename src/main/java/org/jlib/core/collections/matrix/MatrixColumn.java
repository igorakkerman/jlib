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

package org.jlib.core.collections.matrix;

import org.jlib.core.collections.list.EditableIndexList;

/**
 * Column or partial column of a Matrix.
 *
 * @param <Element>
 *        type of elements in the Matrix
 * @author Igor Akkerman
 */
public interface MatrixColumn<Element>
extends EditableIndexList<Element> {

    /**
     * Returns the Matrix of which this MatrixColumn represents the column or the range of
     * a column.
     *
     * @return Matrix of which this MatrixColumn represents the column or the range of a
     *         column
     */
    public Matrix<Element> getMatrix();

    /**
     * Returns the minimum row index of the range of the column that this MatrixColumn
     * represents.
     *
     * @return integer specifying the minimum row index of the range of the column that
     *         this MatrixColumn represents
     */
    public int getMinRowIndex();

    /**
     * Returns the maximum row index of the range of the column that this MatrixColumn
     * represents.
     *
     * @return integer specifying the maximum row index of the range of the column that
     *         this MatrixColumn represents
     */
    public int getMaxRowIndex();

    /**
     * Returns the index of the column that this MatrixColumn represents.
     *
     * @return integer specifying the index of the column that this MatrixColumn
     *         represents
     */
    public int getColumnIndex();

}

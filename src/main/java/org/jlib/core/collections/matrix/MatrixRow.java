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
 * Row or partial row of a Matrix.
 *
 * @param <Element>
 *        type of the elements in the Matrix
 *
 * @author Igor Akkerman
 */
public interface MatrixRow<Element>
extends EditableIndexList<Element> {
    /**
     * Returns the Matrix of which this MatrixRow represents the row or the range of a row.
     *
     * @return Matrix of which this MatrixRow represents the row or the range of a row
     */
    public Matrix<Element> getMatrix();

    /**
     * Returns the index of the row that this MatrixRow represents.
     *
     * @return integer specifying the index of the row that this MatrixRow represents
     */
    public int getRowIndex();

    /**
     * Returns the minimum column index of the range of the row that this MatrixColumn
     * represents.
     *
     * @return integer specifying the minimum column index of the range of the row that
     *         this MatrixColumn represents
     */
    public int getMinColumnIndex();

    /**
     * Returns the maximum column index of the range of the row that this MatrixColumn
     * represents.
     *
     * @return integer specifying the maximum column index of the range of the row that
     *         this MatrixColumn represents
     */
    public int getMaxColumnIndex();
}

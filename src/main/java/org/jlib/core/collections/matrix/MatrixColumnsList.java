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

import org.jlib.core.collections.list.AbstractIndexList;

/**
 * IndexList of MatrixColumns.
 *
 * @param <Element>
 *        type of the elements in the Matrix
 * @author Igor Akkerman
 */
class MatrixColumnsList<Element>
extends AbstractIndexList<MatrixColumn<Element>> {

    /** Matrix owning the Columns */
    private Matrix<Element> matrix;

    /**
     * Creates a new MatrixColumnsList of the specified Matrix.
     *
     * @param matrix
     *        Matrix owning the Columns
     */
    MatrixColumnsList(Matrix<Element> matrix) {
        super(matrix.minColumnIndex(), matrix.maxColumnIndex());
        this.matrix = matrix;
    }

    // @see org.jlib.core.collections.list.IndexList#get(int)
    @Override
    public MatrixColumn<Element> get(int index)
    throws IndexOutOfBoundsException {
        return matrix.column(index);
    }
}

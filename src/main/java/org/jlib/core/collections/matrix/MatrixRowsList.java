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
 * IndexList of MatrixRows.
 *
 * @param <Element>
 *        type of the elements in the Matrix
 * @author Igor Akkerman
 */
class MatrixRowsList<Element>
extends AbstractIndexList<MatrixRow<Element>> {

    /** Matrix owning the Rows */
    private Matrix<Element> matrix;

    /**
     * Creates a new MatrixRowsList of the specified Matrix.
     *
     * @param matrix
     *        Matrix owning the Rows
     */
    MatrixRowsList(Matrix<Element> matrix) {
        super(matrix.minRowIndex(), matrix.maxRowIndex());
        this.matrix = matrix;
    }

    // @see org.jlib.core.collections.list.IndexList#get(int)
    public MatrixRow<Element> get(int index)
    throws IndexOutOfBoundsException {
        return matrix.row(index);
    }
}

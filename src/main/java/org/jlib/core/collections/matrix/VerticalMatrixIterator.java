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

/**
 * MatrixIterator traversing the elements of a Matrix vertically. That is, the traversal algorithm is as follows:
 *
 * <pre>{@literal
 * for each column
 *     for each row
 *         process element at (column, row)}
 * </pre>
 *
 * @param <Element>
 *        type of elements stored in the Matrix
 * @author Igor Akkerman
 */
class VerticalMatrixIterator<Element>
extends MatrixIterator<Element> {

    /**
     * Creates a new VerticalMatrixIterator for the specified Matrix.
     *
     * @param matrix
     *        Matrix to traverse
     */
    protected VerticalMatrixIterator(Matrix<Element> matrix) {
        super(matrix);
    }

    // @see org.jlib.core.collections.MatrixIterator#nextElement()
    @Override
    protected void updateNextElementIndices() {
        nextElementRowIndex ++;
        if (nextElementRowIndex > matrix.maxRowIndex()) {
            nextElementColumnIndex ++;
            nextElementRowIndex = 0;
        }
    }
}

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

/**
 * AbstractMatrixIterator traversing the elements of a ArraySequenceMatrix horizontally. That is, the traversal algorithm is as follows:
 *
 * <pre>{@literal
 * foreach row
 *     foreach column
 *         process element at (column, row)}
 * </pre>
 *
 * @param <Element>
 *        type of elements stored in the ArraySequenceMatrix
 * @author Igor Akkerman
 */
public final class HorizontalMatrixIterator<Element>
extends AbstractMatrixIterator<Element> {

    /**
     * Creates a new HorizontalMatrixIterator for the specified ArraySequenceMatrix.
     *
     * @param matrix
     *        ArraySequenceMatrix to traverse
     */
    public HorizontalMatrixIterator(ArraySequenceMatrix<Element> matrix) {
        super(matrix);
    }

    @Override
    protected void updateNextElementIndices() {
        if (nextElementColumnIndex < matrix.maximumColumnIndex())
            nextElementColumnIndex ++;
        else
            updateNextEntityIndices();
    }

    @Override
    protected void updateNextEntityIndices() {
        nextElementColumnIndex = matrix.minimumColumnIndex();
        nextElementRowIndex ++;
    }    
}

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
 * AbstractIndexMatrixIterator traversing the elements of a ArraySequenceMatrix vertically. That is, the traversal algorithm is as follows:
 *
 * <pre>{@literal
 * for each column
 *     for each row
 *         process element at (column, row)}
 * </pre>
 *
 * @param <Element>
 *        type of elements stored in the ArraySequenceMatrix
 * @author Igor Akkerman
 */
public final class VerticalMatrixIterator<Element>
extends AbstractIndexMatrixIterator<Element, Integer, Integer> {

    /**
     * Creates a new VerticalMatrixIterator for the specified ArraySequenceMatrix.
     *
     * @param matrix
     *        ArraySequenceMatrix to traverse
     */
    protected VerticalMatrixIterator(ArraySequenceMatrix<Element> matrix) {
        super(matrix);
    }

    @Override
    protected void updateNextElementIndices() {
        if (nextElementRowIndex < matrix.getLastRowIndex())
            nextElementRowIndex ++;
        else 
            updateNextEntityIndices();
        
    }

    @Override
    protected void updateNextEntityIndices() {
        nextElementColumnIndex ++;
        nextElementRowIndex = matrix.getFirstRowIndex();
    }    
}

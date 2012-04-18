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

import org.jlib.container.sequence.AbstractNonEmptyIndexSequence;

/**
 * IndexSequence of MatrixColumns.
 *
 * @param <Element>
 *        type of the elements in the ArraySequenceMatrix
 * @author Igor Akkerman
 */
class MatrixColumnsSequence<Element>
extends AbstractNonEmptyIndexSequence<IndexMatrixColumn<Element>> {

    /** ArraySequenceMatrix owning the Columns */
    private ArraySequenceMatrix<Element> matrix;
    
    /**
     * Creates a new MatrixColumnsSequence of the specified ArraySequenceMatrix.
     *
     * @param matrix
     *        ArraySequenceMatrix owning the Columns
     */
    protected MatrixColumnsSequence(ArraySequenceMatrix<Element> matrix) {
        super(matrix.getFirstColumnIndex(), matrix.getLastColumnIndex());
        
        this.matrix = matrix;
    }

    @Override
    public IndexMatrixColumn<Element> get(int index)
    throws IndexOutOfBoundsException {
        return matrix.column(index);
    }
}

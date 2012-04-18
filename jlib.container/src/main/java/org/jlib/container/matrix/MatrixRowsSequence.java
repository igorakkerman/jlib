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
 * IndexSequence of MatrixRows.
 *
 * @param <Element>
 *        type of the elements in the ArraySequenceMatrix
 *        
 * @author Igor Akkerman
 */
class MatrixRowsSequence<Element>
extends AbstractNonEmptyIndexSequence<IndexMatrixRow<Element>> {

    /** ArraySequenceMatrix owning the Rows */
    private ArraySequenceMatrix<Element> matrix;

    /**
     * Creates a new MatrixRowsSequence of the specified ArraySequenceMatrix.
     *
     * @param matrix
     *        ArraySequenceMatrix owning the Rows
     */
    MatrixRowsSequence(ArraySequenceMatrix<Element> matrix) {
        super(matrix.getFirstint(), matrix.getLastint());
        this.matrix = matrix;
    }

    @Override
    public IndexMatrixRow<Element> get(int index)
    throws IndexOutOfBoundsException {
        return matrix.getRow(index);
    }
}

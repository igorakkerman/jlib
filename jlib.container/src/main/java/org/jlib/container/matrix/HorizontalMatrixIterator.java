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
 * AbstractIndexMatrixIterator traversing the elements of a
 * {@link FlexiblyTraversableMatrix} horizontally. That is, the traversal
 * algorithm is as follows:
 * 
 * <pre>
 * {@literal
 * foreach row
 *     foreach column
 *         process element at (column, row)}
 * </pre>
 * 
 * @param <Entry>
 *        type of elements stored in the {@link Matrix}
 *        
 * @author Igor Akkerman
 */
public final class HorizontalMatrixIterator<Entry>
extends EntityMatrixIterator<Entry> {

    /**
     * Creates a new {@link HorizontalMatrixIterator} for the specified
     * {@link FlexiblyTraversableMatrix}.
     * 
     * @param matrix
     *        {@link FlexiblyTraversableMatrix} to traverse
     */
    public HorizontalMatrixIterator(final FlexiblyTraversableMatrix<Entry> matrix) {
        super(matrix, matrix.getRows());
    }
}

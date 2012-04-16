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
 * Order in which a {@link ArraySequenceMatrix} is iterated.
 * 
 * @author Igor Akkerman
 */
public final class MatrixUtility {

    /** No visible default constructor. */
    private MatrixUtility() {}

    /**
     * Horizontal iteration. That is, the traversal algorithm is as follows:
     * 
     * <pre>
     * {@literal
     * foreach row
     *     foreach column
     *         process element at (column, row)}
     * </pre>
     */
    public static final MatrixIterationOrder HORIZONTAL = new MatrixIterationOrder() {

        @Override
        public <Element> MatrixIterator<Element> createIterator(final ArraySequenceMatrix<Element> matrix) {
            return new HorizontalMatrixIterator<Element>(matrix);
        }
    };

    /**
     * Vertical iteration. That is, the traversal algorithm is as follows:
     * 
     * <pre>
     * {@literal
     * foreach column
     *     foreach row
     *         process element at (column, row)}
     * </pre>
     */
    public static final MatrixIterationOrder VERTICAL = new MatrixIterationOrder() {

        @Override
        public <Element> MatrixIterator<Element> createIterator(final ArraySequenceMatrix<Element> matrix) {
            return new VerticalMatrixIterator<Element>(matrix);
        }
    };
}

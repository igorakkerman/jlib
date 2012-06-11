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
 * Order in which a {@link ArrayMatrix} is iterated.
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
     *         process item at (column, row)}
     * </pre>
     */
    public static final MatrixTraversalOrder HORIZONTAL = new MatrixTraversalOrder() {

        @Override
        public <Item> MatrixTraverser<Item> createMatrixTraverser(final RandomTraversalMatrix<Item> matrix) {
            return new EntityMatrixTraverser<Item>(matrix, matrix.getRows());
        }
    };

    /**
     * Vertical iteration. That is, the traversal algorithm is as follows:
     * 
     * <pre>
     * {@literal
     * foreach column
     *     foreach row
     *         process item at (column, row)}
     * </pre>
     */
    public static final MatrixTraversalOrder VERTICAL = new MatrixTraversalOrder() {

        @Override
        public <Item> MatrixTraverser<Item> createMatrixTraverser(final RandomTraversalMatrix<Item> matrix) {
            return new EntityMatrixTraverser<Item>(matrix, matrix.getColumns());
        }
    };
}

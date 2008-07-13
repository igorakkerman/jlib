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
 * Order in which a Matrix is iterated.
 *
 * @author Igor Akkerman
 */
public enum MatrixIterationOrder {

    /**
     * Horizontal iteration. That is, the traversal algorithm is as follows:
     *
     * <pre>{@literal
     * foreach row
     *     foreach column
     *         process element at (column, row)}
     * </pre>
     */
    HORIZONTAL,

    /**
     * Vertical iteration. That is, the traversal algorithm is as follows:
     *
     * <pre>{@literal
     * foreach column
     *     foreach row
     *         process element at (column, row)}
     * </pre>
     */
    VERTICAL;
}

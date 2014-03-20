/*
 * jlib - Open Source Java Library
 *
 *     www.jlib.org
 *
 *
 *     Copyright 2005-2013 Igor Akkerman
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 */

package org.jlib.container.operation.matrix;

/**
 * Order in which a {@link ArrayMatrix} is iterated.
 *
 * @author Igor Akkerman
 */
public final class MatrixUtility {

    /** No visible default constructor. */
    private MatrixUtility() {
    }

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
        public <Item> MatrixTraverser<Item> createTraverser(final RandomTraversalMatrix<Item> matrix) {
            return new EntityMatrixTraverser<>(matrix, matrix.getRows());
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
        public <Item> MatrixTraverser<Item> createTraverser(final RandomTraversalMatrix<Item> matrix) {
            return new EntityMatrixTraverser<>(matrix, matrix.getColumns());
        }
    };

    public static void ensureWidthValid(final int width)
    throws InvalidMatrixWidthException {
        if (width < 1)
            throw new InvalidMatrixWidthException(width);
    }

    public static void ensureHeightValid(final int height)
    throws InvalidMatrixWidthException {
        if (height < 1)
            throw new InvalidMatrixHeightException(height);
    }
}

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

package org.jlib.container.matrix;

/**
 * Exception thrown when a {@link IndexMatrix} is accessed with an invalid
 * index.
 *
 * @author Igor Akkerman
 */
public class MatrixIndexOutOfBoundsException
extends IndexOutOfBoundsException {

    /** serialVersionUID */
    private static final long serialVersionUID = - 1022358594354919533L;

    /** {@link IndexMatrix} */
    private final IndexMatrix<?> matrix;

    /** column index */
    private final int columnIndex;

    /** row index */
    private final int rowIndex;

    /**
     * Creates a new {@link MatrixIndexOutOfBoundsException} for the specified
     * indices.
     *
     * @param matrix
     *        {@link IndexMatrix} accessed with an invalid index
     *
     * @param columnIndex
     *        integer specifying the used columnIndex
     *
     * @param rowIndex
     *        integer specifying the user rowIndex
     *
     * @param message
     *        String specifying the message explaining the invalid access
     */
    public MatrixIndexOutOfBoundsException(final IndexMatrix<?> matrix, final int columnIndex, final int rowIndex, final String message) {
        super(message + ": [" + columnIndex + ", " + rowIndex + "] " + matrix);

        this.matrix = matrix;
        this.columnIndex = columnIndex;
        this.rowIndex = rowIndex;
    }

    /**
     * Returns the referenced {@link IndexMatrix}.
     *
     * @return reference {@link IndexMatrix}
     */
    public IndexMatrix<?> getMatrix() {
        return matrix;
    }

    /**
     * Returns the column index of this {@link MatrixIndexOutOfBoundsException}.
     *
     * @return integer specifying the column index
     */
    public int getColumnIndex() {
        return columnIndex;
    }

    /**
     * Returns the row index of this {@link MatrixIndexOutOfBoundsException}.
     *
     * @return integer specifying the row index
     */
    public int getRowIndex() {
        return rowIndex;
    }
}

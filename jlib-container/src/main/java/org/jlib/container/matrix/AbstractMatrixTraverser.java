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
 * Skeletal implementation of a {@link MatrixTraverser}.
 *
 * @param <Entry>
 *        type of the entries of the {@link Matrix}
 *
 * @author Igor Akkerman
 */
public abstract class AbstractMatrixTraverser<Entry>
implements MatrixTraverser<Entry> {

    /** {@link Matrix} traversed by this {@link AbstractMatrixTraverser} */
    private final Matrix<Entry> matrix;

    /**
     * Creates a new AbstractMatrixTraverser traversing the specified
     * {@link Matrix}.
     *
     * @param matrix
     *        {@link Matrix} to traverse
     */
    public AbstractMatrixTraverser(final Matrix<Entry> matrix) {
        this.matrix = matrix;
    }

    /**
     * Returns the {@link Matrix} traversed by this
     * {@link AbstractMatrixTraverser}.
     *
     * @return {@link Matrix} traversed by this {@link AbstractMatrixTraverser}
     */
    protected Matrix<Entry> getMatrix() {
        return matrix;
    }
}

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
 * Abstract factory for {@link MatrixIterator} instances, representing the
 * iteration order of a {@link RandomTraversalMatrix}.
 *
 * @author Igor Akkerman
 */
public interface MatrixTraversalOrder {

    /**
     * Creates a new {@link MatrixIterator} for the specified {@link Matrix}.
     *
     * @param <Entry>
     *        type of the Entries of the {@link Matrix}
     *
     * @param matrix
     *        {@link RandomTraversalMatrix} to traverse
     *
     * @return new {@link MatrixIterator} over the Items of {@code matrix}
     */
    public <Entry> MatrixIterator<Entry> iterator(RandomTraversalMatrix<Entry> matrix);
}

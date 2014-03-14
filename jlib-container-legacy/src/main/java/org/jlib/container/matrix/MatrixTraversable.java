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
 * {@link Traversable} providing a {@link MatrixTraverser} traversing the Items of
 * a {@link Matrix}.
 *
 * @param <Entry>
 *        type of the entries returned by the {@link MatrixTraversable}.
 *
 * @author Igor Akkerman
 */
public interface MatrixTraversable<Entry> {

    /**
     * Creates a {@link MatrixTraverser} traversing the Entries of this
     * {@link MatrixTraversable} in the default order. The default order may be
     * defined by the concrete implementation or even made customizable.
     *
     * @return a new {@link MatrixTraverser} over the Entries of this
     *         {@link Matrix}
     */
    public MatrixTraverser<Entry> createTraverser();
}

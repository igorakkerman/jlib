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
 * {@link Iterable} providing a {@link MatrixIterator} traversing the Items of
 * a {@link Matrix}.
 *
 * @param <Entry>
 *        type of the entries returned by the {@link MatrixIterable}.
 *
 * @author Igor Akkerman
 */
public interface MatrixIterable<Entry> {

    /**
     * Creates a {@link MatrixIterator} traversing the Entries of this
     * {@link MatrixIterable} in the default order. The default order may be
     * defined by the concrete implementation or even made customizable.
     *
     * @return a new {@link MatrixIterator} over the Entries of this
     *         {@link Matrix}
     */
    public MatrixIterator<Entry> iterator();
}

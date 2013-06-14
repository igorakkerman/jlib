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

import org.jlib.container.sequence.index.SequenceIndexOutOfBoundsException;

/**
 * {@link IndexMatrix} allowing the replacement of entries.
 *
 * @param <Entry>
 *        type of the entries of the {@link ReplaceIndexMatrix}
 *
 * @author Igor Akkerman
 */
public interface ReplaceIndexMatrix<Entry>
extends IndexMatrix<Entry> {

    /**
     * Registers the Item to store at the specified column and row in this
     * ArrayMatrix.
     *
     * @param columnIndex
     *        integer specifying the column of the Item to store
     *
     * @param rowIndex
     *        integer specifying the row of the Item to store
     *
     * @param entry
     *        Item to store.
     *
     * @throws SequenceIndexOutOfBoundsException
     *         if {@code nextint < getMinint() ||
     *         nextint > getMaxint() || nextint <
     *         getMinint || nextint > getMaxint()}
     */
    public void replace(final int columnIndex, final int rowIndex, final Entry entry);
}

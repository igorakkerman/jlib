/*
 * jlib - Open Source Java Library
 *
 *     www.jlib.org
 *
 *
 *     Copyright 2005-2015 Igor Akkerman
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

package org.jlib.container.capacity;

import org.jlib.container.storage.IndexRange;
import org.jlib.container.storage.InvalidIndexException;
import org.jlib.container.storage.LinearIndexStorage;

public abstract class AbstractSplitCapacityStrategy<Item>
extends AbstractCapacityStrategy<Item>
implements SplitCapacityStrategy {

    protected AbstractSplitCapacityStrategy(final LinearIndexStorage<Item> storage,
                                            final IndexRange contentIndexRange) {
        super(storage, contentIndexRange);
    }

    @Override
    public void ensureCapacity(final int splitIndex, final int splitCapacity)
    throws InvalidIndexException {
        ensureIndexValid(splitIndex);

        ensurePartialCapacityValid(splitCapacity);

        if (splitCapacity == 0)
            return;

        safeEnsureCapacity(splitIndex, splitCapacity);

        getContentIndexRange().incrementLastItemIndex(splitCapacity);
    }

    protected abstract void safeEnsureCapacity(int splitIndex, int splitCapacity);
}

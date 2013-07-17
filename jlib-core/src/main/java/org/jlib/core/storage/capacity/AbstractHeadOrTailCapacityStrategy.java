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

package org.jlib.core.storage.capacity;

import org.jlib.core.language.Valid;

import org.jlib.core.storage.ContentIndexRegistry;
import org.jlib.core.storage.LinearIndexStorage;

public abstract class AbstractHeadOrTailCapacityStrategy<Item>
extends AbstractCapacityStrategy<Item>
implements HeadOrTailCapacityStrategy {

    public AbstractHeadOrTailCapacityStrategy(final LinearIndexStorage<Item> storage,
                                              final ContentIndexRegistry contentIndexRegistry) {
        super(storage, contentIndexRegistry);
    }

    @Override
    public final void ensureCapacity(final int headOrTailCapacity)
    throws InvalidPartialCapacityException {
        ensurePartialCapacityValid(headOrTailCapacity);

        safeEnsureCapacity(headOrTailCapacity);
    }

    protected abstract void safeEnsureCapacity(@Valid int headOrTailCapacity);
}

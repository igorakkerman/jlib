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

package org.jlib.container.capacity.minimal;

import org.jlib.container.storage.IndexRange;
import org.jlib.container.storage.InvalidIndexException;
import org.jlib.container.storage.LinearIndexStorage;
import org.jlib.container.capacity.AbstractCapacityStrategy;
import org.jlib.container.capacity.CapacityStrategy;
import org.jlib.container.capacity.HeadOrTailCapacityStrategy;
import org.jlib.container.capacity.InitialCapacityStrategy;
import org.jlib.container.capacity.InvalidPartialCapacityException;
import org.jlib.container.capacity.SplitCapacityStrategy;

public class MinimalCapacityStrategy<Item>
extends AbstractCapacityStrategy<Item>
implements CapacityStrategy {

    private final InitialCapacityStrategy initialCapacityStrategy;

    private final HeadOrTailCapacityStrategy headCapacityStrategy;

    private final SplitCapacityStrategy splitCapacityStrategy;

    private final HeadOrTailCapacityStrategy tailCapacityStrategy;

    public MinimalCapacityStrategy(final LinearIndexStorage<Item> storage,
                                   final IndexRange contentIndexRange) {
        super(storage, contentIndexRange);

        initialCapacityStrategy = new MinimalInitialCapacityStrategy<>(storage, contentIndexRange);
        headCapacityStrategy = new MinimalHeadCapacityStrategy<>(storage, contentIndexRange);
        splitCapacityStrategy = new MinimalSplitCapacityStrategy<>(storage, contentIndexRange);
        tailCapacityStrategy = new MinimalTailCapacityStrategy<>(storage, contentIndexRange);
    }

    @Override
    public void initialize()
    throws InvalidIndexException {
        initialCapacityStrategy.ensureCapacity();
    }

    @Override
    public void ensureHeadCapacity(final int headCapacity)
    throws InvalidPartialCapacityException {
        headCapacityStrategy.ensureCapacity(headCapacity);
    }

    @Override
    public void ensureSplitCapacity(final int splitIndex, final int splitCapacity)
    throws InvalidIndexException, InvalidPartialCapacityException {
        splitCapacityStrategy.ensureCapacity(splitIndex, splitCapacity);
    }

    @Override
    public void ensureTailCapacity(final int tailCapacity)
    throws InvalidPartialCapacityException {
        tailCapacityStrategy.ensureCapacity(tailCapacity);
    }
}

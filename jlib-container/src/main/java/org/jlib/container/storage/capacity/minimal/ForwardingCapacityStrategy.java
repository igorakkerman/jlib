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

package org.jlib.container.storage.capacity.minimal;

import org.jlib.container.storage.capacity.CapacityStrategy;
import org.jlib.container.storage.capacity.HeadCapacityStrategy;
import org.jlib.container.storage.capacity.InitialCapacityStrategy;
import org.jlib.container.storage.capacity.InvalidCapacityException;
import org.jlib.container.storage.capacity.SplitCapacityStrategy;
import org.jlib.container.storage.capacity.TailCapacityStrategy;
import org.jlib.container.storage.InvalidIndexException;

public class ForwardingCapacityStrategy
implements CapacityStrategy {

    private InitialCapacityStrategy delegateInitialCapacityStrategy;
    private HeadCapacityStrategy delegateHeadCapacityStrategy;
    private SplitCapacityStrategy delegateSplitCapacityStrategy;
    private TailCapacityStrategy delegateTailCapacityStrategy;

    @Override
    public void initializeCapacity() {
        delegateInitialCapacityStrategy.initializeCapacity();
    }

    @Override
    public void ensureHeadCapacity(final int headCapacity)
    throws InvalidCapacityException {
        delegateHeadCapacityStrategy.ensureHeadCapacity(headCapacity);
    }

    @Override
    public void ensureSplitCapacity(final int splitIndex, final int splitCapacity)
    throws InvalidIndexException, InvalidCapacityException {
        delegateSplitCapacityStrategy.ensureSplitCapacity(splitIndex, splitCapacity);
    }

    @Override
    public void ensureTailCapacity(final int tailCapacity)
    throws InvalidCapacityException {
        delegateTailCapacityStrategy.ensureTailCapacity(tailCapacity);
    }

    public ForwardingCapacityStrategy with(final InitialCapacityStrategy delegateInitialCapacityStrategy) {
        this.delegateInitialCapacityStrategy = delegateInitialCapacityStrategy;
        return this;
    }

    public ForwardingCapacityStrategy with(final HeadCapacityStrategy delegateHeadCapacityStrategy) {
        this.delegateHeadCapacityStrategy = delegateHeadCapacityStrategy;
        return this;
    }

    public ForwardingCapacityStrategy with(final SplitCapacityStrategy delegateSplitCapacityStrategy) {
        this.delegateSplitCapacityStrategy = delegateSplitCapacityStrategy;
        return this;
    }

    public ForwardingCapacityStrategy with(final TailCapacityStrategy delegateTailCapacityStrategy) {
        this.delegateTailCapacityStrategy = delegateTailCapacityStrategy;
        return this;
    }
}

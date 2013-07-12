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

package org.jlib.core.storage.minimal;

import org.jlib.core.storage.ContentIndex;
import org.jlib.core.storage.LinearIndexStorage;
import org.jlib.core.storage.capacity.CapacityStrategy;
import org.jlib.core.storage.capacity.NegativeCapacityException;
import org.jlib.core.storage.capacity.SingleCapacityStrategy;
import org.jlib.core.storage.indexrangeoperation.IndexRangeOperationDescriptor;

/**
 * {@link SingleCapacityStrategy} providing just as much head capacity as needed.
 * </p>
 * <p>
 * Head capacity:
 * This {@link CapacityStrategy} analyzes the current head capacity to verify for the requested capacity.
 * If the requested head capacity is above the available head capacity,
 * the {@link LinearIndexStorage} is requested to re-allocate a capacity higher by the difference between requested and
 * available head capacity. The {@link Item}s are shifted "right" to have exactly the requested head capacity.
 * The {@link LinearIndexStorage} is always requested to provide an additional capacity even if its tail capacity would
 * be sufficient.
 *
 * @param <Item>
 *        type of the items held in the {@link LinearIndexStorage}
 *
 * @author Igor Akkerman
 */
public class MinimalHeadCapacityStrategy<Item>
extends AbstractSingleCapacityStrategy<Item>
implements SingleCapacityStrategy {

    public MinimalHeadCapacityStrategy(final LinearIndexStorage storage, final ContentIndex contentIndex) {
        super(storage, contentIndex);
    }

    @Override
    public void ensureCapacity(final int capacity)
    throws NegativeCapacityException {

        ensurePartialCapacityValid("headCapacity", newHeadCapacity);

        if (isCurrentHeadCapacitySufficientFor(newHeadCapacity))
            return;

        final int missingHeadCapacity = newHeadCapacity - contentIndexHolder.getFirstItemIndex();

        final IndexRangeOperationDescriptor shiftAllItemsToAllowHeadCapacity = /*
         */ getCopyAllItemsToNewIndexDescriptor(newHeadCapacity);

        storage.ensureCapacityAndShiftItems(storage.getCapacity() + missingHeadCapacity,
                                            shiftAllItemsToAllowHeadCapacity);
    }
}

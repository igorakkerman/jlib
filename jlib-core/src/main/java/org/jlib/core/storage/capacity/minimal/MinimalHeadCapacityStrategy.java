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

package org.jlib.core.storage.capacity.minimal;

import org.jlib.core.storage.ContentIndexRegistry;
import org.jlib.core.storage.LinearIndexStorage;
import org.jlib.core.storage.capacity.AbstractHeadOrTailCapacityStrategy;
import org.jlib.core.storage.capacity.HeadOrTailCapacityStrategy;
import org.jlib.core.storage.indexrangeoperation.IndexRangeOperationDescriptor;

/**
 * {@link HeadOrTailCapacityStrategy} providing just as much head capacity as needed.
 * </p>
 * <p>
 * The {@link MinimalHeadCapacityStrategy} analyzes the current head capacity to verify for the requested capacity.
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
extends AbstractHeadOrTailCapacityStrategy<Item>
implements HeadOrTailCapacityStrategy {

    public MinimalHeadCapacityStrategy(final LinearIndexStorage<Item> storage,
                                       final ContentIndexRegistry contentIndexRegistry) {
        super(storage, contentIndexRegistry);
    }

    @Override
    protected void safeEnsureCapacity(final int headCapacity) {
        final int missingHeadCapacity = headCapacity - getContentIndexRegistry().getFirstItemIndex();

        if (missingHeadCapacity <= 0)
            return;

        final IndexRangeOperationDescriptor shiftAllItemsToAllowHeadCapacity = /*
         */ getDescriptorCopyAllItemsToIndex(/* new first Item index */ headCapacity);

        getStorage().addCapacityAndShiftItems(headCapacity, shiftAllItemsToAllowHeadCapacity);

        getContentIndexRegistry().incrementFirstItemIndex(missingHeadCapacity);
    }
}

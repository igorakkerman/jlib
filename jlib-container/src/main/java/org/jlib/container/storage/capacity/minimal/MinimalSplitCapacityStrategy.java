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

import org.jlib.container.storage.capacity.AbstractSplitCapacityStrategy;
import org.jlib.container.storage.IndexRange;
import org.jlib.container.storage.IndexRangeOperationDescriptor;
import org.jlib.container.storage.LinearIndexStorage;

public class MinimalSplitCapacityStrategy
extends AbstractSplitCapacityStrategy {

    public MinimalSplitCapacityStrategy(final LinearIndexStorage<?> storage, final IndexRange contentIndexRange) {
        super(storage, contentIndexRange);
    }

    @Override
    protected void safeEnsureSplitCapacity(final int splitIndex, final int splitCapacity) {
        final IndexRangeOperationDescriptor shiftRightPartFromSplitIndexRightBySplitCapacity = /*
         */ new IndexRangeOperationDescriptor(splitIndex, getContentIndexRange().getMaximum(),
                                              splitIndex + splitCapacity);

        final int missingTailCapacity = splitCapacity - getTailCapacity();

        if (missingTailCapacity <= 0) {
            getStorage().shiftItems(shiftRightPartFromSplitIndexRightBySplitCapacity);
            return;
        }

        final int finalItemsCount = getContentIndexRange().itemsCount() + splitCapacity;

        final IndexRangeOperationDescriptor headCopyDescriptor = /*
         */ new IndexRangeOperationDescriptor(getContentIndexRange().getMinimum(), splitIndex - 1, splitIndex);

        final IndexRangeOperationDescriptor[] copyDescriptors = /*
         */ splitIndex > getContentIndexRange().getMinimum() ?
            new IndexRangeOperationDescriptor[]{ headCopyDescriptor,
                                                 shiftRightPartFromSplitIndexRightBySplitCapacity } :
            new IndexRangeOperationDescriptor[]{ shiftRightPartFromSplitIndexRightBySplitCapacity };

        getStorage().ensureCapacityAndShiftItems(finalItemsCount, copyDescriptors);
    }
}

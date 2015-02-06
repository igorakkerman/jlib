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

import org.jlib.container.storage.ContentIndexRegistry;
import org.jlib.container.storage.LinearIndexStorage;
import org.jlib.container.capacity.AbstractSplitCapacityStrategy;
import org.jlib.container.storage.IndexRangeOperationDescriptor;

public class MinimalSplitCapacityStrategy<Item>
extends AbstractSplitCapacityStrategy<Item> {

    public MinimalSplitCapacityStrategy(final LinearIndexStorage<Item> storage,
                                        final ContentIndexRegistry contentIndexRegistry) {
        super(storage, contentIndexRegistry);
    }

    @Override
    protected void safeEnsureCapacity(final int splitIndex, final int splitCapacity) {
        final IndexRangeOperationDescriptor shiftRightPartFromSplitIndexRightBySplitCapacity = /*
         */ new IndexRangeOperationDescriptor(splitIndex, getContentIndexRegistry().getLastItemIndex(),
                                              splitIndex + splitCapacity);

        final int missingTailCapacity = splitCapacity - getTailCapacity();

        if (missingTailCapacity <= 0) {
            getStorage().shiftItems(shiftRightPartFromSplitIndexRightBySplitCapacity);
            return;
        }

        final int fullCapacity = getContentIndexRegistry().getItemsCount() + splitCapacity;

        // TODO: is leftCopyDescriptor an adequate name? tried to find a name without analyzing
        final IndexRangeOperationDescriptor leftCopyDescriptor = /*
         */ new IndexRangeOperationDescriptor(getContentIndexRegistry().getFirstItemIndex(), splitIndex - 1,
                                              splitIndex);

        final IndexRangeOperationDescriptor[] copyDescriptors = /*
         */ splitIndex > getContentIndexRegistry().getFirstItemIndex() ?
            new IndexRangeOperationDescriptor[]{ leftCopyDescriptor,
                                                 shiftRightPartFromSplitIndexRightBySplitCapacity } :
            new IndexRangeOperationDescriptor[]{ shiftRightPartFromSplitIndexRightBySplitCapacity };

        // FIXME: not fullCapacity
        getStorage().addCapacityAndShiftItems(fullCapacity, copyDescriptors);
    }
}

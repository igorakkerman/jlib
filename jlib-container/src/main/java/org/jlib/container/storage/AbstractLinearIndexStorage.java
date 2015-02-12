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

package org.jlib.container.storage;

import org.jlib.core.exception.UnexpectedStateException;

import static org.jlib.core.message.MessageUtility.mfmessage;

public abstract class AbstractLinearIndexStorage<Item>
implements LinearIndexStorage<Item> {

    protected AbstractLinearIndexStorage(final int initialCapacity)
    throws InvalidStorageCapacityException {
        ensureCapacityValid("initialCapacity", initialCapacity);
    }

    @Override
    public Item get(final int index)
    throws InvalidStorageIndexException {
        ensureIndexValid("index", index);

        return safeGet(index);
    }

    protected abstract Item safeGet(int index);

    @Override
    public void set(final int index, final Item item)
    throws InvalidStorageIndexException {
        ensureIndexValid("index", index);

        safeSet(index, item);
    }

    protected abstract void safeSet(int index, Item item);

    @Override
    public void ensureCapacityAndShiftItems(final int additionalCapacity,
                                            final IndexRangeOperationDescriptor... copyDescriptors) {
        ensureAdditionalCapacityValid(additionalCapacity);

        safeAddCapacityAndShiftItems(additionalCapacity, copyDescriptors);
    }

    private void ensureAdditionalCapacityValid(final int additionalCapacity)
    throws InvalidAdditionalCapacityException {
        if (additionalCapacity < 0)
            throw new InvalidAdditionalCapacityException(this, additionalCapacity);
    }

    protected abstract void safeAddCapacityAndShiftItems(int capacity,
                                                         IndexRangeOperationDescriptor... copyDescriptors);

    protected void ensureCapacityValid(final String capacityName, final int capacity)
    throws InvalidStorageCapacityException {
        if (capacity < 0)
            throw new InvalidStorageCapacityException(this, capacityName, capacity);
    }

    protected void ensureIndexValid(final String indexName, final int index) {
        if (index < 0)
            throw new InvalidStorageIndexException(this, mfmessage("{0} = {1} < 0", indexName, index));

        if (index > capacity() - 1)
            throw new InvalidStorageIndexException(this, mfmessage("{0} = {1} > {2} = capacity - 1", indexName, index,
                                                            capacity() - 1));
    }

    protected void ensureSourceIndexRangeValid(final int beginIndex, final int endIndex) {
        ensureIndexValid("sourceBeginIndex", beginIndex);
        ensureIndexValid("sourceEndIndex", endIndex);

        if (endIndex < beginIndex)
            throw new InvalidStorageIndexException(this, mfmessage("sourceEndIndex = {0} < {1} = sourceBeginIndex", endIndex,
                                                            beginIndex));
    }

    protected void ensureOperationDescriptorValid(final IndexRangeOperationDescriptor copyDescriptor) {
        ensureSourceIndexRangeValid(copyDescriptor.getSourceRange().getMinimum(),
                                    copyDescriptor.getSourceRange().getMaximum());

        ensureIndexValid("targetIndex", copyDescriptor.getTargetIndex());
    }

    @Override
    @SuppressWarnings("unchecked")
    public AbstractLinearIndexStorage<Item> clone() {
        try {
            return (AbstractLinearIndexStorage<Item>) super.clone();
        }
        catch (final CloneNotSupportedException exception) {
            throw new UnexpectedStateException(exception);
        }
    }
}

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

    /**
     * Creates a new {@link AbstractLinearIndexStorage} with the specified initial capacity.
     *
     * @param initialCapacity
     *        integer specifying the initial capacity
     */
    protected AbstractLinearIndexStorage(final int initialCapacity)
    throws InvalidCapacityException {
        ensureCapacityValid("initialCapacity", initialCapacity);
    }

    @Override
    public Item get(final int index)
    throws InvalidIndexException {

        ensureIndexValid("index", index);

        return safeGet(index);
    }

    protected abstract Item safeGet(int index);

    @Override
    public void set(final int index, final Item item)
    throws InvalidIndexException {

        ensureIndexValid("index", index);

        safeSet(index, item);
    }

    protected abstract void safeSet(int index, Item item);

    @Override
    public void addCapacityAndShiftItems(final int additionalCapacity,
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
    throws InvalidCapacityException {
        if (capacity < 0)
            throw new InvalidCapacityException(this, capacityName, capacity);
    }

    // TODO: add note: ensureIndexValid/ensurePartialCapacityValid methods here have a different meaning than in the
    // strategy!!!!
    // TODO: Here, they mean wrong access to the delegate, there, they may mean: wrong item index. maybe separate the
    // exceptions for clarity?
    protected void ensureIndexValid(final String indexName, final int index) {
        if (index < 0)
            throw new InvalidIndexException(this, mfmessage("{0} = {1} < 0", indexName, index));

        if (index > capacity() - 1)
            throw new InvalidIndexException(this, mfmessage("{0} = {1} > {2} = capacity - 1", indexName, index,
                                                            capacity() - 1));
    }

    protected void ensureIndexRangeValid(final String beginIndexName, final int beginIndex, final String endIndexName,
                                         final int endIndex) {
        ensureIndexValid(beginIndexName, beginIndex);
        ensureIndexValid(endIndexName, endIndex);

        if (endIndex < beginIndex)
            throw new InvalidIndexException(this, mfmessage("{0} = {1} < {2} = {3}", endIndexName, endIndex, beginIndex,
                                                            beginIndexName));
    }

    protected void validateOperationDescriptor(final IndexRangeOperationDescriptor copyDescriptor) {
        ensureIndexRangeValid("sourceBeginIndex", copyDescriptor.getSourceRange().getMinimum(),
                              "sourceEndIndex", copyDescriptor.getSourceRange().getMaximum());

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

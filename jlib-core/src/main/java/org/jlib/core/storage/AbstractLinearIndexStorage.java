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

package org.jlib.core.storage;

import java.lang.reflect.InvocationTargetException;

import org.jlib.core.language.TypedCloneable;
import org.jlib.core.language.exception.UnexpectedStateException;
import org.jlib.core.storage.indexrangeoperation.IndexRangeOperationDescriptor;

import org.apache.commons.beanutils.BeanUtils;
import static org.jlib.core.text.ParametrizedMessageUtility.messageMf;

public abstract class AbstractLinearIndexStorage<Item>
extends TypedCloneable<AbstractLinearIndexStorage<Item>>
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
    public Item getItem(final int index)
    throws InvalidIndexException {

        ensureIndexValid("index", index);

        return safeGetItem(index);
    }

    protected abstract Item safeGetItem(int index);

    @Override
    public void replaceItem(final int index, final Item item)
    throws InvalidIndexException {

        ensureIndexValid("index", index);

        safeReplaceItem(index, item);
    }

    protected abstract void safeReplaceItem(int index, Item item);

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

    /**
     * Ensures the specified capacity is valid.
     *
     * @param capacity
     *        integer specifying a capacity
     *
     * @throws InvalidCapacityException
     *         if {@code capacity < 0}
     */
    protected void ensureCapacityValid(final String capacityName, final int capacity)
    throws InvalidCapacityException {
        if (capacity < 0)
            throw new InvalidCapacityException(this, capacityName, capacity);
    }

    protected void ensureIndexValid(final String indexName, final int index) {
        if (index < 0)
            throw new InvalidIndexException(this, messageMf("{0} = {1} < 0", indexName, index));

        if (index > getCapacity() - 1)
            throw new InvalidIndexException(this, messageMf("{0} = {1} > {2} = capacity - 1", indexName, index,
                                                            getCapacity()));
    }

    protected void ensureIndexRangeValid(final String beginIndexName, final int beginIndex, final String endIndexName,
                                         final int endIndex) {
        ensureIndexValid(beginIndexName, beginIndex);
        ensureIndexValid(endIndexName, endIndex);

        if (endIndex < beginIndex)
            throw new InvalidIndexException(this, messageMf("{0} = {1} < {2} = {3}", endIndexName, endIndex, beginIndex,
                                                            beginIndexName));
    }

    protected void validateOperationDescriptor(final IndexRangeOperationDescriptor copyDescriptor) {
        ensureIndexRangeValid("sourceBeginIndex", copyDescriptor.getSourceBeginIndex(), "sourceEndIndex",
                              copyDescriptor.getSourceEndIndex());

        ensureIndexValid("targetIndex", copyDescriptor.getTargetIndex());
    }

    @Override
    public AbstractLinearIndexStorage<Item> clone() {
        // TODO: replace by more general strategy
        try {
            final AbstractLinearIndexStorage<Item> cloneTarget = super.clone();

            BeanUtils.copyProperties(cloneTarget, this);

            return cloneTarget;
        }
        catch (IllegalAccessException | InvocationTargetException exception) {
            throw new UnexpectedStateException(exception);
        }
    }
}

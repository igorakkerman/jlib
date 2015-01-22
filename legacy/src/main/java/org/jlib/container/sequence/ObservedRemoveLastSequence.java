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

package org.jlib.container.operation.sequence;

import org.jlib.operator.observer.ValueObserver;

import org.jlib.container.operation.SoleItemNotRemoveableException;

/**
 * {@link Sequence} allowing its tail Item to be removed.
 *
 * @param <Item>
 *        type of the items held in the {@link Sequence}
 *
 * @author Igor Akkerman
 */
public interface ObservedRemoveLastSequence<Item>
extends RemoveLastSequence<Item> {

    /**
     * Removes the last Item of this {@link RemoveFirstSequence}.
     *
     * @param observers
     *        comma separated sequence of {@link ValueObserver} instances
     *        attending the removal
     *
     * @throws SoleItemNotRemoveableException
     *         if this {@link ObservedRemoveLastSequence} containsItem only one Item
     *         and may not be empty
     */
    @SuppressWarnings("unchecked")
    public void removeLastItem(ValueObserver<Item>... observers)
    throws SoleItemNotRemoveableException;
}

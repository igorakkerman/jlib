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

package org.jlib.container.operation;

import org.jlib.operator.observer.ValueObserver;

/**
 * Ability to remove <em>all</em> Items;
 * the {@link #removeAll} operation can be attended by {@link ValueObserver} instances.
 *
 * @param <Item>
 *        type of items held in the container
 *
 * @author Igor Akkerman
 */
public interface ObservedRemoveAll<Item> {

    /**
     * Removes all Items from this {@link Object}.
     *
     * @param observers
     *        comma separated sequence of {@link ValueObserver} instances
     *        attending the removal
     *
     * @throws InvalidContainerStateException
     *         if an error occurs during the operation
     */
    @SuppressWarnings("unchecked")
    void removeAll(ValueObserver<Item>... observers)
    throws InvalidContainerStateException;
}

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

package org.jlib.container.iterator;

import java.util.Iterator;

import org.jlib.core.iterator.BidiIterable;
import org.jlib.core.iterator.InvalidIterableStateException;
import org.jlib.core.iterator.RemoveIterable;
import org.jlib.core.iterator.RemoveIterator;
import org.jlib.core.iterator.SingletonIterable;

import org.jlib.operator.observer.ValueObserver;

/**
 * {@link Iterator} utility.
 *
 * @author Igor Akkerman
 */
public final class IterableUtility {

    /**
     * Removes all Items of the specified {@link RemoveIterable}.
     *
     * @param iterable
     *        {@link RemoveIterable} providing the Items
     *
     * @param <Item>
     *        type of the items of {@code iterable}
     *
     * @throws InvalidIterableStateException
     *         if an error occurs during one of the remove operations
     */
    public static <Item> void removeAll(final RemoveIterable<Item> iterable)
    throws InvalidIterableStateException {
        for (final RemoveIterator<Item> iterator = iterable.iterator(); iterator.hasNext(); ) {
            iterator.next();
            iterator.remove();
        }
    }

    /**
     * Removes all Items of the specified {@link RemoveIterable}.
     *
     * @param iterable
     *        {@link RemoveIterable} providing the Items
     *
     * @param <Item>
     *        type of the items of {@code iterable}
     *
     * @param observers
     *        comma separated sequence of {@link ValueObserver} instances
     *        attending the removal
     *
     * @throws InvalidIterableStateException
     *         if an error occurs during one of the remove operations
     */
    @SafeVarargs
    public static <Item> void removeAll(final ObservedRemoveIterable<Item> iterable,
                                        final ValueObserver<Item>... observers)
    throws InvalidIterableStateException {
        for (final ObservedRemoveIterator<Item> iterator = iterable.iterator(); iterator.hasNext(); ) {
            iterator.next();
            iterator.remove(observers);
        }
    }

    public static <Item> BidiIterable<Item> singletonIterable(final Item item) {
        return new SingletonIterable<>(item);
    }

    private IterableUtility() {}
}

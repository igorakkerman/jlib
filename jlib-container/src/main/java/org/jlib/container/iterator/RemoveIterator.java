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

import org.jlib.core.iterator.InvalidIterableStateException;

/**
 * {@link Iterator} allowing returned Items to be removed.
 *
 * @param <Item>
 *        type of the traversed items
 *
 * @author Igor Akkerman
 */
public interface RemoveIterator<Item>
extends Iterator<Item> {

    /**
     * Removes the last Item returned by this {@link RemoveIterator}.
     *
     * @throws NoItemToRemoveException
     *         if not called immediately after a call to {@link Iterator#next()}
     *         or a similar method
     *
     * @throws InvalidIterableStateException
     *         if an error was caused by a delegate used to remove the item
     */
    @Override
    @SuppressWarnings("DuplicateThrows")
    void remove()
    throws NoItemToRemoveException, InvalidIterableStateException;
}

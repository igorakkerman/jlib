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

import org.jlib.iterator.RemoveIterable;

/**
 * Object providing  allowing Items to be removed.
 *
 * @param <Item>
 *        type of the traversed items
 *
 * @author Igor Akkerman
 */
public interface ReplaceRemoveIterable<Item>
extends ReplaceIterable<Item>,
        RemoveIterable<Item> {

    /**
     * Returns a new {@link ReplaceRemoveIterator} over the Items of this {@link ReplaceRemoveIterable}.
     *
     * @return newly created {@link ReplaceRemoveIterator}
     */
    @Override
    ReplaceRemoveIterator<Item> iterator();
}

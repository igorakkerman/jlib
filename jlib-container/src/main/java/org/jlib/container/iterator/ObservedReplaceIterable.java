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

/**
 * Object providing a {@link ObservedReplaceIterable} over its Items.
 *
 * @param <Item>
 *        type of the traversed Items
 *
 * @author Igor Akkerman
 */
public interface ObservedReplaceIterable<Item>
extends ReplaceIterable<Item> {

    /**
     * Returns a new {@link ObservedReplaceIterator} over the Items of this {@link ObservedReplaceIterable}.
     *
     * @return newly created {@link ObservedReplaceIterator}
     */
    @Override
    ObservedReplaceIterator<Item> iterator();
}

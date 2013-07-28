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

package org.jlib.container;

import org.jlib.core.language.ItemOperationStrategy;

public interface ToArray<Item>
extends ItemOperationStrategy<Item> {

    /**
     * Returns an array containing all of the Items of this {@link TraversableContainer} in
     * the proper order as returned by this {@link TraversableContainer}'s Traverser.
     *
     * @return array containing all of the Items of this {@link TraversableContainer}
     *
     * @throws InvalidContainerStateException
     *         if an error occurs during the operation
     */
    public Item[] toArray()
    throws InvalidContainerStateException;
}

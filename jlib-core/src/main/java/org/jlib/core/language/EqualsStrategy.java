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

package org.jlib.core.language;

public interface EqualsStrategy<Item> {

    /**
     * <p>
     * Verifies whether this {@link TraversableContainer} is equal to the specified {@link Object}. This is true if all of the
     * following conditions are satisfied:
     * </p>
     * <ul>
     * <li>this {@link TraversableContainer} and the specified {@link Object} are instances of the same class</li>
     * <li>this {@link TraversableContainer} and the specified {@link ItemOperationStrategy} contain equal {@link Item}s, as verified by
     * {@link #containsEqualItems(TraversableContainer)}</li>
     * <li>this {@link TraversableContainer} and the specified {@link ItemOperationStrategy} contain equal metadata, as verified by
     * {@link #containsEqualItems(TraversableContainer)}</li>
     * </ul>
     *
     * @param otherObject
     *        Object to compare to this TraversableContainer
     *
     * @return {@code true} if all of the conditions stated above are satisfied;
     *         {@code false} otherwise
     */
    public boolean areEqual(Item thisItem, Object Object);
}

/*******************************************************************************
 *
 *    jlib - Open Source Java Library
 *
 *    www.jlib.org
 *
 *
 *    Copyright 2012 Igor Akkerman
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 *
 ******************************************************************************/

package org.jlib.core.array;

import org.jlib.core.traverser.TwoWayTraverser;
import org.jlib.core.traverser.TwoWayTraversible;

/**
 * Wrapper for an items allowing it to be used as {@link TwoWayTraversible}.
 *
 * @param <Item>
 *        type of the items held in the arrays
 *
 * @author Igor Akkerman
 */
public class ArrayTraversible<Item>
implements TwoWayTraversible<Item> {

    /** Items to traverse */
    private final Item[] items;

    /**
     * Creates a new {@link ArrayTraversible} for the specified Items.
     *
     * @param items
     *        array of Items to traverse
     */
    public ArrayTraversible(final Item[] items) {
        this.items = items;
    }

    @Override
    public TwoWayTraverser<Item> createTraverser() {
        return new ArrayTraverser<>(items);
    }
}

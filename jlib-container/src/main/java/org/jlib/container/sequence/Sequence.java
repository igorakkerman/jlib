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

package org.jlib.container.sequence;

import org.jlib.container.Container;
import org.jlib.core.traverser.TwoWayTraversable;

/**
 * Ordered sequence of Items.
 *
 * @param <Item>
 *        type of items held in the {@link Sequence}
 *
 * @author Igor Akkerman
 */
public interface Sequence<Item>
extends Container<Item>,
        TwoWayTraversable<Item> {

    /**
     * Returns a {@link SequenceTraverser} traversing the Items of this Sequence
     * in the correct order.
     *
     * @return {@link SequenceTraverser} over the Items of this Sequence
     */
    @Override
    public SequenceTraverser<Item> createTraverser();
}

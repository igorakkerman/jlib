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

import org.jlib.container.ReplaceContainer;
import org.jlib.core.traverser.TwoWayTraverser;

/**
 * {@link Sequence} allowing its Items to be modified using an
 * {@link ReplaceSequenceTraverser}.
 *
 * @param <Item>
 *        type of items held in the {@link Sequence}
 *
 * @author Igor Akkerman
 */
public interface ReplaceSequence<Item>
extends ReplaceContainer<Item>, Sequence<Item> {

    /**
     * <p>
     * Returns an ReplaceSequenceTraverser traversing the Items of this Sequence
     * in proper order.
     * </p>
     * <p>
     * The {@link ReplaceSequenceTraverser#replace(Object)} method of the
     * {@link TwoWayTraverser} can be used to modify Items in this Sequence.
     * </p>
     *
     * @return ReplaceSequenceTraverser traversing the Items of this Sequence in
     *         proper order
     */
    @Override
    public ReplaceSequenceTraverser<Item> createTraverser();
}

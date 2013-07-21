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

import org.jlib.core.traverser.Traversible;
import org.jlib.core.traverser.TraversibleUtility;
import org.jlib.core.traverser.TwoWayTraversible;
import org.jlib.core.value.Accessible;
import org.jlib.core.value.Initialized;

/**
 * {@link Sequence} representing the concatenation of other {@link Sequence}
 * instances.
 *
 * @param <Item>
 *        type of items held in the {@link ConcatenatedSequence}
 *
 * @author Igor Akkerman
 */
public class ConcatenatedSequence<Item>
extends AbstractSequence<Item> {

    /** array of concatenated {@link TwoWayTraversible} items */
    private TwoWayTraversible<Item>[] traversibles;

    /** total number of {@link Sequence} Items */
    private Accessible<Integer> itemsCountHolder = new Accessible<Integer>() {

        @Override
        public Integer getValue() {
            final int itemsCount = TraversibleUtility.getItemsCount(traversibles);

            itemsCountHolder = new Initialized<>(itemsCount);

            return itemsCount;
        }
    };

    /**
     * Creates a new {@link ConcatenatedSequence}.
     *
     * @param traversibles
     *        comma separated sequence of concatenated {@link TwoWayTraversible}
     *        items
     */
    @SafeVarargs
    public ConcatenatedSequence(final TwoWayTraversible<Item>... traversibles) {
        super();

        this.traversibles = traversibles;
    }

    @Override
    public final int getItemsCount()
    throws InvalidNamedObjectStateException {
        return itemsCountHolder.getValue();
    }

    @Override
    public SequenceTraverser<Item> createTraverser() {
        return new ConcatenatedSequenceTraverser<>(this);
    }

    /**
     * Returns the {@link Traversible} items.
     *
     * @return array of {@link TwoWayTraversible} instances
     */
    public TwoWayTraversible<Item>[] getTraversibles() {
        return traversibles;
    }

    @Override
    @SuppressWarnings("unchecked")
    public ConcatenatedSequence clone() {
        final ConcatenatedSequence clone = (ConcatenatedSequence) super.clone();

        clone.traversibles = traversibles.clone();

        return clone;
    }
}

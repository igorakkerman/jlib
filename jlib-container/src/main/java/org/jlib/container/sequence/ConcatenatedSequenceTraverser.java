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

import org.jlib.core.array.ArrayUtility;
import org.jlib.core.traverser.TwoWayTraverser;
import org.jlib.core.traverser.TwoWayTraversible;

/**
 * {@link TwoWayTraverser} over the Items of a
 * {@link ConcatenatedSequence}.
 *
 * @param <Item>
 *        type of the items held in the {@link Sequence} instances
 *
 * @param <Sequenze>
 *        concrete type of the {@link ConcatenatedSequence}
 *
 * @author Igor Akkerman
 */
public class ConcatenatedSequenceTraverser<Item, Sequenze extends ConcatenatedSequence<Item>>
extends AbstractSequenceTraverser<Item, Sequenze> {

    /**
     * {@link TwoWayTraverser} of the concatenated
     * {@link TwoWayTraversible} instances
     */
    private final TwoWayTraverser<TwoWayTraversible<Item>> traversiblesTraverser;

    /**
     * {@link TwoWayTraverser} over the current
     * {@link TwoWayTraversible}
     */
    private TwoWayTraverser<Item> currentTraversibleTraverser;

    /**
     * Creates a new {@link ConcatenatedSequenceTraverser}.
     *
     * @param concatenatedSequence
     *        {@link Sequence} of concatenated {@link Sequence} instances;
     *        {@code concatenatedSequence} may be empty
     */
    public ConcatenatedSequenceTraverser(final Sequenze concatenatedSequence) {
        super(concatenatedSequence);

        traversiblesTraverser = ArrayUtility.createTraverser(concatenatedSequence.getTraversibles());

        currentTraversibleTraverser = traversiblesTraverser.isNextItemAccessible()
                                      ? traversiblesTraverser.getNextItem().createTraverser()
                                      : EmptySequenceTraverser.<Item>getInstance();
    }

    @Override
    public boolean isPreviousItemAccessible() {
        while (! currentTraversibleTraverser.isPreviousItemAccessible()) {
            if (! traversiblesTraverser.isPreviousItemAccessible())
                return false;

            currentTraversibleTraverser = traversiblesTraverser.getPreviousItem().createTraverser();

            // navigate to the tail of the previous Sequence
            while (currentTraversibleTraverser.isNextItemAccessible())
                currentTraversibleTraverser.getNextItem();
        }

        return true;
    }

    @Override
    public Item getPreviousItem()
    throws NoPreviousSequenceItemException {
        if (! isPreviousItemAccessible())
            throw new NoPreviousSequenceItemException(getSequence());

        return currentTraversibleTraverser.getPreviousItem();
    }

    @Override
    public boolean isNextItemAccessible() {
        while (! currentTraversibleTraverser.isNextItemAccessible()) {
            if (! traversiblesTraverser.isNextItemAccessible())
                return false;

            currentTraversibleTraverser = traversiblesTraverser.getNextItem().createTraverser();
        }

        return true;
    }

    @Override
    public Item getNextItem()
    throws NoNextSequenceItemException {
        if (! isNextItemAccessible())
            throw new NoPreviousSequenceItemException(getSequence());

        return currentTraversibleTraverser.getPreviousItem();
    }
}

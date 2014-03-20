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

package org.jlib.container.operation.sequence;

import org.jlib.core.traverser.TwoWayTraverser;

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
/*extends AbstractSequenceTraverser<Item, Sequenze> */{

//    /**
//     * {@link TwoWayTraverser} of the concatenated
//     * {@link TwoWayTraversable} instances
//     */
//    private final TwoWayTraverser<TwoWayTraversable<Item>> traversablesTraverser;
//
//    /**
//     * {@link TwoWayTraverser} over the current
//     * {@link TwoWayTraversable}
//     */
//    private TwoWayTraverser<Item> currentTraversableTraverser;
//
//    /**
//     * Creates a new {@link ConcatenatedSequenceTraverser}.
//     *
//     * @param concatenatedSequence
//     *        {@link Sequence} of concatenated {@link Sequence} instances;
//     *        {@code concatenatedSequence} may be empty
//     */
//    public ConcatenatedSequenceTraverser(final Sequenze concatenatedSequence) {
//        super(concatenatedSequence);
//
////        traversablesTraverser = ArrayUtility.createTraverser(concatenatedSequence.getTraversables());
//
////        currentTraversableTraverser = traversablesTraverser.hasNextItem()
////                                      ? traversablesTraverser.getNextItem().createTraverser()
////                                      : EmptySequenceTraverser.<Item>getInstance();
//    }
//
//    @Override
//    public boolean hasPreviousItem() {
//        while (! currentTraversableTraverser.hasPreviousItem()) {
//            if (! traversablesTraverser.hasPreviousItem())
//                return false;
//
//            currentTraversableTraverser = traversablesTraverser.getPreviousItem().createTraverser();
//
//            // navigate to the tail of the previous Sequence
//            while (currentTraversableTraverser.hasNextItem())
//                currentTraversableTraverser.getNextItem();
//        }
//
//        return true;
//    }
//
//    @Override
//    public Item getPreviousItem()
//    throws NoPreviousSequenceItemException {
////        if (! hasPreviousItem())
////            throw new NoPreviousSequenceItemException(getSequence());
//
//        return currentTraversableTraverser.getPreviousItem();
//    }
//
//    @Override
//    public boolean hasNextItem() {
//        while (! currentTraversableTraverser.hasNextItem()) {
//            if (! traversablesTraverser.hasNextItem())
//                return false;
//
//            currentTraversableTraverser = traversablesTraverser.getNextItem().createTraverser();
//        }
//
//        return true;
//    }
//
//    @Override
//    public Item getNextItem()
//    throws NoNextSequenceItemException {
//        if (! hasNextItem())
//            throw new NoPreviousSequenceItemException(getSequence());
//
//        return currentTraversableTraverser.getPreviousItem();
//    }
}

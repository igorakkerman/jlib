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

import org.jlib.core.iterator.TwoWayIterator;

/**
 * {@link TwoWayIterator} over the Items of a
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
public class ConcatenatedSequenceIterator<Item, Sequenze extends ConcatenatedSequence<Item>>
/*extends AbstractSequenceIterator<Item, Sequenze> */{

//    /**
//     * {@link TwoWayIterator} of the concatenated
//     * {@link TwoWayIterable} instances
//     */
//    private final TwoWayIterator<TwoWayIterable<Item>> iterablesIterator;
//
//    /**
//     * {@link TwoWayIterator} over the current
//     * {@link TwoWayIterable}
//     */
//    private TwoWayIterator<Item> currentIterableIterator;
//
//    /**
//     * Creates a new {@link ConcatenatedSequenceIterator}.
//     *
//     * @param concatenatedSequence
//     *        {@link Sequence} of concatenated {@link Sequence} instances;
//     *        {@code concatenatedSequence} may be empty
//     */
//    public ConcatenatedSequenceIterator(final Sequenze concatenatedSequence) {
//        super(concatenatedSequence);
//
////        iterablesIterator = ArrayUtility.iterator(concatenatedSequence.getIterables());
//
////        currentIterableIterator = iterablesIterator.hasNext()
////                                      ? iterablesIterator.getNextItem().iterator()
////                                      : EmptySequenceIterator.<Item>getInstance();
//    }
//
//    @Override
//    public boolean hasPreviousItem() {
//        while (! currentIterableIterator.hasPreviousItem()) {
//            if (! iterablesIterator.hasPreviousItem())
//                return false;
//
//            currentIterableIterator = iterablesIterator.getPreviousItem().iterator();
//
//            // navigate to the tail of the previous Sequence
//            while (currentIterableIterator.hasNext())
//                currentIterableIterator.getNextItem();
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
//        return currentIterableIterator.getPreviousItem();
//    }
//
//    @Override
//    public boolean hasNext() {
//        while (! currentIterableIterator.hasNext()) {
//            if (! iterablesIterator.hasNext())
//                return false;
//
//            currentIterableIterator = iterablesIterator.getNextItem().iterator();
//        }
//
//        return true;
//    }
//
//    @Override
//    public Item getNextItem()
//    throws NoNextSequenceItemException {
//        if (! hasNext())
//            throw new NoPreviousSequenceItemException(getSequence());
//
//        return currentIterableIterator.getPreviousItem();
//    }
}

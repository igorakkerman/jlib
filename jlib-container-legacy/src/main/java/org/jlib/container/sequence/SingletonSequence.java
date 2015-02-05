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

/**
 * Sequence containing exactly one Item.
 *
 * @param <Item>
 *        type of the item held in the {@link Sequence}
 *
 * @author Igor Akkerman
 */
class SingletonSequence<Item>
/*extends AbstractNonEmptySequence<Item>*/ {

//    /** sole item of this {@link SingletonSequence} */
//    private final Item item;
//
//    /** current {@link SequenceIterator} state */
//    private SequenceIterator<Item> currentIteratorState;
//
//    /** {@link SequenceIterator} state at the {@link SingletonSequence} head */
//    private final SequenceIterator<Item> headIteratorState = new AbstractSequenceIterator<Item, SingletonSequence<Item>>(
//                                                                                                                           this) {
//
//        @Override
//        public boolean hasPreviousItem() {
//            return false;
//        }
//
//        @Override
//        public Item getPreviousItem()
//        throws NoPreviousSequenceItemException {
//            throw new NoPreviousSequenceItemException(getSequence());
//        }
//
//        @Override
//        public boolean hasNext() {
//            return true;
//        }
//
//        @Override
//        public Item next() {
//            currentIteratorState = tailIteratorState;
//
//            return item;
//        }
//    };
//
//    /** {@link SequenceIterator} state at the {@link SingletonSequence} tail */
//    private final SequenceIterator<Item> tailIteratorState = new AbstractSequenceIterator<Item, SingletonSequence<Item>>(
//                                                                                                                           this) {
//
//        @Override
//        public boolean hasPreviousItem() {
//            return true;
//        }
//
//        @Override
//        public Item getPreviousItem()
//        throws NoPreviousSequenceItemException {
//            currentIteratorState = headIteratorState;
//
//            return item;
//        }
//
//        @Override
//        public boolean hasNext() {
//            return false;
//        }
//
//        @Override
//        public Item next() {
//            throw new NoPreviousSequenceItemException(getSequence());
//        }
//    };
//
//    /**
//     * Creates a new {@link SingletonSequence} with the specified Item.
//     *
//     * @param item
//     *        sole Item in this {@link SingletonSequence}
//     */
//    public SingletonSequence(final Item item) {
//        this.item = item;
//    }
//
//    @Override
//    public SequenceIterator<Item> iterator() {
//        return new AbstractSequenceIterator<Item, SingletonSequence<Item>>(this) {
//
//            @Override
//            public boolean hasPreviousItem() {
//                return currentIteratorState.hasPreviousItem();
//            }
//
//            @Override
//            public Item getPreviousItem()
//            throws NoPreviousSequenceItemException {
//                return currentIteratorState.getPreviousItem();
//            }
//
//            @Override
//            public boolean hasNext() {
//                return currentIteratorState.hasNext();
//            }
//
//            @Override
//            public Item next()
//            throws NoNextSequenceItemException {
//                return currentIteratorState.next();
//            }
//        };
//    }
//
//    @Override
//    public int getCount() {
//        return 1;
//    }
//
////    @Override
////    public boolean containsItem(final Item item)
////    throws InvalidContainerArgumentException, InvalidContainerStateException {
////        return false;
////    }
////
////    @Override
////    public boolean containsItem(final IterableContainer<? extends Item> items)
////    throws InvalidContainerArgumentException, InvalidContainerStateException {
////        return false;
////    }
////
////    @Override
////    public boolean containsItem(final Collection<? extends Item> items)
////    throws InvalidContainerArgumentException, InvalidContainerStateException {
////        return false;
////    }
////
////    @Override
////    public boolean containsItem(final Item... items)
////    throws InvalidContainerArgumentException, InvalidContainerStateException {
////        return false;
////    }
//
//    @Override
//    public boolean containsEqualItems(final IterableContainer<Item> otherContainer) {
//        return false;
//    }
//
//    @Override
//    public Iterator<Item> iterator() {
//        return null;
//    }
}

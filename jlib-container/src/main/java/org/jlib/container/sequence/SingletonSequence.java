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
//    /** current {@link SequenceTraverser} state */
//    private SequenceTraverser<Item> currentTraverserState;
//
//    /** {@link SequenceTraverser} state at the {@link SingletonSequence} head */
//    private final SequenceTraverser<Item> headTraverserState = new AbstractSequenceTraverser<Item, SingletonSequence<Item>>(
//                                                                                                                           this) {
//
//        @Override
//        public boolean isPreviousItemAccessible() {
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
//        public boolean hasNextItem() {
//            return true;
//        }
//
//        @Override
//        public Item getNextItem() {
//            currentTraverserState = tailTraverserState;
//
//            return item;
//        }
//    };
//
//    /** {@link SequenceTraverser} state at the {@link SingletonSequence} tail */
//    private final SequenceTraverser<Item> tailTraverserState = new AbstractSequenceTraverser<Item, SingletonSequence<Item>>(
//                                                                                                                           this) {
//
//        @Override
//        public boolean isPreviousItemAccessible() {
//            return true;
//        }
//
//        @Override
//        public Item getPreviousItem()
//        throws NoPreviousSequenceItemException {
//            currentTraverserState = headTraverserState;
//
//            return item;
//        }
//
//        @Override
//        public boolean hasNextItem() {
//            return false;
//        }
//
//        @Override
//        public Item getNextItem() {
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
//    public SequenceTraverser<Item> createTraverser() {
//        return new AbstractSequenceTraverser<Item, SingletonSequence<Item>>(this) {
//
//            @Override
//            public boolean isPreviousItemAccessible() {
//                return currentTraverserState.isPreviousItemAccessible();
//            }
//
//            @Override
//            public Item getPreviousItem()
//            throws NoPreviousSequenceItemException {
//                return currentTraverserState.getPreviousItem();
//            }
//
//            @Override
//            public boolean hasNextItem() {
//                return currentTraverserState.hasNextItem();
//            }
//
//            @Override
//            public Item getNextItem()
//            throws NoNextSequenceItemException {
//                return currentTraverserState.getNextItem();
//            }
//        };
//    }
//
//    @Override
//    public int getItemsCount() {
//        return 1;
//    }
//
////    @Override
////    public boolean containsItem(final Item item)
////    throws InvalidTraversableArgumentException, InvalidTraversableStateException {
////        return false;
////    }
////
////    @Override
////    public boolean containsItem(final TraversableContainer<? extends Item> items)
////    throws InvalidTraversableArgumentException, InvalidTraversableStateException {
////        return false;
////    }
////
////    @Override
////    public boolean containsItem(final Collection<? extends Item> items)
////    throws InvalidTraversableArgumentException, InvalidTraversableStateException {
////        return false;
////    }
////
////    @Override
////    public boolean containsItem(final Item... items)
////    throws InvalidTraversableArgumentException, InvalidTraversableStateException {
////        return false;
////    }
//
//    @Override
//    public boolean containsEqualItems(final TraversableContainer<Item> otherContainer) {
//        return false;
//    }
//
//    @Override
//    public Iterator<Item> iterator() {
//        return null;
//    }
}

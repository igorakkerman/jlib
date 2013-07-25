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

package org.jlib.container.sequence.index;

/**
 * {@link ReplaceIndexSequence} view of the Items stored in another
 * {@link ReplaceIndexSequence} in the specified index range. The Items in this
 * {@link SubReplaceIndexSequence} will have the same index as they had in the
 * base {@link ReplaceIndexSequence}.
 *
 * @param <Item>
 *        type of the items held in the {@link SubReplaceIndexSequence}
 *
 * @param <BaseSequence>
 *        type of the base {@link ObservedReplaceIndexSequence}
 *
 * @author Igor Akkerman
 */
public class SubReplaceIndexSequence<Item, BaseSequence extends ReplaceIndexSequence<Item>>
/*implements ObservedReplaceIndexSequence<Item>,
           ContainsItem<Item> */{

//    /**
//     * Creates a new {@link SubReplaceIndexSequence}.
//     *
//     * @param baseSequence
//     *        BaseSequence of this {@link SubReplaceIndexSequence}
//     *
//     * @param firstIndex
//     *        integer specifying the index of the first Item
//     *
//     * @param lastIndex
//     *        integer specifying the index of the last Item
//     *
//     * @throws InvalidSequenceIndexException
//     *         if
//     *         {@code firstIndex < baseSequence.getFirstIndex() || lastIndex > baseSequence.getLastIndex()}
//     *
//     * @throws InvalidSequenceIndexException
//     *         if {@code firstIndex > lastIndex}
//     */
//    public SubReplaceIndexSequence(final BaseSequence baseSequence, final int firstIndex, final int lastIndex)
//    throws InvalidSequenceIndexException, InvalidSequenceIndexException {
////        super(baseSequence, firstIndex, lastIndex);
//    }
//
////    @Override
////    public InsertIndexSequence<Item> getSubsequenceView(final int fromIndex, final int toIndex)
////    throws InvalidSequenceIndexException, InvalidSequenceIndexException {
//////        return new SubReplaceIndexSequence<>(this, fromIndex, toIndex);
////    }
//
//    @Override
//    public void replace(final int index, final Item newItem)
//    throws InvalidSequenceIndexException, InvalidTraversableArgumentException, InvalidTraversableStateException {
//        IndexSequenceUtility.ensureIndexValid(this, index);
//
////        getBaseSequence().replace(index, newItem);
//    }
//
//    @Override
//    public Item get(final int index)
//    throws InvalidSequenceIndexException {
//        return null;
//    }
//
//    @Override
//    public int getFirstIndex() {
//        return 0;
//    }
//
//    @Override
//    public int getLastIndex() {
//        return 0;
//    }
//
//    @Override
//    public Item getFirstItem() {
//        return null;
//    }
//
//    @Override
//    public Item getLastItem() {
//        return null;
//    }
//
//    @Override
//    public int getItemIndex(final Item item)
//    throws NoSuchSequenceItemException {
//        return 0;
//    }
//
//    @Override
//    public int getLastItemIndex(final Item item)
//    throws NoSuchSequenceItemException {
//        return 0;
//    }
//
//    @Override
//    public ReplaceIndexSequence<Item> getSubsequenceView(final int fromIndex, final int toIndex)
//    throws InvalidSequenceIndexException {
//        return null;
//    }
//
//    @Override
//    @SuppressWarnings("unchecked")
//    public void replace(final int index, final Item newItem, final ValueObserver<Item>... observers)
//    throws InvalidSequenceIndexException, InvalidTraversableArgumentException, InvalidTraversableStateException {
//        IndexSequenceUtility.ensureIndexValid(this, index);
//
////        getBaseSequence().replace(index, newItem, observers);
//    }
//
//    @Override
//    public IndexSequenceTraverser<Item> createTraverser() {
//        return new DefaultReplaceIndexSequenceTraverser<>(this);
//    }
//
//    @Override
//    public IndexSequenceTraverser<Item> createTraverser(final int startIndex)
//    throws InvalidSequenceIndexException {
//        return new DefaultReplaceIndexSequenceTraverser<>(this, startIndex);
//    }
//
//    @Override
//    public int getCount()
//    throws InvalidTraversableStateException {
//        return 0;
//    }
//
//    @Override
//    public boolean isEmpty()
//    throws InvalidTraversableStateException {
//        return false;
//    }
//
//    @Override
//    public boolean containsItem(final Item item)
//    throws InvalidTraversableArgumentException, InvalidTraversableStateException {
//        return false;
//    }
//
//    @Override
//    public boolean containsItem(final TraversableContainer<? extends Item> items)
//    throws InvalidTraversableArgumentException, InvalidTraversableStateException {
//        return false;
//    }
//
//    @Override
//    public boolean containsItem(final Collection<? extends Item> items)
//    throws InvalidTraversableArgumentException, InvalidTraversableStateException {
//        return false;
//    }
//
//    @Override
//    public boolean containsItem(final Item... items)
//    throws InvalidTraversableArgumentException, InvalidTraversableStateException {
//        return false;
//    }
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

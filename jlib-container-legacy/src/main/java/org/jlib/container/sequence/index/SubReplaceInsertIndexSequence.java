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

package org.jlib.container.operation.sequence.index;

/**
 * {@link SubReplaceIndexSequence} view of the Items stored in another
 * {@link ReplaceIndexSequence} in the specified index range. The Items in this
 * {@link SubReplaceInsertIndexSequence} will have the same index as they had in
 * the base {@link ReplaceIndexSequence}.
 *
 * @param <Item>
 *        type of the items held in the {@link SubReplaceInsertIndexSequence}
 *
 * @param <BaseSequence>
 *        type of the base {@link ObservedReplaceInsertIndexSequence}
 *
 * @author Igor Akkerman
 */
public class SubReplaceInsertIndexSequence<Item, BaseSequence extends ObservedReplaceIndexSequence<Item>/* & ObservedInsertIndexSequence<Item>*/>
/*extends SubReplaceIndexSequence<Item, BaseSequence>
implements ObservedInsertIndexSequence<Item> */ {

//    /**
//     * Creates a new {@link SubReplaceInsertIndexSequence}.
//     *
//     * @param baseSequence
//     *        base {@link ReplaceInsertIndexSequence}
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
//    public SubReplaceInsertIndexSequence(final BaseSequence baseSequence, final int firstIndex, final int lastIndex)
//    throws InvalidSequenceIndexException, InvalidSequenceIndexException {
//        super(baseSequence, firstIndex, lastIndex);
//    }
//
//    @Override
//    public void insert(final int index, final Item item) {
//        IndexSequenceUtility.ensureIndexValid(this, index);
//
////        getBaseSequence().insert(index, item);
//    }
//
//    @Override
//    public void insert(final int index, final IterableContainer<? extends Item> items) {
//        IndexSequenceUtility.ensureIndexValid(this, index);
//
////        getBaseSequence().insert(index, items);
//    }
//
//    @Override
//    public void insert(final int index, final Collection<? extends Item> items) {
//        IndexSequenceUtility.ensureIndexValid(this, index);
//
////        getBaseSequence().insert(index, items);
//    }
//
//    @Override
//    @SuppressWarnings("unchecked")
//    public void insert(final int index, final Item... items) {
//        IndexSequenceUtility.ensureIndexValid(this, index);
//
////        getBaseSequence().insert(index, items);
//    }
//
////    @Override
////    public InsertIndexSequence<Item> getSubsequenceView(final int fromIndex, final int toIndex)
////    throws InvalidSequenceIndexException, InvalidSequenceIndexException {
////        return new SubReplaceInsertIndexSequence<>(this, fromIndex, toIndex);
////    }
//
//    @Override
//    public IndexSequenceIterator<Item> iterator() {
//        return new DefaultReplaceInsertIndexSequenceIterator<>(this);
//    }
//
//    @Override
//    public IndexSequenceIterator<Item> iterator(final int startIndex)
//    throws InvalidSequenceIndexException {
//        return new DefaultReplaceInsertIndexSequenceIterator<>(this, startIndex);
//    }
//
//    @Override
//    @SuppressWarnings("unchecked")
//    public void insert(final int index, final Item item, final ValueObserver<Item>... observers)
//    throws InvalidSequenceIndexException, InvalidContainerArgumentException, InvalidContainerStateException {
//        IndexSequenceUtility.ensureIndexValid(this, index);
//
////        getBaseSequence().insert(index, item, observers);
//    }
//
//    @Override
//    @SuppressWarnings("unchecked")
//    public void insert(final int index, final IterableContainer<? extends Item> items, final ValueObserver<Item>... observers) {
//        IndexSequenceUtility.ensureIndexValid(this, index);
//
////        getBaseSequence().insert(index, items, observers);
//    }
//
//    @Override
//    @SuppressWarnings("unchecked")
//    public void insert(final int index, final Collection<? extends Item> items, final ValueObserver<Item>... observers) {
//        IndexSequenceUtility.ensureIndexValid(this, index);
//
////        getBaseSequence().insert(index, items, observers);
//    }
//
//    @Override
//    @SuppressWarnings("unchecked")
//    public void insert(final int index, final ValueObserver<Item>[] observers, final Item... items) {
//        IndexSequenceUtility.ensureIndexValid(this, index);
//
////        getBaseSequence().insert(index, observers, items);
//    }
}

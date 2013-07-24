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
 * {@link IndexSequence} view of the {@link Item}s stored in a base {@link IndexSequence} in the specified index range.
 * The {@link Item}s in this {@link SubIndexSequence} will have the same index as they had in the base
 *{@link IndexSequence}.
 *
 * @param <Item>
 *        type of the items held in the {@link SubIndexSequence}
 *
 * @param <BaseSequence>
 *        type of the base {@link IndexSequence}
 *
 * @author Igor Akkerman
 */
public class SubIndexSequence<Item, BaseSequence extends IndexSequence<Item>>
/*extends AbstractIndexSequence<Item> */{

//    /** BaseSequence of this {@link SubIndexSequence} */
//    private final BaseSequence baseSequence;
//
//    /**
//     * Creates a new {@link SubIndexSequence}.
//     *
//     * @param baseSequence
//     *        base {@link IndexSequence}
//     *
//     * @param firstIndex
//     *        integer specifying the index of the first {@link Item}
//     *
//     * @param lastIndex
//     *        integer specifying the index of the last {@link Item}
//     *
//     * @throws InvalidSequenceIndexException
//     *         if {@code firstIndex < baseSequence.getFirstIndex() || lastIndex > baseSequence.getLastIndex()}
//     *
//     * @throws InvalidSequenceIndexException
//     *         if {@code firstIndex > lastIndex}
//     */
//    public SubIndexSequence(final BaseSequence baseSequence, final int firstIndex, final int lastIndex)
//    throws InvalidSequenceIndexException, InvalidSequenceIndexException {
//        super(firstIndex, lastIndex);
//
//        ensureSubIndexRangeValid(baseSequence, firstIndex, lastIndex);
//
//        this.baseSequence = baseSequence;
//    }
//
//    @Override
//    protected Item getStoredItem(final int index) {
//        return baseSequence.get(index);
//    }
//
//    /**
//     * Returns the base BaseSequence of this {@link SubIndexSequence}.
//     *
//     * @return BaseSequence of this {@link SubIndexSequence}
//     */
//    protected BaseSequence getBaseSequence() {
//        return baseSequence;
//    }
//
//    @Override
//    public boolean contains(final Item item)
//    throws InvalidTraversableArgumentException, InvalidTraversableStateException {
//        return false;
//    }
//
//    @Override
//    public boolean contains(final TraversableContainer<? extends Item> items)
//    throws InvalidTraversableArgumentException, InvalidTraversableStateException {
//        return false;
//    }
//
//    @Override
//    public boolean contains(final Collection<? extends Item> items)
//    throws InvalidTraversableArgumentException, InvalidTraversableStateException {
//        return false;
//    }
//
//    @Override
//    public boolean contains(final Item... items)
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

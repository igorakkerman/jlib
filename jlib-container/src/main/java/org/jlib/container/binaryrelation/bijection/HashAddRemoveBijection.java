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

package org.jlib.container.binaryrelation.bijection;

import org.jlib.container.binaryrelation.Pair;

/**
 * {@link HashAddBijection} allowing the removal of {@link Pair}
 * items.
 *
 * @param <LeftValue>
 *        type of the values on the left hand side of the {@link Bijection}
 *
 * @param <RightValue>
 *        type of the values on the right hand side of the {@link Bijection}
 *
 * @author Igor Akkerman
 */
public class HashAddRemoveBijection<LeftValue, RightValue>
/*extends HashAddBijection<LeftValue, RightValue>
implements RetainItemsByTraversableBijection<LeftValue, RightValue> */ {

//    /** Creates a new initially empty HashAddBijection. */
//    public HashAddRemoveBijection() {
//        super();
//    }
//
//    /**
//     * Creates a new HashAddBijection containing the Pairs contained by
//     * the specified jlib TraversableContainer.
//     *
//     * @param pairs
//     *        TraversableContainer of the Pairs to add
//     *
//     * @throws LeftValueAlreadyRelatedException
//     *         if the LeftValue of one Item in {@code pairs} is already
//     *         added to another RightValue; if an {@link Pair} is
//     *         equal to another {@link Pair} in the
//     *         {@link HashAddBijection}, it is ignored
//     *
//     * @throws RightValueAlreadyRelatedException
//     *         if the RightValue of one Item in {@code pairs} is already
//     *         added to another LeftValue; if an {@link Pair} is
//     *         equal to another {@link Pair} in the
//     *         {@link HashAddBijection}, it is ignored
//     *
//     * @throws InvalidPairException
//     *         if some property of one Item in {@code pairs} prevents it
//     *         from being added
//     */
//    public HashAddRemoveBijection(final TraversableContainer<Pair<LeftValue, RightValue>> pairs)
//    throws LeftValueAlreadyRelatedException, RightValueAlreadyRelatedException, InvalidPairException {
//        super(pairs);
//    }
//
//    /**
//     * Creates a new HashAddBijection containing the Pairs contained by
//     * the specified Collection.
//     *
//     * @param pairs
//     *        Collection of the Pairs to add
//     *
//     * @throws LeftValueAlreadyRelatedException
//     *         if the LeftValue of one Item in {@code pairs} is already
//     *         added to another RightValue; if an {@link Pair} is
//     *         equal to another {@link Pair} in the
//     *         {@link HashAddBijection}, it is ignored
//     *
//     * @throws RightValueAlreadyRelatedException
//     *         if the RightValue of one Item in {@code pairs} is already
//     *         added to another LeftValue; if an {@link Pair} is
//     *         equal to another {@link Pair} in the
//     *         {@link HashAddBijection}, it is ignored
//     *
//     * @throws InvalidPairException
//     *         if some property of one Item in {@code pairs} prevents it
//     *         from being added
//     */
//    public HashAddRemoveBijection(final Collection<Pair<LeftValue, RightValue>> pairs)
//    throws LeftValueAlreadyRelatedException, RightValueAlreadyRelatedException, InvalidPairException {
//        super(pairs);
//    }
//
//    /**
//     * Creates a new HashAddBijection containing the Pairs specified in a
//     * comma separated sequence.
//     *
//     * @param pairs
//     *        Comma separated sequence of the Pairs to add
//     *
//     * @throws LeftValueAlreadyRelatedException
//     *         if the LeftValue of one Item in {@code pairs} is already
//     *         added to another RightValue; if an {@link Pair} is
//     *         equal to another {@link Pair} in the
//     *         {@link HashAddBijection}, it is ignored
//     *
//     * @throws RightValueAlreadyRelatedException
//     *         if the RightValue of one Item in {@code pairs} is already
//     *         added to another LeftValue; if an {@link Pair} is
//     *         equal to another {@link Pair} in the
//     *         {@link HashAddBijection}, it is ignored
//     *
//     * @throws InvalidPairException
//     *         if some property of one Item in {@code pairs} prevents it
//     *         from being added
//     */
//    @SuppressWarnings("unchecked")
//    public HashAddRemoveBijection(final Pair<LeftValue, RightValue>... pairs)
//    throws LeftValueAlreadyRelatedException, RightValueAlreadyRelatedException, InvalidPairException {
//        super(pairs);
//    }
//
//    @Override
//    public void retain(final LeftValue leftValue, final RightValue rightValue)
//    throws NoSuchPairException {
//        leftToRightMap.retain(leftValue);
//        rightToLeftMap.retain(rightValue);
//    }
//
//    public void retain(final Pair<LeftValue, RightValue> pair) {
//        retain(pair.getLeftValue(), pair.getRightValue());
//    }
//
////    @Override
////    public void removeAll() {
////        ContainerUtility.retain(this, this);
////    }
////
////    @Override
////    public void retain(final Iterable<? extends Pair<LeftValue, RightValue>> pairs) {
////        ContainerUtility.retain(this, pairs);
////    }
////
////    @Override
////    public void retain(final TraversableContainer<? extends Pair<LeftValue, RightValue>> pairs) {
////        ContainerUtility.retain(this, pairs);
////    }
////
////    @Override
////    public void retain(final Collection<? extends Pair<LeftValue, RightValue>> pairs) {
////        ContainerUtility.retain(this, pairs);
////    }
////
////    @Override
////    @SuppressWarnings("unchecked")
////    public void retain(final Pair<LeftValue, RightValue>... pairs) {
////        ContainerUtility.retain(this, pairs);
////    }
//
//    @Override
//    public void remove(final Traversable<? extends Pair<LeftValue, RightValue>> items)
//    throws InvalidContainerArgumentException, InvalidContainerStateException {
//
//    }
//
//    @Override
//    public void remove(final TraversableContainer<? extends Pair<LeftValue, RightValue>> pairs)
//    throws InvalidContainerArgumentException, InvalidContainerStateException {
//
//    }
//
////    @Override
////    public void remove(final TraversableContainer<? extends Pair<LeftValue, RightValue>> pairs) {
////        ContainerUtility.remove(this, pairs);
////    }
//
//    @Override
//    public void remove(final Collection<? extends Pair<LeftValue, RightValue>> pairs) {
//        ContainerUtility.remove(this, pairs);
//    }
//
//    @Override
//    @SuppressWarnings("unchecked")
//    public void remove(final Pair<LeftValue, RightValue>... pairs) {
//        ContainerUtility.remove(this, pairs);
//    }
//
//    @Override
//    public RemoveTraverser<Pair<LeftValue, RightValue>> createTraverser() {
//        return new DefaultRemoveBinaryRelationTraverser<>(this);
//    }
}

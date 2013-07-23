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

package org.jlib.container.binaryrelation;

import java.util.Collection;

import org.jlib.core.traverser.RemoveTraverser;

import org.jlib.container.ReadContainer;
import org.jlib.container.ItemToRemoveNotContainedException;

/**
 * {@link AddBinaryRelation} implemented using hashing for left and right
 * hand side items.
 *
 * @param <LeftValue>
 *        type of the values on the left hand side of the {@link BinaryRelation}
 *
 * @param <RightValue>
 *        type of the values on the right hand side of the
 *        {@link BinaryRelation}
 *
 * @author Igor Akkerman
 */
public class HashAddRemoveBinaryRelation<LeftValue, RightValue>
extends HashAddBinaryRelation<LeftValue, RightValue>
implements RemoveBinaryRelation<LeftValue, RightValue> {

    /**
     * Creates a new initially empty {@link HashAddRemoveBinaryRelation}.
     */
    public HashAddRemoveBinaryRelation() {
        super();
    }

    /**
     * Creates a new {@link HashAddRemoveBinaryRelation} containing the
     * {@link Pair} items contained by the specified {@link ReadContainer}.
     *
     * @param pairs
     *        ReadContainer of the Pairs to add
     *
     * @throws InvalidPairException
     *         if {@code pairs} violate the rules of this
     *         {@link HashAddRemoveBinaryRelation}
     */
    public HashAddRemoveBinaryRelation(final ReadContainer<Pair<LeftValue, RightValue>> pairs)
    throws InvalidPairException {
        super(pairs);
    }

    /**
     * Creates a new {@link HashAddRemoveBinaryRelation} containing the
     * {@link Pair} items contained by the specified {@link Collection}.
     *
     * @param pairs
     *        {@link Collection} of {@link Pair} items to add
     *
     * @throws InvalidPairException
     *         if {@code pairs} violate the rules of this
     *         {@link HashAddRemoveBinaryRelation}
     */
    public HashAddRemoveBinaryRelation(final Collection<Pair<LeftValue, RightValue>> pairs)
    throws InvalidPairException {
        super(pairs);
    }

    /**
     * Creates a new HashAddRemoveBinaryRelation containing the
     * {@link Pair} items specified in a comma separated sequence.
     *
     * @param pairs
     *        comma separated sequence of the {@link Pair} items to add
     *
     * @throws InvalidPairException
     *         if {@code pairs} violate the rules of this
     *         {@link HashAddRemoveBinaryRelation}
     */
    @SuppressWarnings("unchecked")
    public HashAddRemoveBinaryRelation(final Pair<LeftValue, RightValue>... pairs)
    throws InvalidPairException {
        super(pairs);
    }

    // overridden to be made public
    @Override
    public void addPair(final LeftValue leftValue, final RightValue rightValue)
    throws InvalidPairException {
        super.addPair(leftValue, rightValue);
    }

    @Override
    public void remove(final LeftValue leftValue, final RightValue rightValue)
    throws NoSuchLeftValueException, NoSuchRightValueException {
        remove(new Pair(leftValue, rightValue));
    }

    @Override
    public void remove(final Pair<LeftValue, RightValue> pair)
    throws ItemToRemoveNotContainedException {
        try {
            removePair(pair);
        }
        catch (final NoSuchPairException exception) {
            throw new ItemToRemoveNotContainedException(this, pair, exception);
        }
    }

    private void removePair(final Pair<LeftValue, RightValue> pair) {
        final LeftValue leftValue = pair.getLeftValue();
        final RightValue rightValue = pair.getRightValue();

        if (! contains(leftValue, rightValue))
            throw new NoSuchPairException(this, new Pair(leftValue, rightValue));

        leftToRightMap.get(leftValue).remove(rightValue);
        rightToLeftMap.get(rightValue).remove(leftValue);
    }

    @Override
    public void removeAll() {
        BinaryRelationUtility.remove(this, this);
    }

    @Override
    public void remove(final Iterable<? extends Pair<LeftValue, RightValue>> pairs) {
        BinaryRelationUtility.remove(this, pairs);
    }

    @Override
    public void remove(final ReadContainer<? extends Pair<LeftValue, RightValue>> pairs) {
        BinaryRelationUtility.remove(this, pairs);
    }

    @Override
    public void remove(final Collection<? extends Pair<LeftValue, RightValue>> pairs) {
        BinaryRelationUtility.remove(this, pairs);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void remove(final Pair<LeftValue, RightValue>... pairs) {
        BinaryRelationUtility.remove(this, pairs);
    }

    @Override
    public void retain(final ReadContainer<? extends Pair<LeftValue, RightValue>> pairs) {
        BinaryRelationUtility.retain(this, pairs);
    }

    @Override
    public void retain(final Collection<? extends Pair<LeftValue, RightValue>> pairs) {
        BinaryRelationUtility.retain(this, pairs);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void retain(final Pair<LeftValue, RightValue>... pairs) {
        BinaryRelationUtility.retain(this, pairs);
    }

    @Override
    public RemoveTraverser<Pair<LeftValue, RightValue>> createTraverser() {
        return new DefaultRemoveBinaryRelationTraverser<>(this);
    }
}

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

import org.jlib.container.Container;
import org.jlib.container.ItemToRemoveNotContainedException;
import org.jlib.core.traverser.RemoveTraverser;

/**
 * {@link AssociateBinaryRelation} implemented using hashing for left and right
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
public class HashAssociateRemoveBinaryRelation<LeftValue, RightValue>
extends HashAssociateBinaryRelation<LeftValue, RightValue>
implements RemoveBinaryRelation<LeftValue, RightValue> {

    /**
     * Creates a new initially empty {@link HashAssociateRemoveBinaryRelation}.
     */
    public HashAssociateRemoveBinaryRelation() {
        super();
    }

    /**
     * Creates a new {@link HashAssociateRemoveBinaryRelation} containing the
     * {@link Pair} items contained by the specified {@link Container}.
     *
     * @param associations
     *        Container of the Associations to add
     *
     * @throws InvalidPairException
     *         if {@code associations} violate the rules of this
     *         {@link HashAssociateRemoveBinaryRelation}
     */
    public HashAssociateRemoveBinaryRelation(final Container<Pair<LeftValue, RightValue>> associations)
    throws InvalidPairException {
        super(associations);
    }

    /**
     * Creates a new {@link HashAssociateRemoveBinaryRelation} containing the
     * {@link Pair} items contained by the specified {@link Collection}.
     *
     * @param pairs
     *        {@link Collection} of {@link Pair} items to add
     *
     * @throws InvalidPairException
     *         if {@code pairs} violate the rules of this
     *         {@link HashAssociateRemoveBinaryRelation}
     */
    public HashAssociateRemoveBinaryRelation(final Collection<Pair<LeftValue, RightValue>> pairs)
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
     *         {@link HashAssociateRemoveBinaryRelation}
     */
    @SuppressWarnings("unchecked")
    public HashAssociateRemoveBinaryRelation(final Pair<LeftValue, RightValue>... pairs)
    throws InvalidPairException {
        super(pairs);
    }

    // overridden to be made public
    @Override
    public void associate(final LeftValue leftValue, final RightValue rightValue)
    throws InvalidPairException {
        super.associate(leftValue, rightValue);
    }

    @Override
    public void remove(final LeftValue leftValue, final RightValue rightValue)
    throws NoSuchPairValueException {
        if (! contains(leftValue, rightValue))
            throw new NoSuchPairException(this, leftValue, rightValue);

        leftToRightMap.get(leftValue).remove(rightValue);
        rightToLeftMap.get(rightValue).remove(leftValue);
    }

    @Override
    public void remove(final Pair<LeftValue, RightValue> pair)
    throws ItemToRemoveNotContainedException {
        try {
            remove(pair.getLeftValue(), pair.getRightValue());
        }
        catch (final NoSuchPairValueException exception) {
            throw new ItemToRemoveNotContainedException(this, pair, exception);
        }
    }

    @Override
    public void removeAll() {
        BinaryRelationUtility.remove(this, this);
    }

    @Override
    public void remove(final Iterable<? extends Pair<LeftValue, RightValue>> associations) {
        BinaryRelationUtility.remove(this, associations);
    }

    @Override
    public void remove(final Container<? extends Pair<LeftValue, RightValue>> associations) {
        BinaryRelationUtility.remove(this, associations);
    }

    @Override
    public void remove(final Collection<? extends Pair<LeftValue, RightValue>> associations) {
        BinaryRelationUtility.remove(this, associations);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void remove(final Pair<LeftValue, RightValue>... pairs) {
        BinaryRelationUtility.remove(this, pairs);
    }

    @Override
    public void retain(final Container<? extends Pair<LeftValue, RightValue>> associations) {
        BinaryRelationUtility.retain(this, associations);
    }

    @Override
    public void retain(final Collection<? extends Pair<LeftValue, RightValue>> associations) {
        BinaryRelationUtility.retain(this, associations);
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

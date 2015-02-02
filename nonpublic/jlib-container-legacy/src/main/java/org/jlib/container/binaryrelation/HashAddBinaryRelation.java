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

package org.jlib.container.operation.binaryrelation;

import java.util.Collection;

import org.jlib.container.operation.InvalidContainerArgumentException;

/**
 * {@link AddBinaryRelation} implemented using hashing for left and right
 * hand side items.
 *
 * @param <LeftValue>
 *        type of the items on the left hand side of the {@link BinaryRelation}
 *
 * @param <RightValue>
 *        type of the items on the right hand side of the {@link BinaryRelation}
 *
 * @author Igor Akkerman
 */
public class HashAddBinaryRelation<LeftValue, RightValue>
extends HashBinaryRelation<LeftValue, RightValue>
implements AddBinaryRelation<LeftValue, RightValue> {

    /**
     * Creates a new initially empty {@link HashAddBinaryRelation}.
     */
    public HashAddBinaryRelation() {
        super();
    }

    /**
     * Creates a new {@link HashAddBinaryRelation} containing the
     * {@link Pair} items contained by the specified {@link Object}.
     *
     * @param pairs
     *        IterableContainer of the Pairs to add
     *
     * @throws InvalidPairException
     *         if {@code pairs} violates the rules of this
     *         {@link HashAddBinaryRelation}
     */
    public HashAddBinaryRelation(final IterableContainer<Pair<LeftValue, RightValue>> pairs)
    throws InvalidPairException {
        super(pairs);
    }

    /**
     * Creates a new {@link HashAddBinaryRelation} containing the
     * {@link Pair} items contained by the specified {@link Collection}.
     *
     * @param pairs
     *        {@link Collection} of {@link Pair} items to add
     *
     * @throws InvalidPairException
     *         if {@code pairs} violates the rules of this
     *         {@link HashAddBinaryRelation}
     */
    public HashAddBinaryRelation(final Collection<Pair<LeftValue, RightValue>> pairs)
    throws InvalidPairException {
        super(pairs);
    }

    /**
     * Creates a new {@link HashAddBinaryRelation} containing the
     * {@link Pair} items specified in a comma separated sequence.
     *
     * @param pairs
     *        comma separated sequence of the {@link Pair} items to add
     *
     * @throws InvalidPairException
     *         if {@code pairs} violates the rules of this
     *         {@link HashAddBinaryRelation}
     */
    @SuppressWarnings("unchecked")
    public HashAddBinaryRelation(final Pair<LeftValue, RightValue>... pairs)
    throws InvalidPairException {
        super(pairs);
    }

    @Override
    // raising visibility from protected to public
    public void addPair(final LeftValue leftValue, final RightValue rightValue)
    throws InvalidPairException {
        super.associate(leftValue, rightValue);
    }

    @Override
    // raising visibility from protected to public
    public void ensureContained(final LeftValue leftValue, final RightValue rightValue)
    throws InvalidPairException {
        super.ensureAssociated(leftValue, rightValue);
    }

    @Override
    public void add(final Pair<LeftValue, RightValue> pair)
    throws InvalidPairException {
        addPair(pair.getLeftValue(), pair.getRightValue());
    }

    @Override
    public void addPairs(final IterableContainer<? extends Pair<LeftValue, RightValue>> pairs)
    throws InvalidContainerArgumentException {
        BinaryRelationUtility.add(this, pairs);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void addPairs(final Pair<LeftValue, RightValue>... pairs)
    throws InvalidPairException {
        BinaryRelationUtility.add(this, pairs);
    }

    @Override
    public void addPairs(final Collection<? extends Pair<LeftValue, RightValue>> pairs)
    throws InvalidPairException {
        BinaryRelationUtility.add(this, pairs);
    }

    @Override
    public void ensureContained(final Pair<LeftValue, RightValue> pair)
    throws InvalidPairException {
        ensureContained(pair.getLeftValue(), pair.getRightValue());
    }

    @Override
    public void ensureContained(final IterableContainer<? extends Pair<LeftValue, RightValue>> pairs)
    throws InvalidPairException {
        BinaryRelationUtility.ensureContained(this, pairs);
    }

    @Override
    public void ensureContained(final Collection<? extends Pair<LeftValue, RightValue>> pairs)
    throws InvalidPairException {
    }

    @Override
    @SuppressWarnings("unchecked")
    public void ensureContained(final Pair<LeftValue, RightValue>... pairs)
    throws InvalidPairException {
        BinaryRelationUtility.ensureContained(this, pairs);
    }
}

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

import java.util.Collection;

import org.jlib.container.ReadContainer;
import org.jlib.container.binaryrelation.InvalidPairException;
import org.jlib.container.binaryrelation.LeftValueAlreadyRelatedException;
import org.jlib.container.binaryrelation.Pair;
import org.jlib.container.binaryrelation.BinaryRelationUtility;
import org.jlib.container.binaryrelation.RightValueAlreadyRelatedException;

/**
 * {@link HashBijection} allowing the addition of new {@link Pair} items.
 *
 * @param <LeftValue>
 *        type of the values on the left hand side of the {@link Bijection}
 *
 * @param <RightValue>
 *        type of the values on the right hand side of the {@link Bijection}
 *
 * @author Igor Akkerman
 */
public class HashAddBijection<LeftValue, RightValue>
extends HashBijection<LeftValue, RightValue>
implements AddBijection<LeftValue, RightValue> {

    /** Creates a new initially empty HashAddBijection. */
    public HashAddBijection() {
        super();
    }

    /**
     * Creates a new HashAddBijection containing the Pairs contained by
     * the specified jlib ReadContainer.
     *
     * @param pairs
     *        ReadContainer of the Pairs to add
     *
     * @throws LeftValueAlreadyRelatedException
     *         if the LeftValue of one Item in {@code pairs} is already
     *         added to another RightValue; if an {@link Pair} is
     *         equal to another {@link Pair} in the
     *         {@link HashAddBijection}, it is ignored
     *
     * @throws RightValueAlreadyRelatedException
     *         if the RightValue of one Item in {@code pairs} is already
     *         added to another LeftValue; if an {@link Pair} is
     *         equal to another {@link Pair} in the
     *         {@link HashAddBijection}, it is ignored
     *
     * @throws InvalidPairException
     *         if some property of one Item in {@code pairs} prevents it
     *         from being added
     */
    public HashAddBijection(final ReadContainer<Pair<LeftValue, RightValue>> pairs)
    throws LeftValueAlreadyRelatedException, RightValueAlreadyRelatedException, InvalidPairException {
        super(pairs);
    }

    /**
     * Creates a new HashAddBijection containing the Pairs contained by
     * the specified Collection.
     *
     * @param pairs
     *        Collection of the Pairs to add
     *
     * @throws LeftValueAlreadyRelatedException
     *         if the LeftValue of one Item in {@code pairs} is already
     *         added to another RightValue; if an {@link Pair} is
     *         equal to another {@link Pair} in the
     *         {@link HashAddBijection}, it is ignored
     *
     * @throws RightValueAlreadyRelatedException
     *         if the RightValue of one Item in {@code pairs} is already
     *         added to another LeftValue; if an {@link Pair} is
     *         equal to another {@link Pair} in the
     *         {@link HashAddBijection}, it is ignored
     *
     * @throws InvalidPairException
     *         if some property of one Item in {@code pairs} prevents it
     *         from being added
     */
    public HashAddBijection(final Collection<Pair<LeftValue, RightValue>> pairs)
    throws LeftValueAlreadyRelatedException, RightValueAlreadyRelatedException, InvalidPairException {
        super(pairs);
    }

    /**
     * Creates a new HashAddBijection containing the Pairs specified in a
     * comma separated sequence.
     *
     * @param pairs
     *        Comma separated sequence of the Pairs to add
     *
     * @throws LeftValueAlreadyRelatedException
     *         if the LeftValue of one Item in {@code pairs} is already
     *         added to another RightValue; if an {@link Pair} is
     *         equal to another {@link Pair} in the
     *         {@link HashAddBijection}, it is ignored
     *
     * @throws RightValueAlreadyRelatedException
     *         if the RightValue of one Item in {@code pairs} is already
     *         added to another LeftValue; if an {@link Pair} is
     *         equal to another {@link Pair} in the
     *         {@link HashAddBijection}, it is ignored
     *
     * @throws InvalidPairException
     *         if some property of one Item in {@code pairs} prevents it
     *         from being added
     */
    @SuppressWarnings("unchecked")
    public HashAddBijection(final Pair<LeftValue, RightValue>... pairs)
    throws LeftValueAlreadyRelatedException, RightValueAlreadyRelatedException, InvalidPairException {
        super(pairs);
    }

    @Override
    // raising visibility from protected to public
    public void addPair(final LeftValue leftValue, final RightValue rightValue)
    throws PairAlreadyContainedException, LeftValueAlreadyRelatedException, RightValueAlreadyRelatedException, InvalidPairException {
        super.associate(leftValue, rightValue);
    }

    @Override
    // raising visibility from protected to public
    public void ensureContained(final LeftValue leftValue, final RightValue rightValue)
    throws LeftValueAlreadyRelatedException, RightValueAlreadyRelatedException, InvalidPairException {
        super.ensureAssociated(leftValue, rightValue);
    }

    @Override
    public void add(final Pair<LeftValue, RightValue> pair)
    throws PairAlreadyContainedException, LeftValueAlreadyRelatedException, RightValueAlreadyRelatedException, InvalidPairException {
        addPair(pair.getLeftValue(), pair.getRightValue());
    }

    @Override
    public void addPairs(final ReadContainer<? extends Pair<LeftValue, RightValue>> pairs)
    throws PairAlreadyContainedException, LeftValueAlreadyRelatedException, RightValueAlreadyRelatedException, InvalidPairException {
        BinaryRelationUtility.add(this, pairs);
    }

    @Override
    public void addPairs(final Collection<? extends Pair<LeftValue, RightValue>> pairs)
    throws PairAlreadyContainedException, LeftValueAlreadyRelatedException, RightValueAlreadyRelatedException, InvalidPairException {
        BinaryRelationUtility.add(this, pairs);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void addPairs(final Pair<LeftValue, RightValue>... pairs)
    throws PairAlreadyContainedException, LeftValueAlreadyRelatedException, RightValueAlreadyRelatedException, InvalidPairException {
        BinaryRelationUtility.add(this, pairs);
    }

    @Override
    public void ensureContained(final Pair<LeftValue, RightValue> pair)
    throws LeftValueAlreadyRelatedException, RightValueAlreadyRelatedException, InvalidPairException {
        BinaryRelationUtility.ensureContained(this, pair);
    }

    @Override
    public void ensureContained(final ReadContainer<? extends Pair<LeftValue, RightValue>> pairs)
    throws LeftValueAlreadyRelatedException, RightValueAlreadyRelatedException, InvalidPairException {
        BinaryRelationUtility.ensureContained(this, pairs);
    }

    @Override
    public void ensureContained(final Collection<? extends Pair<LeftValue, RightValue>> pairs)
    throws LeftValueAlreadyRelatedException, RightValueAlreadyRelatedException, InvalidPairException {
        BinaryRelationUtility.ensureContained(this, pairs);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void ensureContained(final Pair<LeftValue, RightValue>... pairs)
    throws LeftValueAlreadyRelatedException, RightValueAlreadyRelatedException, InvalidPairException {
        BinaryRelationUtility.ensureContained(this, pairs);
    }
}

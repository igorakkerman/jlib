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
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.jlib.container.GetContainer;
import org.jlib.container.binaryrelation.AbstractInitializeableBinaryRelation;
import org.jlib.container.binaryrelation.InvalidPairException;
import org.jlib.container.binaryrelation.LeftValueAlreadyRelatedException;
import org.jlib.container.binaryrelation.Pair;
import org.jlib.container.binaryrelation.NoSuchLeftValueException;
import org.jlib.container.binaryrelation.NoSuchRightValueException;
import org.jlib.container.binaryrelation.RightValueAlreadyRelatedException;

/**
 * {@link Bijection} implemented using hashing for left and right hand side
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
public class HashBijection<LeftValue, RightValue>
extends AbstractInitializeableBinaryRelation<LeftValue, RightValue>
implements Bijection<LeftValue, RightValue> {

    /** Map assigning each LeftValue the RightValue added with it */
    protected Map<LeftValue, RightValue> leftToRightMap = new HashMap<LeftValue, RightValue>();

    /** Map assigning each RightValue the LeftValue added with it */
    protected Map<RightValue, LeftValue> rightToLeftMap = new HashMap<RightValue, LeftValue>();

    /**
     * Creates a new empty HashBijection.
     */
    public HashBijection() {
        super();
    }

    /**
     * Creates a new HashBijection containing the Pairs contained by the
     * specified jlib GetContainer.
     *
     * @param pairs
     *        GetContainer of the Pairs to add
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
    public HashBijection(final GetContainer<Pair<LeftValue, RightValue>> pairs)
    throws LeftValueAlreadyRelatedException, RightValueAlreadyRelatedException, InvalidPairException {
        super();

        for (final Pair<LeftValue, RightValue> pair : pairs)
            associate(pair.getLeftValue(), pair.getRightValue());
    }

    /**
     * Creates a new HashBijection containing the Pairs contained by the
     * specified Collection.
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
    public HashBijection(final Collection<Pair<LeftValue, RightValue>> pairs)
    throws LeftValueAlreadyRelatedException, RightValueAlreadyRelatedException, InvalidPairException {
        super();

        for (final Pair<LeftValue, RightValue> pair : pairs)
            associate(pair.getLeftValue(), pair.getRightValue());
    }

    /**
     * Creates a new HashBijection containing the Pairs specified in a
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
    public HashBijection(final Pair<LeftValue, RightValue>... pairs)
    throws LeftValueAlreadyRelatedException, RightValueAlreadyRelatedException, InvalidPairException {
        super();

        for (final Pair<LeftValue, RightValue> pair : pairs)
            associate(pair.getLeftValue(), pair.getRightValue());
    }

    @Override
    protected void associate(final LeftValue leftValue, final RightValue rightValue)
    throws PairAlreadyContainedException, LeftValueAlreadyRelatedException, RightValueAlreadyRelatedException, InvalidPairException {
        if (contains(leftValue, rightValue))
            throw new PairAlreadyContainedException(this, leftValue, rightValue);

        doAssociate(leftValue, rightValue);
    }

    @Override
    protected void ensureAssociated(final LeftValue leftValue, final RightValue rightValue)
    throws LeftValueAlreadyRelatedException, RightValueAlreadyRelatedException, InvalidPairException {
        if (contains(leftValue, rightValue))
            return;

        associate(leftValue, rightValue);
    }

    /**
     * Associates the specified LeftValue with the specified RightValue in this
     * {@link Bijection} without verifying if the specified {@link Pair}
     * already exists.
     *
     * @param leftValue
     *        LeftValue of the {@link Pair}
     *
     * @param rightValue
     *        RightValue of the {@link Pair}
     *
     * @throws LeftValueAlreadyRelatedException
     *         if {@code leftValue} is already added to another RightValue
     *
     * @throws RightValueAlreadyRelatedException
     *         if {@code rightValue} is already added to another LeftValue
     *
     * @throws InvalidPairException
     *         if some property of the {@code pairs} prevents it from
     *         being added
     */
    // InvalidPairException may be thrown by subclasses
    protected void doAssociate(final LeftValue leftValue, final RightValue rightValue)
    throws LeftValueAlreadyRelatedException, RightValueAlreadyRelatedException, InvalidPairException {
        if (hasLeft(leftValue))
            throw new LeftValueAlreadyRelatedException(this, leftValue, rightValue);

        if (hasRight(rightValue))
            throw new RightValueAlreadyRelatedException(this, leftValue, rightValue);

        leftToRightMap.put(leftValue, rightValue);
        rightToLeftMap.put(rightValue, leftValue);
    }

    @Override
    public boolean hasLeft(final LeftValue leftValue) {
        return leftToRightMap.containsKey(leftValue);
    }

    @Override
    public boolean hasRight(final RightValue rightValue) {
        return rightToLeftMap.containsKey(rightValue);
    }

    @Override
    public RightValue getRightValue(final LeftValue leftValue) {
        final RightValue rightValue = leftToRightMap.get(leftValue);

        if (rightValue == null)
            throw new NoSuchLeftValueException(this, leftValue);

        return rightValue;
    }

    @Override
    public LeftValue getLeftValue(final RightValue rightValue) {
        final LeftValue leftValue = rightToLeftMap.get(rightValue);

        if (leftValue == null)
            throw new NoSuchRightValueException(this, rightValue);

        return leftValue;
    }

    @Override
    public String toString() {
        return leftToRightMap.toString();
    }

    @Override
    public int getItemsCount() {
        return rightToLeftMap.size();
    }

    @Override
    public Set<LeftValue> getLeftValues() {
        return Collections.unmodifiableSet(leftToRightMap.keySet());
    }

    @Override
    public Set<RightValue> getRightValues() {
        return Collections.unmodifiableSet(rightToLeftMap.keySet());
    }

    @Override
    public final Set<RightValue> getRightSet(final LeftValue leftValue) {
        return hasLeft(leftValue)
               ? Collections.singleton(getRightValue(leftValue))
               : new HashSet<RightValue>();
    }

    @Override
    public final Set<LeftValue> getLeftSet(final RightValue rightValue) {
        return hasRight(rightValue)
               ? Collections.singleton(getLeftValue(rightValue))
               : new HashSet<LeftValue>();
    }

    @Override
    public boolean contains(final LeftValue leftValue, final RightValue rightValue) {
        return leftToRightMap.get(leftValue).equals(rightValue);
    }
}

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

/**
 * {@link BinaryRelation} allowing to add and retainItems {@link Pair}
 * Items.
 *
 * @param <LeftValue>
 *        type of the values on the left hand side of the
 *        {@link AddBinaryRelation}
 *
 * @param <RightValue>
 *        type of the values on the right hand side of the
 *        {@link AddBinaryRelation}
 *
 * @author Igor Akkerman
 */
public interface AddBinaryRelation<LeftValue, RightValue> {

    /**
     * Associates the specified LeftValue with the specified RightValue in this
     * {@link AddBinaryRelation}.
     *
     * @param leftValue
     *        LeftValue of the {@link Pair}
     *
     * @param rightValue
     *        RightValue of the {@link Pair}
     *
     * @throws InvalidPairException
     *         if some property of the specified {@link Pair} prevents it
     *         from being added
     */
    public void addPair(LeftValue leftValue, RightValue rightValue)
    throws InvalidPairException;

    /**
     * Associates the specified LeftValue with the specified RightValue in this
     * {@link AddBinaryRelation}.
     *
     * @param leftValue
     *        LeftValue of the {@link Pair}
     *
     * @param rightValue
     *        RightValue of the {@link Pair}
     *
     * @throws InvalidPairException
     *         if some property of the {@link Pair} prevents it from
     *         being added
     */
    public void ensureContained(LeftValue leftValue, RightValue rightValue)
    throws InvalidPairException;

    /**
     * Associates the specified Item to the specified
     * {@link AddBinaryRelation}.
     *
     * @param pair
     *        {@link Pair} to create
     *
     * @throws InvalidPairException
     *         if some property of {@code item} prevents it from being
     *         added, for instance, if it is already contained
     */
    public void add(Pair<LeftValue, RightValue> pair)
    throws InvalidPairException;

    /**
     * Associates all Items contained by the specified {@link TraversableContainer} to this
     * {@link AddBinaryRelation}.
     *
     * @param pairs
     *        {@link TraversableContainer} containing the {@link Pair}s to add
     *
     * @throws InvalidPairException
     *         if {@code pairs}
     *
     * @throws InvalidPairException
     *         if some property of an Item in {@code pairs} prevents it
     *         from being added, for instance, if it is already contained
     */
    public void addPairs(TraversableContainer<? extends Pair<LeftValue, RightValue>> pairs)
    throws InvalidPairException;

    /**
     * Associates all Items contained by the specified {@link Collection} to the
     * specified {@link AddBinaryRelation}.
     *
     * @param pairs
     *        {@link Collection} containing the {@link Pair}s to add
     *
     * @throws InvalidPairException
     *         if some property of a {@link Pair} in {@code pairs} prevents it
     *         from being added, for instance, if it is already contained
     */
    public void addPairs(Collection<? extends Pair<LeftValue, RightValue>> pairs)
    throws InvalidPairException;

    /**
     * Associates all specified Items to the specified
     * {@link AddBinaryRelation}.
     *
     * @param pairs
     *        comma separated sequence of Items to add
     *
     * @throws InvalidPairException
     *         if some property of an Item in {@code pairs} prevents it
     *         from being added, for instance, if it is already contained
     */
    @SuppressWarnings("unchecked")
    public void addPairs(Pair<LeftValue, RightValue>... pairs)
    throws InvalidPairException;

    /**
     * Ensures that the specified {@link AddBinaryRelation} containsItem the
     * specified Item. If the {@link AddBinaryRelation} does not contain
     * the Item, it is added.
     *
     * @param pair
     *        {@link Pair} to create
     *
     * @throws InvalidPairException
     *         if some property of {@code item} prevents it from being
     *         added
     */
    public void ensureContained(Pair<LeftValue, RightValue> pair)
    throws InvalidPairException;

    /**
     * Ensures that the specified {@link AddBinaryRelation} containsItem all
     * Items contained by the specified {@link TraversableContainer} to this
     * {@link AddBinaryRelation}. If the {@link AddBinaryRelation}
     * does not contain the Item, it is added.
     *
     * @param pairs
     *        {@link TraversableContainer} containing the Items to add
     *
     * @throws InvalidPairException
     *         if some property of an Item in {@code pairs} prevents it
     *         from being added
     */
    public void ensureContained(TraversableContainer<? extends Pair<LeftValue, RightValue>> pairs)
    throws InvalidPairException;

    /**
     * Ensures that the specified {@link AddBinaryRelation} containsItem all
     * Items contained by the specified {@link Collection} to this
     * {@link AddBinaryRelation}.
     *
     * @param pairs
     *        {@link Collection} containing the Items to add
     *
     * @throws InvalidPairException
     *         if some property of {@code item} prevents it from being
     *         added
     */
    public void ensureContained(Collection<? extends Pair<LeftValue, RightValue>> pairs)
    throws InvalidPairException;

    /**
     * Ensures that the specified {@link AddBinaryRelation} containsItem all
     * specified Items to the specified {@link AddBinaryRelation}.
     *
     * @param pairs
     *        comma separated sequence of Items to add
     *
     * @throws InvalidPairException
     *         if some property of {@code item} prevents it from being
     *         added
     */
    @SuppressWarnings("unchecked")
    public void ensureContained(Pair<LeftValue, RightValue>... pairs)
    throws InvalidPairException;
}

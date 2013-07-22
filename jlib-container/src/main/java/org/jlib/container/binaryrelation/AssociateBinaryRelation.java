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

/**
 * {@link BinaryRelation} allowing to associate and remove {@link Pair}
 * Items.
 *
 * @param <LeftValue>
 *        type of the values on the left hand side of the
 *        {@link AssociateBinaryRelation}
 *
 * @param <RightValue>
 *        type of the values on the right hand side of the
 *        {@link AssociateBinaryRelation}
 *
 * @author Igor Akkerman
 */
public interface AssociateBinaryRelation<LeftValue, RightValue>
extends BinaryRelation<LeftValue, RightValue> {

    /**
     * Associates the specified LeftValue with the specified RightValue in this
     * {@link AssociateBinaryRelation}.
     *
     * @param leftValue
     *        LeftValue of the {@link Pair}
     *
     * @param rightValue
     *        RightValue of the {@link Pair}
     *
     * @throws InvalidPairException
     *         if some property of the specified {@link Pair} prevents it
     *         from being associated
     */
    public void associate(LeftValue leftValue, RightValue rightValue)
    throws InvalidPairException;

    /**
     * Associates the specified LeftValue with the specified RightValue in this
     * {@link AssociateBinaryRelation}.
     *
     * @param leftValue
     *        LeftValue of the {@link Pair}
     *
     * @param rightValue
     *        RightValue of the {@link Pair}
     *
     * @throws InvalidPairException
     *         if some property of the {@link Pair} prevents it from
     *         being associated
     */
    public void assertAssociated(LeftValue leftValue, RightValue rightValue)
    throws InvalidPairException;

    /**
     * Associates the specified Item to the specified
     * {@link AssociateBinaryRelation}.
     *
     * @param pair
     *        {@link Pair} to create
     *
     * @throws InvalidPairException
     *         if some property of {@code item} prevents it from being
     *         associated, for instance, if it is already contained
     */
    public void associate(Pair<LeftValue, RightValue> pair)
    throws InvalidPairException;

    /**
     * Associates all Items contained by the specified {@link Container} to this
     * {@link AssociateBinaryRelation}.
     *
     * @param associations
     *        {@link Container} containing the Items to associate
     *
     * @throws InvalidPairException
     *         if {@code associations}
     *
     * @throws InvalidPairException
     *         if some property of an Item in {@code associations} prevents it
     *         from being associated, for instance, if it is already contained
     */
    public void associate(Container<? extends Pair<LeftValue, RightValue>> associations)
    throws InvalidPairException;

    /**
     * Associates all Items contained by the specified {@link Collection} to the
     * specified {@link AssociateBinaryRelation}.
     *
     * @param associations
     *        {@link Collection} containing the Items to associate
     *
     * @throws InvalidPairException
     *         if some property of an Item in {@code associations} prevents it
     *         from being associated, for instance, if it is already contained
     */
    public void associate(Collection<? extends Pair<LeftValue, RightValue>> associations)
    throws InvalidPairException;

    /**
     * Associates all specified Items to the specified
     * {@link AssociateBinaryRelation}.
     *
     * @param pairs
     *        comma separated sequence of Items to associate
     *
     * @throws InvalidPairException
     *         if some property of an Item in {@code pairs} prevents it
     *         from being associated, for instance, if it is already contained
     */
    @SuppressWarnings("unchecked")
    public void associate(Pair<LeftValue, RightValue>... pairs)
    throws InvalidPairException;

    /**
     * Asserts that the specified {@link AssociateBinaryRelation} contains the
     * specified Item. If the {@link AssociateBinaryRelation} does not contain
     * the Item, it is associated.
     *
     * @param pair
     *        {@link Pair} to create
     *
     * @throws InvalidPairException
     *         if some property of {@code item} prevents it from being
     *         associated
     */
    public void assertContained(Pair<LeftValue, RightValue> pair)
    throws InvalidPairException;

    /**
     * Asserts that the specified {@link AssociateBinaryRelation} contains all
     * Items contained by the specified {@link Container} to this
     * {@link AssociateBinaryRelation}. If the {@link AssociateBinaryRelation}
     * does not contain the Item, it is associated.
     *
     * @param associations
     *        {@link Container} containing the Items to associate
     *
     * @throws InvalidPairException
     *         if some property of an Item in {@code associations} prevents it
     *         from being associated
     */
    public void assertContained(Container<? extends Pair<LeftValue, RightValue>> associations)
    throws InvalidPairException;

    /**
     * Asserts that the specified {@link AssociateBinaryRelation} contains all
     * Items contained by the specified {@link Collection} to this
     * {@link AssociateBinaryRelation}.
     *
     * @param associations
     *        {@link Collection} containing the Items to associate
     *
     * @throws InvalidPairException
     *         if some property of {@code item} prevents it from being
     *         associated
     */
    public void assertContained(Collection<? extends Pair<LeftValue, RightValue>> associations)
    throws InvalidPairException;

    /**
     * Asserts that the specified {@link AssociateBinaryRelation} contains all
     * specified Items to the specified {@link AssociateBinaryRelation}.
     *
     * @param pairs
     *        comma separated sequence of Items to associate
     *
     * @throws InvalidPairException
     *         if some property of {@code item} prevents it from being
     *         associated
     */
    @SuppressWarnings("unchecked")
    public void assertContained(Pair<LeftValue, RightValue>... pairs)
    throws InvalidPairException;
}

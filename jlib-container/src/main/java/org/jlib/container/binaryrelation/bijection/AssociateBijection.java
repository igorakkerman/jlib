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

import org.jlib.container.binaryrelation.AssociateBinaryRelation;
import org.jlib.container.binaryrelation.Pair;
import org.jlib.container.binaryrelation.InvalidAssociationException;
import org.jlib.container.binaryrelation.LeftValueAlreadyAssociatedException;
import org.jlib.container.binaryrelation.RightValueAlreadyAssociatedException;

/**
 * Bijection allowing to add new {@link Pair} items.
 *
 * @param <LeftValue>
 *        type of the values on the left hand side of the {@link Bijection}
 *
 * @param <RightValue>
 *        type of the values on the right hand side of the {@link Bijection}
 *
 * @author Igor Akkerman
 */
public interface AssociateBijection<LeftValue, RightValue>
extends Bijection<LeftValue, RightValue>, AssociateBinaryRelation<LeftValue, RightValue> {

    /**
     * Associates the specified LeftValue with the specified RightValue in this
     * {@link Bijection}.
     *
     * @param leftValue
     *        LeftValue of the {@link Pair}
     *
     * @param rightValue
     *        RightValue of the {@link Pair}
     *
     * @throws AssociationAlreadyContainedException
     *         if the specified {@link Pair} already exists
     *
     * @throws LeftValueAlreadyAssociatedException
     *         if {@code leftValue} is already associated to another RightValue
     *
     * @throws RightValueAlreadyAssociatedException
     *         if {@code rightValue} is already associated to another LeftValue
     *
     * @throws InvalidAssociationException
     *         if some property of the {@link Pair} prevents it from
     *         being added
     */
    @Override
    public void associate(LeftValue leftValue, RightValue rightValue)
    throws AssociationAlreadyContainedException, LeftValueAlreadyAssociatedException,
           RightValueAlreadyAssociatedException, InvalidAssociationException;

    /**
     * Associates the specified LeftValue with the specified RightValue in this
     * {@link Bijection}.
     *
     * @param leftValue
     *        LeftValue of the {@link Pair}
     *
     * @param rightValue
     *        RightValue of the {@link Pair}
     *
     * @throws LeftValueAlreadyAssociatedException
     *         if {@code leftValue} is already associated to another RightValue;
     *         if the {@link Pair} is equal to another
     *         {@link Pair} in this {@link AssociateBijection}, it is ignored
     *
     * @throws RightValueAlreadyAssociatedException
     *         if {@code rightValue} is already associated to another LeftValue;
     *         if the {@link Pair} is equal to another
     *         {@link Pair} in this {@link AssociateBijection}, it is ignored
     *
     * @throws InvalidAssociationException
     *         if some property of the {@link Pair} prevents it from
     *         being added
     */
    @Override
    public void assertAssociated(LeftValue leftValue, RightValue rightValue)
    throws LeftValueAlreadyAssociatedException, RightValueAlreadyAssociatedException, InvalidAssociationException;
}

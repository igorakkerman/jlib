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

import org.jlib.container.binaryrelation.AddBinaryRelation;
import org.jlib.container.binaryrelation.InvalidPairException;
import org.jlib.container.binaryrelation.LeftValueAlreadyRelatedException;
import org.jlib.container.binaryrelation.Pair;
import org.jlib.container.binaryrelation.RightValueAlreadyRelatedException;

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
public interface AddBijection<LeftValue, RightValue>
extends Bijection<LeftValue, RightValue>,
        AddBinaryRelation<LeftValue, RightValue> {

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
     * @throws PairAlreadyContainedException
     *         if the specified {@link Pair} already exists
     *
     * @throws LeftValueAlreadyRelatedException
     *         if {@code leftValue} is already added to another RightValue
     *
     * @throws RightValueAlreadyRelatedException
     *         if {@code rightValue} is already added to another LeftValue
     *
     * @throws InvalidPairException
     *         if some property of the {@link Pair} prevents it from
     *         being added
     */
    @Override
    public void addPair(LeftValue leftValue, RightValue rightValue)
    throws PairAlreadyContainedException, LeftValueAlreadyRelatedException, RightValueAlreadyRelatedException, InvalidPairException;

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
     * @throws LeftValueAlreadyRelatedException
     *         if {@code leftValue} is already added to another RightValue;
     *         if the {@link Pair} is equal to another
     *         {@link Pair} in this {@link AddBijection}, it is ignored
     *
     * @throws RightValueAlreadyRelatedException
     *         if {@code rightValue} is already added to another LeftValue;
     *         if the {@link Pair} is equal to another
     *         {@link Pair} in this {@link AddBijection}, it is ignored
     *
     * @throws InvalidPairException
     *         if some property of the {@link Pair} prevents it from
     *         being added
     */
    @Override
    public void ensureContained(LeftValue leftValue, RightValue rightValue)
    throws LeftValueAlreadyRelatedException, RightValueAlreadyRelatedException, InvalidPairException;
}

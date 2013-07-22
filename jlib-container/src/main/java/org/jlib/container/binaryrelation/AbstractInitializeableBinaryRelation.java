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

import org.jlib.container.binaryrelation.bijection.PairAlreadyContainedException;

/**
 * Skeletal implementation of a {@link BinaryRelation} allowing to be filled
 * with data.
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
public abstract class AbstractInitializeableBinaryRelation<LeftValue, RightValue>
extends AbstractBinaryRelation<LeftValue, RightValue> {

    /**
     * Creates a new {@link AbstractInitializeableBinaryRelation}.
     */
    protected AbstractInitializeableBinaryRelation() {
        super();
    }

    /**
     * Associates the specified LeftValue with the specified RightValue in this
     * {@link AbstractInitializeableBinaryRelation}.
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
     * @throws InvalidPairException
     *         if some property of the specified {@link Pair} prevents it
     *         from being added
     */
    protected abstract void associate(LeftValue leftValue, RightValue rightValue)
    throws PairAlreadyContainedException, InvalidPairException;

    /**
     * Asserts that the specified LeftValue is associated with the specified
     * RightValue.
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
    protected abstract void assertAssociated(LeftValue leftValue, RightValue rightValue)
    throws InvalidPairException;
}

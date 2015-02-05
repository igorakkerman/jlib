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

package org.jlib.container.operation.binaryrelation.bijection;

import org.jlib.container.operation.binaryrelation.BinaryRelation;
import org.jlib.container.operation.binaryrelation.NoSuchLeftValueException;
import org.jlib.container.operation.binaryrelation.NoSuchRightValueException;

/**
 * One-To-One pair of values with other values. The further values are
 * called left hand side values, the latter right hand side values. The value
 * comparisons for lookup, retrieval and addition on both sides are accomplished
 * using the {@code equals} and {@code hashCode} methods of the Objects.
 *
 * @param <LeftValue>
 *        type of the values on the left hand side of the Bijection
 *
 * @param <RightValue>
 *        type of the values on the right hand side of the Bijection
 *
 * @author Igor Akkerman
 */
public interface Bijection<LeftValue, RightValue>
extends BinaryRelation<LeftValue, RightValue> {

    /**
     * Returns the RightValue added with the specified LeftValue by this
     * Bijection.
     *
     * @param leftValue
     *        LeftValue added with the RightValue to return
     *
     * @return RightValue added with {@code leftValue}
     *
     * @throws NoSuchLeftValueException
     *         if no RightValue is added with {@code leftValue}
     */
    public RightValue getRightValue(LeftValue leftValue)
    throws NoSuchLeftValueException;

    /**
     * Returns the LeftValue added with the specified RightValue by this
     * Bijection.
     *
     * @param rightValue
     *        RightValue added with the LeftValue to return
     *
     * @return LeftValue added with {@code rightValue}
     *
     * @throws NoSuchRightValueException
     *         if no LeftValue is added with {@code rightValue}
     */
    public LeftValue getLeftValue(RightValue rightValue)
    throws NoSuchRightValueException;
}

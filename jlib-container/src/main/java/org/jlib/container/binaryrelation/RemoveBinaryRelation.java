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

import org.jlib.container.Remove;

/**
 * {@link BinaryRelation} allowing the removal of {@link Pair} items.
 *
 * @param <LeftValue>
 *        type of the values on the left hand side of the BinaryRelation
 *
 * @param <RightValue>
 *        type of the values on the right hand side of the BinaryRelation
 *
 * @author Igor Akkerman
 */
public interface RemoveBinaryRelation<LeftValue, RightValue>
extends BinaryRelation<LeftValue, RightValue>,
        Remove<Pair<LeftValue, RightValue>> {

    /**
     * Removes the {@link Pair} specified by its LeftValue and RightValue
     * from this {@link RemoveBinaryRelation}.
     *
     * @param leftValue
     *        LeftValue of the {@link Pair}
     *
     * @param rightValue
     *        RightValue of the {@link Pair}
     *
     * @throws NoSuchPairException
     *         if this {@link RemoveBinaryRelation} does not contain the
     *         specified {@link Pair}
     */
    public void remove(LeftValue leftValue, RightValue rightValue)
    throws NoSuchPairException;
}

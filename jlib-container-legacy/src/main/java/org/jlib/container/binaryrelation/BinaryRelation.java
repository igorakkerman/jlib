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

import java.util.Set;

import org.jlib.core.language.ItemOperationStrategy;
import org.jlib.container.iterator.iterator.Iterator;

/**
 * Binary pair between various Objects. Each Object on either of the two
 * sides may be added with a Set of Objects on the other side.
 *
 * @param <LeftValue>
 *        type of the values on the left hand side of the BinaryRelation
 *
 * @param <RightValue>
 *        type of the values on the right hand side of the BinaryRelation
 *
 * @author Igor Akkerman
 */
public interface BinaryRelation<LeftValue, RightValue>
extends ItemOperationStrategy<Pair<LeftValue, RightValue>>,
        Iterable<Pair<LeftValue, RightValue>>,
        Iterable<Pair<LeftValue, RightValue>> {

    /**
     * Returns the Set of RightValues added with the specified LeftValue.
     *
     * @param leftValue
     *        LeftValue added with the Set of RightValues to return
     *
     * @return {@link Set} of {@link RightValue}s added with {@code leftValue};
     *         empty {@link Set} if no {@link RightValue} is added with {@code leftValue}
     */
    public Set<RightValue> getRightSet(LeftValue leftValue);

    /**
     * Returns the Set of LeftValues added with the specified RightValue.
     *
     * @param rightValue
     *        RightValue added with the Set of LeftValues to return
     *
     * @return {@link Set} of RightValues added with {@code leftValue} empty {@link Set} if no RightValue is added with
     *         {@code leftValue}
     */
    public Set<LeftValue> getLeftSet(RightValue rightValue);

    /**
     * Verifies whether the specified LeftValue is added with the specified
     * RightValue.
     *
     * @param leftValue
     *        LeftValue of the potential pair
     *
     * @param rightValue
     *        RightValue of the potential pair
     *
     * @return {@code true} if {@code leftValue} is added with
     *         {@code rightValue}
     */
    public boolean contains(LeftValue leftValue, RightValue rightValue);

    /**
     * Verifies whether the specified LeftValue is added with some
     * RightValue by this BinaryRelation.
     *
     * @param leftValue
     *        the LeftValue
     *
     * @return {@code true} if {@code leftValue} is added with some
     *         RightValue; {@code false} otherwise
     */
    public boolean hasLeft(LeftValue leftValue);

    /**
     * Verifies whether the specified RightValue is added with some
     * LeftValue by this BinaryRelation.
     *
     * @param rightValue
     *        the RightValue
     *
     * @return {@code true} if {@code rightValue} is added with some
     *         LeftValue; {@code false} otherwise
     */
    public boolean hasRight(RightValue rightValue);

    /**
     * Returns a {@link Set} containing the LeftValues of this
     * {@link BinaryRelation}. The {@link Set} is updated when this
     * {@link BinaryRelation} is modified. Note that, in that case, the values
     * returned by the {@link Set}'s {@link Iterator} may be inconsistent. The
     * {@link Set} is immutable, that is, calling one of its modifying
     * operations results in an {@link UnsupportedOperationException}.
     *
     * @return {@link Set} containing the LeftValues
     */
    public Set<LeftValue> getLeftValues();

    /**
     * Returns a {@link Set} containing the RightValues of this
     * {@link BinaryRelation}. The {@link Set} is updated when this
     * {@link BinaryRelation} is modified. Note that, in that case, the values
     * returned by the {@link Set}'s {@link Iterator} may be inconsistent. The
     * {@link Set} is immutable, that is, calling one of its modifying
     * operations results in an {@link UnsupportedOperationException}.
     *
     * @return {@link Set} containing the RightValues
     */
    public Set<RightValue> getRightValues();
}

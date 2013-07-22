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

import org.jlib.container.binaryrelation.InvalidPairException;
import org.jlib.container.binaryrelation.Pair;
import org.jlib.container.binaryrelation.BinaryRelation;

/**
 * {@link InvalidPairException} thrown when trying to invalidy add an
 * {@link Pair} to a {@link BinaryRelation}.
 *
 * @author Igor Akkerman
 */
public class PairAlreadyContainedException
extends InvalidPairException {

    /** serialVersionUID */
    private static final long serialVersionUID = - 1416174523765702421L;

    /**
     * Creates a new {@link PairAlreadyContainedException}.
     *
     * @param binaryRelation
     *        referenced {@link BinaryRelation}
     *
     * @param leftValue
     *        LeftValue of the {@link Pair}
     *
     * @param rightValue
     *        RightValue of the {@link Pair}
     */
    public PairAlreadyContainedException(final BinaryRelation<?, ?> binaryRelation, final Object leftValue,
                                         final Object rightValue) {
        super(binaryRelation, leftValue, rightValue);
    }
}

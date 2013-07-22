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

/**
 * {@link ValueAlreadyRelatedException} for a LeftValue.
 *
 * @author Igor Akkerman
 */
public class LeftValueAlreadyRelatedException
extends InvalidPairException {

    /** serialVersionUID */
    private static final long serialVersionUID = 7999182498569902948L;

    /**
     * Creates a new {@link LeftValueAlreadyRelatedException} for the
     * specified {@link BinaryRelation} and the specified {@link Pair}.
     *
     * @param binaryRelation
     *        referenced {@link BinaryRelation}
     *
     * @param leftValue
     *        already added LeftValue
     *
     * @param rightValue
     *        RightValue to which {@code leftValue} cannot be added
     */
    public <LeftValue, RightValue> /*
        */ LeftValueAlreadyRelatedException(final BinaryRelation<LeftValue, RightValue> binaryRelation,
                                            final Pair<LeftValue, RightValue> pair) {
        super(binaryRelation, pair);
    }
}

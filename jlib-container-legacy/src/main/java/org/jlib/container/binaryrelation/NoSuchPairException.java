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

/**
 * {@link InvalidPairException} thrown when referencing an {@link Pair} not contained by the specified
 * {@link BinaryRelation}.
 *
 * @author Igor Akkerman
 */
public class NoSuchPairException
extends InvalidPairException {

    /** serialVersionUID */
    private static final long serialVersionUID = - 5774667231932174427L;

    /**
     * Creates a new {@link NoSuchPairException}.
     *
     * @param binaryRelation
     *        referenced {@link BinaryRelation}
     */
    public <LeftValue, RightValue> /*
        */ NoSuchPairException(final BinaryRelation<LeftValue, RightValue> binaryRelation,
                               final Pair<LeftValue, RightValue> pair) {

        super(binaryRelation, pair);
    }
}

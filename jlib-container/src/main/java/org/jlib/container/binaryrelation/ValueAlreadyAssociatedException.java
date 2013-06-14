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
 * Exception thrown when trying to associate a value with another value by a
 * {@link BinaryRelation} which allows a value to be associated with only one
 * other value, and the first value is already associated with some third value.
 *
 * @author Igor Akkerman
 */
public abstract class ValueAlreadyAssociatedException
extends IllegalAssociationException {

    /** serialVersionUID */
    private static final long serialVersionUID = - 6309445418086228661L;

    /**
     * Creates a new {@link ValueAlreadyAssociatedException}.
     *
     * @param binaryRelation
     *        referenced {@link BinaryRelation}
     *
     * @param leftValue
     *        LeftValue of the illegal {@link Association}
     *
     * @param rightValue
     *        RightValue of the illegal {@link Association}
     */
    public ValueAlreadyAssociatedException(final BinaryRelation<?, ?> binaryRelation, final Object leftValue, final Object rightValue) {
        super(binaryRelation, leftValue, rightValue);
    }
}

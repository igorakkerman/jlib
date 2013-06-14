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
 * {@link IllegalAssociationException} thrown when referencing an
 * {@link Association} not contained by the specified {@link BinaryRelation}.
 *
 * @author Igor Akkerman
 */
public abstract class NoSuchAssociationValueException
extends IllegalBinaryRelationArgumentException {

    /** serialVersionUID */
    private static final long serialVersionUID = 5642778973583219541L;

    /** LeftValue or RightValue of the {@link Association} */
    private final Object value;

    /**
     * Creates a new {@link NoSuchAssociationValueException}.
     *
     * @param binaryRelation
     *        referenced {@link BinaryRelation}
     *
     * @param valueName
     *        {@link String} specifying the value name
     *
     * @param value
     *        LeftValue or RightValue of the {@link Association}
     */
    public NoSuchAssociationValueException(final BinaryRelation<?, ?> binaryRelation, final String valueName, final Object value) {
        super(binaryRelation, "{1}: {2} '{3}'", value);

        this.value = value;
    }

    /**
     * Returns the LeftValue of the illegal {@link Association}.
     *
     * @return LeftValue of the {@link Association}
     */
    public Object getValue() {
        return value;
    }
}

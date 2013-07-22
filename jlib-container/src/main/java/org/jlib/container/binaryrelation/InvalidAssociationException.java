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

import static org.jlib.core.language.ExceptionMessageUtility.message;

import org.jlib.core.language.ExceptionMessage;

/**
 * {@link InvalidBinaryRelationArgumentException} thrown when an
 * {@link Association} cannot be added to a {@link BinaryRelation}.
 *
 * @author Igor Akkerman
 */
public abstract class InvalidAssociationException
extends InvalidBinaryRelationArgumentException {

    /** serialVersionUID */
    private static final long serialVersionUID = 6498242933289941100L;

    /**
     * Creates a new {@link InvalidAssociationException}.
     *
     * @param binaryRelation
     *        referenced {@link BinaryRelation}
     *
     * @param leftValue
     *        LeftValue of the invalid {@link Association}
     *
     * @param rightValue
     *        RightValue of the invalid {@link Association}
     */
    public InvalidAssociationException(final BinaryRelation<?, ?> binaryRelation, final Object leftValue,
                                       final Object rightValue) {
        super(binaryRelation, message().with("<{0}, {1}>", leftValue, rightValue));
    }

    /**
     * Creates a new {@link InvalidAssociationException}.
     *
     * @param binaryRelation
     *        referenced {@link BinaryRelation}
     *
     * @param leftValue
     *        LeftValue of the invalid {@link Association}
     *
     * @param rightValue
     *        RightValue of the invalid {@link Association}
     *
     * @param messageTemplate
     *        {@link String} specifying the template of the error message
     *
     * @param messageArguments
     *        sequence of {@link Object} parameters of the error message
     */
    public InvalidAssociationException(final BinaryRelation<?, ?> binaryRelation, final Object leftValue,
                                       final Object rightValue, final ExceptionMessage message) {

        super(binaryRelation, leftValue, rightValue);
    }

    /**
     * Creates a new {@link InvalidAssociationException}.
     *
     * @param binaryRelation
     *        referenced {@link BinaryRelation}
     *
     * @param leftValue
     *        LeftValue of the invalid {@link Association}
     *
     * @param rightValue
     *        RightValue of the invalid {@link Association}
     *
     * @param messageTemplate
     *        {@link String} specifying the template of the error message
     *
     * @param cause
     *        {@link Exception} that caused this
     *        {@link InvalidBinaryRelationArgumentException}
     *
     * @param messageArguments
     *        sequence of {@link Object} parameters of the error message
     */
    public InvalidAssociationException(final BinaryRelation<?, ?> binaryRelation, final Object leftValue,
                                       final Object rightValue, final String messageTemplate, final Exception cause,
                                       final Object... messageArguments) {
        super(binaryRelation, messageTemplate, cause, messageArguments, leftValue, rightValue);
    }
}

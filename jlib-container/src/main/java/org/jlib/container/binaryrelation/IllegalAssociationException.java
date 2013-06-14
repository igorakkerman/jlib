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
 * {@link IllegalBinaryRelationArgumentException} thrown when an
 * {@link Association} cannot be added to a {@link BinaryRelation}.
 *
 * @author Igor Akkerman
 */
public abstract class IllegalAssociationException
extends IllegalBinaryRelationArgumentException {

    /** serialVersionUID */
    private static final long serialVersionUID = 6498242933289941100L;

    /** LeftValue of the illegal {@link Association} */
    private final Object leftValue;

    /** RightValue of the illegal {@link Association} */
    private final Object rightValue;

    /**
     * Creates a new {@link IllegalAssociationException}.
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
    public IllegalAssociationException(final BinaryRelation<?, ?> binaryRelation, final Object leftValue, final Object rightValue) {
        this(binaryRelation, leftValue, rightValue, "{1}: <{2}, {3}>");
    }

    /**
     * Creates a new {@link IllegalAssociationException}.
     *
     * @param binaryRelation
     *        referenced {@link BinaryRelation}
     *
     * @param leftValue
     *        LeftValue of the illegal {@link Association}
     *
     * @param rightValue
     *        RightValue of the illegal {@link Association}
     *
     * @param messagePattern
     *        {@link String} specifying the pattern of the error message
     *
     * @param messageArguments
     *        sequence of {@link Object} parameters of the error message
     */
    public IllegalAssociationException(final BinaryRelation<?, ?> binaryRelation, final Object leftValue, final Object rightValue, final String messagePattern, final Object... messageArguments) {
        this(binaryRelation, leftValue, rightValue, messagePattern, (Throwable) null, messageArguments);
    }

    /**
     * Creates a new {@link IllegalAssociationException}.
     *
     * @param binaryRelation
     *        referenced {@link BinaryRelation}
     *
     * @param leftValue
     *        LeftValue of the illegal {@link Association}
     *
     * @param rightValue
     *        RightValue of the illegal {@link Association}
     *
     * @param messagePattern
     *        {@link String} specifying the pattern of the error message
     *
     * @param cause
     *        {@link Throwable} that caused this
     *        {@link IllegalBinaryRelationArgumentException}
     *
     * @param messageArguments
     *        sequence of {@link Object} parameters of the error message
     */
    public IllegalAssociationException(final BinaryRelation<?, ?> binaryRelation, final Object leftValue, final Object rightValue, final String messagePattern, final Throwable cause, final Object... messageArguments) {
        super(binaryRelation, messagePattern, cause, messageArguments, leftValue, rightValue);

        this.leftValue = leftValue;
        this.rightValue = rightValue;
    }

    /**
     * Returns the LeftValue of the illegal {@link Association}.
     *
     * @return LeftValue of the {@link Association}
     */
    public Object getLeftValue() {
        return leftValue;
    }

    /**
     * Returns the rightValue of this {@link IllegalAssociationException}.
     *
     * @return RightValue of the {@link Association}
     */
    public Object getRightValue() {
        return rightValue;
    }
}

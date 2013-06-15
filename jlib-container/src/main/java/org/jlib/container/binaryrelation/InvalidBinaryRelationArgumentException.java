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

import org.jlib.container.InvalidContainerArgumentException;

/**
 * {@link InvalidContainerArgumentException} referencing a
 * {@link BinaryRelation}.
 *
 * @author Igor Akkerman
 */
public abstract class InvalidBinaryRelationArgumentException
extends InvalidContainerArgumentException {

    /** serialVersionUID */
    private static final long serialVersionUID = - 5603158282885764114L;

    /** referenced {@link BinaryRelation} */
    private final BinaryRelation<?, ?> binaryRelation;

    /**
     * Creates a new {@link InvalidBinaryRelationArgumentException}.
     *
     * @param binaryRelation
     *        referenced {@link BinaryRelation}
     */
    public InvalidBinaryRelationArgumentException(final BinaryRelation<?, ?> binaryRelation) {
        this(binaryRelation, "{1}");
    }

    /**
     * Creates a new {@link InvalidBinaryRelationArgumentException}.
     *
     * @param binaryRelation
     *        referenced {@link BinaryRelation}
     *
     * @param messageTemplate
     *        {@link String} specifying the template of the error message
     *
     * @param messageArguments
     *        sequence of {@link Object} parameters of the error message
     */
    public InvalidBinaryRelationArgumentException(final BinaryRelation<?, ?> binaryRelation, final String messageTemplate, final Object... messageArguments) {
        this(binaryRelation, messageTemplate, (Throwable) null, messageArguments);
    }

    /**
     * Creates a new {@link InvalidBinaryRelationArgumentException}.
     *
     * @param binaryRelation
     *        referenced {@link BinaryRelation}
     *
     * @param messageTemplate
     *        {@link String} specifying the template of the error message
     *
     * @param cause
     *        {@link Throwable} that caused this
     *        {@link InvalidBinaryRelationArgumentException}
     *
     * @param messageArguments
     *        sequence of {@link Object} parameters of the error message
     */
    public InvalidBinaryRelationArgumentException(final BinaryRelation<?, ?> binaryRelation, final String messageTemplate, final Throwable cause, final Object... messageArguments) {
        super(binaryRelation, messageTemplate, cause, messageArguments);

        this.binaryRelation = binaryRelation;
    }

    /**
     * Returns the referenced {@link BinaryRelation}.
     *
     * @return referenced {@link BinaryRelation}
     */
    @Override
    public BinaryRelation<?, ?> getContainer() {
        return binaryRelation;
    }
}

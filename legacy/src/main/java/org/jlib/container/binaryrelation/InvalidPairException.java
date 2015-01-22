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

import org.jlib.core.language.Message;

import org.jlib.container.operation.InvalidContainerArgumentException;

import static org.jlib.core.language.MessageUtility.message;

/**
 * {@link InvalidBinaryRelationArgumentException} thrown when an
 * {@link Pair} cannot be added to a {@link BinaryRelation}.
 *
 * @author Igor Akkerman
 */
public abstract class InvalidPairException
extends InvalidContainerArgumentException {

    private static final long serialVersionUID = 6498242933289941100L;

    /**
     * Creates a new {@link InvalidPairException}.
     *
     * @param binaryRelation
     *        referenced {@link BinaryRelation}
     */
    protected <LeftValue, RightValue> /*
        */ InvalidPairException(  /*
                             */ final BinaryRelation<LeftValue, RightValue> binaryRelation,
                                final Pair<LeftValue, RightValue> pair) {
        super(binaryRelation, message(pair));
    }

    /**
     * Creates a new {@link InvalidPairException}.
     *
     * @param binaryRelation
     *        referenced {@link BinaryRelation}
     */

    protected <LeftValue, RightValue> /*
        */ InvalidPairException(final BinaryRelation<LeftValue, RightValue> binaryRelation,
                                Pair<LeftValue, RightValue> pair, final Message message) {

        super(binaryRelation, message.with(pair));
    }

    /**
     * Creates a new {@link InvalidPairException}.
     *
     * @param binaryRelation
     *        referenced {@link BinaryRelation}
     *
     * @param cause
     *        {@link Exception} that caused this
     *        {@link InvalidBinaryRelationArgumentException}
     */

    protected <LeftValue, RightValue> /*
        */ InvalidPairException(final BinaryRelation<LeftValue, RightValue> binaryRelation,
                                Pair<LeftValue, RightValue> pair, final Message message,
                                final Exception cause) {

        super(binaryRelation, message.with(pair), cause);
    }
}

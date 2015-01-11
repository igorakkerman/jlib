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

import org.jlib.container.operation.InvalidContainerArgumentException;

import static org.jlib.core.language.ParametrizedMessageUtility.message;
import static org.jlib.core.language.ParametrizedMessageUtility.namedObject;

/**
 * Exception thrown when a {@link BinaryRelation} does not contain an
 * {@link Pair} with the requested left value.
 *
 * @author Igor Akkerman
 */
public class NoSuchLeftValueException
extends InvalidContainerArgumentException {

    /** serialVersionUID */
    private static final long serialVersionUID = - 723559454379105926L;

    /**
     * Creates a new {@link NoSuchLeftValueException}.
     *
     * @param binaryRelation
     *        referenced {@link BinaryRelation}
     *
     * @param leftValue
     *        LeftValue of the {@link Pair}
     */
    public <LeftValue> /*
        */ NoSuchLeftValueException(@SuppressWarnings("TypeMayBeWeakened") /*
                                 */ final BinaryRelation<LeftValue, ?> binaryRelation, final LeftValue leftValue) {

        super(binaryRelation, message(namedObject("leftValue", leftValue)));
    }
}
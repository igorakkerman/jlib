/*
 * jlib - Open Source Java Library
 *
 *     www.jlib.org
 *
 *
 *     Copyright 2005-2015 Igor Akkerman
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

package org.jlib.core.math;

import org.jlib.core.exception.InvalidArgumentException;

import static org.jlib.core.message.MessageUtility.messageMf;

/**
 * {@link InvalidArgumentException} thrown when an invalid value has been specified as a
 * base of a numeral system.
 */
public class InvalidNumeralBaseException
extends InvalidArgumentException {

    private static final long serialVersionUID = - 1111631415238248975L;

    private final int baseValue;

    public InvalidNumeralBaseException(final int baseValue) {

        super(messageMf("{0} < 1", baseValue));

        this.baseValue = baseValue;
    }

    public int getBaseValue() {
        return baseValue;
    }
}

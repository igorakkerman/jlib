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

package org.jlib.core.language;

import org.jlib.core.array.ArrayUtility;

import java.text.MessageFormat;

/**
 * {@link IllegalArgumentException} using a formatted message.
 *
 * @author Igor Akkerman
 */
// TODO: move system exceptions to system package
public abstract class InvalidArgumentException
extends IllegalArgumentException {

    private static final long serialVersionUID = 5894034302749387338L;

    /**
     * Creates a new {@link InvalidArgumentException}.
     *
     * @param messageTemplate
     *        {@link String} specifying the message template
     *
     * @param messageArguments
     *        comma separated sequence of additional {@link Object} message arguments
     */
    public InvalidArgumentException(final String messageTemplate, final Object... messageArguments) {
        this(messageTemplate, null, messageArguments);
    }

    /**
     * Creates a new {@link InvalidArgumentException}.
     *
     * @param cause
     *        Throwable that caused this {@link InvalidArgumentException}
     */
    public InvalidArgumentException(final Throwable cause) {
        super(cause);
    }

    /**
     * Creates a new {@link InvalidArgumentException}.
     *
     * @param messageTemplate
     *        {@link String} specifying the message template
     *
     * @param cause
     *        Throwable that caused this {@link InvalidArgumentException}
     *
     * @param messageArguments
     *        comma separated sequence of additional {@link Object} message arguments
     */
    public InvalidArgumentException(final String messageTemplate, final Throwable cause, final Object... messageArguments) {
        super(MessageFormat.format(messageTemplate, ArrayUtility.flatten(messageArguments)), cause);
    }
}

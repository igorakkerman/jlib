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

package org.jlib.core.exception;

import org.jlib.core.array.ArrayUtility;

import java.text.MessageFormat;

/**
 * {@link IllegalArgumentException} using a formatted message.
 *
 * @author Igor Akkerman
 */
public abstract class IllegalJlibArgumentException
extends IllegalArgumentException {

    private static final long serialVersionUID = 5894034302749387338L;

    /**
     * Creates a new {@link IllegalJlibArgumentException}.
     *
     * @param messagePattern
     *        {@link String} specifying the message pattern
     *
     * @param messageArguments
     *        comma separated sequence of { @link Object} message arguments
     */
    public IllegalJlibArgumentException(final String messagePattern, final Object... messageArguments) {
        this(messagePattern, null, messageArguments);
    }

    /**
     * Creates a new {@link IllegalJlibArgumentException}.
     *
     * @param cause
     *        Throwable that caused this {@link IllegalJlibArgumentException}
     */
    public IllegalJlibArgumentException(final Throwable cause) {
        super(cause);
    }

    /**
     * Creates a new {@link IllegalJlibArgumentException}.
     *
     * @param messagePattern
     *        {@link String} specifying the message pattern
     *
     * @param cause
     *        Throwable that caused this {@link IllegalJlibArgumentException}
     *
     * @param messageArguments
     *        comma separated sequence of {@link Object} message arguments
     */
    public IllegalJlibArgumentException(final String messagePattern, final Throwable cause, final Object... messageArguments) {
        super(MessageFormat.format(messagePattern, ArrayUtility.flatten(messageArguments)), cause);
    }
}

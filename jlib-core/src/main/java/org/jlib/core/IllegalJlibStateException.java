/*******************************************************************************
 *
 *    jlib - Open Source Java Library
 *
 *    www.jlib.org
 *
 *
 *    Copyright 2012 Igor Akkerman
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 *
 ******************************************************************************/

package org.jlib.core;

import org.jlib.core.array.ArrayUtility;

import java.text.MessageFormat;

/**
 * {@link IllegalStateException} using a formatted message.
 *
 * @author Igor Akkerman
 */
public abstract class IllegalJlibStateException
extends IllegalStateException {

    /** serialVersionUID */
    private static final long serialVersionUID = 6535760982905205135L;

    /**
     * Creates a new {@link IllegalJlibStateException}.
     */
    public IllegalJlibStateException() {
        super();
    }

    /**
     * Creates a new {@link IllegalJlibStateException}.
     *
     * @param messagePattern
     *        {@link String} specifying the message pattern
     *
     * @param messageArguments
     *        comma separated sequence of {@link Object} message arguments
     */
    public IllegalJlibStateException(final String messagePattern, final Object... messageArguments) {
        this(messagePattern, null, messageArguments);
    }

    /**
     * Creates a new {@link IllegalJlibStateException}.
     *
     * @param cause
     *        Throwable that caused this {@link IllegalJlibStateException}
     */
    public IllegalJlibStateException(final Throwable cause) {
        super(cause);
    }

    /**
     * Creates a new {@link IllegalJlibStateException}.
     *
     * @param messagePattern
     *        {@link String} specifying the message pattern
     *
     * @param cause
     *        Throwable that caused this {@link IllegalJlibStateException}
     *
     * @param messageArguments
     *        comma separated sequence of {@link Object} message States
     */
    public IllegalJlibStateException(final String messagePattern, final Throwable cause,
                                     final Object... messageArguments) {
        super(MessageFormat.format(messagePattern, ArrayUtility.flatten(messageArguments)), cause);
    }
}

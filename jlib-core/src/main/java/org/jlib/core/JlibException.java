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

import java.text.MessageFormat;

import org.jlib.core.array.ArrayUtility;

/**
 * {@link Exception} using a formatted message.
 *
 * @author Igor Akkerman
 */
public abstract class JlibException
extends Exception {

    /** serialVersionUID */
    private static final long serialVersionUID = - 7508635402610527176L;

    /**
     * Creates a new {@link JlibException}.
     */
    protected JlibException() {
        super();
    }

    /**
     * Creates a new {@link JlibException}.
     *
     * @param messagePattern
     *        {@link String} specifying the message pattern
     *
     * @param messageArguments
     *        comma separated sequence of {@link Object} message arguments
     */
    protected JlibException(final String messagePattern, final Object... messageArguments) {
        this(messagePattern, null, messageArguments);
    }

    /**
     * Creates a new {@link JlibException}.
     *
     * @param cause
     *        Throwable that caused this {@link JlibException}
     */
    protected JlibException(final Throwable cause) {
        super(cause);
    }

    /**
     * Creates a new {@link JlibException}.
     *
     * @param messagePattern
     *        {@link String} specifying the message pattern
     *
     * @param cause
     *        Throwable that caused this {@link JlibException}
     *
     * @param messageArguments
     *        comma separated sequence of {@link Object} message States
     */
    protected JlibException(final String messagePattern, final Throwable cause, final Object... messageArguments) {
        super(createMessage(messagePattern, messageArguments), cause);
    }

    /**
     * Returns the message created applying the specified message arguments to the specified message pattern.
     *
     * @param messagePattern
     *        {@link String} specifying the message pattern
     *
     * @param messageArguments
     *        comma separated sequence of {@link Object} message States
     *
     * @return {@link String} specifying the message
     */
    private static String createMessage(final String messagePattern, final Object... messageArguments) {
        // TODO: use some formatter interface and template method returning the implementation

        return MessageFormat.format(messagePattern, ArrayUtility.flatten(messageArguments));
    }
}

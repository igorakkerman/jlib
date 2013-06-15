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

import org.jlib.core.text.placeholderreplacer.MessageFormatPlaceholderReplacer;
import org.jlib.core.text.placeholderreplacer.PlaceholderReplacer;

import static org.jlib.core.array.ArrayUtility.flatten;

/**
 * Skeletal implementation of an {@link Exception} using a formatted message.
 *
 * @author Igor Akkerman
 */
public abstract class AbstractException
extends Exception {

    /** serialVersionUID */
    private static final long serialVersionUID = - 7508635402610527176L;

    /** default {@link PlaceholderReplacer} used */
    public static final PlaceholderReplacer DEFAULT_PLACEHOLDER_REPLACER =
        MessageFormatPlaceholderReplacer.getInstance();

    /** {@link String} specifying the message */
     private final String message;

     /**
     * Creates a new {@link AbstractException}.
     */
    protected AbstractException() {
        super();

        message = super.getMessage();
    }

    /**
     * Creates a new {@link AbstractException}.
     *
     * @param messageTemplate
     *        {@link String} specifying the message template
     *
     * @param messageArguments
     *        comma separated sequence of {@link Object} message arguments
     */
    protected AbstractException(final String messageTemplate, final Object... messageArguments) {
        super();

        message = createMessage(messageTemplate, messageArguments);
    }

    /**
     * Creates a new {@link AbstractException}.
     *
     * @param cause
     *        Throwable that caused this {@link AbstractException}
     */
    protected AbstractException(final Throwable cause) {
        super(cause);

        message = super.getMessage();
    }

    /**
     * Creates a new {@link AbstractException}.
     *
     * @param messageTemplate
     *        {@link String} specifying the message template
     *
     * @param cause
     *        Throwable that caused this {@link AbstractException}
     *
     * @param messageArguments
     *        comma separated sequence of {@link Object} message arguments
     */
    protected AbstractException(final String messageTemplate, final Throwable cause, final Object... messageArguments) {
        super(cause);

        message = createMessage(messageTemplate, messageArguments);
    }

    /**
     * Creates the message applying the specified message arguments to the specified message template.
     *
     * @param messageTemplate
     *        {@link String} specifying the message template
     *
     * @param messageArguments
     *        comma separated sequence of {@link Object} message arguments
     */
    private String createMessage(final String messageTemplate, final Object... messageArguments) {
        return getTemplateProcessor().replacePlaceholders(messageTemplate, flatten(messageArguments));
    }

    protected PlaceholderReplacer getTemplateProcessor() {
        return DEFAULT_PLACEHOLDER_REPLACER;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

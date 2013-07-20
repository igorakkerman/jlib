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

import static org.jlib.core.language.ExceptionUtility.DEFAULT_MESSAGE_FORMATTER;
import static org.jlib.core.language.ExceptionUtility.formatMessage;

import org.jlib.core.text.textbuilder.TemplateEngine;

/**
 * {@link IllegalArgumentException} using a formatted message.
 *
 * @author Igor Akkerman
 */
public abstract class InvalidArgumentException
extends IllegalArgumentException {

    private static final long serialVersionUID = 5894034302749387338L;

    /** {@link String} specifying the message */
    private final String message;

    /**
     * Creates a new {@link InvalidArgumentException}.
     */
    protected InvalidArgumentException() {
        super();

        message = super.getMessage();
    }

    /**
     * Creates a new {@link InvalidArgumentException}.
     *
     * @param messageTemplate
     *        {@link CharSequence} specifying the message template
     *
     * @param messageArguments
     *        comma separated sequence of {@link Object} message arguments
     */
    protected InvalidArgumentException(final CharSequence messageTemplate, final Object... messageArguments) {
        super();

        message = createMessage(messageTemplate, messageArguments);
    }

    /**
     * Creates a new {@link InvalidArgumentException}.
     *k
     * @param cause
     *        {@link Exception} that caused this {@link InvalidArgumentException}
     */
    protected InvalidArgumentException(final Exception cause) {
        super(cause);

        message = super.getMessage();
    }

    /**
     * Creates a new {@link InvalidArgumentException}.
     *
     * @param messageTemplate
     *        {@link CharSequence} specifying the message template
     *
     * @param cause
     *        {@link Exception} that caused this {@link InvalidArgumentException}
     *
     * @param messageArguments
     *        comma separated sequence of {@link Object} message arguments
     */
    protected InvalidArgumentException(final CharSequence messageTemplate, final Exception cause,
                                       final Object... messageArguments) {
        super(cause);

        message = createMessage(messageTemplate, messageArguments);
    }

    /**
     * Creates the message applying the specified message arguments to the specified message template.
     *
     * @param messageTemplate
     *        {@link CharSequence} specifying the message template
     *
     * @param messageArguments
     *        comma separated sequence of {@link Object} message arguments
     */
    private String createMessage(final CharSequence messageTemplate, final Object... messageArguments) {
        return formatMessage(getMessageFormatter(), messageTemplate, messageArguments);
    }

    /**
     * Returns the {@link TemplateEngine} used to format the message.
     *
     * @return used {@link TemplateEngine}
     */
    protected TemplateEngine getMessageFormatter() {
        return DEFAULT_MESSAGE_FORMATTER;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

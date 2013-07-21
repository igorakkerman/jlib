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

import static org.jlib.core.language.ExceptionUtility.DEFAULT_MESSAGE_TEMPLATE_ENGINE;

import org.jlib.core.text.textbuilder.TemplateEngine;

/**
 * Skeletal implementation of an {@link Exception} using a formatted message.
 *
 * @author Igor Akkerman
 */
public abstract class ApplicationException
extends Exception {

    /** serialVersionUID */
    private static final long serialVersionUID = - 7508635402610527176L;

    /** {@link String} specifying the message */
    private final String message;

    /**
     * Creates a new {@link ApplicationException}.
     */
    protected ApplicationException() {
        super();

        message = super.getMessage();
    }

    /**
     * Creates a new {@link ApplicationException}.
     *
     * @param messageTemplate
     *        {@link CharSequence} specifying the message template
     *
     * @param messageArguments
     *        comma separated sequence of {@link Object} message arguments
     */
    protected ApplicationException(final CharSequence messageTemplate, final Object... messageArguments) {
        super();

        message = createMessage(messageTemplate, messageArguments);
    }

    /**
     * Creates a new {@link ApplicationException}.
     *k
     * @param cause
     *        {@link Exception} that caused this {@link ApplicationException}
     */
    protected ApplicationException(final Exception cause) {
        super(cause);

        message = super.getMessage();
    }

    /**
     * Creates a new {@link ApplicationException}.
     *
     * @param messageTemplate
     *        {@link CharSequence} specifying the message template
     *
     * @param cause
     *        {@link Exception} that caused this {@link ApplicationException}
     *
     * @param messageArguments
     *        comma separated sequence of {@link Object} message arguments
     */
    protected ApplicationException(final CharSequence messageTemplate, final Exception cause,
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
        return getMessageFormatter().applyArguments(messageTemplate, messageArguments);
    }

    /**
     * Returns the {@link TemplateEngine} used to format the message.
     *
     * @return used {@link TemplateEngine}
     */
    protected TemplateEngine getMessageFormatter() {
        return DEFAULT_MESSAGE_TEMPLATE_ENGINE;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

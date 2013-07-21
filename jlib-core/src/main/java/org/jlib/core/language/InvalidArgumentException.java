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

import static org.jlib.core.language.ExceptionMessageUtility.DEFAULT_MESSAGE_TEMPLATE_ENGINE;

import org.jlib.core.text.textbuilder.TemplateEngine;

/**
 * {@link IllegalArgumentException} using a parametrized message.
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
     *
     * @param messageTemplate
     *        {@link CharSequence} specifying the message template
     *
     * @param messageArguments
     *        comma separated sequence of {@link Object} message arguments
     */
    protected InvalidArgumentException(final ParametrizedMessage parametrizedMessage) {

        super();

        message = getMessageTemplateEngine().applyArguments(parametrizedMessage);
    }

    /**
     * Creates a new {@link InvalidArgumentException}.
     *
     * @param cause
     *        {@link Exception} that caused this {@link InvalidArgumentException}
     *
     * @param messageTemplate
     *        {@link CharSequence} specifying the message template
     *@param messageArguments
     *        comma separated sequence of {@link Object} message arguments
     */
    protected InvalidArgumentException(final Exception cause, final ParametrizedMessage parametrizedMessage) {
        super(cause);

        message = getMessageTemplateEngine().applyArguments(parametrizedMessage);
    }

    /**
     * Returns the {@link TemplateEngine} used to create the message.
     *
     * @return used {@link TemplateEngine}
     */
    protected TemplateEngine getMessageTemplateEngine() {
        return DEFAULT_MESSAGE_TEMPLATE_ENGINE;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

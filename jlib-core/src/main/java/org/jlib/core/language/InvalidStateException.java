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

import static org.apache.commons.lang3.StringUtils.EMPTY;

/**
 * {@link IllegalStateException} using a formatted message.
 *
 * @author Igor Akkerman
 */
public abstract class InvalidStateException
extends IllegalStateException {

    /** serialVersionUID */
    private static final long serialVersionUID = 6535760982905205135L;

    /**
     * Creates a new {@link InvalidStateException}.
     */
    protected InvalidStateException() {
        super(EMPTY);
    }

    /**
     * Creates a new {@link InvalidStateException}.
     *
     * @param messageTemplate
     *        {@link CharSequence} specifying the message template
     *
     * @param messageArguments
     *        comma separated sequence of {@link Object} message arguments
     */
    protected InvalidStateException(final ParametrizedMessage message) {
        super(message.toString());
    }

    /**
     * Creates a new {@link InvalidStateException}.
     *
     * @param cause
     *        {@link Exception} that caused this {@link InvalidStateException}
     */
    protected InvalidStateException(final Exception cause) {
        super(EMPTY, cause);
    }

    /**
     * Creates a new {@link InvalidStateException}.
     *
     * @param cause
     *        {@link Exception} that caused this {@link InvalidStateException}
     *
     *
     */
    protected InvalidStateException(final ParametrizedMessage message, final Exception cause) {
        super(message.toString(), cause);
    }
}

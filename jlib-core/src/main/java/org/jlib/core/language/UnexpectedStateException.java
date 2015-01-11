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

import org.jlib.core.text.ParametrizedMessage;

/**
 * {@link InvalidStateException} thrown in an uexpected state.
 *
 * @author Igor Akkerman
 */
public class UnexpectedStateException
extends InvalidStateException {

    private static final long serialVersionUID = 4388525477338778336L;

    /**
     * Creates a new {@link UnexpectedStateException}.
     *
     * @param messageTemplate
     *        {@link String} specifying the error message template
     *
     * @param messageArguments
     *        comma separated sequence of error message arguments
     */
    public UnexpectedStateException(final ParametrizedMessage message) {
        super(message);
    }

    /**
     * Creates a new {@link UnexpectedStateException}.
     *
     * @param cause
     *        {@link Exception} that caused this {@link UnexpectedStateException}
     */
    public UnexpectedStateException(final Exception cause) {
        super(cause);
    }

    /**
     * Creates a new {@link UnexpectedStateException}.
     *
     * @param cause
     *        {@link Exception} that caused this {@link UnexpectedStateException}
     *
     * @param messageTemplate
     *        {@link String} specifying the error message template
     *
     * @param messageArguments
     *        comma separated sequence of error message arguments
     */
    public UnexpectedStateException(final Exception cause, final ParametrizedMessage message) {
        super(message, cause);
    }
}

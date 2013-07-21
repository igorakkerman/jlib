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

package org.jlib.core.traverser;

import org.jlib.core.language.ParametrizedMessage;

/**
 * {@link InvalidTraverserStateException} thrown when there is no next Item to
 * return by a {@link Traverser}.
 *
 * @author Igor Akkerman
 */
public class NoPreviousItemException
extends InvalidTraverserStateException {

    /** serialVersionUID */
    private static final long serialVersionUID = 1747026481047589428L;

    /**
     * Creates a new {@link NoPreviousItemException}.
     *
     * @param traversible
     *        traversed {@link Traversible}
     */
    public NoPreviousItemException(final Traversible<?> traversible) {
        super(traversible);
    }

    /**
     * Creates a new {@link NoPreviousItemException} with the specified cause.
     *
     * @param traversible
     *        traversed {@link Traversible}
     *
     * @param cause
     *        {@link Exception} that caused this {@link NoPreviousItemException}
     */
    public NoPreviousItemException(final Traversible<?> traversible, final Exception cause) {
        super(traversible, cause);
    }

    /**
     * Creates a new {@link NoPreviousItemException} with the specified cause.
     *
     * @param traversible
     *        traversed {@link Traversible}
     *
     * @param messageTemplate
     *        {@link String} specifying the error message template
     *
     * @param messageArguments
     *        comma separated sequence of {@link Object} instances specifying
     *        the message arguments
     */
    public NoPreviousItemException(final Traversible<?> traversible, final ParametrizedMessage parametrizedMessage) {
        super(traversible, parametrizedMessage);
    }

    /**
     * Creates a new {@link NoPreviousItemException} with the specified cause.
     *
     * @param traversible
     *        traversed {@link Traversible}
     *
     * @param messageTemplate
     *        {@link String} specifying the error message template
     *
     * @param cause
     *        {@link Exception} that caused this {@link NoPreviousItemException}
     *
     * @param messageArguments
     *        comma separated sequence of {@link Object} instances specifying
     *        the message arguments
     */
    public NoPreviousItemException(final Traversible<?> traversible, final String messageTemplate, final Exception cause, final Object... messageArguments) {
        super(traversible, messageTemplate, cause, messageArguments);
    }
}

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

import static org.jlib.core.language.ExceptionMessageUtility.message;

import org.jlib.core.language.InvalidStateException;
import org.jlib.core.language.ParametrizedMessage;

/**
 * {@link InvalidStateException} thrown when an invalid state has been
 * reached in a {@link Traverser}.
 *
 * @author Igor Akkerman
 */
public abstract class InvalidTraverserStateException
extends InvalidStateException {

    /** serialVersionUID */
    private static final long serialVersionUID = - 5070211173782251202L;

    /*
     * Creates a new {@link InvalidTraverserStateException}.
     *
     * @param traversible
     *        traversed {@link Traversible}
     */
    public InvalidTraverserStateException(final Traversible<?> traversible) {
        super(message().with(traversible));
    }

    /**
     * Creates a new {@link InvalidTraverserStateException}.
     *
     * @param traversible
     *        traversed {@link Traversible}
     *
     * @param cause
     *        {@link Exception} that caused this {@link InvalidStateException}
     */
    public InvalidTraverserStateException(final Traversible<?> traversible, final Exception cause) {
        super(message().with(traversible), cause);
    }

    /**
     * Creates a new {@link InvalidTraverserStateException}.
     *
     * @param traversible
     *        traversed {@link Traversible}
     *
     * @param messageTemplate
     *        {@link String} specifying the error message template
     *
     * @param errorMessageArguments
     *        comma separated sequence of {@link Object} instances specifying
     *        the message arguments
     */
    public InvalidTraverserStateException(final Traversible<?> traversible,
                                          final ParametrizedMessage message) {
        super(message.with(traversible));
    }

    /**
     * Creates a new {@link InvalidTraverserStateException}.
     *
     * @param traversible
     *        traversed {@link Traversible}
     *
     * @param messageTemplate
     *        {@link String} specifying the error message template
     *
     * @param cause
     *        {@link Exception} that caused this {@link InvalidStateException}
     *
     * @param messageArguments
     *        comma separated sequence of {@link Object} instances specifying
     *        the message arguments
     */
    public InvalidTraverserStateException(final Traversible<?> traversible, final ParametrizedMessage message,
                                          final Exception cause) {
        super(message.with(traversible), cause);
    }
}

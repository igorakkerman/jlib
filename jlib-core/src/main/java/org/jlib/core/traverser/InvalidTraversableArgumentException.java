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

import org.jlib.core.language.ExceptionMessage;
import org.jlib.core.language.InvalidStateException;

/**
 * {@link InvalidTraverserStateException} thrown when the traversed {@link Traversable} claims a state error.
 *
 * @author Igor Akkerman
 */
public class InvalidTraversableArgumentException
extends InvalidStateException {

    /** serialVersionUID */
    private static final long serialVersionUID = - 5070211173782251202L;

    /*
     * Creates a new {@link InvalidTraversableArgumentException}.
     *
     * @param traversable
     *        traversed {@link Traversable}
     */
    public InvalidTraversableArgumentException(final Traversable<?> traversable) {
        super(message().with(traversable));
    }

    /**
     * Creates a new {@link InvalidTraversableArgumentException}.
     *
     * @param traversable
     *        traversed {@link Traversable}
     *
     * @param cause
     *        {@link Exception} that caused this {@link InvalidStateException}
     */
    public InvalidTraversableArgumentException(final Traversable<?> traversable, final Exception cause) {
        super(message().with(traversable), cause);
    }

    /**
     * Creates a new {@link InvalidTraversableArgumentException}.
     *
     * @param traversable
     *        traversed {@link Traversable}
     *
     * @param messageTemplate
     *        {@link String} specifying the error message template
     *
     * @param errorMessageArguments
     *        comma separated sequence of {@link Object} instances specifying
     *        the message arguments
     */
    public InvalidTraversableArgumentException(final Traversable<?> traversable, final ExceptionMessage message) {
        super(message.with(traversable));
    }

    /**
     * Creates a new {@link InvalidTraversableArgumentException}.
     *
     * @param traversable
     *        traversed {@link Traversable}
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
    public InvalidTraversableArgumentException(final Traversable<?> traversable, final ExceptionMessage message,
                                               final Exception cause) {
        super(message.with(traversable), cause);
    }
}

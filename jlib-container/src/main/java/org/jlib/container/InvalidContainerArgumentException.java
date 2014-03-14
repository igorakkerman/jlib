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

package org.jlib.container;

import org.jlib.core.language.ExceptionMessage;
import org.jlib.core.language.InvalidStateException;
import org.jlib.core.language.ItemOperationStrategy;
import org.jlib.core.traverser.InvalidTraverserStateException;

import static org.jlib.core.language.ExceptionMessageUtility.message;

/**
 * {@link InvalidTraverserStateException} thrown when the traversed {@link ItemOperationStrategy} claims a state error.
 *
 * @author Igor Akkerman
 */
public class InvalidContainerArgumentException
extends InvalidStateException {

    /** serialVersionUID */
    private static final long serialVersionUID = - 5070211173782251202L;

    /*
     * Creates a new {@link InvalidContainerArgumentException}.
     *
     * @param traversable
     *        traversed {@link ItemOperationStrategy}
     */
    public InvalidContainerArgumentException(final ItemOperationStrategy<?> traversable) {
        super(message().with(traversable));
    }

    /**
     * Creates a new {@link InvalidContainerArgumentException}.
     *
     * @param traversable
     *        traversed {@link ItemOperationStrategy}
     *
     * @param cause
     *        {@link Exception} that caused this {@link InvalidStateException}
     */
    public InvalidContainerArgumentException(final ItemOperationStrategy<?> traversable, final Exception cause) {
        super(message().with(traversable), cause);
    }

    /**
     * Creates a new {@link InvalidContainerArgumentException}.
     *
     * @param traversable
     *        traversed {@link ItemOperationStrategy}
     *
     * @param messageTemplate
     *        {@link String} specifying the error message template
     *
     * @param errorMessageArguments
     *        comma separated sequence of {@link Object} instances specifying
     *        the message arguments
     */
    public InvalidContainerArgumentException(final ItemOperationStrategy<?> traversable, final ExceptionMessage message) {
        super(message.with(traversable));
    }

    /**
     * Creates a new {@link InvalidContainerArgumentException}.
     *
     * @param traversable
     *        traversed {@link ItemOperationStrategy}
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
    public InvalidContainerArgumentException(final ItemOperationStrategy<?> traversable, final ExceptionMessage message,
                                             final Exception cause) {
        super(message.with(traversable), cause);
    }
}
